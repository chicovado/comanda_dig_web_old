package dao;

import javax.ejb.Stateless;

import model.ItemMenu;



@Stateless
public class ItemMenuDAO extends GenericDAO<ItemMenu> {
	
	public ItemMenuDAO() {
		super(ItemMenu.class);
	}
	
	
	 
}