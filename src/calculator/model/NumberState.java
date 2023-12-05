package calculator.model;

public class NumberState implements CalculatorState {

    private Calculator calculator;
    private double currentNumber    ;

    public NumberState(Calculator calculator) {
        this.calculator = calculator;
        this.currentNumber = this.calculator.getCurrentNumber();
    }

    @Override
    public void clearPressed() {
        calculator.setCurrentNumber(0.0);
        calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        this.currentNumber = this.currentNumber * 10 + number;
        calculator.setCurrentNumber(this.currentNumber);
    }

    @Override
    public void dividePressed() {
        this.calculator.setState(new DivideState(this.calculator));
        this.calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void multiplyPressed() {
        calculator.setState(new MultiplyState(this.calculator));
        calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void subtractPressed() {
        calculator.setState(new SubtractState(this.calculator));
        calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void addPressed() {
        calculator.setState(new AddState(this.calculator));
        calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void equalsPressed() {
    }

    @Override
    public void decimalPressed() {
        calculator.setState(new DecimalState(this.calculator));
    }
}
