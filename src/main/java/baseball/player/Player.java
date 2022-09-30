package baseball.player;

import static baseball.constant.BaseballNumberEnum.BEGINNING_CHARACTER;
import static baseball.constant.BaseballNumberEnum.MAX_DIGIT;
import static baseball.constant.BaseballStringEnum.INVALID_NUMBER_FOR_INPUT;

public class Player {
    String inputNumber;


    public String getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(String inputNumber) {
        if (!validateInput(inputNumber)) {
            throw new IllegalArgumentException(inputNumber);
        }
        this.inputNumber = inputNumber;
    }

    protected boolean validateInput(String inputNumber) {
        if (inputNumber.length() != MAX_DIGIT.intValue) {
            return false;
        }
        if (inputNumber.contains(INVALID_NUMBER_FOR_INPUT.label)) {
            return false;
        }
        if (containDuplicate(inputNumber)) {
            return false;
        }
        return true;
    }

    protected boolean containDuplicate(String inputNumber) {
        String subString = inputNumber.substring(1, 3);
        return subString.contains(String.valueOf(inputNumber.charAt(BEGINNING_CHARACTER.intValue)));
    }
}
