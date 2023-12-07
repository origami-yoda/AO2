package calculator.model;

public class EqualsState implements CalculatorState {

    private Calculator calculator;
    private CalculatorState prevState;

    public EqualsState(Calculator calculator, CalculatorState prevState) {
        this.calculator = calculator;
        this.prevState = prevState;
    }
    @Override
    public void clearPressed() {

    }

    @Override
    public void numberPressed(int number) {
        calculator.setCurrentNumber(number);
        calculator.setState(new NumberState(this.calculator));
    }

    @Override
    public void dividePressed() {
    }

    @Override
    public void multiplyPressed() {
    }

    @Override
    public void subtractPressed() {
    }

    @Override
    public void addPressed() {
    }

    @Override
    public void equalsPressed() {

    }

    @Override
    public void decimalPressed() {

    }
}
