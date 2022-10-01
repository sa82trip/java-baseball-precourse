package baseball.constant;

public enum BaseballStringEnum {

    ZERO_BALL("0"),
    ONE_BALL("1"),
    TWO_BALL("2"),
    THREE_BALL("3"),
    ZERO_STRIKE("0"),
    ONE_STRIKE("1"),
    TWO_STRIKE("2"),
    THREE_STRIKE("3"),
    NOTHING("낫싱"),

    INVALID_NUMBER_FOR_INPUT("0"),
    INVALID_DIGIT_NUMBER("1234"),
    VALID_NUMBER("123"),
    NUMBER_INCLUDES_DUPLICATE("122"),
    NUMBER_INCLUDES_DUPLICATE_OVER_3_DIGIT("1233"),
    STRING_WITH_LENGTH_ONE("1"),
    STRING_WITH_LENGTH_TWO("12"),
    STRIKE("strike"),
    BALL("ball"),
    STRIKE_IN_KOREAN("스트라이크"),
    BALL_IN_KOREAN("볼"),
    USER_INPUT_REQUEST_STATEMENT("숫자를 입력해주세요");


    public final String label;

    BaseballStringEnum(String label) {
        this.label = label;
    }

}
