package com.tudou.upms.server.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.validator.LengthValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsOrganization;
import com.tudou.upms.dao.model.UpmsOrganizationExample;
import com.tudou.upms.rpc.api.UpmsOrganizationService;
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
	public Object list(
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
			@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
			@RequestParam(required = false, defaultValue = "", value = "search") String search,
			@RequestParam(required = false, value = "sort") String sort,
			@RequestParam(required = false, value = "order") String order) {
		UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
		if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
			upmsOrganizationExample.setOrderByClause(sort + " " + order);
		}
		if (StringUtils.isNotBlank(search)) {
			upmsOrganizationExample.or()
					.andNameLike("%" + search + "%");
		}
		List<UpmsOrganization> rows = upmsOrganizationService.selectByExampleForOffsetPage(upmsOrganizationExample, offset, limit);
		long total = upmsOrganizationService.countByExample(upmsOrganizationExample);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", rows);
		result.put("total", total);
		return result;
	}

	@ApiOperation(value = "新增组织")
	@RequiresPermissions("upms:organization:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(UpmsOrganization upmsOrganization) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		upmsOrganization.setCtime(time);
		int count = upmsOrganizationService.insertSelective(upmsOrganization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "删除组织")
	@RequiresPermissions("upms:organization:delete")
	@RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		int count = upmsOrganizationService.deleteByPrimaryKeys(ids);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "修改组织")
	@RequiresPermissions("upms:organization:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable("id") int id, UpmsOrganization upmsOrganization) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsOrganization.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		upmsOrganization.setOrganizationId(id);
		int count = upmsOrganizationService.updateByPrimaryKeySelective(upmsOrganization);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

}
