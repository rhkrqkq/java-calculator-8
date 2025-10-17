package calculator.service;

import java.util.Arrays;

import calculator.domain.Delimiter;

public class CalculatorService {

	public int calculate(String text) {
		if (text == null || text.trim().isEmpty()) {
			return 0;
		}
		Delimiter delimiter = Delimiter.fromText(text);
		String[] token = delimiter.getNumberText().split(delimiter.getDelimiter());

		if (token.length == 0 || token.length == 1 && token[0].isEmpty()) {
			return 0;
		}
		return Arrays.stream(token)
			.mapToInt(this::parseToInt)
			.sum();

	}

	private int parseToInt(String numberText) { // 숫자 변환
		return Integer.parseInt(numberText);
	}

}
