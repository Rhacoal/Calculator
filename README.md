# Calculator
Calculate expressions
## Usage
<p>When running the program, a dialog will show up informing you to input a expression. 
Then it will calculated the expression output the result.</p>
<p>If you want to stop the calculator, simply click 'cancel'</p>
###Supporting operators
####Binary Operators
- plus(+)
- minus(-)
- multiplication(*)
- division(/)
- exponent(E)
- power(^)
- modulo(mod)
- reminder(rem)
- comma(,)

####Unary Operators
- negative(-)
- positive(+)
- logarithm(log)
- common logarithm(lg)
- natural logarithm(ln)

####Pair Operators
> consumes a pair like log(2,8)

- logarithm(log)

####Suffix Operators
- Factorial(!)

###Format
Just like common expressions. For example:
```
1+(2*3)^4*6
8e10-7e20
6mod5+2
(-1)*(1+23*3^2+(7+8)/7^3-21-13*3^2-21*3^2+(7+8)+23*3^2+(7+8)/7^3-21+23+(7+8)/7^3/7^3-21+23*3^2+(7+8)/7^3-2)
3+log(3,9)
lg7*lg8*lg9
```
Not supporting parentheses directly following a number like
>2+3(5*6)

##Modify the code
You may easily modify the code and add new operators
###Create a new operator
For unary prefix operator, create a class which extends UnaryOperatorNode 
and register it in Registration.java by adding a line to register()
```java
registerOperator("youroperatorname", YourOperatorClass.class, PREFIX);
```
And for binary operators, create a class which extends BinaryOperatorNode and register it with type BINARY instead of UNARY.
####Implementing Methods
For example, this PlusOperatorNode
```java
package com.github.rhacoal.calculator.operator.binaryoperator;

import com.github.rhacoal.calculator.exception.CalculationException;
import com.github.rhacoal.calculator.operator.BinaryOperatorNode;

import java.math.BigDecimal;

public class PlusOperatorNode extends BinaryOperatorNode {

    @Override
    public BigDecimal calculate() throws CalculationException {
        return getLeftChild().calculate().add(getRightChild().calculate());
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
```
The getPriority() method implies what priority it should be. This affects the order of calculation.
The calculate() method return the value of the current node by adding the value of two child nodes.
###Calculate expressions
The class Calculation will help.
Create an instance of Calculation class and call the method calculate(). It will return the result in java.math.BigDecimal.
For example
```java
System.out.println(new Calculation("1+2+3+4+5+6").calculate());
```
