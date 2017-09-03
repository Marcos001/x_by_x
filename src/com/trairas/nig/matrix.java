package com.trairas.nig;

/**
 * Created by nig on 01/09/17.
 */
public class matrix {

    public int matrix[][];
    private int _size;
    private static final int _rainha = 3;
    private static final int _X = 4;

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
        print("---------------------");
        for (int i=0;i<_size;i++){
            print("\n");
            for (int j=0;j<_size;j++){
                System.out.printf(" %d ",matrix[i][j]);
            }
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

    //diagonais
    private boolean D1(int ii, int jj){

        for (int i=(ii+1);i>=0;i++){
            for (int j=(jj+1);j < _size ;j++){

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


        return false;
    }



    public void traduz_para_matrix(int index){

        int value=0;

        for (int i=0;i<_size;i++){
            for (int j =0;j<_size;j++){

              if (index == value){

                  if(matrix[i][j] == _rainha || matrix[i][j] == _X){
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


    public matrix(int size){
        this._size = size;
        inicializar_matrix();
        ver_matrix();
    }

    void print(String m){
        System.out.println(m);
    }


}
