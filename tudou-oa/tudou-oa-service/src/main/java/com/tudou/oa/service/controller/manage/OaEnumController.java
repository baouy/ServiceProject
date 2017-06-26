package com.tudou.oa.service.controller.manage;

import com.tudou.oa.service.modelvalid.OaEnumValid;
import com.tudou.common.base.BaseController;
import com.tudou.oa.dao.model.OaEnum;
import com.tudou.oa.dao.model.OaEnumExample;
import com.tudou.oa.rpc.api.OaEnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/manage/oaenum")
public class OaEnumController extends BaseController{

	private static Logger _log = LoggerFactory.getLogger(OaEnumController.class);

	@Autowired
	private OaEnumService oaEnumService;

	@ApiOperation(value = "枚举列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OaEnumValid oaEnumValid) {

		OaEnumExample oaEnumExample = new OaEnumExample();
		OaEnumExample.Criteria criteria = oaEnumExample.createCriteria();
		if (!StringUtils.isBlank(oaEnumValid.getName())){
			criteria.andNameLike("%" + oaEnumValid.getName() + "%");
		}

		if (oaEnumValid.getType() != null){
			criteria.andTypeEqualTo(oaEnumValid.getType());
		}

		List<OaEnum> rows = oaEnumService.selectByExampleForOffsetPage(oaEnumExample, oaEnumValid.getPageCurrent(), oaEnumValid.getPageSize());
		long total = oaEnumService.countByExample(oaEnumExample);
		Map<String, Object> result = new HashMap<>();
		result.put("data", rows);
		result.put("total", total);
		return result;
	}

}
