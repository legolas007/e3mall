package cn.e3mall.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册功能Controller
 */
@Controller
public class RegitsterController {

	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
}
