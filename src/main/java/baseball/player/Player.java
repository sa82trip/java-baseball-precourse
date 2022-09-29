package baseball.player;

public class Player {
    String inputNumber;

    int MAX_DIGIT = 3;

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
        if (inputNumber.length() != MAX_DIGIT) {
            return false;
        }
        if (inputNumber.contains("0")) {
            return false;
        }
        return containDuplicate(inputNumber);
    }

    private boolean containDuplicate(String inputNumber) {
        String subString = inputNumber.substring(1, 3);
        return !subString.contains(inputNumber.charAt(0) + "");
    }
}
