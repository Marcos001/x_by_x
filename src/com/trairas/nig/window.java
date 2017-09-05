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
    int DIMENSION = 8;
    private static final String _TITLE = "n-Rainhas";

    public window(){

        _menu = new menu();
        _t = new tabuleiro(DIMENSION);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.setBackground(new Color(255,255,255));
        contentPane.setVisible(true);
        contentPane.setSize(500,500);
        contentPane.add(_t);

       this.setTitle(_TITLE);
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.add(contentPane);
       this.setJMenuBar(_menu.getBarraMenu());

       _menu.getItemReiniciar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               _reiniciar();
           }
       });

       _menu.getItemSair().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });

       _menu.getQtd_casa().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
                   int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de casas : "));
                   if(quantidade > 0){
                       DIMENSION = quantidade;
                       _reiniciar();
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Valor Inválido");
                   }
               }catch (Exception erro){
                   JOptionPane.showMessageDialog(null, erro);
               }
           }
       });

       _menu.getTema_1().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              _t.setTema(tabuleiro.getTema1());
               _t.update_tabuleiro();
           }
       });

        _menu.getTema_2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _t.setTema(tabuleiro.getTema2());
                _t.update_tabuleiro();
            }
        });

       this.setSize(_t.getWidth(), _t.getHeight());
       this.setVisible(true);

    }

    private void _reiniciar(){
        contentPane.remove(_t);
        contentPane.setBackground(new Color(55,55,55));
        _t = null;
        _t = new tabuleiro(DIMENSION);
        contentPane.add(_t);
        contentPane.updateUI();
    }


}
