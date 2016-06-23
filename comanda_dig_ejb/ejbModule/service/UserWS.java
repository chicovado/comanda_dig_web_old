package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.User;



@WebService(targetNamespace="http://comandaDig/wsdl")
@SOAPBinding(style=Style.RPC)
public interface UserWS {
	
	@WebMethod
	public abstract void save(User User);
	@WebMethod
	public abstract User update(User User);
	@WebMethod
	public abstract void delete(User User);
	@WebMethod
	public abstract User find(Long entityID);
	@WebMethod
	public abstract List<User> findAll();
	
	@WebMethod
	public abstract Boolean autenticarUser(String email, String senha);
	
	
	
}
