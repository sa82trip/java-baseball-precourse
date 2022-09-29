package baseball.player;

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
        int MAX_DIGIT = 3;
        return inputNumber.length() == MAX_DIGIT;
    }
}
