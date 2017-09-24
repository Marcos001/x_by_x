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
    tabu_game _tg;
    JPanel contentPane;
    menu _menu;
    int DIMENSION = 8;
    private static final int DEFAULT_DIMENSION = 8;
    private static final String _TITLE = "N-Rainhas";
    mv_util util;

    final int servidor = 0;
    final int cliente = 1;



    public window(){

        _menu = new menu();
        _t = new tabuleiro(DIMENSION);
        util = new mv_util();

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
       this.setIconImage(util.get_img_Icon("asserts/data/icone/256.png"));

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

        _menu.getInit_server().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Iniciando Servidor");
                play_game_network();
            }
        });

        _menu.getSearch_server().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Conentando a Servidor");
            }
        });



        this.setSize(_t.getWidth(), _t.getHeight());
        this.setVisible(true);

    }

    private void remove_painel_anterior(){
        if(_t != null){
            contentPane.remove(_t);
        }
        if (_tg != null){
            contentPane.remove(_tg);
        }
    }

    private void _reiniciar(){

        remove_painel_anterior();

        contentPane.setBackground(new Color(55,55,55));
        _t = null;
        _t = new tabuleiro(DIMENSION);
        contentPane.add(_t);
        contentPane.updateUI();
        contentPane.setSize(_t.getWidth(), _t.getHeight());
        this.setSize(contentPane.getWidth(), contentPane.getHeight());
    }

    private void play_game_network(){

        remove_painel_anterior();

        contentPane.setBackground(new Color(55,55,55));
        _tg = null;
        _tg = new tabu_game(DEFAULT_DIMENSION, servidor);
        contentPane.add(_tg);
        contentPane.updateUI();
        contentPane.setSize(_tg.getWidth(), _tg.getHeight());
        this.setSize(contentPane.getWidth(), contentPane.getHeight());

    }


}
