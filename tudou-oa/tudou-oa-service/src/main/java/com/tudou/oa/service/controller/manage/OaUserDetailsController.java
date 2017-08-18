package com.tudou.oa.service.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.util.MD5Util;
import com.tudou.common.util.RedisUtil;
import com.tudou.common.util.SerializeUtil;
import com.tudou.common.util.StringUtil;
import com.tudou.common.validator.LengthValidator;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.dao.model.OaUserDetails;
import com.tudou.oa.dao.model.OaUserDetailsExample;
import com.tudou.oa.rpc.api.OaUserDetailsService;
import com.tudou.oa.service.modelvalid.OaViewUserValid;
import com.tudou.common.base.BaseController;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.*;
import com.tudou.upms.rpc.api.UpmsOrganizationService;
import com.tudou.upms.rpc.api.UpmsUserOrganizationService;
import com.tudou.upms.rpc.api.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

	@Autowired
	private UpmsOrganizationService upmsOrganizationService;

	@Autowired
	private UpmsUserOrganizationService upmsUserOrganizationService;

	@ApiOperation(value = "用户列表")
	@RequiresPermissions("oa:userdetail:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OaViewUserValid oaViewUserValid) {

		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		OaViewUser oaViewUser = (OaViewUser)SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));

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
		if (!StringUtils.isBlank(oaViewUser.getOrganizationId())){
			List<String> stringList = StringUtil.stringList(oaViewUser.getOrganizationId());
			if(stringList.size() > 1){
				List<Integer> list = new ArrayList<Integer>();
				for (String a : stringList){
					list.add(Integer.valueOf(a));
				}
				criteria.andOrganizationIdIn(list);
			}else{
				criteria.andOrganizationIdEqualTo(stringList.get(0));
			}

		}
		int pagec = oaViewUserValid.getPageCurrent();
		int pages = oaViewUserValid.getPageSize();

		List<OaViewUser> rows = oaViewUserService.selectByExampleForOffsetPage(oaViewUserExample, pagec,pages);
		long total = oaViewUserService.countByExample(oaViewUserExample);

		return new OaResult(OaResultConstant.SUCCESS,rows,pages,pagec,total);
	}

	@ApiOperation(value = "新增用户权限")
	@RequiresPermissions("oa:userdetail:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(@ModelAttribute UpmsUser upmsUser, @ModelAttribute OaUserDetails oaUserDetails,@ModelAttribute UpmsUserOrganization upmsUserOrganization) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsUser.getUsername(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new OaResult(OaResultConstant.INVALID_LENGTH, result.getErrors());
		}

		OaUserDetailsExample oaUserDetailsExample = new OaUserDetailsExample();
		oaUserDetailsExample.createCriteria().andFlowerNameEqualTo(oaUserDetails.getFlowerName());

		long num = oaUserDetailsService.countByExample(oaUserDetailsExample);
		if (num > 0){
			return new OaResult(OaResultConstant.FAILED, "花名已经存在！");
		}

		check_username(upmsUser);

		long time = System.currentTimeMillis();
		upmsUser.setCtime(time);
		upmsUser = upmsUserService.createUser(upmsUser);
		if (null == upmsUser) {
			return new OaResult(OaResultConstant.FAILED, "帐号名已存在！");
		}

		oaUserDetails.setUserId(upmsUser.getUserId());
		oaUserDetailsService.insertSelective(oaUserDetails);
		upmsUserOrganization.setUserId(upmsUser.getUserId());
		upmsUserOrganizationService.insertSelective(upmsUserOrganization);

		return new OaResult(OaResultConstant.SUCCESS, null);
	}

	@ApiOperation(value = "新增用户")
	@RequiresPermissions(value = {"oa:userdetail:leave","oa:userdetail:update"}, logical = Logical.OR)
	@ResponseBody
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public Object detail(@PathVariable("id") int id) {
		UpmsUser upmsUser = upmsUserService.selectByPrimaryKey(id);
		OaUserDetails oaUserDetails = oaUserDetailsService.selectByPrimaryKey(id);
		Map<String,Object> map = new HashMap();
		map.put("upmsUser",upmsUser);
		map.put("oaUserDetails",oaUserDetails);
		return new OaResult(OaResultConstant.SUCCESS, map);
	}

	@ApiOperation(value = "更新用户")
	@RequiresPermissions("oa:userdetail:update")
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(@ModelAttribute UpmsUser upmsUser, @ModelAttribute OaUserDetails oaUserDetails) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsUser.getUsername(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new OaResult(OaResultConstant.INVALID_LENGTH, result.getErrors());
		}

		UpmsUserExample upmsUserExample = new UpmsUserExample();
		UpmsUserExample.Criteria u_criteria = upmsUserExample.createCriteria();
		u_criteria.andUserIdNotEqualTo(upmsUser.getUserId());
		u_criteria.andUsernameEqualTo(upmsUser.getUsername());
		long u_num = upmsUserService.countByExample(upmsUserExample);
		if (u_num > 0){
			return new OaResult(OaResultConstant.FAILED, "登录账号已经存在！");
		}

		OaUserDetailsExample oaUserDetailsExample = new OaUserDetailsExample();
		OaUserDetailsExample.Criteria criteria = oaUserDetailsExample.createCriteria();
		criteria.andFlowerNameEqualTo(oaUserDetails.getFlowerName());
		criteria.andUserIdNotEqualTo(upmsUser.getUserId());
		long num = oaUserDetailsService.countByExample(oaUserDetailsExample);
		if (num > 0){
			return new OaResult(OaResultConstant.FAILED, "花名已经存在！");
		}

		check_username(upmsUser);
		upmsUserService.updateByPrimaryKeySelective(upmsUser);
		oaUserDetailsService.updateByPrimaryKeySelective(oaUserDetails);

		return new OaResult(OaResultConstant.SUCCESS, null);
	}

	/**
	 * 判断是否有登录名称
	 * @param upmsUser
	 */
	private void check_username(UpmsUser upmsUser){
		if (!StringUtils.isBlank(upmsUser.getUsername())){
			upmsUser.setLocked((byte) 0);
			String salt = UUID.randomUUID().toString().replaceAll("-", "");
			upmsUser.setSalt(salt);
			upmsUser.setPassword(MD5Util.MD5("123456" + upmsUser.getSalt()));
		}
	}

	@ApiOperation(value = "员工离职")
	@RequiresPermissions("oa:userdetail:leave")
	@ResponseBody
	@RequestMapping(value = "/leave", method = RequestMethod.POST)
	public Object leave(@ModelAttribute UpmsUser upmsUser,@ModelAttribute OaUserDetails oaUserDetails) {

		upmsUser.setLocked((byte) 1);
		upmsUserService.updateByPrimaryKeySelective(upmsUser);
		oaUserDetailsService.updateByPrimaryKeySelective(oaUserDetails);

		return new OaResult(OaResultConstant.SUCCESS, null);
	}

	@ApiOperation(value = "用户所在组织列表")
	@RequiresPermissions(value = {"oa:userdetail:create"}, logical = Logical.OR)
	@RequestMapping(value = "/organization/list", method = RequestMethod.GET)
	@ResponseBody
	public Object organization_list() {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		OaViewUser oaViewUser = (OaViewUser)SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));
		List<String> stringList = StringUtil.stringList(oaViewUser.getOrganizationId());
		List<Integer> list = new ArrayList<Integer>();
		for (String a : stringList){
			list.add(Integer.valueOf(a));
		}

		UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
		UpmsOrganizationExample.Criteria criteria = upmsOrganizationExample.createCriteria();
		criteria.andOrganizationIdIn(list);

		UpmsOrganizationExample.Criteria criteria1 = upmsOrganizationExample.createCriteria();
		upmsOrganizationExample.or(criteria1);
		criteria1.andFidIn(list);

		List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(upmsOrganizationExample);

		return new OaResult(OaResultConstant.SUCCESS,upmsOrganizations);
	}

	@ApiOperation(value = "用户组织")
	@RequiresPermissions("oa:userdetail:organization")
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object organization(@PathVariable("id") int id) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		OaViewUser oaViewUser = (OaViewUser)SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));
		List<String> stringList = StringUtil.stringList(oaViewUser.getOrganizationId());
		List<Integer> list = new ArrayList<Integer>();
		for (String a : stringList){
			list.add(Integer.valueOf(a));
		}
		UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
		UpmsOrganizationExample.Criteria criteria = upmsOrganizationExample.createCriteria();
		criteria.andOrganizationIdIn(list);

		UpmsOrganizationExample.Criteria criteria1 = upmsOrganizationExample.createCriteria();
		upmsOrganizationExample.or(criteria1);
		criteria1.andFidIn(list);

		List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectByExample(upmsOrganizationExample);
		UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
		upmsUserOrganizationExample.createCriteria()
				.andUserIdEqualTo(id);
		List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("upmsOrganizations",upmsOrganizations);
		map.put("upmsUserOrganizations",upmsUserOrganizations);
		return new UpmsResult(UpmsResultConstant.SUCCESS, map);
	}

	@ApiOperation(value = "用户组织")
	@RequiresPermissions("oa:userdetail:organization")
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object organization(@PathVariable("id") int id,@RequestParam(value = "organizationId[]") String [] organizationId) {
		upmsUserOrganizationService.organization(organizationId, id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, "");
	}

}
