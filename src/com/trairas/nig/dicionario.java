package com.trairas.nig;

import java.util.ArrayList;

/**
 * Created by nig on 28/09/17.
 */
public class dicionario {


    /**
     * A classe deve armazenar a posicao da peça e o seu valor
     *
     * add (int posicao, int valor) -> posicao:valor
     *
     */

    public  ArrayList <String> dict = new ArrayList<>();



    public boolean _add(int linha, int coluna, int valor){
        String indice = linha+":"+coluna+":"+valor;
        //verifica se ja contem
        for(int i=0;i<dict.size();i++){
            if (dict.get(i).equals(indice)){
                return false;
            }
        }
        dict.add(indice);
        return true;
    }

    public boolean _remove(int linha, int coluna){

            for(int i=0;i<dict.size();i++){
                String []tmp = dict.get(i).split(":");
                System.out.println(i+" = "+dict.get(i));
                if (Integer.parseInt(tmp[0]) == linha && Integer.parseInt(tmp[1]) == coluna){
                    dict.remove(i);
                    return true;
                }
            }

        return false;
    }

    public boolean is_value(){
        if (dict.size() > 0){
            return false;
        }
        return true;
    }

    public boolean clear(){
        try{
                dict.clear();
        }catch (Exception erro){
            return false;
        }
        return true;
    }

    public int[] get_posicao_valor(int index){
        int[] v = new int[3];
        String tmp = dict.get(index);
        String []vt = tmp.split(":");
        v[0] = Integer.parseInt(vt[0]);
        v[1] = Integer.parseInt(vt[1]);
        v[2] = Integer.parseInt(vt[2]);
        System.out.println("0 = "+v[0]+" 1 = "+v[1]+" 2= "+v[2]);
        return v;
    }








}
