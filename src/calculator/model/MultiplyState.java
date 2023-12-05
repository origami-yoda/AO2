package calculator.model;

public class MultiplyState implements CalculatorState{
    private Calculator calculator;

    public MultiplyState(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public void clearPressed() {
        this.calculator.setCurrentNumber(0.0);
        this.calculator.setState(new InitialState(this.calculator));
    }

    @Override
    public void numberPressed(int number) {
        this.calculator.setCurrentNumber(0.0);
        double currentNumber = this.calculator.getCurrentNumber();
        currentNumber = currentNumber * 10 + number;
        calculator.setCurrentNumber(currentNumber);
        calculator.setState(new NumberState(this.calculator));
    }

    @Override
    public void dividePressed() {
        this.calculator.setStoredNumber(this.calculator.getCurrentNumber());
        this.calculator.setState(new DivideState(this.calculator));
    }

    @Override
    public void multiplyPressed() {
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
        this.calculator.setCurrentNumber(this.calculator.getStoredNumber() * this.calculator.getCurrentNumber());
        this.calculator.setState(new ResultState(this.calculator));
    }

    @Override
    public void decimalPressed() {
        this.calculator.setState(new DecimalState(this.calculator));
    }
}
