package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedidos_fila_cozinha database table.
 * 
 */
@Entity
@Table(name="pedidos_fila_cozinha")
@NamedQuery(name="PedidosFilaCozinha.findAll", query="SELECT p FROM PedidosFilaCozinha p")
public class PedidosFilaCozinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedidos_fila_cozinha")
	private int idPedidosFilaCozinha;

	private String situacao;

	//bi-directional many-to-one association to FilaCozinha
	@ManyToOne
	@JoinColumn(name="id_fila_cozinha")
	private FilaCozinha filaCozinha;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	public PedidosFilaCozinha() {
	}

	public int getIdPedidosFilaCozinha() {
		return this.idPedidosFilaCozinha;
	}

	public void setIdPedidosFilaCozinha(int idPedidosFilaCozinha) {
		this.idPedidosFilaCozinha = idPedidosFilaCozinha;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public FilaCozinha getFilaCozinha() {
		return this.filaCozinha;
	}

	public void setFilaCozinha(FilaCozinha filaCozinha) {
		this.filaCozinha = filaCozinha;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}