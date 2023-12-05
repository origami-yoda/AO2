package calculator.model;

public class DecimalNumberState implements CalculatorState{

    private Calculator calculator;

    public DecimalNumberState(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0.0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        double currentNumber = this.calculator.getCurrentNumber();
        double newNumber = currentNumber * 10 + number;
        this.calculator.setCurrentNumber(newNumber);
    }

    @Override
    public void dividePressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setCurrentNumber(0.0);
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
        this.calculator.setStoredNumber(this.calculator.getStoredNumber() + this.calculator.getCurrentNumber());
        this.calculator.setState(new ResultState(this.calculator));
    }

    @Override
    public void decimalPressed() {
    }
}
