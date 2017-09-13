package com.tudou.upms.server.controller.manage;

import com.alibaba.fastjson.JSON;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.validator.LengthValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsRole;
import com.tudou.upms.dao.model.UpmsSystem;
import com.tudou.upms.dao.model.UpmsSystemExample;
import com.tudou.upms.rpc.api.UpmsSystemService;
import com.tudou.upms.server.modelvalid.UpmsSystemValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DavidWang on 2017/6/6.
 */
@Controller
@Api(value = "系统管理", description = "系统管理")
@RequestMapping("/manage/system")
public class UpmsSystemController extends BaseController{

	private static Logger _log = LoggerFactory.getLogger(UpmsSystemController.class);

	@Autowired
	private UpmsSystemService upmsSystemService;

	@ApiOperation(value = "系统列表")
	@RequiresPermissions("upms:system:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute UpmsSystemValid upmsSystemValid) {

		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		UpmsSystemExample.Criteria criteria = upmsSystemExample.createCriteria();

		if (!StringUtils.isBlank(upmsSystemValid.getTitle())){
			criteria.andTitleLike("%" + upmsSystemValid.getTitle() + "%");
		}
		if (!StringUtils.isBlank(upmsSystemValid.getName())){
			criteria.andNameLike("%" + upmsSystemValid.getName() + "%");
		}
		if (!StringUtils.isBlank(upmsSystemValid.getDescription())){
			criteria.andDescriptionLike("%" + upmsSystemValid.getDescription() + "%");
		}
		if (!StringUtils.isBlank(upmsSystemValid.getBasepath())){
			criteria.andBasepathLike("%" + upmsSystemValid.getBasepath() + "%");
		}
		if (upmsSystemValid.getStatus() != null){
			criteria.andStatusEqualTo(upmsSystemValid.getStatus());
		}

		int pagec = upmsSystemValid.getPageCurrent();
		int pages = upmsSystemValid.getPageSize();
		List<UpmsSystem> rows = upmsSystemService.selectByExampleForOffsetPage(upmsSystemExample,pagec, pages);
		long total = upmsSystemService.countByExample(upmsSystemExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS,rows,pages,pagec,total);
	}

	@ApiOperation(value = "新增系统")
//	@RequiresPermissions(value = {"upms:system:create","upms:system:update"}, logical = Logical.OR)
	@RequiresPermissions("upms:system:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object create(@RequestParam String json) {
		List<UpmsSystem> upmsSystems = JSON.parseArray(json, UpmsSystem.class);
		UpmsSystem upmsSystem = upmsSystems.get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsSystem.getTitle(), new LengthValidator(1, 20, "标题"))
				.on(upmsSystem.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		upmsSystem.setCtime(time);
		upmsSystem.setOrders(time);
		int count = upmsSystemService.insertSelective(upmsSystem);

		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "修改系统")
	@RequiresPermissions("upms:system:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestParam String json) {
		List<UpmsSystem> upmsSystems = JSON.parseArray(json, UpmsSystem.class);
		UpmsSystem upmsSystem = upmsSystems.get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsSystem.getTitle(), new LengthValidator(1, 20, "标题"))
				.on(upmsSystem.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		upmsSystem.setSystemId(upmsSystem.getSystemId());
		int count = upmsSystemService.updateByPrimaryKeySelective(upmsSystem);

		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "删除系统")
	@RequiresPermissions("upms:system:delete")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String systemId) {
		int count = upmsSystemService.deleteByPrimaryKeys(systemId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

}
