package com.tudou.oa.service.controller.act;

import com.tudou.common.FileEnum;
import com.tudou.common.base.BaseController;
import com.tudou.common.util.VelocityUtil;
import com.tudou.oa.service.modelvalid.ExportValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.velocity.VelocityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by DavidWang on 2017/8/26.
 */
@Controller
@Api(value = "OA导出", description = "OA导出")
@RequestMapping("/act/export")
public class ActExportController extends BaseController{

    @ApiOperation(value = "文件导出")
    @RequiresPermissions("act:model:read")
    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public void word2(HttpServletResponse resp, ExportValid exportValid)throws ServletException, IOException {
        try {
            VelocityContext context = new VelocityContext();
            context.put("title",exportValid.getTitle());
            context.put("uname",exportValid.getName());
            context.put("age",exportValid.getAge());
            context.put("sex",exportValid.getSex());
            context.put("major",exportValid.getMajor());
            context.put("school",exportValid.getSchool());
            context.put("filename",exportValid.getFilename());
            context.put("introduce",exportValid.getIntroduce());
            VelocityUtil.exportFile(context,resp, FileEnum.WORD);
        }catch (Exception e){

        }
    }
}
