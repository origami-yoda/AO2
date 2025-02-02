package calculator.model.States;

import calculator.model.Calculator;

public class DecimalState implements CalculatorState {

    private Calculator calculator;
    private String currNumber;
    private CalculatorState prevState;

    public DecimalState(Calculator calculator, CalculatorState prevState) {
        this.calculator = calculator;
        String number = this.calculator.getCurrentNumber() + "";
        this.currNumber = number.substring(0, number.length()-1);
        this.prevState = prevState;
    }

    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        String newNumber = this.currNumber + number;
        this.currNumber = newNumber;
        this.calculator.setCurrentNumber(Double.parseDouble(newNumber));
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
        this.calculator.setState(prevState);
        this.calculator.equalsPressed();
    }

    @Override
    public void decimalPressed() {
    }
}
