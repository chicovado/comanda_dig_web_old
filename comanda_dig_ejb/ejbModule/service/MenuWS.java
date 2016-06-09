package service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import model.CategoriaMenu;
import model.ItemMenu;



@WebService(targetNamespace="http://comandaDig/wsdl")
@SOAPBinding(style=Style.RPC)
public interface MenuWS {
	
	@WebMethod
	public abstract void saveCategoria(CategoriaMenu categoriaMenu);
	@WebMethod
	public abstract CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu);
	@WebMethod
	public abstract void deleteCategoria(CategoriaMenu categoriaMenu);
	@WebMethod
	public abstract CategoriaMenu findCategoria(Long id);
	@WebMethod
	public abstract List<CategoriaMenu> findAllCategoria();
	@WebMethod
	public abstract void saveItem(ItemMenu itemMenu);
	@WebMethod
	public abstract ItemMenu updateItem(ItemMenu itemMenu);
	@WebMethod
	public abstract void deleteItem(ItemMenu itemMenu);
	@WebMethod
	public abstract ItemMenu findItem(Long id);
	@WebMethod
	public abstract List<ItemMenu> findAllItem();
	
	
	
}
