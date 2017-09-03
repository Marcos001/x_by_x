package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 01/09/17.
 */
public class window extends JFrame {

    tabuleiro _t;
    JPanel contentPane;
    menu _menu;

    public window(){

        _menu = new menu();
        _t = new tabuleiro(8);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.setBackground(new Color(255,255,255));
        contentPane.setVisible(true);
        contentPane.setSize(500,500);
        contentPane.add(_t);

       this.setTitle("8 Rainhas");
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.add(contentPane);
       this.setJMenuBar(_menu.getBarraMenu());

       _menu.getItemReiniciar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               contentPane.remove(_t);
               contentPane.setBackground(new Color(55,55,55));
               _t = null;
               _t = new tabuleiro(8);
               contentPane.add(_t);
               contentPane.updateUI();
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
