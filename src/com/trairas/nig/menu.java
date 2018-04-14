package com.trairas.nig;

import javax.swing.*;
import java.awt.*;


/**
 * Created by nig on 03/09/17.
 */

public class menu {

    Font f = new Font("Times New Roman", Font.BOLD, 14);

    private JMenuBar BarraMenu = null;

    private JMenu mnuArquivo = null;
    private JMenu menu_search_solution = null;
    private JMenu menu_conf = null;
    private JMenu game_network = null;

    private JMenuItem menu_reiniciar = null;
    private JMenuItem qtd_casa = null;
    private JMenuItem mnuSair = null;

    private JMenuItem menu_algoritmo = null;

    private JMenuItem tema_1 = null;
    private JMenuItem tema_2 = null;

    public JMenuItem getInit_server() {
        return init_server;
    }

    public JMenuItem getSearch_server() {
        return search_server;
    }

    public JMenuItem get_game_you() {
        return xadrez_jogar_so;
    }

    private JMenuItem init_server = null;
    private JMenuItem search_server = null;
    private JMenuItem xadrez_jogar_so = null;


    //
    public JMenuBar getBarraMenu() {
        if (BarraMenu == null){
            BarraMenu = new JMenuBar();
            BarraMenu.setBackground(new Color(55,55,55));
            BarraMenu.add(getMnuArquivo());
            BarraMenu.add(get_menu_search_soluction());
            BarraMenu.add(getMnuConfig());
            BarraMenu.add(getMnuGameXadrez());
        }
        return BarraMenu;
    }


    //
    private JMenu get_menu_search_soluction() {
        if (menu_search_solution == null){
            menu_search_solution = new JMenu();
            menu_search_solution.setText("Algoritmo");
            menu_search_solution.setFont(f);
            menu_search_solution.setForeground(new Color(255,255,255));
            menu_search_solution.add(get_menu_algoritmo());
        }
        return menu_search_solution;
    }

    private JMenu getMnuArquivo() {
        if (mnuArquivo == null){
            mnuArquivo = new JMenu();
            mnuArquivo.setText("Game");
            mnuArquivo.setFont(f);
            mnuArquivo.setForeground(new Color(255,255,255));
            mnuArquivo.add(get_menu_reiniciar());
            mnuArquivo.add(get_menu_qtd_casa());
            mnuArquivo.add(getMnuSair());
        }
        return mnuArquivo;
    }

    private JMenu getMnuConfig() {
        if (menu_conf == null){
            menu_conf = new JMenu();
            menu_conf.setText("Configurações");
            menu_conf.setFont(f);
            menu_conf.setForeground(new Color(255,255,255));
            menu_conf.add(get_tema_1());
            menu_conf.add(get_tema_2());
        }
        return menu_conf;
    }

    private JMenu getMnuGameXadrez() {
        if (game_network == null){
            game_network = new JMenu();
            game_network.setText(" Xadrez ");
            game_network.setFont(f);
            game_network.setForeground(new Color(255,255,255));
            game_network.add(get_init_server());
            game_network.add(get_search_server());
            game_network.add(set_game_you());
        }
        return game_network;
    }

    //
    private JMenuItem getMnuSair() {
        if (mnuSair == null){
            mnuSair = new JMenuItem();
            mnuSair.setBackground(new Color(55,55,55));
            mnuSair.setForeground(new Color(255,255,255));
            mnuSair.setText("Sair");
            mnuSair.setFont(f);
        }
        return mnuSair;
    }

    private JMenuItem get_menu_reiniciar() {
        if (menu_reiniciar == null){
            menu_reiniciar = new JMenuItem();
            menu_reiniciar.setBackground(new Color(55,55,55));
            menu_reiniciar.setForeground(new Color(255,255,255));
            menu_reiniciar.setText("Novo Jogo");
            menu_reiniciar.setFont(f);
        }
        return menu_reiniciar;
    }

    private JMenuItem get_menu_qtd_casa() {
        if (qtd_casa == null){
            qtd_casa = new JMenuItem();
            qtd_casa.setBackground(new Color(55,55,55));
            qtd_casa.setForeground(new Color(255,255,255));
            qtd_casa.setText("Dimensão");
            qtd_casa.setFont(f);
        }
        return qtd_casa;
    }


    //
    private JMenuItem get_tema_1() {
        if (tema_1 == null){
            tema_1 = new JMenuItem();
            tema_1.setBackground(new Color(55,55,55));
            tema_1.setForeground(new Color(255,255,255));
            tema_1.setText("Tema BLUE ");
            tema_1.setFont(f);
        }
        return tema_1;
    }

    private JMenuItem get_tema_2() {
        if (tema_2 == null){
            tema_2 = new JMenuItem();
            tema_2.setBackground(new Color(55,55,55));
            tema_2.setForeground(new Color(255,255,255));
            tema_2.setText("Tema RED ");
            tema_2.setFont(f);
        }
        return tema_2;
    }

    //
    private JMenuItem get_menu_algoritmo() {
        if (menu_algoritmo == null){
            menu_algoritmo = new JMenuItem();
            menu_algoritmo.setBackground(new Color(55,55,55));
            menu_algoritmo.setForeground(new Color(255,255,255));
            menu_algoritmo.setText("Jogar");
            menu_algoritmo.setFont(f);
        }
        return menu_algoritmo;
    }


    private JMenuItem set_game_you() {
        if (xadrez_jogar_so == null){
            xadrez_jogar_so = new JMenuItem();
            xadrez_jogar_so.setBackground(new Color(55,55,55));
            xadrez_jogar_so.setForeground(new Color(255,255,255));
            xadrez_jogar_so.setText(" Você X Você ");
            xadrez_jogar_so.setFont(f);
        }
        return xadrez_jogar_so;
    }



    private JMenuItem get_init_server() {
        if (init_server == null){
            init_server = new JMenuItem();
            init_server.setBackground(new Color(55,55,55));
            init_server.setForeground(new Color(255,255,255));
            init_server.setText("Iniciar Game Servidor ");
            init_server.setFont(f);
        }
        return init_server;
    }

    private JMenuItem get_search_server() {
        if (search_server == null){
            search_server = new JMenuItem();
            search_server.setBackground(new Color(55,55,55));
            search_server.setForeground(new Color(255,255,255));
            search_server.setText(" Conectar a Game Servidor ");
            search_server.setFont(f);
        }
        return search_server;
    }


    // gets()

    public JMenuItem getItemSair(){
        return mnuSair;
    }

    public JMenuItem getItemReiniciar(){
        return menu_reiniciar;
    }

    public JMenuItem getQtd_casa(){
        return qtd_casa;
    }
    public JMenuItem getTema_1() {
        return tema_1;
    }
    public JMenuItem getTema_2() {
        return tema_2;
    }

}
