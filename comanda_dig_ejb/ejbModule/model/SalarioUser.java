package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the salario_user database table.
 * 
 */
@Entity
@Table(name="salario_user")
@NamedQueries(
	{
		@NamedQuery(name="SalarioUser.findAll", query="SELECT s FROM SalarioUser s"),
		@NamedQuery(name="SalarioUser.findByUser", query="SELECT s FROM SalarioUser s where s.user.idUser = :id_user")
	}
)

public class SalarioUser implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_USER = "SalarioUser.findByUser";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_salario_user")
	private Long idSalarioUser;

	private String agencia;

	private String banco;

	@Column(name="conta_corrente")
	private String contaCorrente;

	@Column(name="dia_pagamento")
	private int diaPagamento;

	@Column(name="forma_pagamento")
	private String formaPagamento;

	@Column(name="percent_comissao")
	private double percentComissao;

	private double salario;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	
	
	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public SalarioUser() {
	}

	

	public Long getIdSalarioUser() {
		return idSalarioUser;
	}



	public void setIdSalarioUser(Long idSalarioUser) {
		this.idSalarioUser = idSalarioUser;
	}



	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public int getDiaPagamento() {
		return this.diaPagamento;
	}

	public void setDiaPagamento(int diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public String getFormaPagamento() {
		return this.formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getPercentComissao() {
		return this.percentComissao;
	}

	public void setPercentComissao(double percentComissao) {
		this.percentComissao = percentComissao;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}


	

}