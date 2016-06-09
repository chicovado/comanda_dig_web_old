package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_user database table.
 * 
 */
@Entity
@Table(name="tipo_user")
@NamedQuery(name="TipoUser.findAll", query="SELECT t FROM TipoUser t")
public class TipoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_user")
	private int idTipoUser;

	private String descricao;

	private String tipo;

	

	public TipoUser() {
	}

	public int getIdTipoUser() {
		return this.idTipoUser;
	}

	public void setIdTipoUser(int idTipoUser) {
		this.idTipoUser = idTipoUser;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

}