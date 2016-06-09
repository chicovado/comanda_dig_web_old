package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.TipoUser;
import dao.TipoUserDAO;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class TipoUserFacadeImp implements TipoUserFacade {

    @EJB
    private TipoUserDAO dao;
    
   
   
    
    public TipoUserFacadeImp() {
    	
    }

	@Override
	public void save(TipoUser tipoUser) {
		dao.save(tipoUser);		
		
	}

	@Override
	public TipoUser update(TipoUser tipoUser) {		
		return dao.update(tipoUser);
	}

	@Override
	public void delete(TipoUser tipoUser) {
		dao.delete(tipoUser);
	}

	@Override
	public TipoUser find(int entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<TipoUser> findAll() {
		
		return dao.findAll();
	}

	
	
	
}
