package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\\\\?n(.*)");

	private final String delimiter;  // 문자열 분리 시 사용될 구분자
	private final String numberText;  // 숫자, 구분자로만 구성된 식

	private Delimiter(String delimiter, String numberText) {
		this.delimiter = delimiter;
		this.numberText = numberText;
	}

	public static Delimiter fromText(String text) {
		Matcher matcher = CUSTOM_DELIMITER.matcher(text);

		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String numbers = matcher.group(2);
		}
		return new Delimiter(DEFAULT_DELIMITER, text);
	}

	public String getDelimiter() {
		return delimiter;
	}

	public String getNumberText() {
		return numberText;
	}
}
