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

    private void x_ataque(int i, int j){

    }

    private boolean verifica_horizontal(int ii, int jj){

        //H1 ++
        print("H1");
            for (int j=(jj+1);j<_size;j++){
                print("casa["+ii+"]["+j+"] = "+matrix[ii][j]);
                if(matrix[ii][j] == _rainha){ // || _X
                    print("Rainha encontrada ["+ii+"]["+j+"]");
                    return true;
                }
            }

        //H2 --
        print("H2");
        for (int j=(jj-1);j>=0;j--){
            print("casa["+ii+"]["+j+"] = "+matrix[ii][j]);
            if(matrix[ii][j] == _rainha){
                print("Rainha encontrada ["+ii+"]["+j+"]");
                return true;
            }
        }

        return false;
    }

    public void traduz_para_matrix(int index){
        //tem que achar i e j da matrix
        int value=0;

        print("Procurando a coordenada da posição i = "+index);

        //procurando a coluna - [entra o problema de busca] - ja incrementaria i e j pra
        // que ficasse proximo de value
        for (int i=0;i<_size;i++){
            for (int j =0;j<_size;j++){

              if (index == value){
                  //encontrou i & j
                  if(matrix[i][j] == 0 || matrix[i][j] == 1 ){
                      if(!verifica_horizontal(i,j)){
                          print("---- Não encontrado Rinhas --  INSERT ");
                          matrix[i][j] = _rainha;
                          //inserir x nas casas em ataque
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
