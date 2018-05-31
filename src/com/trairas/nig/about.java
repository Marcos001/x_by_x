package com.trairas.nig;

import javax.swing.*;
import java.awt.*;

public class about extends JPanel {

    public about(int x, int y){
        int p = 5;
        int x_10 = (p * x) / 100;
        int y_10 = (p * y) / 100;
        System.out.println(x_10+","+y_10+" = "+x+","+y);
        JTextArea campo = new JTextArea();
        campo.setText(" Autor :  Marcos Vinícius dos Santos Ferreira " +
                "\nEmail :  marcosvsf@ufba.com" +
                "\nBibliotecas :  Java com swing para GUI");
        campo.setLineWrap(true);
        campo.setEditable(false);
        campo.setBounds(x_10, y_10, x-(2*x_10), y-(2*y_10));
        campo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));


        this.add(campo);

        this.setLayout(null);
        this.setBackground(new Color(230, 230, 230));

    }

}
