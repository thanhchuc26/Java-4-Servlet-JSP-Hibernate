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
public class Book implements Serializable{

    public Book() {
    }
    private String isbn, title;

    public String getIsbn() {
        return isbn;
    }
    
   
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
