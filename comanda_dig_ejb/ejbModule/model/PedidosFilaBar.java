package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedidos_fila_bar database table.
 * 
 */
@Entity
@Table(name="pedidos_fila_bar")
@NamedQuery(name="PedidosFilaBar.findAll", query="SELECT p FROM PedidosFilaBar p")
public class PedidosFilaBar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidos_fila_bar")
	private int idPedidosFilaBar;

	private String situacao;

	//bi-directional many-to-one association to FilaBar
	@ManyToOne
	@JoinColumn(name="id_fila_bar")
	private FilaBar filaBar;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	public PedidosFilaBar() {
	}

	public int getIdPedidosFilaBar() {
		return this.idPedidosFilaBar;
	}

	public void setIdPedidosFilaBar(int idPedidosFilaBar) {
		this.idPedidosFilaBar = idPedidosFilaBar;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public FilaBar getFilaBar() {
		return this.filaBar;
	}

	public void setFilaBar(FilaBar filaBar) {
		this.filaBar = filaBar;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}