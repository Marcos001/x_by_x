package com.trairas.nig.net;

import com.sun.security.ntlm.Server;
import com.trairas.nig.mv_util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by nig on 23/09/17.
 */
public class servidor extends Thread{


    private ObjectOutputStream output; //gera o fluxo de saida para o cliente
    private ObjectInputStream input; // gera o fluxo de entrada a apartir do cliente
    private mv_util u = new mv_util();
    private Socket conexao;
    private ServerSocket s = null;


    public servidor(){

        try{

            s = new ServerSocket(12345);

            u.print("criado socket servidor");

            while(true){
                Socket conexao = s.accept();
                u.print("socket aceito");
                Thread t = new servidor(conexao);
                t.start();
                u.print("thread iniciada");
            }
        }catch(IOException e){
            u.print("IOException "+e);
        }
    }

    public servidor(Socket s){//recebe o valor do socket enviado na thread
        conexao = s;
    }

    private void sendData(String message){

        try{
            output.writeObject(message);
            output.flush();
            u.print("\nSERVER>> "+message);
        }catch(IOException io){
            u.print("\nError writing objetc");}
    }



    public void run(){

        try{

            u.print("metodo run");

            //configura o fluxo de saida de dados
            output = new ObjectOutputStream(conexao.getOutputStream());

            //configura o fluxo de entrada de dados
            input = new ObjectInputStream(conexao.getInputStream());

            try{

                String message = (String) input.readObject();//lê uma nova menssagem

                u.print("o cliente enviou = "+message);

                sendData("Menssagem recebida");

            }catch (Exception erro){
                u.print("erro ao obter fluxo de dado do cliente");
            }


        }catch(IOException e){
            u.print("IOException "+e);
        }
    }


    public String server_getIP(){

        String ip;

        try{
            u.print("Obtendo ip");
            ip = s.getInetAddress().getHostName();
        }catch (Exception erro){
            u.print("Erro ao obter o ip > \n"+erro);
            ip = "localhost";
        }

        return ip;
    }

}
