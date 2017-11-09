package com.ynov.appbancairev2.servlet;
import javax.servlet.http.HttpServletRequest;

public class ServletHelper {
	
	public static final String ACCOUNT = "/WEB-INF/views/account.jsp";	
	public static final String SERVLET_ACCOUNT = "/ClientAccount";	
	public static final String LOGIN = "/WEB-INF/views/accueil.jsp";	
	public static final String SERVLET_LOGIN = "/Accueil";	
	public static final String TRANSACTIONS = "/WEB-INF/views/transactions.jsp";	
	public static final String SERVLET_TRANSACTIONS = "/Transactions/*";	
	public static final String UPDATEPASSWORD = "/WEB-INF/views/updatePassword.jsp";
	public static final String SERVLET_UPDATEPASSWORD = "/UpdateClientPassword";
	
	public static String getServletUrl(String servlet, HttpServletRequest request) {
		return request.getContextPath()+servlet;
	}


}
