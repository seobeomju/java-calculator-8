package calculator;

import camp.nextstep.edu.missionutils.Console;



public class Application {

    private static final String BASIC_SEPARATOR = "[,:]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine();

        if (!checkString(input)) {
            System.out.println("결과 : 0");
        }

        int result = calculator(input);
        System.out.println("결과 : " + result);

    }

    public static boolean checkString(String input) {
        return input != null && !input.isBlank();
    }

    public static int calculator(String input) {
        int sum = 0;
        String[] tokens = input.split(BASIC_SEPARATOR);
        for (String token : tokens){
            sum += Integer.parseInt(token);
        }
        return sum;
    }

}
