package com.tudou.gen.server.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tudou.common.base.BaseController;
import com.tudou.gen.common.constant.GenResult;
import com.tudou.gen.common.constant.GenResultConstant;
import com.tudou.gen.dao.model.GenScheme;
import com.tudou.gen.dao.model.GenSchemeExample;
import com.tudou.gen.rpc.api.GenSchemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "生成方案", description = "生成方案")
@RequestMapping("/manage/genscheme")
public class GenTableSchemeController extends BaseController{

	@Autowired
	GenSchemeService genSchemeService;

	@ApiOperation(value = "生成方案列表")
	@RequiresPermissions("gen:tablescheme:read")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@ModelAttribute GenScheme genScheme) {
		GenSchemeExample genSchemeExample = new GenSchemeExample();
		genSchemeExample.setOrderByClause("create_date desc");
		GenSchemeExample.Criteria criteria = genSchemeExample.createCriteria();
		if (!StringUtils.isBlank(genScheme.getName())){
			criteria.andNameLike(genScheme.getName());
		}

		if (!StringUtils.isBlank(genScheme.getPackageName())){
			criteria.andPackageNameLike(genScheme.getPackageName());
		}

		if (!StringUtils.isBlank(genScheme.getModuleName())){
			criteria.andModuleNameLike(genScheme.getModuleName());
		}

		if (!StringUtils.isBlank(genScheme.getFunctionName())){
			criteria.andFunctionAuthorLike(genScheme.getFunctionName());
		}

		if (!StringUtils.isBlank(genScheme.getFunctionAuthor())){
			criteria.andFunctionAuthorLike(genScheme.getFunctionAuthor());
		}

		int pagec = genScheme.getPageCurrent();
		int pages = genScheme.getPageSize();

		List<GenScheme> genTables = genSchemeService.selectByExampleForOffsetPage(genSchemeExample,pagec,pages);
		long total = genSchemeService.countByExample(genSchemeExample);

		return new GenResult(GenResultConstant.SUCCESS,genTables,pages,pagec,total);
	}

}
