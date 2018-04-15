package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 01/09/17.
 * Janela com aa s Opções de Jogar com N-Rainhas ou Jogar Xadrez
 */


public class window extends JFrame {

    private tabuleiro _tabuleiro_N_rainhas;
    private tabu_game _tabuleiro_xadrez;
    private JPanel contentPane;
    private menu _menu;
    private int DIMENSION = 8;
    private static final int DEFAULT_DIMENSION = 8;
    private static final String _TITLE = "N-Rainhas";
    private mv_util util;

    private final int servidor = 0;
    private final int cliente = 1;
    private final int jogar_so = 2;
    private boolean verbose;


    /**
     * Janela principal - GUI
     *
     * */

    public window(){

        verbose =  false;
        _menu = new menu();
        _tabuleiro_N_rainhas = new tabuleiro(DIMENSION);
        util = new mv_util();


        // painel que pega o conteudo do tablueiro - JPANEL
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.setBackground(new Color(255,255,255));
        contentPane.setVisible(true);
        contentPane.setSize(500,500);
        contentPane.add(_tabuleiro_N_rainhas);


        // Configurações de toda a janena - JFRAME
       this.setTitle(_TITLE);
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.add(contentPane);
       this.setJMenuBar(_menu.getBarraMenu());
       this.setIconImage(util.get_img_Icon("asserts/data/icone/256.png"));
       this.setLocationRelativeTo(null);



       // Botão do menu para reiniciar
       _menu.getItemReiniciar().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               _reiniciar();
           }
       });


       // Botão do Menu para Sair - Fechar
       _menu.getItemSair().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });


       // Criar um novo jog  de N rainhas de acordo com a entrada do usuario
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


       // mudança de TEMA 1
       _menu.getTema_1().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               _tabuleiro_N_rainhas.setTema(tabuleiro.getTema1());
               _tabuleiro_N_rainhas.update_tabuleiro();
           }
       });


       // Mudança de TEMA 2
        _menu.getTema_2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _tabuleiro_N_rainhas.setTema(tabuleiro.getTema2());
                _tabuleiro_N_rainhas.update_tabuleiro();
            }
        });

        // Inicia servidor de Xadrez
        _menu.getInit_server().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Iniciando Servidor");
                play_game_network(servidor);
            }
        });

        // Opção para jogar Xadrez do lado Cliente - espera um a conexao com o servidor
        _menu.getSearch_server().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Conentando a Servidor");
                play_game_network(cliente);
            }
        });


        // função para jogar xadrez só
        _menu.get_game_you().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                print("Jogar Xadrez só");
                play_game_network(jogar_so);
            }
        });



        this.setSize(_tabuleiro_N_rainhas.getWidth(), _tabuleiro_N_rainhas.getHeight());
        this.setVisible(true);

    }

    private void remove_painel_anterior(){
        if(_tabuleiro_N_rainhas != null){
            contentPane.remove(_tabuleiro_N_rainhas);
        }
        if (_tabuleiro_xadrez != null){
            contentPane.remove(_tabuleiro_xadrez);
        }
    }

    private void _reiniciar(){

        // _t = instancia do tabuleiro das N rainhas

        remove_painel_anterior();

        _tabuleiro_N_rainhas = null;
        _tabuleiro_N_rainhas = new tabuleiro(DIMENSION);

        contentPane.setBackground(new Color(55,55,55));
        contentPane.add(_tabuleiro_N_rainhas);
        contentPane.updateUI();
        contentPane.setSize(_tabuleiro_N_rainhas.getWidth(), _tabuleiro_N_rainhas.getHeight());

        this.setSize(contentPane.getWidth(), contentPane.getHeight());
    }

    // Funcao que chama a instancia de um jogo de Xadrez
    private void play_game_network(int conexao){

        // _tg = instancia do tabuleiro das N rainhas

        remove_painel_anterior();

        _tabuleiro_xadrez = null;
        _tabuleiro_xadrez = new tabu_game(conexao);

        contentPane.setBackground(new Color(55,55,55));
        contentPane.add(_tabuleiro_xadrez);
        contentPane.updateUI();
        contentPane.setSize(_tabuleiro_xadrez.getWidth(), _tabuleiro_xadrez.getHeight());

        this.setSize(contentPane.getWidth(), contentPane.getHeight());
    }

    private void print(String m){
        if (verbose)
            System.out.print(""+m);
    }

}
