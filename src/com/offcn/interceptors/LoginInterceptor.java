package com.offcn.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.pojo.Users;
import com.offcn.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器，拦截游客没登录却在只有用户能在的页面，和拦截管理员登录了还想去用户页面
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 请求被处理之前拦截判断
	 */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
    	//是否在用户界面
    	Boolean is_in_user_page = (uri.indexOf("/user") == 0);
    	//是否在登录或注册页面
    	Boolean is_in_login_page = (uri.indexOf("/user/login") == 0 || uri.indexOf("/user/reg") == 0 || uri.indexOf("/user/email") == 0) && uri.indexOf("/user/login/logout") != 0  && uri.indexOf("/user/login/ajax/logout") != 0;
    	//是否在资源页面
        Boolean is_in_asset_page = (uri.indexOf("/assets") == 0);
        //是否在用户状态判断页
        Boolean is_in_check_page = (uri.indexOf("/user/login/ajax/is_login") == 0);
        
        //无条件放行
        if(is_in_check_page) {
        	return true;
        }
        
        //读取当前用户
        Users user = new SessionUtil(httpServletRequest.getSession()).getUserFromSession();
        //没登录还瞎转悠，让他去该去的地方吧
        if(user == null && is_in_user_page && !is_in_login_page && !is_in_asset_page) {
            httpServletResponse.sendRedirect("/user/login");
            return false;
        }
        
        //登录了就不要乱走了
        if(user != null && is_in_login_page) {
            httpServletResponse.sendRedirect("/");
            return false;
        }

        //一切正常，走~
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
