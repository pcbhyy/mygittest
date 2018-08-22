package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//判断是否想自动登录
		Cookie[] cookies = request.getCookies();
		
		String username = null;
		String autoLogin = null;
		
		for(Cookie cookie : cookies) {
			if("username".equals(cookie.getName())){
				username = cookie.getValue();
			}else if("autoLogin".equals(cookie.getName())) {
				autoLogin = cookie.getValue();
			}
		}
		
		if(username != null && autoLogin != null) {
			if("admin".equals(username) && "123".equals(autoLogin)) {
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}
		}else {
			//判断请求中是否有用户名和密码
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			if("admin".equals(name) && "123".equals(password)) {
				//判断是否选择了自动登录，如果选择了自动登录，向两个cookie中分别放入用户名和密码
				String auto = request.getParameter("autoLogin");
				if(auto != null) {
					Cookie cookie = new Cookie("username", name);
					cookie.setMaxAge(60*60*24*10);
					response.addCookie(cookie);
					
					cookie = new Cookie("autoLogin", password);
					cookie.setMaxAge(60*60*24*10);
					response.addCookie(cookie);
				}
				
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			}			
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean doAutoLogin(HttpServletRequest request,HttpServletResponse response) throws
	ServletException, IOException { 
		String username = null;
		String autoLogin = null;
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("username".equals(cookie.getName())) {
					username = cookie.getValue();
				}else if("autoLogin".equals(cookie.getName())) {
					autoLogin = cookie.getValue();
				}
			}
		}
		
		if(username != null && autoLogin != null) {
			return true;
		}
		
		return false;
	 }


}
