package calculator;

public class Calculator {
    public static int calculator(String input, String splitRegex) {
        int sum = 0;
        // 끝 토큰까지 확인
        String[] tokens = input.split(splitRegex, -1);
        for (String token : tokens) {
            String number = token.trim();
            Validator.validator(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
