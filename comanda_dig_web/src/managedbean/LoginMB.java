package managedbean;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import model.CategoriaMenu;
import model.ItemMenu;
import model.User;
import service.MenuWS;
import service.UserWS;
import ejb.UserFacade;



@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB  implements Serializable {
	
	private String hostName = "localhost";
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private UserFacade usuarioFacade;
	private User usuario =  new  User();
	private String login = new String();
	private String senha = new String();
	
	
	
	
	public LoginMB() {

	}

	
	@PostConstruct
	public void ini() {
		this.usuario =  new  User();
		login = new String();
		senha = new String();
		try {
			this.testeWS();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private void testeWS() throws MalformedURLException{
		
		Service userService = Service.create(
                new URL("http://localhost:8080/comanda_dig_ejb/UserService/UserWSImp?wsdl"),
                new QName("http://comandaDig/wsdl", "UserService"));
		
		Service menuService = Service.create(
                new URL("http://localhost:8080/comanda_dig_ejb/MenuService/MenuWSImp?wsdl"),
                new QName("http://comandaDig/wsdl", "MenuService"));

        

        UserWS userWs = (UserWS) userService.getPort(UserWS.class);
		 	
	     User u = new User();
	     u.setNome("testeWS");
	     u.setCpf("8888888888");
	     
	     List<User> list = userWs.findAll();
	     for (User user : list) {
			//System.out.println(user.getNome());
		}
	     
	     //--------------------------
	     
	     
	     MenuWS menuWS = (MenuWS) menuService.getPort(MenuWS.class);
	     
	     List<CategoriaMenu> categoriaMenus = menuWS.findAllCategoria();
	     
	     for (CategoriaMenu categoriaMenu : categoriaMenus) {
			System.out.println(categoriaMenu.getNome());
			if (categoriaMenu.getItemMenuList() != null && !categoriaMenu.getItemMenuList().isEmpty()){
				for (ItemMenu itemMenu : categoriaMenu.getItemMenuList()) {
					//System.out.println(itemMenu.getNome());
				}
			}
			
		}
	     
	     
	}
	
	
	
	public String login(){
		
		List<User>  list = usuarioFacade.listarPorLogin(this.login);
		
		if (list != null && !list.isEmpty()){
			this.usuario = list.get(0);
			if (usuario.getSenha().equals(this.senha)){
				FacesContext fc = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
				session.setAttribute("user", usuario);
				return "go_init";
			} else {
				String info = "Senha Inválida !";
				FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_ERROR,info, ""));
			}
			
		} else {
			String info = "Login Inválido !";
			FacesContext.getCurrentInstance().addMessage(null,	new FacesMessage(FacesMessage.SEVERITY_ERROR,info, ""));
		}
		
		return "";
	}


	public String getHostName() {
		return hostName;
	}


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}


	public UserFacade getUsuarioFacade() {
		return usuarioFacade;
	}


	public void setUsuarioFacade(UserFacade usuarioFacade) {
		this.usuarioFacade = usuarioFacade;
	}


	public User getUsuario() {
		return usuario;
	}


	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	


	
	
	
	
	
	
}
