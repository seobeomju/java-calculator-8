package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    public static int parseAndCalculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        //이유: //(0,1) + 구분자 1글자(2) + 개행(3)
        if (input.startsWith(CUSTOM_SEPARATOR_START)) {
            return calculatorWithCustom(input);
        }

        return Calculator.calculator(input, BASIC_SEPARATOR);
    }

    private static int calculatorWithCustom(String input){
        final int end = input.indexOf(CUSTOM_SEPARATOR_END);
        if (end != 3) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        String delimiter = input.substring(2, 3);
        String body = input.substring(end + 1);
        //메타 문자 안전 처리
        String splitRegex = Pattern.quote(delimiter);
        return Calculator.calculator(body, splitRegex);
    }
}
