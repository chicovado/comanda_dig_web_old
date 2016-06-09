package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import model.CategoriaMenu;
import model.ItemMenu;
import ejb.CategoriaItensMenuFacade;

@Stateless
@WebService(portName= "MenuPort",
			serviceName ="MenuService",
			endpointInterface = "service.MenuWS", 
			targetNamespace= "http://comandaDig/wsdl" 
			)
public class MenuWSImp implements MenuWS {

	@EJB
	private CategoriaItensMenuFacade categoriaItensMenuFacade;

	@Override
	public void saveCategoria(CategoriaMenu categoriaMenu) {
		this.categoriaItensMenuFacade.saveCategoria(categoriaMenu);
	}

	@Override
	public CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu) {
		return this.categoriaItensMenuFacade.updateCategoria(categoriaMenu);
	}

	@Override
	public void deleteCategoria(CategoriaMenu categoriaMenu) {
		this.categoriaItensMenuFacade.deleteCategoria(categoriaMenu);
	}

	@Override
	public CategoriaMenu findCategoria(Long id) {
		return this.categoriaItensMenuFacade.findCategoria(id);
	}

	@Override
	public List<CategoriaMenu> findAllCategoria() {
		return categoriaItensMenuFacade.findAllCategoria();
	}

	@Override
	public void saveItem(ItemMenu itemMenu) {
		this.categoriaItensMenuFacade.saveItem(itemMenu);
	}

	@Override
	public ItemMenu updateItem(ItemMenu itemMenu) {
		return this.categoriaItensMenuFacade.updateItem(itemMenu);
	}

	@Override
	public void deleteItem(ItemMenu itemMenu) {
		this.categoriaItensMenuFacade.deleteItem(itemMenu);
	}

	@Override
	public ItemMenu findItem(Long id) {
		return this.categoriaItensMenuFacade.findItem(id);
	}

	@Override
	public List<ItemMenu> findAllItem() {
		return this.categoriaItensMenuFacade.findAllItem();
	}

	
	
	

	
	
	
}
