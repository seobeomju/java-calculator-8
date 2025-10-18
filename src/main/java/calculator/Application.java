package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //입력 내 \n을 실제 개행으로 변환
        input = input.replace("\\n", "\n");
        System.out.println("결과 : " + StringCalculator.parseAndCalculate(input));
    }
}
