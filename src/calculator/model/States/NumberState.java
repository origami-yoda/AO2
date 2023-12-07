package calculator.model.States;

import calculator.model.Calculator;

public class NumberState implements CalculatorState {

    private Calculator calculator;
    private double currentNumber;

    public NumberState(Calculator calculator) {
        this.calculator = calculator;
        this.currentNumber = this.calculator.getCurrentNumber();
    }

    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0);
        this.calculator.setState(new InitialState(this.calculator));
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
        this.calculator.setState(new MultiplyState(this.calculator));
        this.calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void subtractPressed() {
        this.calculator.setState(new SubtractState(this.calculator));
        this.calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void addPressed() {
        this.calculator.setState(new AddState(this.calculator));
        this.calculator.setStoredNumber(this.currentNumber);
    }

    @Override
    public void equalsPressed() {
    }

    @Override
    public void decimalPressed() {
        this.calculator.setState(new DecimalState(this.calculator, this));
    }
}
