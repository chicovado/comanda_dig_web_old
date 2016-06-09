package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido")
	private int idPedido;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim_fila")
	private Date dtFimFila;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_ini_fila")
	private Date dtIniFila;

	private String obs;

	private String situacao;

	//bi-directional many-to-one association to ItemMenu
	@ManyToOne
	@JoinColumn(name="id_item_menu")
	private ItemMenu itemMenu;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to PedidosComanda
	@OneToMany(mappedBy="pedido")
	private List<PedidosComanda> pedidosComandas;

	//bi-directional many-to-one association to PedidosFilaBar
	@OneToMany(mappedBy="pedido")
	private List<PedidosFilaBar> pedidosFilaBars;

	//bi-directional many-to-one association to PedidosFilaCozinha
	@OneToMany(mappedBy="pedido")
	private List<PedidosFilaCozinha> pedidosFilaCozinhas;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDtFimFila() {
		return this.dtFimFila;
	}

	public void setDtFimFila(Date dtFimFila) {
		this.dtFimFila = dtFimFila;
	}

	public Date getDtIniFila() {
		return this.dtIniFila;
	}

	public void setDtIniFila(Date dtIniFila) {
		this.dtIniFila = dtIniFila;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public ItemMenu getItemMenu() {
		return this.itemMenu;
	}

	public void setItemMenu(ItemMenu itemMenu) {
		this.itemMenu = itemMenu;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PedidosComanda> getPedidosComandas() {
		return this.pedidosComandas;
	}

	public void setPedidosComandas(List<PedidosComanda> pedidosComandas) {
		this.pedidosComandas = pedidosComandas;
	}

	public PedidosComanda addPedidosComanda(PedidosComanda pedidosComanda) {
		getPedidosComandas().add(pedidosComanda);
		pedidosComanda.setPedido(this);

		return pedidosComanda;
	}

	public PedidosComanda removePedidosComanda(PedidosComanda pedidosComanda) {
		getPedidosComandas().remove(pedidosComanda);
		pedidosComanda.setPedido(null);

		return pedidosComanda;
	}

	public List<PedidosFilaBar> getPedidosFilaBars() {
		return this.pedidosFilaBars;
	}

	public void setPedidosFilaBars(List<PedidosFilaBar> pedidosFilaBars) {
		this.pedidosFilaBars = pedidosFilaBars;
	}

	public PedidosFilaBar addPedidosFilaBar(PedidosFilaBar pedidosFilaBar) {
		getPedidosFilaBars().add(pedidosFilaBar);
		pedidosFilaBar.setPedido(this);

		return pedidosFilaBar;
	}

	public PedidosFilaBar removePedidosFilaBar(PedidosFilaBar pedidosFilaBar) {
		getPedidosFilaBars().remove(pedidosFilaBar);
		pedidosFilaBar.setPedido(null);

		return pedidosFilaBar;
	}

	public List<PedidosFilaCozinha> getPedidosFilaCozinhas() {
		return this.pedidosFilaCozinhas;
	}

	public void setPedidosFilaCozinhas(List<PedidosFilaCozinha> pedidosFilaCozinhas) {
		this.pedidosFilaCozinhas = pedidosFilaCozinhas;
	}

	public PedidosFilaCozinha addPedidosFilaCozinha(PedidosFilaCozinha pedidosFilaCozinha) {
		getPedidosFilaCozinhas().add(pedidosFilaCozinha);
		pedidosFilaCozinha.setPedido(this);

		return pedidosFilaCozinha;
	}

	public PedidosFilaCozinha removePedidosFilaCozinha(PedidosFilaCozinha pedidosFilaCozinha) {
		getPedidosFilaCozinhas().remove(pedidosFilaCozinha);
		pedidosFilaCozinha.setPedido(null);

		return pedidosFilaCozinha;
	}

}