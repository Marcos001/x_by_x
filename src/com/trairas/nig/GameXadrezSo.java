package com.trairas.nig;

import javax.swing.*;

public class GameXadrezSo {

    private boolean verbose = false;
    private painel_tabu painel_game = null;

    public JPanel getPainelGame(){
        return painel_game;
    }

    private void setar_pecas(){
        painel_game.mat.set_pecas_xadrez();
        painel_game.update_tabuleiro();
        painel_game.updateUI();
        print("Pecas setadas");
    }

    public JPanel painel_game(){
        painel_game = new painel_tabu();
        setar_pecas();
        return painel_game;
    }

    public GameXadrezSo(){

    }

    private void print(String m){
        if (verbose)
            System.out.print(m);
    }

}
