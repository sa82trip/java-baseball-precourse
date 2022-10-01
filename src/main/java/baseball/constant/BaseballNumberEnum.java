package baseball.constant;

public enum BaseballNumberEnum {

    // conditions
    MAX_DIGIT(3),
    BEGINNING_CHARACTER(0),
    TARGET_LENGTH_FOR_CHECKING_STRING(1),
    // array related
    INDEX_ZERO(0),
    INDEX_ONE(1);

    public final Integer intValue;

    BaseballNumberEnum(int intValue) {
        this.intValue = intValue;
    }
}
