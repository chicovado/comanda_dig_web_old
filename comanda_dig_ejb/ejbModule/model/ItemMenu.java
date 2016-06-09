package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the item_menu database table.
 * 
 */
@Entity
@Table(name="item_menu")
@NamedQueries({
@NamedQuery(name="ItemMenu.findAll", query="SELECT i FROM ItemMenu i")
})

@XmlAccessorType(XmlAccessType.FIELD)
public class ItemMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_item_menu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idItemMenu;

	private double desconto;

	@Column(name="descricao_ingredientes")
	private String descricaoIngredientes;

	@Column(name="fila_preparo")
	private String filaPreparo;

	@Lob
	private byte[] foto;

	private String nome;

	private String quant;

	private String situacao;

	private Double valor;
	
	@XmlTransient
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id_categoria_menu", referencedColumnName="id_categoria_menu")
	private CategoriaMenu categoriaMenu;
	

	public ItemMenu() {
	}

	
	
	public CategoriaMenu getCategoriaMenu() {
		return categoriaMenu;
	}



	public void setCategoriaMenu(CategoriaMenu categoriaMenu) {
		this.categoriaMenu = categoriaMenu;
	}



	public Long getIdItemMenu() {
		return idItemMenu;
	}



	public void setIdItemMenu(Long idItemMenu) {
		this.idItemMenu = idItemMenu;
	}



	public double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getDescricaoIngredientes() {
		return this.descricaoIngredientes;
	}

	public void setDescricaoIngredientes(String descricaoIngredientes) {
		this.descricaoIngredientes = descricaoIngredientes;
	}

	public String getFilaPreparo() {
		return this.filaPreparo;
	}

	public void setFilaPreparo(String filaPreparo) {
		this.filaPreparo = filaPreparo;
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

	public String getQuant() {
		return this.quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


}