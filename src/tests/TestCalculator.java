package tests;

import calculator.model.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCalculator {

    @Test
    public void testCalculator() {

        Calculator calc = new Calculator();
        double delta = 0.0001;

        assertEquals(0.0, calc.displayNumber(), delta);

        calc.numberPressed(4);
        calc.numberPressed(6);
        calc.numberPressed(1);
        assertEquals(461, calc.displayNumber(), delta);

        calc.clearPressed();
        assertEquals(0, calc.displayNumber(), delta);

        calc.numberPressed(2);
        calc.numberPressed(5);
        calc.dividePressed();
        calc.numberPressed(1);
        calc.numberPressed(0);
        calc.equalsPressed();
        assertEquals(2.5, calc.displayNumber(), delta);

        calc.addPressed();
        calc.numberPressed(4);
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(47.5, calc.displayNumber(), delta);

        calc.subtractPressed();
        calc.numberPressed(4);
        calc.numberPressed(2);
        calc.equalsPressed();
        assertEquals(5.5, calc.displayNumber(), delta);

        calc.multiplyPressed();
        calc.numberPressed(2);
        calc.equalsPressed();
        assertEquals(11, calc.displayNumber(), delta);

        calc.clearPressed();

        calc.numberPressed(5);
        calc.numberPressed(0);
        calc.subtractPressed();
        calc.numberPressed(1);
        calc.numberPressed(0);
        calc.numberPressed(0);
        calc.equalsPressed();
        assertEquals(-50, calc.displayNumber(), delta);

        calc.dividePressed();
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(-10, calc.displayNumber(),delta);

        calc.addPressed();
        calc.numberPressed(1);
        calc.numberPressed(0);
        calc.equalsPressed();
        assertEquals(0, calc.displayNumber(), delta);

        calc.multiplyPressed();
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(0, calc.displayNumber(), delta);

        calc.clearPressed();
        calc.numberPressed(1);
        calc.numberPressed(2);
        calc.decimalPressed();
        calc.decimalPressed();
        calc.numberPressed(5);
        calc.decimalPressed();
        calc.decimalPressed();
        calc.numberPressed(0);
        calc.decimalPressed();
        calc.numberPressed(5);
        assertEquals(12.505, calc.displayNumber(), delta);

        calc.clearPressed();
        calc.numberPressed(5);
        calc.multiplyPressed();
        calc.decimalPressed();
        calc.numberPressed(5);
        calc.equalsPressed();
        assertEquals(2.5, calc.displayNumber(), delta);

        calc.multiplyPressed();
        calc.numberPressed(2);
        calc.equalsPressed();
        calc.equalsPressed();
        calc.equalsPressed();
        assertEquals(20, calc.displayNumber(), delta);

        calc.clearPressed();
        calc.numberPressed(8);
        calc.numberPressed(0);
        calc.subtractPressed();
        calc.numberPressed(1);
        calc.numberPressed(0);
        calc.equalsPressed();
        calc.equalsPressed();
        calc.equalsPressed();
        calc.equalsPressed();
        assertEquals(40, calc.displayNumber(), delta);

        calc.clearPressed();
        calc.numberPressed(1);
        calc.decimalPressed();
        calc.numberPressed(2);
        calc.dividePressed();
        calc.decimalPressed();
        calc.numberPressed(3);
        calc.equalsPressed();
        assertEquals(4, calc.displayNumber(), delta);
    }

}
