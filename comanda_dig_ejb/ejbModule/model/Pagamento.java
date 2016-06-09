package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pagamento database table.
 * 
 */
@Entity
@NamedQuery(name="Pagamento.findAll", query="SELECT p FROM Pagamento p")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pagamento")
	private int idPagamento;

	@Column(name="data_pag")
	private String dataPag;

	@Column(name="mes_ano")
	private int mesAno;

	private String situacao;

	//bi-directional many-to-one association to SalarioUser
	@ManyToOne
	@JoinColumn(name="id_salario_user")
	private SalarioUser salarioUser;

	public Pagamento() {
	}

	public int getIdPagamento() {
		return this.idPagamento;
	}

	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getDataPag() {
		return this.dataPag;
	}

	public void setDataPag(String dataPag) {
		this.dataPag = dataPag;
	}

	public int getMesAno() {
		return this.mesAno;
	}

	public void setMesAno(int mesAno) {
		this.mesAno = mesAno;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public SalarioUser getSalarioUser() {
		return this.salarioUser;
	}

	public void setSalarioUser(SalarioUser salarioUser) {
		this.salarioUser = salarioUser;
	}

}