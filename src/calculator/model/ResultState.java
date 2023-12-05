package calculator.model;

public class ResultState implements CalculatorState {

    private Calculator calculator;

    public ResultState(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0.0);
        this.calculator.setStoredNumber(0.0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        this.calculator.setCurrentNumber(number);
        this.calculator.setState(new NumberState(this.calculator));
    }

    @Override
    public void dividePressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setState(new DivideState(this.calculator));
    }

    @Override
    public void multiplyPressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setState(new MultiplyState(this.calculator));
    }

    @Override
    public void subtractPressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setState(new SubtractState(this.calculator));
    }

    @Override
    public void addPressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setState(new AddState(this.calculator));
    }

    @Override
    public void equalsPressed() {
    }

    @Override
    public void decimalPressed() {
        this.calculator.setState(new DecimalState(this.calculator));
    }
}
