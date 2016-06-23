package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Endereco;
import model.SalarioUser;
import model.User;



@Local
public interface UserFacade {

	public abstract void save(User User);

	public abstract User update(User User);
	
	public abstract void delete(User User);

	public abstract User find(Long entityID);
	
	public abstract List<User> findAll();
	
	public abstract List<User> listarPorEmail(String email);
	
	public abstract List<User> listarPorLogin(String login);
	
	public abstract Endereco findEnderecoByUser(Long idUser);
	
	public abstract SalarioUser findSalarioByUser(Long idUser);
	
	public abstract Boolean autenticarUser(String email, String senha);
		
	

}
