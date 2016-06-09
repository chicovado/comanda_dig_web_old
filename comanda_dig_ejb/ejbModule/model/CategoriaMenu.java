package model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.List;


/**
 * The persistent class for the categoria_menu database table.
 * 
 */
@Entity
@Table(name="categoria_menu")
@NamedQuery(name="CategoriaMenu.findAll", query="SELECT c FROM CategoriaMenu c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriaMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria_menu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategoriaMenu;

	@Column(name="desconto_cat")
	private double descontoCat;

	private String descricao;

	@Lob
	private byte[] foto;

	private String nome;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="id_categoria_menu")
	private List<ItemMenu> itemMenuList;

	public CategoriaMenu() {
	}

	public Long getIdCategoriaMenu() {
		return this.idCategoriaMenu;
	}

	public void setIdCategoriaMenu(Long idCategoriaMenu) {
		this.idCategoriaMenu = idCategoriaMenu;
	}

	public double getDescontoCat() {
		return this.descontoCat;
	}

	public void setDescontoCat(double descontoCat) {
		this.descontoCat = descontoCat;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return this.foto;
	}

	

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public List<ItemMenu> getItemMenuList() {
		return itemMenuList;
	}

	public void setItemMenuList(List<ItemMenu> itemMenuList) {
		this.itemMenuList = itemMenuList;
	}

	

	

}