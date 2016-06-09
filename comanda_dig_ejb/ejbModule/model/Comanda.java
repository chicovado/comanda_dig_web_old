package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the comanda database table.
 * 
 */
@Entity
@NamedQuery(name="Comanda.findAll", query="SELECT c FROM Comanda c")
public class Comanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_comanda")
	private int idComanda;

	private String codigo;

	@Column(name="nr_comanda")
	private int nrComanda;

	private String situacao;

	//bi-directional many-to-one association to Caixa
	@ManyToOne
	@JoinColumn(name="id_caixa")
	private Caixa caixa;

	//bi-directional many-to-one association to PedidosComanda
	@OneToMany(mappedBy="comanda")
	private List<PedidosComanda> pedidosComandas;

	public Comanda() {
	}

	public int getIdComanda() {
		return this.idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNrComanda() {
		return this.nrComanda;
	}

	public void setNrComanda(int nrComanda) {
		this.nrComanda = nrComanda;
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

	public List<PedidosComanda> getPedidosComandas() {
		return this.pedidosComandas;
	}

	public void setPedidosComandas(List<PedidosComanda> pedidosComandas) {
		this.pedidosComandas = pedidosComandas;
	}

	public PedidosComanda addPedidosComanda(PedidosComanda pedidosComanda) {
		getPedidosComandas().add(pedidosComanda);
		pedidosComanda.setComanda(this);

		return pedidosComanda;
	}

	public PedidosComanda removePedidosComanda(PedidosComanda pedidosComanda) {
		getPedidosComandas().remove(pedidosComanda);
		pedidosComanda.setComanda(null);

		return pedidosComanda;
	}

}