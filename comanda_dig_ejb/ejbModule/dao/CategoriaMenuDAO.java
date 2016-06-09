package dao;

import javax.ejb.Stateless;

import model.CategoriaMenu;



@Stateless
public class CategoriaMenuDAO extends GenericDAO<CategoriaMenu> {
	
	public CategoriaMenuDAO() {
		super(CategoriaMenu.class);
	}
	
	
	 
}