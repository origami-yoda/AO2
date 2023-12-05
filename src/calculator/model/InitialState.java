package calculator.model;

public class InitialState implements CalculatorState {

    private Calculator calculator;

    public InitialState(Calculator calculator) {
        this.calculator = calculator;
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
        calculator.setCurrentNumber(0.0);
        calculator.setState(new DecimalState(this.calculator));
    }
}
