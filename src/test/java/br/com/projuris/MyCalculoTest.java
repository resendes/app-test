package br.com.projuris;

import static br.com.projuris.MyCalculo.SALARY_SCALE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyCalculoTest {

	private static final String DEPTO_JURIDICO = "Jurídico";
	private static final String DEPTO_FINANCEIRO = "Financeiro";
	private static final String DEPTO_ADMINISTRATIVO = "Administrativo";
	private static final String CARGO_ESTAGIARIO = "Estagiário";
	private static final String CARGO_DIRETOR = "Diretor";
	private static final String CARGO_GERENTE = "Gerente";
	private static final String CARGO_ASSISTENTE = "Assistente";
	private Calculo calculo;

	@Before
	public void init() {
		calculo = new MyCalculo();
	}

	@Test
	public void testCustoPorCargo() {
		List<Funcionario> listaFuncionario = loadData();

		List<CustoCargo> custoPorCargos = calculo.custoPorCargo(listaFuncionario);
		CustoCargo assistente = findCustoPorCargo(custoPorCargos, CARGO_ASSISTENTE);
		CustoCargo diretor = findCustoPorCargo(custoPorCargos, CARGO_DIRETOR);
		CustoCargo estagiario = findCustoPorCargo(custoPorCargos, CARGO_ESTAGIARIO);
		CustoCargo gerente = findCustoPorCargo(custoPorCargos, CARGO_GERENTE);

		Assert.assertEquals(assistente.getCusto(), getBigDecimalValue(4101.8D));
		Assert.assertEquals(diretor.getCusto(), getBigDecimalValue(34000.45D));
		Assert.assertEquals(estagiario.getCusto(), getBigDecimalValue(700.40D));
		Assert.assertEquals(gerente.getCusto(), getBigDecimalValue(24001.20D));
	}
	
	@Test
	public void testCustoPorDepartamento() {
		List<Funcionario> funcionarios = loadData();

		List<CustoDepartamento> custoPorDepartamentos = calculo.custoPorDepartamento(funcionarios);
		CustoDepartamento administrativo = findCustoPorDepartamento(custoPorDepartamentos, DEPTO_ADMINISTRATIVO);
		CustoDepartamento financeiro = findCustoPorDepartamento(custoPorDepartamentos, DEPTO_FINANCEIRO);
		CustoDepartamento juridico = findCustoPorDepartamento(custoPorDepartamentos, DEPTO_JURIDICO);

		Assert.assertEquals(administrativo.getCusto(), getBigDecimalValue(18001.15D));
		Assert.assertEquals(financeiro.getCusto(), getBigDecimalValue(19800.9D));
		Assert.assertEquals(juridico.getCusto(), getBigDecimalValue(25001.8D));
	}

	private BigDecimal getBigDecimalValue(double value) {
		return BigDecimal.valueOf(value).setScale(SALARY_SCALE, BigDecimal.ROUND_HALF_EVEN);
	}

	private CustoCargo findCustoPorCargo(List<CustoCargo> custoPorCargos, String cargo) {
		return custoPorCargos.stream().filter(custoPorCargo -> custoPorCargo.getCargo().equals(cargo)).findFirst()
				.get();
	}

	private CustoDepartamento findCustoPorDepartamento(List<CustoDepartamento> custoPorDepartamentos,
			String departamento) {
		return custoPorDepartamentos.stream()
				.filter(custoPorDepartamento -> custoPorDepartamento.getDepartamento().equals(departamento)).findFirst()
				.get();
	}

	private List<Funcionario> loadData() {
		Funcionario funcionario1 = new Funcionario(CARGO_ASSISTENTE, DEPTO_ADMINISTRATIVO, new BigDecimal(1000.0));
		Funcionario funcionario2 = new Funcionario(CARGO_GERENTE, DEPTO_ADMINISTRATIVO, new BigDecimal(7000.70));
		Funcionario funcionario3 = new Funcionario(CARGO_DIRETOR, DEPTO_ADMINISTRATIVO, new BigDecimal(10000.45));
		Funcionario funcionario4 = new Funcionario(CARGO_ASSISTENTE, DEPTO_FINANCEIRO, new BigDecimal(1300.9));
		Funcionario funcionario5 = new Funcionario(CARGO_GERENTE, DEPTO_FINANCEIRO, new BigDecimal(7500));
		Funcionario funcionario6 = new Funcionario(CARGO_DIRETOR, DEPTO_FINANCEIRO, new BigDecimal(11000.0));
		Funcionario funcionario7 = new Funcionario(CARGO_ESTAGIARIO, DEPTO_JURIDICO, new BigDecimal(700.4));
		Funcionario funcionario8 = new Funcionario(CARGO_ASSISTENTE, DEPTO_JURIDICO, new BigDecimal(1800.90));
		Funcionario funcionario9 = new Funcionario(CARGO_GERENTE, DEPTO_JURIDICO, new BigDecimal(9500.50));
		Funcionario funcionario10 = new Funcionario(CARGO_DIRETOR, DEPTO_JURIDICO, new BigDecimal(13000.0));
		List<Funcionario> listaFuncionario = new ArrayList<>();
		listaFuncionario.add(funcionario1);
		listaFuncionario.add(funcionario2);
		listaFuncionario.add(funcionario3);
		listaFuncionario.add(funcionario4);
		listaFuncionario.add(funcionario5);
		listaFuncionario.add(funcionario6);
		listaFuncionario.add(funcionario7);
		listaFuncionario.add(funcionario8);
		listaFuncionario.add(funcionario9);
		listaFuncionario.add(funcionario10);
		return listaFuncionario;
	}

}
