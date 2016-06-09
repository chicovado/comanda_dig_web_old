package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import model.SalarioUser;



@Stateless
public class SalarioUserDAO extends GenericDAO<SalarioUser> {
	
	public SalarioUserDAO() {
		super(SalarioUser.class);
	}
	
	public SalarioUser findEnderecoByUser(Long idUser){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("id_user",idUser);     
	    return super.findOneResult(SalarioUser.FIND_BY_USER,parameters);
	}
	 
}