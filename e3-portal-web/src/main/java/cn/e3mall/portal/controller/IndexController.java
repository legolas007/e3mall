package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 首页展示Controller
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p > 
 * @version 1.0
 */
@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String showIndex(Model model) {
		//查询内容列表
		
		return "index";
	}
}
