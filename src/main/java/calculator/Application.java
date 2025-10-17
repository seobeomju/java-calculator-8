package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;


public class Application {

    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\n";

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine();

        //입력 내 \n을 실제 개행으로 변환
        input = input.replace("\\n","\n");

        if (!checkString(input)) {
            System.out.println("결과 : 0");
            return;
        }

        System.out.println("결과 : " + inputParser(input));

    }

    public static boolean checkString(String input) {
        return input != null && !input.isBlank();

    }

    public static int inputParser(String input) {
        //이유: //(0,1) + 구분자 1글자(2) + 개행(3)
        if(input.startsWith(CUSTOM_SEPARATOR_START) && input.indexOf(CUSTOM_SEPARATOR_END) == 3) {
            String delimiter = input.substring(2,3);
            String body = input.substring(4);

            //메타 문자 안전 처리
            String splitRegex = Pattern.quote(delimiter);
            return calculator(body,splitRegex);
        }

        return calculator(input,BASIC_SEPARATOR);
    }

    public static int calculator(String input, String delimiter) {
        int sum = 0;
        String[] tokens = input.split(delimiter);
        for (String token : tokens){
            String number = token.trim();
            sum += Integer.parseInt(number);
        }
        return sum;
    }


}
