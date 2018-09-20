package br.com.projuris;

import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MyCalculo implements Calculo {

	public static final int SALARY_SCALE = 2;

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		return funcionarios.stream().collect(groupingBy(Funcionario::getCargo, Collectors.toList())).entrySet().stream()
				.map(a -> this.calculateCustoCarga(a.getKey(), a.getValue())).collect(Collectors.toList());
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		return funcionarios.stream().collect(groupingBy(Funcionario::getDepartamento, Collectors.toList())).entrySet()
				.stream().map(a -> this.calculateCustoDepartamento(a.getKey(), a.getValue()))
				.collect(Collectors.toList());
	}

	private CustoDepartamento calculateCustoDepartamento(String departamento, List<Funcionario> funcionarios) {
		return new CustoDepartamento(departamento, sumSalarios(funcionarios));
	}

	private CustoCargo calculateCustoCarga(String cargo, List<Funcionario> funcionarios) {
		return new CustoCargo(cargo, sumSalarios(funcionarios));
	}

	private BigDecimal sumSalarios(List<Funcionario> funcionarios) {
		return funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(SALARY_SCALE, BigDecimal.ROUND_HALF_EVEN);
	}

}
