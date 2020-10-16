/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.asyncweb;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 *
 * @author egnnnth
 */
public class AsyncCompleteListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("on complete"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("on timeout"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("on error"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("on timeout"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
