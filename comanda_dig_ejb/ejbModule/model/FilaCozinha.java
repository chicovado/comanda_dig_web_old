package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fila_cozinha database table.
 * 
 */
@Entity
@Table(name="fila_cozinha")
@NamedQuery(name="FilaCozinha.findAll", query="SELECT f FROM FilaCozinha f")
public class FilaCozinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fila_cozinha")
	private int idFilaCozinha;

	private String situacao;

	//bi-directional many-to-one association to Caixa
	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;

	//bi-directional many-to-one association to PedidosFilaCozinha
	@OneToMany(mappedBy="filaCozinha")
	private List<PedidosFilaCozinha> pedidosFilaCozinhas;

	public FilaCozinha() {
	}

	public int getIdFilaCozinha() {
		return this.idFilaCozinha;
	}

	public void setIdFilaCozinha(int idFilaCozinha) {
		this.idFilaCozinha = idFilaCozinha;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Caixa getCaixa() {
		return this.caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<PedidosFilaCozinha> getPedidosFilaCozinhas() {
		return this.pedidosFilaCozinhas;
	}

	public void setPedidosFilaCozinhas(List<PedidosFilaCozinha> pedidosFilaCozinhas) {
		this.pedidosFilaCozinhas = pedidosFilaCozinhas;
	}

	public PedidosFilaCozinha addPedidosFilaCozinha(PedidosFilaCozinha pedidosFilaCozinha) {
		getPedidosFilaCozinhas().add(pedidosFilaCozinha);
		pedidosFilaCozinha.setFilaCozinha(this);

		return pedidosFilaCozinha;
	}

	public PedidosFilaCozinha removePedidosFilaCozinha(PedidosFilaCozinha pedidosFilaCozinha) {
		getPedidosFilaCozinhas().remove(pedidosFilaCozinha);
		pedidosFilaCozinha.setFilaCozinha(null);

		return pedidosFilaCozinha;
	}

}