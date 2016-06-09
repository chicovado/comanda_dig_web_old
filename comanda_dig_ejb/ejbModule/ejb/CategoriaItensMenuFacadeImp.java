package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.CategoriaMenu;
import model.ItemMenu;
import dao.CategoriaMenuDAO;
import dao.ItemMenuDAO;



/**
 * Session Bean implementation class CategoriaItensMenuFacadeImp
 */
@Stateless
  public class CategoriaItensMenuFacadeImp implements CategoriaItensMenuFacade {

    @EJB
    private CategoriaMenuDAO categoriaMenuDAO;
    @EJB
    private ItemMenuDAO itemMenuDAO;
   
   
    
    public CategoriaItensMenuFacadeImp() {
    	
    }

	@Override
	public void saveCategoria(CategoriaMenu categoriaMenu) {
		categoriaMenuDAO.save(categoriaMenu);		
		
	}

	@Override
	public CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu) {		
		return categoriaMenuDAO.update(categoriaMenu);
	}

	@Override
	public void deleteCategoria(CategoriaMenu categoriaMenu) {
		categoriaMenuDAO.delete(categoriaMenu);
	}

	@Override
	public CategoriaMenu findCategoria(Long entityID) {
		
		return categoriaMenuDAO.find(entityID);
	}

	@Override
	public List<CategoriaMenu> findAllCategoria() {
		return categoriaMenuDAO.findAll();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveItem(ItemMenu itemMenu) {
		CategoriaMenu categoriaMenu = categoriaMenuDAO.find(itemMenu.getCategoriaMenu().getIdCategoriaMenu());
		itemMenu.setCategoriaMenu(categoriaMenu);
		this.itemMenuDAO.save(itemMenu);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ItemMenu updateItem(ItemMenu itemMenu) {
		itemMenuDAO.update(itemMenu);
		if (itemMenu.getCategoriaMenu() != null){
			CategoriaMenu categoriaMenu = categoriaMenuDAO.find(itemMenu.getCategoriaMenu().getIdCategoriaMenu());
			categoriaMenuDAO.update(categoriaMenu);
		}
		
		return itemMenu;
	}

	@Override
	public void deleteItem(ItemMenu itemMenu) {
		this.itemMenuDAO.delete(itemMenu);
	}

	@Override
	public ItemMenu findItem(Long id) {
		return this.itemMenuDAO.find(id);
	}

	@Override
	public List<ItemMenu> findAllItem() {
		return this.itemMenuDAO.findAll();
	}

	
}
