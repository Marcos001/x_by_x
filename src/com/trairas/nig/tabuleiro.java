package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 01/09/17.
 */
public class tabuleiro extends JPanel implements ActionListener{

    private JButton botoes[];
    private int _TAM;
    public matrix mat;
    private int _size;

    private static final int _WIDTH = 500;
    private static final int _HEIGTH = 500;

    ImageIcon ic_blue = new ImageIcon(getClass().getResource("asserts/r_blue.png"));
    ImageIcon ic_red = new ImageIcon(getClass().getResource("asserts/r_red.png"));
    ImageIcon ic_x = new ImageIcon(getClass().getResource("asserts/x_.png"));

    private void init_buttons(int rainhas){
        botoes = new JButton[rainhas];
    }

    private void add_buutons(int TAM){

      for(int i=0;i< TAM; i++){
          botoes[i] = new JButton();

          if(i % 2 == 0){
              botoes[i].setBackground(new Color(255,255,255));
          }
            else{
              botoes[i].setBackground(new Color(55,55,55));
          }

          botoes[i].setSize(20,20);
          botoes[i].addActionListener(this);
          this.add(botoes[i]);
      }

      update_tabuleiro();

    }


    public tabuleiro(int rainhas){

        int TAM = (rainhas*rainhas);
        this._size = rainhas;
        this._TAM = TAM;

        this.setLayout(new GridLayout(rainhas, rainhas));
        this.setBackground(new Color(255,255,255));
        this.setVisible(true);
        this.setSize(_WIDTH,_HEIGTH);


        //iniciando parte logica da matrix
        print("iniciando parte logica...");
        if(mat == null){
            mat = new matrix(8);
        }



        //adicionando botoes
        print("\nAdicionando os botoes...");
        init_buttons(TAM);
        add_buutons(TAM);

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

    // vai ser depracaciada
    public void update_tabuleiro(){
        int value = 0;
        for (int i=0;i<_size;i++){
            for (int j=0;j<_size;j++){

                if(mat.matrix[i][j] == 0){
                    botoes[value].setBackground(new Color(55,55,55));
                }
                else if(mat.matrix[i][j] == 1){
                    botoes[value].setBackground(new Color(255,255,255));
                }
                else if(mat.matrix[i][j] == 3){
                    botoes[value].setIcon(ic_red);
                }
                else if(mat.matrix[i][j] == 4){
                    botoes[value].setIcon(ic_x);
                }
                value += 1;
            }
        }
    }

    public void reiniciar(){
         mat.inicializar_matrix();
         update_tabuleiro();

    }

    private void print(String M){
        System.out.println(M);
    }
}
