package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 23/09/17.
 */
public class tabu_game extends JPanel implements ActionListener{

    private JButton botoes[];
    private int _TAM;
    public matrix_game mat;
    private int _size;
    mv_util u;
    pecas p;
    private int comeco = 0;

    private int vez_brancas = 1;
    private int vez_pretas = -1;
    private int jogada = vez_brancas;


    private static final int _WIDTH = 500;
    private static final int _HEIGTH = 500;

    JPanel painel_log_server;
    JPanel painel_game;

    public tabu_game(int rainhas){


        int TAM = (rainhas*rainhas);
        this._size = rainhas;
        this._TAM = TAM;

        u = new mv_util();
        p = new pecas();


        painel_game = new JPanel();
        painel_game.setLayout(new GridLayout(this._size, this._size));
        painel_game.setBackground(new Color(255,255,255));
        painel_game.setBounds(0,0,_WIDTH,_HEIGTH);


        painel_log_server = new JPanel();
        painel_log_server.setBackground(u.branca);
        painel_log_server.setBounds(_WIDTH+10, 10, 100, 50);


        int size_painel_x = (_WIDTH+painel_log_server.getWidth()+20);
        int size_painel_y = _HEIGTH;


        this.add(painel_game);
        this.add(painel_log_server);
        this.setLayout(null);
        this.setBackground(new Color(55,55,55));
        this.setVisible(true);
        this.setSize(size_painel_x,size_painel_y);



        //iniciando parte logica da matrix
        u.print("iniciando parte logica...");
        if(mat == null){
            mat = new matrix_game(_size);
        }



        //adicionando botoes
        u.print("\nAdicionando os botoes...");
        init_buttons(TAM);
        add_buutons(TAM);


    }

    private void init_buttons(int rainhas){
        botoes = new JButton[rainhas];
    }

    private void add_buutons(int TAM){

        for(int i=0;i< TAM; i++){
            botoes[i] = new JButton();
            botoes[i].setSize(20,20);
            botoes[i].addActionListener(this);
            painel_game.add(botoes[i]);
        }

        int value = 0;

        for (int i=0;i<_size;i++){
            for (int j=0;j<_size;j++) {

                if (mat.matrix[i][j] == p.casa_preta) {
                    botoes[value].setBackground(u.preta);
                } else if (mat.matrix[i][j] == p.casa_branca) {
                    botoes[value].setBackground(u.branca);
                }
                value += 1;
            }
        }
    }

    // vai ser depracaciada
    public void update_tabuleiro(){

        int tam_x = 40;
        int tam_y = 40;
        int value = 0;

        for (int i=0;i<_size;i++){
            for (int j=0;j<_size;j++){

                if(mat.matrix[i][j] == p.casa_preta){
                    botoes[value].setBackground(u.preta);
                }
                else if(mat.matrix[i][j] == p.casa_branca){
                    botoes[value].setBackground(u.branca);
                }

                 if(mat.matrix[i][j] == p.peao_white){
                    botoes[value].setIcon(u.tratar_icone(p.ic_peao_white, tam_x, tam_y));
                }

                else if(mat.matrix[i][j] == p.peao_black){
                    botoes[value].setIcon(u.tratar_icone(p.ic_peao_black, tam_x, tam_y));
                }

                //torres
                 else if(mat.matrix[i][j] == p.torre_white){
                     botoes[value].setIcon(u.tratar_icone(p.ic_torre_white, tam_x, tam_y));
                 }

                 else if(mat.matrix[i][j] == p.torre_black){
                     botoes[value].setIcon(u.tratar_icone(p.ic_torre_black, tam_x, tam_y));
                 }

                 //cavalos
                 else if(mat.matrix[i][j] == p.cavalo_white){
                     botoes[value].setIcon(u.tratar_icone(p.ic_cavalo_white, tam_x, tam_y));
                 }

                 else if(mat.matrix[i][j] == p.cavalo_black){
                     botoes[value].setIcon(u.tratar_icone(p.ic_cavalo_black, tam_x, tam_y));
                 }

                 //bispos
                 else if(mat.matrix[i][j] == p.bispo_white){
                     botoes[value].setIcon(u.tratar_icone(p.ic_bispo_white, tam_x, tam_y));
                 }

                 else if(mat.matrix[i][j] == p.bispo_black){
                     botoes[value].setIcon(u.tratar_icone(p.ic_bispo_black, tam_x, tam_y));
                 }

                 //rainhas
                 else if(mat.matrix[i][j] == p.rainha_white){
                     botoes[value].setIcon(u.tratar_icone(p.ic_rainha_white, tam_x, tam_y));
                 }

                 else if(mat.matrix[i][j] == p.rainha_black){
                     botoes[value].setIcon(u.tratar_icone(p.ic_rainha_black, tam_x, tam_y));
                 }

                 //rei
                 else if(mat.matrix[i][j] == p.rei_white){
                     botoes[value].setIcon(u.tratar_icone(p.ic_rei_white, tam_x, tam_y));
                 }

                 else if(mat.matrix[i][j] == p.rei_black){
                     botoes[value].setIcon(u.tratar_icone(p.ic_rei_black, tam_x, tam_y));
                 }

                 //casas e pecas sobre ataque

                 //casa limpa
                 else if(mat.matrix[i][j] == p.casa_limpa_at){
                     botoes[value].setIcon(u.tratar_icone(p.ic_casa_at, tam_x, tam_y));
                 }
                value += 1;
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(comeco == 0){
            mat.set_pecas_xadrez();
            comeco = 1;
        }
        else{
            for (int i=0;i<_TAM;i++){
                if(e.getSource() == botoes[i]){
                    mat.traduz_para_matrix(i);
                }
            }
            update_tabuleiro();
            mat.ver_matrix();
        }
    }
}
