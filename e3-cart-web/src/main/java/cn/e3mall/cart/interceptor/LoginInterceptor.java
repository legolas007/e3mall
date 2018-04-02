package cn.e3mall.cart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.e3mall.common.utils.CookieUtils;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.TokenService;

/**
 * 用户登录处理拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private TokenService tokenService;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String token = CookieUtils.getCookieValue(request, "token");
		if (StringUtils.isBlank(token)) {
			return true;
		}
		E3Result e3Result = tokenService.getUserByToken(token);
		
		if (e3Result.getStatus() != 200) {
			return true;
		}
		
		TbUser user = (TbUser)e3Result.getData();
		request.setAttribute("user", user);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		//handler执行之后，返回ModeAndView之前
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//完成处理，返回ModelAndView之后。
		//可以再此处理异常

	}

}
