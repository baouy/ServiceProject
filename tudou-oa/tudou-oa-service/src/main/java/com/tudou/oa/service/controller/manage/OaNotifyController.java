package com.tudou.oa.service.controller.manage;

import com.tudou.common.base.BaseController;
import com.tudou.common.base.BaseResult;
import com.tudou.common.util.QiniuUtil;
import com.tudou.common.util.TokenUtil;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.dao.model.OaNotify;
import com.tudou.oa.dao.model.OaNotifyExample;
import com.tudou.oa.rpc.api.OaNotifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 通知通告controller
 * Created by tudou on 2017/9/13.
 */
@Controller
@RequestMapping("/manage/oanotify")
@Api(value = "通知通告控制器", description = "通知通告管理")
public class OaNotifyController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(OaNotifyController.class);

	@Autowired
	private OaNotifyService oaNotifyService;

	@RequestMapping(value = "/uptoken", method = RequestMethod.GET)
	@ResponseBody
	public Object uptocken(@ModelAttribute OaNotify oaNotify) {
		return new BaseResult(1,"ok",QiniuUtil.getUpToken());
	}

	@ApiOperation(value = "通知通告列表")
	@RequiresPermissions("oa:notify:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OaNotify oaNotify) {
		OaNotifyExample oaNotifyExample = new OaNotifyExample();
		OaNotifyExample.Criteria criteria = oaNotifyExample.createCriteria();

		if (!StringUtils.isBlank(oaNotify.getId())) {
			criteria.andIdLike("%" + oaNotify.getId() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getType())) {
			criteria.andTypeLike("%" + oaNotify.getType() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getTitle())) {
			criteria.andTitleLike("%" + oaNotify.getTitle() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getContent())) {
			criteria.andContentLike("%" + oaNotify.getContent() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getFiles())) {
			criteria.andFilesLike("%" + oaNotify.getFiles() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getStatus())) {
			criteria.andStatusLike("%" + oaNotify.getStatus() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getCreateBy())) {
			criteria.andCreateByLike("%" + oaNotify.getCreateBy() + "%");
		}


		if (!StringUtils.isBlank(oaNotify.getUpdateBy())) {
			criteria.andUpdateByLike("%" + oaNotify.getUpdateBy() + "%");
		}


		if (!StringUtils.isBlank(oaNotify.getRemarks())) {
			criteria.andRemarksLike("%" + oaNotify.getRemarks() + "%");
		}

		if (!StringUtils.isBlank(oaNotify.getDelFlag())) {
			criteria.andDelFlagLike("%" + oaNotify.getDelFlag() + "%");
		}


		int pagec = oaNotify.getPageCurrent();
		int pages = oaNotify.getPageSize();
		List<OaNotify> rows = oaNotifyService.selectByExampleForOffsetPage(oaNotifyExample, pagec, pages);
		long total = oaNotifyService.countByExample(oaNotifyExample);
		return new OaResult(OaResultConstant.SUCCESS, rows, pages, pagec, total);
	}

	@ApiOperation(value = "通知通告详情")
	@RequiresPermissions("oa:notify:update")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public Object detail(@ModelAttribute OaNotify oaNotify) {
		OaNotifyExample oaNotifyExample = new OaNotifyExample();
		OaNotifyExample.Criteria criteria = oaNotifyExample.createCriteria();
		criteria.andIdEqualTo(oaNotify.getId());
		oaNotify = oaNotifyService.selectFirstByExample(oaNotifyExample);

		return new OaResult(OaResultConstant.SUCCESS, oaNotify);
	}


	@ApiOperation(value = "通知通告保存修改")
	@RequiresPermissions(value = {"oa:notify:update", "oa:notify:create"}, logical = Logical.OR)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@ModelAttribute OaNotify oaNotify) {
		if (!StringUtils.isBlank(oaNotify.getId())) {
			//编辑
			OaNotifyExample oaNotifyExample = new OaNotifyExample();
			OaNotifyExample.Criteria criteria = oaNotifyExample.createCriteria();
			criteria.andIdEqualTo(oaNotify.getId());
			oaNotify.setUpdateBy(TokenUtil.getUserName());
			oaNotify.setUpdateDate(new Date());
			oaNotifyService.updateByExampleSelective(oaNotify, oaNotifyExample);
		} else {
			//新增
			oaNotify.setCreateBy(TokenUtil.getUserName());
			oaNotify.setCreateDate(new Date());
			oaNotify.setUpdateBy(TokenUtil.getUserName());
			oaNotify.setUpdateDate(new Date());
			oaNotifyService.insertSelective(oaNotify);
		}

		return new OaResult(OaResultConstant.SUCCESS, oaNotify);
	}


	@ApiOperation(value = "删除通知通告")
	@RequiresPermissions("oa:notify:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(OaNotify oaNotify) {
		OaNotifyExample oaNotifyExample = new OaNotifyExample();
		OaNotifyExample.Criteria criteria = oaNotifyExample.createCriteria();
		criteria.andIdEqualTo(oaNotify.getId());
		int count = oaNotifyService.deleteByExample(oaNotifyExample);
		return new OaResult(OaResultConstant.SUCCESS, count);
	}


}