package ru.mykvm.mycalc;

import java.io.Serializable;

public class Calculate implements Serializable {
private int number1;
private int number2;
private int result;
private String operation;
public Calculate()
{
number1 = 0;
number2 = 0;
result = 0;
operation = null;
}



    public int getResult(int n1, int n2, String s) {
    this.number1 = n1;
    this.number2 = n2;
    this.operation = s;
    if(operation.equals("addition"))
    {
        this.result = number1 + number2;
    }
    else if(operation.equals("subtraction"))
    {
        this.result = number1 - number2;
    }
    else if(operation.equals("multiplication"))
    {
        this.result = number1 * number2;
    }
    else if(operation.equals("division"))
    {
        this.result = number1 / number2;
    }

        return result;
    }

  }
