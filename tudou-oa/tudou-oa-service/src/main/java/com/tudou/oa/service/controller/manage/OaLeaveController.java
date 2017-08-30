package com.tudou.oa.service.controller.manage;

import com.tudou.common.base.BaseController;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.dao.model.OaEnum;
import com.tudou.oa.dao.model.OaEnumExample;
import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.dao.model.OaLeaveExample;
import com.tudou.oa.rpc.api.OaLeaveService;
import com.tudou.oa.service.controller.act.service.ActLeaveService;
import com.tudou.oa.service.modelvalid.OaEnumValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by DavidWang on 2017/8/26.
 */
@Controller
@Api(value = "OA请假", description = "OA请假")
@RequestMapping("/manage/oaleave")
public class OaLeaveController extends BaseController{

	@Resource
	private ActLeaveService actLeaveService;
	@Autowired
	private OaLeaveService oaLeaveService;

	@ApiOperation(value = "OA请假表单提交")
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(@ModelAttribute OaLeave oaLeave,boolean type,String taskId,String tag) {

		actLeaveService.save(oaLeave,type,taskId,tag);

		return new OaResult(OaResultConstant.SUCCESS,null);
	}

	@ApiOperation(value = "OA请假表单详情")
	@RequestMapping(value = "/detail")
	@ResponseBody
	public Object detail(@ModelAttribute OaLeave oaLeave) {

		OaLeaveExample oaLeaveExample = new OaLeaveExample();
		OaLeaveExample.Criteria criteria = oaLeaveExample.createCriteria();
		criteria.andProcessInstanceIdEqualTo(oaLeave.getProcessInstanceId());
		OaLeave oaLeave1 = oaLeaveService.selectFirstByExample(oaLeaveExample);

		return new OaResult(OaResultConstant.SUCCESS,oaLeave1);
	}


}
