package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;

public class CalculatorRunner {
	public void run() {
		CalculatorService calculatorService = new CalculatorService();
		CalculatorController calculatorController = new CalculatorController(calculatorService);

		calculatorController.start();
	}
}
