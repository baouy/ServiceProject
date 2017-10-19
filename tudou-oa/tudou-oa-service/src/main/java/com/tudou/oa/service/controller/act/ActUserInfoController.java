package com.tudou.oa.service.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.common.base.BaseModelValid;
import com.tudou.common.util.RedisUtil;
import com.tudou.common.util.SerializeUtil;
import com.tudou.common.util.StringUtil;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import com.tudou.oa.service.modelvalid.OaViewUserValid;
import com.tudou.upms.dao.model.UpmsRole;
import com.tudou.upms.dao.model.UpmsRoleExample;
import com.tudou.upms.rpc.api.UpmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/act/user")
public class ActUserInfoController extends BaseController{

	@Autowired
	private OaViewUserService oaViewUserService;

	@Autowired
	private UpmsRoleService upmsRoleService;


	@ApiOperation(value = "获取系统用户")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@ModelAttribute OaViewUserValid oaViewUserValid) {

		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		OaViewUser oaViewUser = (OaViewUser) SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));
		OaViewUserExample oaViewUserExample = new OaViewUserExample();
		OaViewUserExample.Criteria criteria = oaViewUserExample.createCriteria();
		if (!StringUtils.isBlank(oaViewUserValid.getRealname())) {
			criteria.andRealnameLike("%" + oaViewUserValid.getRealname() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getFlowerName())) {
			criteria.andFlowerNameLike("%" + oaViewUserValid.getFlowerName() + "%");
		}
		if (!StringUtils.isBlank(oaViewUserValid.getUsername())) {
			criteria.andUsernameLike("%" + oaViewUserValid.getUsername() + "%");
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

		if (!StringUtils.isBlank(oaViewUserValid.getRoleId())){
			List<String> stringList = StringUtil.stringList(oaViewUserValid.getRoleId());
			if(stringList.size() > 1){
				List<Integer> list = new ArrayList<Integer>();
				for (String a : stringList){
					list.add(Integer.valueOf(a));
				}
				criteria.andRoleIdIn(list);
			}else{
				criteria.andRoleIdEqualTo(stringList.get(0));
			}
		}

		int pagec = oaViewUserValid.getPageCurrent();
		int pages = oaViewUserValid.getPageSize();

		List<OaViewUser> rows = oaViewUserService.selectByExampleForOffsetPage(oaViewUserExample, pagec,pages);
		long total = oaViewUserService.countByExample(oaViewUserExample);

		return new OaResult(OaResultConstant.SUCCESS,rows,pages,pagec,total);
	}


	@ApiOperation(value = "获取系统角色列表")
	@RequestMapping(value = "/role/list", method = RequestMethod.POST)
	@ResponseBody
	public Object role_list(@ModelAttribute UpmsRole upmsRole, @ModelAttribute BaseModelValid baseModelValid) {

		UpmsRoleExample upmsRoleExample = new UpmsRoleExample();
		UpmsRoleExample.Criteria criteria = upmsRoleExample.createCriteria();

		if (upmsRole.getRoleId() != null) {
			criteria.andRoleIdEqualTo(upmsRole.getRoleId());
		}

		if (!StringUtils.isBlank(upmsRole.getName())) {
			criteria.andNameLike("%" + upmsRole.getName() + "%");
		}

		if (!StringUtils.isBlank(upmsRole.getTitle())) {
			criteria.andTitleLike("%" + upmsRole.getTitle() + "%");
		}

		int pagec = baseModelValid.getPageCurrent();
		int pages = baseModelValid.getPageSize();

		List<UpmsRole> rows = upmsRoleService.selectByExample(upmsRoleExample);
		long total = upmsRoleService.countByExample(upmsRoleExample);

		return new OaResult(OaResultConstant.SUCCESS,rows,pages,pagec,total);

	}

}
