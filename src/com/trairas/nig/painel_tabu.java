package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 24/09/17.
 */
public class painel_tabu extends JPanel implements ActionListener{

    private JButton botoes[];
    private int _TAM;
    private int _size;
    mv_util u;
    pecas p;
    matrix_game mat;

    private static final int _WIDTH = 500;
    private static final int _HEIGTH = 500;

    painel_tabu(){

        int rainhas = 8;
        int TAM = (rainhas*rainhas);
        this._size = rainhas;
        this._TAM = TAM;

        u = new mv_util();
        p = new pecas();

        if(mat == null){
            mat = new matrix_game(_size);
        }

        init_buttons(TAM);
        add_buutons(TAM);

        this.setLayout(new GridLayout(this._size, this._size));
        this.setBackground(new Color(255,255,255));
        this.setBounds(0,0,_WIDTH,_HEIGTH);

    }
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

        for (int i=0;i<_TAM;i++){
            if(e.getSource() == botoes[i]){
                mat.traduz_para_matrix(i);
            }
        }
        update_tabuleiro();
        mat.ver_matrix();
    }


    private void init_buttons(int rainhas){
        botoes = new JButton[rainhas];
    }


    private void add_buutons(int TAM){

        for(int i=0;i< TAM; i++){
            botoes[i] = new JButton();
            botoes[i].setSize(20,20);
            botoes[i].addActionListener(this);
            this.add(botoes[i]);
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



}
