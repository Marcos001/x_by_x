package com.trairas.nig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 01/09/17.
 */
public class window extends JFrame {

    tabuleiro _t;
    menu _menu;

    public window(){

       _menu = new menu();
       _t = new tabuleiro(8);

       this.setTitle("8 Rainhas");
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.add(_t);
       this.setJMenuBar(_menu.getBarraMenu());

       _menu.getItemReiniciar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               _t.reiniciar();
           }
       });

       _menu.getItemSair().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });


       this.setSize(_t.getWidth(), _t.getHeight());
       this.setVisible(true);

    }



}
