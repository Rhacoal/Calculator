package com.github.rhacoal;

import com.github.rhacoal.calculator.Calculation;
import com.github.rhacoal.calculator.CalculationException;
import com.github.rhacoal.calculator.Registration;

import javax.swing.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws CalculationException {

        Registration.register();



//        while (scanner.hasNext()) {
//            BigDecimal result0 = new Calculation(scanner.nextLine()).calculate();
//            System.out.println(result0);
//        }

        while (true) {

            String expr = JOptionPane.showInputDialog("Input an expression");
            if (expr == null || expr.isEmpty()) break;

            BigDecimal result = null;
            long start = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long millis = System.currentTimeMillis();

            for (int i = 0; i != 1000000; ++ i) {
                result = new Calculation(expr).calculate();
            }

            long millis2 = System.currentTimeMillis();
            long end = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            String result0 =
                    "1000k"
                    + "\n计算结果　　\t" + result
                    + "\n耗时　　　　\t" + (millis2 - millis)
                    + "ms\n" + "内存占用增加\t" + (end - start)/1024D/1024D + "M"
                    + "\n内存占用　　\t" + end/1024D/1024D + "M";

            JOptionPane.showMessageDialog(null, result0);

        }

    }

}
