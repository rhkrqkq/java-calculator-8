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
		System.out.println("Delimiter: " + delimiter.getDelimiter());
		System.out.println("NumberText: " + delimiter.getNumberText());
		System.out.println("Tokens: " + Arrays.toString(token));

		if (token.length == 0 || token.length == 1 && token[0].isEmpty()) {
			return 0;
		}
		return Arrays.stream(token)
			.mapToInt(this::parseAndValidate)
			.sum();

	}

	private int parseAndValidate(String numberText) { // 유효성 검증 수행 및 숫자변환
		int number;
		try {  // 숫자로 변환
			number = Integer.parseInt(numberText);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
		}

		if (number<0) {  // 음수일 경우
			throw new IllegalArgumentException("음수가 포함되어 있습니다.");
		}
		return number;
	}

}
