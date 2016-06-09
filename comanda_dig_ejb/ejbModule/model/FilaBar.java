package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fila_bar database table.
 * 
 */
@Entity
@Table(name="fila_bar")
@NamedQuery(name="FilaBar.findAll", query="SELECT f FROM FilaBar f")
public class FilaBar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fila_bar")
	private int idFilaBar;

	private String situacao;

	//bi-directional many-to-one association to Caixa
	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;

	//bi-directional many-to-one association to PedidosFilaBar
	@OneToMany(mappedBy="filaBar")
	private List<PedidosFilaBar> pedidosFilaBars;

	public FilaBar() {
	}

	public int getIdFilaBar() {
		return this.idFilaBar;
	}

	public void setIdFilaBar(int idFilaBar) {
		this.idFilaBar = idFilaBar;
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

	public List<PedidosFilaBar> getPedidosFilaBars() {
		return this.pedidosFilaBars;
	}

	public void setPedidosFilaBars(List<PedidosFilaBar> pedidosFilaBars) {
		this.pedidosFilaBars = pedidosFilaBars;
	}

	public PedidosFilaBar addPedidosFilaBar(PedidosFilaBar pedidosFilaBar) {
		getPedidosFilaBars().add(pedidosFilaBar);
		pedidosFilaBar.setFilaBar(this);

		return pedidosFilaBar;
	}

	public PedidosFilaBar removePedidosFilaBar(PedidosFilaBar pedidosFilaBar) {
		getPedidosFilaBars().remove(pedidosFilaBar);
		pedidosFilaBar.setFilaBar(null);

		return pedidosFilaBar;
	}

}