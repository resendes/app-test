package br.com.projuris;

import java.math.BigDecimal;

public class CustoCargo {
	private String cargo;
	private BigDecimal custo;

	public CustoCargo() {
	}

	public CustoCargo(String cargo, BigDecimal custo) {
		this.cargo = cargo;
		this.custo = custo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

}