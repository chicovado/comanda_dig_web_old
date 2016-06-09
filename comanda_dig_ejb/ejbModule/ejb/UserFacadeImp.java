package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.Endereco;
import model.SalarioUser;
import model.User;
import dao.EnderecoDAO;
import dao.SalarioUserDAO;
import dao.UserDAO;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class UserFacadeImp implements UserFacade {

    @EJB
    private UserDAO dao;
    @EJB
    private EnderecoDAO enderecoDAO;
    @EJB
    private SalarioUserDAO salarioUserDAO;
   
   
    
    public UserFacadeImp() {
    	
    }

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(User user) {
		this.dao.save(user);
		if (user.getEndereco() != null){
			Endereco endereco =  user.getEndereco();
			endereco.setUser(user);
			this.enderecoDAO.save(user.getEndereco());
		}
		if (user.getSalarioUser() != null){
			SalarioUser salarioUser = user.getSalarioUser();
			salarioUser.setUser(user);
			this.salarioUserDAO.save(user.getSalarioUser());
		} 
			
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User update(User user) {
		
		User userPersist = dao.find(user.getIdUser());
		userPersist.setEndereco(user.getEndereco());
		userPersist.setSalarioUser(user.getSalarioUser());
		userPersist.setCelular(user.getCelular());
		userPersist.setCpf(user.getCpf());
		userPersist.setEmail(user.getEmail());
		userPersist.setFoto(user.getFoto());
		userPersist.setLogin(user.getLogin());
		userPersist.setNome(user.getNome());
		userPersist.setSenha(user.getSenha());
		userPersist.setTelefone(user.getTelefone());
		this.dao.update(userPersist);
		
		if (user.getEndereco().getIdEndereco() == null){
			Endereco endereco = user.getEndereco();
			endereco.setUser(userPersist);
			this.enderecoDAO.save(endereco);
		} else {
			Endereco endereco = user.getEndereco();
			Endereco enderecoPersist = this.enderecoDAO.find(endereco.getIdEndereco());
			enderecoPersist.setUf(endereco.getUf());
			enderecoPersist.setBairro(endereco.getBairro());
			enderecoPersist.setCep(endereco.getCep());
			enderecoPersist.setCidade(endereco.getCidade());
			enderecoPersist.setRua(endereco.getRua());
			enderecoPersist.setNr(endereco.getNr());
			enderecoPersist.setUser(userPersist);
			this.enderecoDAO.update(enderecoPersist);
		}
		
		if (user.getSalarioUser().getIdSalarioUser() == null){
			SalarioUser salarioUser = user.getSalarioUser();
			salarioUser.setUser(userPersist);
			this.salarioUserDAO.save(user.getSalarioUser());
		} else {
			SalarioUser salarioUser = user.getSalarioUser();
			SalarioUser salarioUserPersist = this.salarioUserDAO.find(salarioUser.getIdSalarioUser());
			salarioUserPersist.setAgencia(salarioUser.getAgencia());
			salarioUserPersist.setBanco(salarioUser.getBanco());
			salarioUserPersist.setContaCorrente(salarioUser.getContaCorrente());
			salarioUserPersist.setDiaPagamento(salarioUser.getDiaPagamento());
			salarioUserPersist.setFormaPagamento(salarioUser.getFormaPagamento());
			salarioUserPersist.setPercentComissao(salarioUser.getPercentComissao());
			salarioUserPersist.setSalario(salarioUser.getSalario());
			salarioUserPersist.setUser(userPersist);
			this.salarioUserDAO.update(salarioUserPersist);
		}
		
		return user;
	}

	@Override
	public void delete(User recurso) {
		dao.delete(recurso);
	}

	@Override
	public User find(Long entityID) {
		
		return dao.find(entityID);
	}

	@Override
	public List<User> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<User> listarPorEmail(String email) {
		return dao.listarPoreEmail(email);
	}

	@Override
	public List<User> listarPorLogin(String login) {
		return dao.listarPorLogin(login);
	}

	@Override
	public Endereco findEnderecoByUser(Long idUser) {
		   return this.enderecoDAO.findEnderecoByUser(idUser);
	}

	@Override
	public SalarioUser findSalarioByUser(Long idUser) {
		return this.salarioUserDAO.findEnderecoByUser(idUser);
	}

	

	

	
	
}
