package com.tudou.gen.server.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tudou.common.util.IdGen;
import com.tudou.common.util.StringUtil;
import com.tudou.common.util.TokenUtil;
import com.tudou.gen.common.constant.GenResult;
import com.tudou.gen.common.constant.GenResultConstant;
import com.tudou.gen.dao.model.*;
import com.tudou.gen.rpc.api.GenApiService;
import com.tudou.gen.rpc.api.GenTableColumnService;
import com.tudou.gen.rpc.api.GenTableService;
import com.tudou.gen.server.modelvalid.GenTableAddValid;
import com.tudou.gen.server.modelvalid.GenTableColumnValid;
import com.tudou.gen.server.util.GenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DavidWang on 2017/9/4.
 */
@Controller
@Api(value = "业务表列表", description = "业务表列表")
@RequestMapping("/manage/gentable")
public class GenTableController {

	@Autowired
	GenTableService genTableService;
	@Autowired
	GenTableColumnService genTableColumnService;

	@Autowired
	GenApiService genApiService;

	@ApiOperation(value = "业务表列表")
	@RequiresPermissions("gen:table:read")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@ModelAttribute GenTable genTable) {
		GenTableExample genTableExample = new GenTableExample();
		genTableExample.setOrderByClause("create_date desc");
		GenTableExample.Criteria criteria = genTableExample.createCriteria();
		if (!StringUtils.isBlank(genTable.getName())){
			criteria.andNameLike(genTable.getName());
		}

		if (!StringUtils.isBlank(genTable.getComments())){
			criteria.andCommentsLike(genTable.getComments());
		}

		if (!StringUtils.isBlank(genTable.getClassName())){
			criteria.andClassNameLike(genTable.getClassName());
		}

		int pagec = genTable.getPageCurrent();
		int pages = genTable.getPageSize();

		List<GenTable> genTables = genTableService.selectByExampleForOffsetPage(genTableExample,pagec,pages);
		long total = genTableService.countByExample(genTableExample);

		return new GenResult(GenResultConstant.SUCCESS,genTables,pages,pagec,total);
	}

	@ApiOperation(value = "数据库列表")
	@RequiresPermissions(value = {"gen:table:create","gen:table:update"},logical = Logical.OR)
	@RequestMapping(value = "/dblist")
	@ResponseBody
	public Object dblist(@ModelAttribute TableList tableList) {

		List<TableList> tableLists = genApiService.findTableList(tableList);

		return new GenResult(GenResultConstant.SUCCESS,tableLists);
	}

	@ApiOperation(value = "数据库详情列表")
	@RequiresPermissions(value = {"gen:table:create","gen:table:update"},logical = Logical.OR)
	@RequestMapping(value = "/dblist_detail")
	@ResponseBody
	public Object dblist_detail(@ModelAttribute TableList tableList) {
		List<GenTableColumn> genTableColumns = genApiService.findTableColumnList(tableList);
		ArrayList<GenTableColumn> genTableColumnArrayList = null;
		List<String> strings = genApiService.findTablePK(tableList);

		GenTableColumnValid genTableColumnValid = new GenTableColumnValid();
		if (StringUtils.isBlank(tableList.getId())){
			genTableColumnArrayList = new ArrayList<>(genTableColumns);
			GenTableExample genTableExample = new GenTableExample();
			GenTableExample.Criteria criteria = genTableExample.createCriteria();
			criteria.andNameEqualTo(tableList.getName());
			long num = genTableService.countByExample(genTableExample);
			if (num != 0){
				return new GenResult(GenResultConstant.FAILED,tableList.getName()+"表已经添加");
			}
			genTableColumnValid.setClassName(StringUtil.toCapitalizeCamelCase(tableList.getName()));
		}else{
			GenTableColumnExample genTableColumnExample = new GenTableColumnExample();
			genTableColumnExample.setOrderByClause("sort asc");
			GenTableColumnExample.Criteria criteria1 = genTableColumnExample.createCriteria();
			criteria1.andGenTableIdEqualTo(tableList.getId());
			//插入表读出columns ，genTableColumnArrayList 系统表
			List<GenTableColumn> columns = genTableColumnService.selectByExample(genTableColumnExample);
			genTableColumnArrayList = new ArrayList<>(columns);
			for(GenTableColumn column : genTableColumns){
				boolean b = false;
				for (GenTableColumn column1 : genTableColumnArrayList){
					if (column1.getName().equals(column.getName())){
						b = true;
					}
				}
				if (!b){
					genTableColumnArrayList.add(column);
				}
			}

			for (GenTableColumn column1 : genTableColumns){
				boolean b = false;
				for(GenTableColumn column : columns){
					if (!column1.getName().equals(column.getName())){
						b = true;
					}
				}
				if(!b){
					column1.setDelFlag("1");
				}
			}
		}
		genTableColumnValid.setGenTableColumns(genTableColumnArrayList);
		genTableColumnValid.setPkList(strings);
		GenUtils.initColumnField(genTableColumnValid);

		return new GenResult(GenResultConstant.SUCCESS,genTableColumnValid);
	}

	@ApiOperation(value = "数据库详情保存")
	@RequiresPermissions(value = {"gen:table:create","gen:table:update"} ,logical = Logical.OR)
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(@RequestBody GenTableAddValid genTableAddValid) {
		String name = TokenUtil.getUserName();
		Date new_time = new Date();
		GenTableExample genTableExample = new GenTableExample();
		GenTableExample.Criteria criteria = genTableExample.createCriteria();
		if (!StringUtils.isBlank(genTableAddValid.getGenTable().getName())){
			criteria.andNameLike(genTableAddValid.getGenTable().getName());
		}
		long num = genTableService.countByExample(genTableExample);
		if (num == 0){
			genTableAddValid.getGenTable().setId(IdGen.uuid());
			genTableAddValid.getGenTable().setCreateBy(name);
			genTableAddValid.getGenTable().setCreateDate(new_time);
			genTableService.insertSelective(genTableAddValid.getGenTable());
		}else{
			GenTableColumnExample genTableColumnExample = new GenTableColumnExample();
			GenTableColumnExample.Criteria criteria1 = genTableColumnExample.createCriteria();
			criteria1.andGenTableIdEqualTo(genTableAddValid.getGenTable().getId());
			genTableColumnService.deleteByExample(genTableColumnExample);
		}
		for (GenTableColumn genTableColumn : genTableAddValid.getList()){
			genTableColumn.setId(IdGen.uuid());
			genTableColumn.setGenTableId(genTableAddValid.getGenTable().getId());
			genTableColumn.setCreateBy(name);
			genTableColumn.setCreateDate(new_time);
			genTableColumn.setUpdateBy(name);
			genTableColumn.setUpdateDate(new_time);
			genTableColumnService.insertSelective(genTableColumn);

		}
		return new GenResult(GenResultConstant.SUCCESS,null);
	}

	@ApiOperation(value = "数据库列表")
	@RequiresPermissions("gen:table:delete")
	@RequestMapping(value = "/delete")
	@ResponseBody
	public Object delete(@ModelAttribute GenTable genTable) {
		GenTableExample genTableExample = new GenTableExample();
		GenTableExample.Criteria criteria = genTableExample.createCriteria();
		criteria.andIdEqualTo(genTable.getId());
		genTableService.deleteByExample(genTableExample);
		GenTableColumnExample genTableColumnExample = new GenTableColumnExample();
		GenTableColumnExample.Criteria criteria1 = genTableColumnExample.createCriteria();
		criteria1.andGenTableIdEqualTo(genTable.getId());
		genTableColumnService.deleteByExample(genTableColumnExample);

		return new GenResult(GenResultConstant.SUCCESS,null);
	}

}
