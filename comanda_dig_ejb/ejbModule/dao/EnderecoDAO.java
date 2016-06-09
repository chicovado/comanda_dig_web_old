package dao;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import model.Endereco;



@Stateless
public class EnderecoDAO extends GenericDAO<Endereco> {
	
	public EnderecoDAO() {
		super(Endereco.class);
	}
	
	public Endereco findEnderecoByUser(Long idUser){
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("id_user",idUser);     
	    return super.findOneResult(Endereco.FIND_BY_USER,parameters);
	}
	 
}