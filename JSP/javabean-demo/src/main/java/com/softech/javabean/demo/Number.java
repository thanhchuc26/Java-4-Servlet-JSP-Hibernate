/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.javabean.demo;

import java.io.Serializable;

/**
 *
 * @author June
 */
public class Number implements Serializable{
    String num1, num2;
    public Number(){
    }
    
     public int add(){
        try {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            
            return a + b;
        } catch (Exception e) {
        }
        return 0;
    }
    
    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }
}
