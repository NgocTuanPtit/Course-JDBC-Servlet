package com.tony_funny.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tony_funny.constant.SystemConstant;
import com.tony_funny.model.UserModel;
import com.tony_funny.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

    private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();	
	}

	@Override
	public void doFilter(ServletRequest requestt, ServletResponse responsee, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) requestt;
       HttpServletResponse response = (HttpServletResponse) responsee;
       String url = request.getRequestURI();
       if (url.startsWith("/admin")) {
           UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
           if (model != null) {
               if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
            	   chain.doFilter(requestt, responsee);
               } else if (model.getRole().getCode().equals(SystemConstant.USER)) {
                   response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
               }
           } else {
               response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
           }
       } else {
    	   chain.doFilter(requestt, responsee);
       }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
