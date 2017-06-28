package com.tudou.oa.service.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.validator.LengthValidator;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.dao.model.OaUserDetails;
import com.tudou.oa.rpc.api.OaUserDetailsService;
import com.tudou.oa.service.modelvalid.OaViewUserValid;
import com.tudou.common.base.BaseController;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.rpc.api.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DavidWang on 2017/6/24.
 */
@Controller
@Api(value = "OA枚举管理", description = "OA枚举管理")
@RequestMapping("/manage/oauserdetail")
public class OaUserDetailsController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(OaUserDetailsController.class);

	@Autowired
	private OaViewUserService oaViewUserService;

	@Autowired
	private UpmsUserService upmsUserService;

	@Autowired
	private OaUserDetailsService oaUserDetailsService;

	@ApiOperation(value = "用户列表")
	@RequiresPermissions("oa:userdetail:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OaViewUserValid oaViewUserValid) {
		OaViewUserExample oaViewUserExample = new OaViewUserExample();
		OaViewUserExample.Criteria criteria = oaViewUserExample.createCriteria();

		if (!StringUtils.isBlank(oaViewUserValid.getWorkNum())) {
			criteria.andWorkNumLike("%" + oaViewUserValid.getWorkNum() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getRealname())) {
			criteria.andRealnameLike("%" + oaViewUserValid.getRealname() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getFlowerName())) {
			criteria.andFlowerNameLike("%" + oaViewUserValid.getFlowerName() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getUsername())) {
			criteria.andUsernameLike("%" + oaViewUserValid.getUsername() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getOrganization())) {
			criteria.andOrganizationLike("%" + oaViewUserValid.getOrganization() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getDepartment())) {
			criteria.andDepartmentLike("%" + oaViewUserValid.getDepartment() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getPhone())) {
			criteria.andPhoneLike("%" + oaViewUserValid.getPhone() + "%");
		}
		if (oaViewUserValid.getSex() != null) {
			criteria.andSexEqualTo(oaViewUserValid.getSex());
		}
		if (!StringUtils.isBlank(oaViewUserValid.getCompanyMobile())) {
			criteria.andCompanyMobileLike("%" + oaViewUserValid.getCompanyMobile() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getCompanyEmail())) {
			criteria.andCompanyEmailLike("%" + oaViewUserValid.getCompanyEmail() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getIdNumber())) {
			criteria.andIdNumberLike("%" + oaViewUserValid.getIdNumber() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getIdAddress())) {
			criteria.andIdAddressLike("%" + oaViewUserValid.getIdAddress() + "%");
		}
		if (oaViewUserValid.getLocked() != null) {
			criteria.andLockedEqualTo(oaViewUserValid.getLocked());
		}
		if (!StringUtils.isBlank(oaViewUserValid.getEmail())) {
			criteria.andEmailLike("%" + oaViewUserValid.getEmail() + "%");
		}

		List<OaViewUser> rows = oaViewUserService.selectByExampleForOffsetPage(oaViewUserExample, oaViewUserValid.getPageSize(), oaViewUserValid.getPageCurrent());

		int total = oaViewUserService.countByExample(oaViewUserExample);

		return new OaResult(OaResultConstant.SUCCESS,rows,oaViewUserValid.getPageSize(),oaViewUserValid.getPageCurrent(),total);
	}

	@ApiOperation(value = "新增权限")
	@RequiresPermissions("oa:userdetail:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(@ModelAttribute UpmsUser upmsUser, @ModelAttribute OaUserDetails oaUserDetails) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsUser.getUsername(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new OaResult(OaResultConstant.INVALID_LENGTH, result.getErrors());
		}
//		long time = System.currentTimeMillis();
//		upmsPermission.setCtime(time);
//
//		if (upmsPermission.getOrders() == null){
//			upmsPermission.setOrders(time);
//		}
//
//		upmsPermission = upmsPermissionService.createUpmsPermission(upmsPermission);
		return new OaResult(OaResultConstant.SUCCESS, null);
	}


}
