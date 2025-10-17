package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public void start() {
		String inputString = InputView.readInput();

		int result = calculatorService.calculate(inputString);

		OutputView.printResult(result);
	}
}
