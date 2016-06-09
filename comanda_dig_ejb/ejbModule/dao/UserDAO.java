package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import model.User;



@Stateless
public class UserDAO extends GenericDAO<User> {
	
	public UserDAO() {
		super(User.class);
	}
	
	public List<User> listarPorLogin(String login){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("login",login);     
	    return super.findListResult(User.FIND_BY_LOGIN,parameters);
	}
	
	public List<User> listarPoreEmail(String email){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("email",email);     
	    return super.findListResult(User.FIND_BY_EMAIL,parameters);
	}
	 
}