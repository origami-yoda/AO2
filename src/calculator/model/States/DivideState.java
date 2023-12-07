package calculator.model.States;

import calculator.model.Calculator;

public class DivideState implements CalculatorState {
    private Calculator calculator;

    public DivideState(Calculator calculator) {
        this.calculator = calculator;
        this.calculator.setCurrentNumber(0);
    }

    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        this.calculator.setCurrentNumber(this.calculator.getCurrentNumber() * 10 + number);
    }

    @Override
    public void dividePressed() {
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
        double result = this.calculator.getStoredNumber() / this.calculator.getCurrentNumber();
        double operand = this.calculator.getCurrentNumber();
        this.calculator.setCurrentNumber(result);
        this.calculator.setState(new EqualsState(this.calculator, this, operand, result));
    }

    @Override
    public void decimalPressed() {
        this.calculator.setState(new DecimalState(this.calculator, this));
    }
}
