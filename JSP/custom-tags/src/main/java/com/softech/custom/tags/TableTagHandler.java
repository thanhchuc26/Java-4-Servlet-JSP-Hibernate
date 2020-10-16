/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.custom.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author June
 */
public class TableTagHandler extends SimpleTagSupport {

    private String color;
    private int rows;
    private int cols;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            out.println(String.format("<table style='color:%s'>", color));
            for (int i = 0; i < rows; i++) {
                out.println("<tr>");
                for (int j = 0; j < cols; j++) {
                    out.println("<td>");
                    out.println("" + i * j);
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in TableTagHandler tag", ex);
        }
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

}
