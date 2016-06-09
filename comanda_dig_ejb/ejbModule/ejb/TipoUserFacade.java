package ejb;

import java.util.List;

import javax.ejb.Local;

import model.TipoUser;



@Local
public interface TipoUserFacade {

	public abstract void save(TipoUser User);

	public abstract TipoUser update(TipoUser User);
	
	public abstract void delete(TipoUser User);

	public abstract TipoUser find(int entityID);
	
	public abstract List<TipoUser> findAll();
	
	
	
}
