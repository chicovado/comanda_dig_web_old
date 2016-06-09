package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedidos_comanda database table.
 * 
 */
@Entity
@Table(name="pedidos_comanda")
@NamedQuery(name="PedidosComanda.findAll", query="SELECT p FROM PedidosComanda p")
public class PedidosComanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidos_comanda")
	private int idPedidosComanda;

	private int quant;

	//bi-directional many-to-one association to Comanda
	@ManyToOne
	@JoinColumn(name="id_comanda")
	private Comanda comanda;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	public PedidosComanda() {
	}

	public int getIdPedidosComanda() {
		return this.idPedidosComanda;
	}

	public void setIdPedidosComanda(int idPedidosComanda) {
		this.idPedidosComanda = idPedidosComanda;
	}

	public int getQuant() {
		return this.quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public Comanda getComanda() {
		return this.comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}