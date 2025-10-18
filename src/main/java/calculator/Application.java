package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;


public class Application {

    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //입력 내 \n을 실제 개행으로 변환
        input = input.replace("\\n", "\n");

        if (!checkString(input)) {
            System.out.println("결과 : 0");
            return;
        }

        System.out.println("결과 : " + parseAndCalculate(input));

    }

    public static boolean checkString(String input) {
        return input != null && !input.isBlank();

    }

    public static int parseAndCalculate(String input) {
        //이유: //(0,1) + 구분자 1글자(2) + 개행(3)
        if (input.startsWith(CUSTOM_SEPARATOR_START)) {
            int end = input.indexOf(CUSTOM_SEPARATOR_END);
            if (end != 3) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }

            String delimiter = input.substring(2, 3);
            String body = input.substring(end + 1);

            //메타 문자 안전 처리
            String splitRegex = Pattern.quote(delimiter);
            return calculator(body, splitRegex);
        }

        return calculator(input, BASIC_SEPARATOR);
    }

    public static int calculator(String input, String splitRegex) {
        int sum = 0;
        // 끝 토큰까지 확인
        String[] tokens = input.split(splitRegex, -1);
        for (String token : tokens) {
            String number = token.trim();

            validate(number);

            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public static void validate(String input) {

        //빈 토큰 체크
        if (input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식: 빈 값이 포함되어 있습니다.");
        }

        //숫자 체크
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
        }
    }

}
