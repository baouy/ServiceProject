package com.tudou.oa.service.controller.manage;

import com.tudou.oa.service.modelvalid.OaViewUserValid;
import com.tudou.common.base.BaseController;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@ApiOperation(value = "用户列表")
	@RequiresPermissions("upms:oa_userdetail:read")
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

		long total = oaViewUserService.countByExample(oaViewUserExample);

		Map<String, Object> result = new HashMap<>();
		result.put("data", rows);
		result.put("total", total);
		return result;
	}


}
