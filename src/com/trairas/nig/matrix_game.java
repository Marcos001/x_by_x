package com.trairas.nig;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

/**
 * Created by nig on 23/09/17.
 */
public class matrix_game {

    public int matrix[][];
    private int _size;
    private static final int _rainha = 3;
    private static final int _X = 4;
    pecas p = new pecas();



    //serve para numero par
    public void inicializar_matrix(){
        boolean _state = false;
        matrix = new int[_size][_size];
        for (int i=0;i<_size;i++){

            if (_state) {
                _state = false; }
            else{
                _state = true;}

            for (int j=0;j<_size;j++){
                if (_state){
                    matrix[i][j] = 1;
                    _state = false;
                }
                else{
                    matrix[i][j] = 0;
                    _state = true;
                }
            }
        }
    }

    public void ver_matrix(){
        boolean end = false;
        int t_rainhas = 0;
        String resultado = "";
        print("---------------------");
        for (int i=0;i<_size;i++){
            print("\n");
            for (int j=0;j<_size;j++){
                System.out.printf(" %d ",matrix[i][j]);
                if(!end){
                    if(matrix[i][j] == 0 || matrix[i][j] == 1){
                        end = true;
                    }
                }
                if(matrix[i][j] == _rainha){
                    t_rainhas += 1;
                }

            }
        }

        if (!end){
            if(t_rainhas == _size){
                resultado = "Satus : Vitoria! \n";
            }
            else{
                resultado = "Satus : Verme Inútil - Falha \n";
            }
            JOptionPane.showMessageDialog(null,"Tabuleiro Prenchido \n "+resultado+" Rainhas = "+t_rainhas);
        }
    }

    private boolean H1(int ii, int jj){
        print("H1");
        for (int j=(jj+1);j < _size ;j++){
            if(matrix[ii][j] == _rainha){ // || _X
                return true;
            }

            if(matrix[ii][j] == 0 || matrix[ii][j] == 1){
                matrix[ii][j] = _X;
            }
        }
        return false;
    }

    private boolean H2(int ii, int jj){
        print("H2");
        for (int j=(jj-1);j>=0;j--){

            if(matrix[ii][j] == _rainha){
                return true;
            }

            if(matrix[ii][j] == 0 || matrix[ii][j] == 1){
                matrix[ii][j] = _X;
            }
        }
        return false;
    }

    private boolean V1(int ii, int jj){
        print("V1");
        for (int i=(ii+1);i < _size ;i++){

            if(matrix[i][jj] == _rainha){ // || _X
                return true;
            }

            if(matrix[i][jj] == 0 || matrix[i][jj] == 1){
                matrix[i][jj] = _X;
            }
        }
        return false;
    }

    private boolean V2(int ii, int jj){
        print("H2");
        for (int i=(ii-1);i>=0;i--){

            if(matrix[i][jj] == _rainha){
                return true;
            }

            if(matrix[i][jj] == 0 || matrix[i][jj] == 1){
                matrix[i][jj] = _X;
            }
        }
        return false;
    }

    private boolean D1(int ii, int jj){
        int i = ii;
        int j = jj;
        while(j < _size && i <_size ){
            i += 1;
            j += 1;
            if(i < _size && j <_size){
                if(matrix[i][j] == _rainha){
                    return true;
                }

                if(matrix[i][j] == 0 || matrix[i][j] == 1){
                    matrix[i][j] = _X;
                }
            }
        }

        return false;
    }

    private boolean D2(int ii, int jj){
        int i = ii;
        int j = jj;
        while(j < _size && i >= 0 ){
            i -= 1;
            j += 1;
            if(i >= 0 && j <_size){
                if(matrix[i][j] == _rainha){
                    return true;
                }

                if(matrix[i][j] == 0 || matrix[i][j] == 1){
                    matrix[i][j] = _X;
                }
            }
        }

        return false;
    }

    private boolean D3(int ii, int jj){
        int i = ii;
        int j = jj;
        while(j >= 0 && i >= 0 ){
            i -= 1;
            j -= 1;
            if(i >= 0 && j >= 0){
                if(matrix[i][j] == _rainha){
                    return true;
                }

                if(matrix[i][j] == 0 || matrix[i][j] == 1){
                    matrix[i][j] = _X;
                }
            }
        }

        return false;
    }

    private boolean D4(int ii, int jj){
        int i = ii;
        int j = jj;
        while(j >= 0 && i <_size ){
            i += 1;
            j -= 1;
            if(i <_size && j >= 0){
                if(matrix[i][j] == _rainha){
                    return true;
                }

                if(matrix[i][j] == 0 || matrix[i][j] == 1){
                    matrix[i][j] = _X;
                }
            }
        }

        return false;
    }

    private boolean verifica_posicoes(int ii, int jj){

        if (H1(ii,jj))
            return true;

        if (H2(ii,jj))
            return true;

        if (V1(ii,jj))
            return true;

        if (V2(ii,jj))
            return true;

        if(D1(ii,jj))
            return true;

        if(D2(ii,jj))
            return true;

        if(D3(ii,jj))
            return true;

        if(D4(ii,jj))
            return true;

        return false;
    }

    public void traduz_para_matrix(int index){
        int value=0;
        for (int i=0;i<_size;i++){
            for (int j =0;j<_size;j++){

                if (index == value){

                    if(matrix[i][j] == p.peao_white){
                        mov_peao(i,j);
                        return;
                    }

                    if(matrix[i][j] == 0 || matrix[i][j] == 1 ){
                        if(!verifica_posicoes(i,j)){
                            matrix[i][j] = _rainha;
                        }
                        return;
                    }
                }
                else{
                    value +=1;
                }
            }
        }
    }

    public matrix_game(int size){
        this._size = size;
        inicializar_matrix();
        ver_matrix();
    }

    private void setar_pecas_brancas(){
        matrix[0][0] = p.torre_white;
        matrix[0][1] = p.cavalo_white;
        matrix[0][2] = p.bispo_white;
        matrix[0][3] = p.rei_white;

        matrix[0][4] = p.rainha_white;
        matrix[0][5] = p.bispo_white;
        matrix[0][6] = p.cavalo_white;
        matrix[0][7] = p.torre_white;
    }

    private void setar_pecas_pretas(){
        matrix[7][0] = p.torre_black;
        matrix[7][1] = p.cavalo_black;
        matrix[7][2] = p.bispo_black;
        matrix[7][3] = p.rei_black;

        matrix[7][4] = p.rainha_black;
        matrix[7][5] = p.bispo_black;
        matrix[7][6] = p.cavalo_black;
        matrix[7][7] = p.torre_black;
    }

    public void setar_peoes(){
        for (int j=0;j<_size;j++){
            //setando os peoes brancos
            matrix[1][j] = p.peao_white;
            //setando os peoes pretos
            matrix[6][j] = p.peao_black;
        }
    }


    void print(String m){
        System.out.println(m);
    }

    public void set_pecas_xadrez(){
        setar_peoes();
        setar_pecas_brancas();
        setar_pecas_pretas();
    }

    public matrix_game(){

    }

    //actions of pices

    public void mov_peao(int linha, int coluna){
        //peao branco -> amenta linha
        if(linha == 1){
            matrix[linha+1][coluna] = p.casa_limpa_at;
            matrix[linha+2][coluna] = p.casa_limpa_at;
        }
    }

}
