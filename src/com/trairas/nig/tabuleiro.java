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
    matrix mat;

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

      //gambiarra para setar as cores de fundo dos botoes
      int value = 0;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(mat.matrix[i][j] == 1){
                    botoes[value].setBackground(new Color(255,255,255));
                }
                else {
                    botoes[value].setBackground(new Color(55,55,55));
                    //print("preto = "+mat.matrix[i][j]);
                }
                value += 1;
            }
        }


    }


    public tabuleiro(int rainhas){

        int TAM = (rainhas*rainhas);
        this._TAM = TAM;

        this.setLayout(new GridLayout(rainhas, rainhas));
        this.setBackground(new Color(255,255,255));
        this.setVisible(true);
        this.setSize(400,400);


        //iniciando parte logica da matrix
        print("iniciando parte logica...");
        mat = new matrix(8);


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
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(mat.matrix[i][j] == 1){
                    botoes[value].setBackground(new Color(255,255,255));
                }
                else if(mat.matrix[i][j] == 1){
                    botoes[value].setBackground(new Color(55,55,55));
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

    private void print(String M){
        System.out.println(M);
    }
}
