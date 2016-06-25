package com.github.rhacoal;

import com.github.rhacoal.calculator.Calculation;
import com.github.rhacoal.calculator.CalculationException;
import com.github.rhacoal.calculator.Registration;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws CalculationException {

        Registration.register();

        while (true) {

            String expr = JOptionPane.showInputDialog("Input an expression");
            if (expr == null || expr.isEmpty()) break;

            BigDecimal result = null;
            long millis = System.currentTimeMillis();

            for (int i = 0; i != 1000000; ++ i) {
                result = new Calculation(expr).calculate();
            }

            long millis2 = System.currentTimeMillis();
            long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            String result0 = String.format(
                    "1000k times"
                    + "\nResult\n  %s"
                    + "\nTime used\n  %dms"
                    + "\nMemory used\n  %.2fM"
                    , result.toString(), (millis2 - millis), memory/1024D/1024D
            );

            JOptionPane.showMessageDialog(null, result0);

        }
        JOptionPane.showMessageDialog(null, "Calculator exited");

    }

}
