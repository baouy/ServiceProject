package com.tudou.gen.server.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tudou.common.base.BaseController;
import com.tudou.common.util.IdGen;
import com.tudou.common.util.TokenUtil;
import com.tudou.gen.common.constant.GenResult;
import com.tudou.gen.common.constant.GenResultConstant;
import com.tudou.gen.dao.model.*;
import com.tudou.gen.rpc.api.GenSchemeService;
import com.tudou.gen.rpc.api.GenTableColumnService;
import com.tudou.gen.rpc.api.GenTableService;
import com.tudou.gen.server.util.GeneratourUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@Api(value = "生成方案", description = "生成方案")
@RequestMapping("/manage/genscheme")
public class GenTableSchemeController extends BaseController{

	@Autowired
	GenSchemeService genSchemeService;
	@Autowired
	GenTableService genTableService;
	@Autowired
	GenTableColumnService genTableColumnService;

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

	@ApiOperation(value = "生成方案列表")
	@RequiresPermissions(value = {"gen:tablescheme:create","gen:tablescheme:update"},logical = Logical.OR)
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(@ModelAttribute GenScheme genScheme,@RequestParam int status) {
		//保存方案
		if (status == 1 || status == 2){
			GenTableColumnExample genTableColumnExample = new GenTableColumnExample();
			genTableColumnExample.setOrderByClause("sort asc");
			GenTableColumnExample.Criteria criteria1 = genTableColumnExample.createCriteria();
			criteria1.andGenTableIdEqualTo(genScheme.getGenTableId());
			//插入表读出columns ，genTableColumnArrayList 系统表
			List<GenTableColumn> columns = genTableColumnService.selectByExample(genTableColumnExample);

			GenTableExample genTableExample = new GenTableExample();
			GenTableExample.Criteria criteria = genTableExample.createCriteria();
			criteria.andIdEqualTo(genScheme.getGenTableId());
			GenTable genTable = genTableService.selectFirstByExample(genTableExample);
			GeneratourUtil.ChooseVM(genScheme,columns,genTable);
		}
		if (StringUtils.isBlank(genScheme.getId())){
			//新增
			genScheme.setId(IdGen.uuid());
			genScheme.setCreateBy(TokenUtil.getUserName());
			genScheme.setCreateDate(new Date());
			genSchemeService.insertSelective(genScheme);
		}else{
			//编辑
			if (status == 1 || status == 0){
				GenSchemeExample genSchemeExample = new GenSchemeExample();
				GenSchemeExample.Criteria criteria = genSchemeExample.createCriteria();
				criteria.andIdEqualTo(genScheme.getId());
				genScheme.setUpdateBy(TokenUtil.getUserName());
				genScheme.setUpdateDate(new Date());
				genSchemeService.updateByExampleSelective(genScheme,genSchemeExample);
			}
		}

		return new GenResult(GenResultConstant.SUCCESS,null);
	}

	@ApiOperation(value = "生成方案列表")
	@RequiresPermissions("gen:tablescheme:update")
	@RequestMapping(value = "/detail")
	@ResponseBody
	public Object detail(String id) {
		GenSchemeExample genSchemeExample = new GenSchemeExample();
		GenSchemeExample.Criteria criteria = genSchemeExample.createCriteria();
		criteria.andIdEqualTo(id);
		GenScheme genScheme = genSchemeService.selectFirstByExample(genSchemeExample);
		return new GenResult(GenResultConstant.SUCCESS,genScheme);
	}



}
