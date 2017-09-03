package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by nig on 03/09/17.
 */
public class menu {

    private JMenuBar BarraMenu = null;
    private JMenu mnuArquivo = null;
    private JMenuItem menu_reiniciar = null;
    private JMenuItem mnuSair = null;

    public JMenuBar getBarraMenu() {
        if (BarraMenu == null){
            BarraMenu = new JMenuBar();
            BarraMenu.setBackground(new Color(55,55,55));
            BarraMenu.add(getMnuArquivo());
        }
        return BarraMenu;
    }


    private JMenu getMnuArquivo() {
        if (mnuArquivo == null){
            mnuArquivo = new JMenu();
            mnuArquivo.setText("Game");
            mnuArquivo.setForeground(new Color(255,255,255));
            mnuArquivo.add(get_menu_reiniciar());
            mnuArquivo.add(getMnuSair());
        }
        return mnuArquivo;
    }

    private JMenuItem getMnuSair() {
        if (mnuSair == null){
            mnuSair = new JMenuItem();
            mnuSair.setBackground(new Color(55,55,55));
            mnuSair.setForeground(new Color(255,255,255));
            mnuSair.setText("Sair");
        }
        return mnuSair;
    }

    private JMenuItem get_menu_reiniciar() {
        if (menu_reiniciar == null){
            menu_reiniciar = new JMenuItem();
            menu_reiniciar.setBackground(new Color(55,55,55));
            menu_reiniciar.setForeground(new Color(255,255,255));
            menu_reiniciar.setText("Novo Jogo");
        }
        return menu_reiniciar;
    }

    public JMenuItem getItemSair(){
        return mnuSair;
    }

    public JMenuItem getItemReiniciar(){
        return menu_reiniciar;
    }

}
