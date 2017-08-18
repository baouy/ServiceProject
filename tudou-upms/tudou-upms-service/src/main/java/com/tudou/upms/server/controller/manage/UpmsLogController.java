package com.tudou.upms.server.controller.manage;

import com.tudou.common.base.BaseController;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsLog;
import com.tudou.upms.dao.model.UpmsLogExample;
import com.tudou.upms.dao.model.UpmsPermissionExample;
import com.tudou.upms.rpc.api.UpmsLogService;
import com.tudou.upms.server.modelvalid.ManageLogListValid;
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
 * Created by DavidWang on 2017/6/3.
 */
@Controller
@Api(value = "日志管理", description = "日志管理")
@RequestMapping("/manage/log")
public class UpmsLogController  extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsLogController.class);

	@Autowired
	private UpmsLogService upmsLogService;

	@ApiOperation(value = "日志列表")
	@RequiresPermissions("upms:log:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute ManageLogListValid manageLogListValid) {
		UpmsLogExample upmsLogExample = new UpmsLogExample();
		upmsLogExample.setOrderByClause("log_id desc");
		UpmsLogExample.Criteria criteria = upmsLogExample.createCriteria();

		if (!StringUtils.isBlank(manageLogListValid.getDescription())){
			criteria.andDescriptionLike("%" + manageLogListValid.getDescription() + "%");
		}
		if (!StringUtils.isBlank(manageLogListValid.getUsername())){
			criteria.andUserAgentLike("%" + manageLogListValid.getUsername() + "%");
		}
		if (manageLogListValid.getStartTime() != null){
			//包含了 min 和 max 边界值 >= 0 <= time
			criteria.andStartTimeBetween(0L,manageLogListValid.getStartTime());
		}
		if (manageLogListValid.getSpendTime() != null){
			criteria.andSpendTimeBetween(0,manageLogListValid.getSpendTime());
		}
		if (!StringUtils.isBlank(manageLogListValid.getUrl())){
			criteria.andUrlLike("%" + manageLogListValid.getUrl() + "%");
		}
		if (!StringUtils.isBlank(manageLogListValid.getMethod())){
			criteria.andMethodLike("%" + manageLogListValid.getMethod() + "%");
		}
		if (!StringUtils.isBlank(manageLogListValid.getUserAgent())){
			criteria.andUserAgentLike("%" + manageLogListValid.getUserAgent() + "%");
		}
		if (!StringUtils.isBlank(manageLogListValid.getIp())){
			criteria.andIpLike("%" + manageLogListValid.getIp() + "%");
		}
		if (!StringUtils.isBlank(manageLogListValid.getPermissions())){
			criteria.andPermissionsLike("%" + manageLogListValid.getPermissions() + "%");
		}

		int pagec = manageLogListValid.getPageCurrent();
		int pages = manageLogListValid.getPageSize();

		List<UpmsLog> rows = upmsLogService.selectByExampleForOffsetPage(upmsLogExample, pagec, pages);
		long total = upmsLogService.countByExample(upmsLogExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS,rows,pages,pagec,total);
	}

	@ApiOperation(value = "删除日志")
	@RequiresPermissions("upms:log:delete")
	@RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		int count = upmsLogService.deleteByPrimaryKeys(ids);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
	
}
