package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQueries(
	{
		@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e"),
		@NamedQuery(name="Endereco.findByUser", query="SELECT e FROM Endereco e where e.user.idUser = :id_user"),
	}
)
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_USER = "Endereco.findByUser";

	@Id
	@Column(name="id_endereco")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEndereco;

	private String bairro;

	private String cep;

	private String cidade;

	private int nr;

	private String rua;

	private String uf;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Endereco() {
	}

	

	public Long getIdEndereco() {
		return idEndereco;
	}



	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNr() {
		return this.nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	

}