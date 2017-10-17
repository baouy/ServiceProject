package com.tudou.upms.server.controller.manage;

import com.tudou.common.base.BaseController;
import com.tudou.common.base.BaseModelValid;
import com.tudou.common.util.TokenUtil;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsMarkdown;
import com.tudou.upms.dao.model.UpmsMarkdownExample;
import com.tudou.upms.rpc.api.UpmsMarkdownService;
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
 * 文章markdowncontroller
 * Created by tudou on 2017/10/17.
 */
@Controller
@RequestMapping("/manage/upmsmarkdown")
@Api(value = "文章markdown控制器", description = "文章markdown管理")
public class UpmsMarkdownController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsMarkdownController.class);

	@Autowired
	private UpmsMarkdownService upmsMarkdownService;

	@ApiOperation(value = "文章markdown列表")
	@RequiresPermissions("upms:markdown:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute UpmsMarkdown upmsMarkdown, @ModelAttribute BaseModelValid modelValid) {
		UpmsMarkdownExample upmsMarkdownExample = new UpmsMarkdownExample();
		UpmsMarkdownExample.Criteria criteria = upmsMarkdownExample.createCriteria();

		if (upmsMarkdown.getmId() != null) {
			criteria.andMIdEqualTo(upmsMarkdown.getmId());
		}
		if (!StringUtils.isBlank(upmsMarkdown.getKeywords())) {
			criteria.andKeywordsLike("%" + upmsMarkdown.getKeywords() + "%");
		}
		if (!StringUtils.isBlank(upmsMarkdown.getTitle())) {
			criteria.andTitleLike("%" + upmsMarkdown.getTitle() + "%");
		}
//		if (upmsMarkdown.getContent() != null) {
//			criteria.andContentLike("%" + upmsMarkdown.getContent() + "%");
//		}
		if (upmsMarkdown.getStatue() != null) {
			criteria.andStatueEqualTo(upmsMarkdown.getStatue());
		}
		if (upmsMarkdown.getVersion() != null) {
			criteria.andVersionEqualTo(upmsMarkdown.getVersion());
		}

		int pagec = modelValid.getPageCurrent();
		int pages = modelValid.getPageSize();
		List<UpmsMarkdown> rows = upmsMarkdownService.selectByExampleForOffsetPage(upmsMarkdownExample, pagec, pages);
		long total = upmsMarkdownService.countByExample(upmsMarkdownExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS, rows, pages, pagec, total);
	}

	@ApiOperation(value = "文章markdown详情")
	@RequiresPermissions("upms:markdown:update")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public Object detail(@ModelAttribute UpmsMarkdown upmsMarkdown) {
		UpmsMarkdownExample upmsMarkdownExample = new UpmsMarkdownExample();
		UpmsMarkdownExample.Criteria criteria = upmsMarkdownExample.createCriteria();
		criteria.andMIdEqualTo(upmsMarkdown.getmId());
		upmsMarkdown = upmsMarkdownService.selectFirstByExample(upmsMarkdownExample);

		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsMarkdown);
	}

	@ApiOperation(value = "文章markdown保存修改")
	@RequiresPermissions(value = {"upms:markdown:update", "upms:markdown:create"}, logical = Logical.OR)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@ModelAttribute UpmsMarkdown upmsMarkdown) {
		Date new_time = new Date();
		if (upmsMarkdown.getmId() != null) {
			//编辑
			UpmsMarkdownExample upmsMarkdownExample = new UpmsMarkdownExample();
			UpmsMarkdownExample.Criteria criteria = upmsMarkdownExample.createCriteria();
			criteria.andMIdEqualTo(upmsMarkdown.getmId());
			upmsMarkdownService.updateByExample(upmsMarkdown, upmsMarkdownExample);
		} else {
			//新增
			upmsMarkdownService.insertSelective(upmsMarkdown);
		}

		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsMarkdown);
	}


	@ApiOperation(value = "删除文章markdown")
	@RequiresPermissions("upms:markdown:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam UpmsMarkdown upmsMarkdown) {
		UpmsMarkdownExample upmsMarkdownExample = new UpmsMarkdownExample();
		UpmsMarkdownExample.Criteria criteria = upmsMarkdownExample.createCriteria();
		criteria.andMIdEqualTo(upmsMarkdown.getmId());
		int count = upmsMarkdownService.deleteByExample(upmsMarkdownExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}


}