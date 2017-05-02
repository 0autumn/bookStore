package app.store.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import app.store.model.entity.User;
import app.store.model.service.UserService;

public class UserAction extends GenericActionSupport<User, UserService> {

	private static final long serialVersionUID = 1L;

	//
	public String login() throws Exception {
		String loginId = this.getModel().getLoginId();
		String password = this.getModel().getPassword();
		User user = this.getService().verifyUser(loginId, password);
		if (user != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}
		this.addActionError("µÇÂ½Ê§°Ü");
		return INPUT;
	}
	//
	public String register() throws Exception {
		try {
			this.getService().saveUser(this.getModel());
		}
		catch (Exception ex){
			this.addActionError(ex.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	//
	public String logout() throws Exception {
		
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
}
