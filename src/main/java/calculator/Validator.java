package calculator;

public class Validator {
    public static void validator(String token) {
        //빈 토큰 체크
        if (token.isEmpty()) {
            throw new IllegalArgumentException("잘못된 형식: 빈 값이 포함되어 있습니다.");
        }
        //숫자 체크
        if (!token.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
        }
    }
}
