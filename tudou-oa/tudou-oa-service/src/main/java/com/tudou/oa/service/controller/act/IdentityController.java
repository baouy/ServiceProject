package com.tudou.oa.service.controller.act;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by billJiang on 2017/6/16.
 * e-mail:475572229@qq.com  qq:475572229
 * 用户/用户组控制器
 */
@Controller
@RequestMapping("/act")
public class IdentityController {

    //用户选择界面
    //multiple=0 单选  multiple=1 多选
    @RequestMapping(value = "/user/select/{multiple}/{ids}/{names}", method = RequestMethod.GET)
    public String selectUserPage(@PathVariable("multiple") String multiple,
								 @PathVariable("ids") String ids,@PathVariable("names") String names ,HttpServletRequest request) {
        request.setAttribute("multiple", multiple);
        request.setAttribute("ids", ids);
        request.setAttribute("names", names);
        return "activiti/id_user_select";
    }

    //用户组选择界面
    @RequestMapping(value = "/group/select/{ids}/{names}", method = RequestMethod.GET)
    public String selectGroupPage(@PathVariable("ids") String ids,@PathVariable("names") String names, HttpServletRequest request) {
        request.setAttribute("ids", ids);
        request.setAttribute("names", names);
        return "activiti/id_group_select";
    }

}
