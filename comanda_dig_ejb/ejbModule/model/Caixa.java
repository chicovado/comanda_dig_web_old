package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the caixa database table.
 * 
 */
@Entity
@NamedQuery(name="Caixa.findAll", query="SELECT c FROM Caixa c")
public class Caixa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_caixa")
	private int idCaixa;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura")
	private Date dtAbertura;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fechamento")
	private Date dtFechamento;

	private String situacao;

	//bi-directional many-to-one association to Comanda
	@OneToMany(mappedBy="caixa")
	private List<Comanda> comandas;

	//bi-directional many-to-one association to FilaBar
	@OneToMany(mappedBy="caixa")
	private List<FilaBar> filaBars;

	//bi-directional many-to-one association to FilaCozinha
	@OneToMany(mappedBy="caixa")
	private List<FilaCozinha> filaCozinhas;

	public Caixa() {
	}

	public int getIdCaixa() {
		return this.idCaixa;
	}

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}

	public Date getDtAbertura() {
		return this.dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return this.dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Comanda> getComandas() {
		return this.comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

	public Comanda addComanda(Comanda comanda) {
		getComandas().add(comanda);
		comanda.setCaixa(this);

		return comanda;
	}

	public Comanda removeComanda(Comanda comanda) {
		getComandas().remove(comanda);
		comanda.setCaixa(null);

		return comanda;
	}

	public List<FilaBar> getFilaBars() {
		return this.filaBars;
	}

	public void setFilaBars(List<FilaBar> filaBars) {
		this.filaBars = filaBars;
	}

	public FilaBar addFilaBar(FilaBar filaBar) {
		getFilaBars().add(filaBar);
		filaBar.setCaixa(this);

		return filaBar;
	}

	public FilaBar removeFilaBar(FilaBar filaBar) {
		getFilaBars().remove(filaBar);
		filaBar.setCaixa(null);

		return filaBar;
	}

	public List<FilaCozinha> getFilaCozinhas() {
		return this.filaCozinhas;
	}

	public void setFilaCozinhas(List<FilaCozinha> filaCozinhas) {
		this.filaCozinhas = filaCozinhas;
	}

	public FilaCozinha addFilaCozinha(FilaCozinha filaCozinha) {
		getFilaCozinhas().add(filaCozinha);
		filaCozinha.setCaixa(this);

		return filaCozinha;
	}

	public FilaCozinha removeFilaCozinha(FilaCozinha filaCozinha) {
		getFilaCozinhas().remove(filaCozinha);
		filaCozinha.setCaixa(null);

		return filaCozinha;
	}

}