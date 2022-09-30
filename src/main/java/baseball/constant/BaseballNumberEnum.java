package baseball.constant;

public enum BaseballNumberEnum {

    MAX_DIGIT(3),
    BEGINNING_CHARACTER(0);

    public final Integer intValue;

    BaseballNumberEnum(int intValue) {
        this.intValue = intValue;
    }
}
