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
                print("Clicado no botão "+i );
            }
        }

    }

    private void print(String M){
        System.out.println(M);
    }
}
