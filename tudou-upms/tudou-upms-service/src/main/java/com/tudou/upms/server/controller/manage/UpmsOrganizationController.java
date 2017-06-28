package com.tudou.upms.server.controller.manage;

import com.alibaba.fastjson.JSON;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.validator.LengthValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsLogExample;
import com.tudou.upms.dao.model.UpmsOrganization;
import com.tudou.upms.dao.model.UpmsOrganizationExample;
import com.tudou.upms.dao.model.UpmsPermission;
import com.tudou.upms.rpc.api.UpmsOrganizationService;
import com.tudou.upms.server.modelvalid.OrganizationValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DavidWang on 2017/6/5.
 */
@Controller
@Api(value = "组织管理", description = "组织管理")
@RequestMapping("/manage/organization")
public class UpmsOrganizationController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsOrganizationController.class);

	@Autowired
	private UpmsOrganizationService upmsOrganizationService;

	@ApiOperation(value = "组织列表")
	@RequiresPermissions("upms:organization:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OrganizationValid organizationValid) {
		UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
		UpmsOrganizationExample.Criteria criteria = upmsOrganizationExample.createCriteria();
		if (organizationValid.getOrganizationId() != null){
			criteria.andOrganizationIdEqualTo(organizationValid.getOrganizationId());
		}
		if (!StringUtils.isBlank(organizationValid.getName())){
			criteria.andNameLike("%"+ organizationValid.getName() +"%");
		}
		if (!StringUtils.isBlank(organizationValid.getDescription())){
			criteria.andDescriptionLike("%"+ organizationValid.getDescription() +"%");
		}

		List<UpmsOrganization> rows = upmsOrganizationService.selectByExampleForOffsetPage(upmsOrganizationExample,organizationValid.getPageCurrent(),organizationValid.getPageSize());
		int total = upmsOrganizationService.countByExample(upmsOrganizationExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS,rows,organizationValid.getPageSize(),organizationValid.getPageCurrent(),total);
	}

	@ApiOperation(value = "新增组织")
	@RequiresPermissions("upms:organization:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(@ModelAttribute  UpmsOrganization upmsOrganization) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		upmsOrganization.setCtime(time);
		upmsOrganization = upmsOrganizationService.createUpmsOrganization(upmsOrganization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsOrganization.getOrganizationId());
	}

	@ApiOperation(value = "删除组织")
	@RequiresPermissions("upms:organization:delete")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String organizationId) {
		int count = upmsOrganizationService.deleteByPrimaryKeys(organizationId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "修改组织")
	@RequiresPermissions("upms:organization:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@ModelAttribute UpmsOrganization upmsOrganization) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		upmsOrganization.setOrganizationId(upmsOrganization.getOrganizationId());
		int count = upmsOrganizationService.updateByPrimaryKeySelective(upmsOrganization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

}
