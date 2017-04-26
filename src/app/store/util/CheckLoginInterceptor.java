package app.store.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.http.HttpRequest;

import app.store.model.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class CheckLoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ac=invocation.getInvocationContext();
	String path=ServletActionContext.getRequest().getRequestURI();
	System.out.println(path);
	   if(path.indexOf("manger")>=0){
		   User user=(User) ac.getSession().get("manger");
		   if(user!=null)
			   return invocation.invoke();
		   return "false";
		   
	   }
		return invocation.invoke();
	}




	


}
