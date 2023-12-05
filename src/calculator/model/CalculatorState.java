package calculator.model;

public interface CalculatorState {
    void clearPressed();
    void numberPressed(int number);
    void dividePressed();
    void multiplyPressed();
    void subtractPressed();
    void addPressed();
    void equalsPressed();
    void decimalPressed();
}
