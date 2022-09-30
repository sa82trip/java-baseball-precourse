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
    STRIKE("strike"),
    BALL("ball");


    public final String label;

    BaseballStringEnum(String label) {
        this.label = label;
    }

}
