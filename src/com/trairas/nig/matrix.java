package com.trairas.nig;

/**
 * Created by nig on 01/09/17.
 */
public class matrix {

    public int matrix[][];
    private int _size;


    public void inicializar_matrix(){
        boolean _state = false;
        matrix = new int[_size][_size];
        for (int i=0;i<_size;i++){
            if (_state){
                _state = false;
            }
            else{
                _state = true;
            }
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
        for (int i=0;i<_size;i++){
            print("\n");
            for (int j=0;j<_size;j++){
                System.out.printf(" %d ",matrix[i][j]);
            }
        }

    }

    public void traduz_para_vetor(int i, int j){

    }

    public void traduz_para_matrix(int i){

    }


    public matrix(int size){
        this._size = size;
        inicializar_matrix();
        ver_matrix();
    }

    void print(String m){
        System.out.println(m);
    }


}
