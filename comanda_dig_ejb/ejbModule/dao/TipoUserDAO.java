package dao;

import javax.ejb.Stateless;

import model.TipoUser;



@Stateless
public class TipoUserDAO extends GenericDAO<TipoUser> {
	
	public TipoUserDAO() {
		super(TipoUser.class);
	}
	
	
	 
}