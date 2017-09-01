package com.trairas.nig;

import javax.swing.*;

/**
 * Created by nig on 01/09/17.
 */
public class window extends JFrame {

    public window(){

        tabuleiro t = new tabuleiro(8);
       this.setTitle("8 Rainhas");
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.add(t);
       this.setSize(t.getWidth(), t.getHeight());
       this.setVisible(true);

    }



}
