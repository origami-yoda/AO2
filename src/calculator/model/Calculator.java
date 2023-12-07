package calculator.model;

import calculator.model.States.CalculatorState;
import calculator.model.States.InitialState;

public class Calculator {

    private CalculatorState currentState;
    private double currentNumber;
    private double storedNumber;

    public Calculator() {
        currentState = new InitialState(this);
    }

    public void setState(CalculatorState state) {
        this.currentState = state;
    }

    public void setCurrentNumber(double number) {
        this.currentNumber = number;
    }

    public void setStoredNumber(double number) {
        this.storedNumber = number;
    }

    public double getCurrentNumber() {
        return this.currentNumber;
    }

    public double getStoredNumber() {
        return this.storedNumber;
    }

    // Accessed by View. You should edit this method as you build functionality
    public double displayNumber() {
        return currentNumber;
    }

    public void clearPressed() {
        currentState.clearPressed();
    }

    public void numberPressed(int number) {
        currentState.numberPressed(number);
    }

    public void dividePressed() {
        currentState.dividePressed();
    }

    public void multiplyPressed() {
        currentState.multiplyPressed();
    }

    public void subtractPressed() {
        currentState.subtractPressed();
    }

    public void addPressed() {
        currentState.addPressed();
    }

    public void equalsPressed() {
        currentState.equalsPressed();
    }

    public void decimalPressed() {
        currentState.decimalPressed();
    }
}