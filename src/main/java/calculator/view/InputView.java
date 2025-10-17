package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String readInput() {
		System.out.println("덧셈할 문자열을 입력해주세요");
		String inputString = Console.readLine();

		if (inputString == null || inputString.trim().isEmpty()) {
			throw new IllegalArgumentException("입력값이 비어있습니다.");
		}
		return inputString;
	}
}
