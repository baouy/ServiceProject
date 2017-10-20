package com.tudou.oss.web.controller;

import com.tudou.common.base.BaseController;
import com.tudou.oss.common.constant.OssResult;
import com.tudou.oss.common.constant.OssResultConstant;
import com.tudou.oss.common.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qiniu/oss")
public class QiniuOssController extends BaseController{


	@RequestMapping(value = "/uptoken", method = RequestMethod.GET)
	@ResponseBody
	public Object uptocken() {
		return new OssResult(OssResultConstant.SUCCESS, QiniuUtil.getUpToken());
	}

}
