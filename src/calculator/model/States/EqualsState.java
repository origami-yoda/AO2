package calculator.model.States;

import calculator.model.Calculator;

public class EqualsState implements CalculatorState {

    private Calculator calculator;
    private CalculatorState prevState;
    private double operand;
    private double result;

    public EqualsState(Calculator calculator, CalculatorState prevState,double operand, double result) {
        this.calculator = calculator;
        this.prevState = prevState;
        this.operand = operand;
        this.result = result;
    }
    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        calculator.setCurrentNumber(number);
        calculator.setState(new NumberState(this.calculator));
    }

    @Override
    public void dividePressed() {
        this.calculator.setState(new DivideState(this.calculator));
        this.calculator.setStoredNumber(this.result);
    }

    @Override
    public void multiplyPressed() {
        this.calculator.setState(new MultiplyState(this.calculator));
        this.calculator.setStoredNumber(this.result);
    }

    @Override
    public void subtractPressed() {
        this.calculator.setState(new SubtractState(this.calculator));
        this.calculator.setStoredNumber(this.result);
    }

    @Override
    public void addPressed() {
        this.calculator.setState(new AddState(this.calculator));
        this.calculator.setStoredNumber(this.result);
    }

    @Override
    public void equalsPressed() {
        this.calculator.setStoredNumber(this.result);
        this.calculator.setCurrentNumber(this.operand);
        this.calculator.setState(prevState);
        this.calculator.equalsPressed();
    }

    @Override
    public void decimalPressed() {
        this.calculator.setState(new DecimalState(this.calculator, this));
    }
}
