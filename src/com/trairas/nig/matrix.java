package com.trairas.nig;

/**
 * Created by nig on 01/09/17.
 */
public class matrix {

    public int matrix[][];
    private int _size;
    private final int _rainha = 3;

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
        //tem que achar i do vetor
    }

    private boolean verifica_horizontal(int i, int j){

        while ( i >= 0 || i <= _size ) {
            while ( j >= 0 || j <= _size ) {
                if(matrix[i][j] == _rainha){
                    //
                    return false;
                }
            }

        }

        return true;
    }

    public int[] traduz_para_matrix(int index){
        //tem que achar i e j da matrix
        int value=0;
        int v[] = new int[2];
        print("Procurando a coordenada da posição i = "+index);

        //procurando a coluna - [entra o problema de busca] - ja incrementaria i e j pra
        // que ficasse proximo de value
        for (int i=0;i<_size;i++){
            for (int j =0;j<_size;j++){
              if (index == value){

                  //encontrou i & j
                  if(matrix[i][j] == 0 || matrix[i][j] == 1 ){
                      //posicao valida
                      if(){
                          //se sofre ameaça ou ataca
                      }
                  }

                  v[0] = i;v[1] = j;
                  //print("linha = "+v[0]+" coluna = "+v[1]);
                  return v;
              }
              else{
                  value +=1;
              }
            }
        }
        return null;
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
