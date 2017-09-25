package com.trairas.nig;

import com.sun.security.ntlm.Server;
import com.trairas.nig.mv_util;

import javax.swing.*;
import java.io.EOFException;
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
    private Socket connection;
    private ServerSocket server = null;
    int counter=0;


    private JScrollPane scrollPane;
    private JTextArea tx_area;
    private JPanel painel;
    private painel_tabu painel_game;

    public JPanel getPainel(){
        return painel;
    }

    public JPanel getPainelGame(){
        return painel_game;
    }

    public servidor(){

        tx_area =  new JTextArea();
        tx_area.setEditable(false);
        scrollPane = new JScrollPane(tx_area);
        scrollPane.setBounds(0,0,200,200);

        painel = new JPanel();
        painel.setLayout(null);
        painel.add(scrollPane);
        painel.setBounds(30,100,250,200);

        painel_game = new painel_tabu();
    }

    private void setar_pecas(){
        painel_game.mat.set_pecas_xadrez();
        painel_game.update_tabuleiro();
        painel_game.updateUI();
        u.print("Pecas setadas");
    }

    public void run(){

        try{//config o servidor para receber conexões; processa as conexoes
            server = new ServerSocket(12345,100); //cria ServerSpcket


            try{
                waitForConnection();
                getStreams();
                ProcessConection();
            }catch(EOFException e){
                displayMessage("\nServer Termined connection");
            }
            finally{
                closeConection(); //fecha a conexao
                ++counter;
            }

        }
        catch(IOException io){
            io.printStackTrace();
        }
    }

    //espera que a conexao chegue e então exibe informações sobre a conexão
    private void waitForConnection()throws IOException{

        displayMessage("Waiting for connection");
        connection = server.accept(); //permite que o servidor aceite a conexão
        displayMessage("Connection "+counter+" received from: "+connection.getInetAddress().getHostName());
    }

    //ontém fluxos para enviar e receber dados
    private void getStreams() throws IOException{
        //configura o fluxo de saida de dados
        output = new ObjectOutputStream(connection.getOutputStream());
        //configura o fluxo de entrada de dados
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\n I/O streams\n");
    }

    //processa a conexão com o cliente
    private void  ProcessConection() throws IOException{
        String message = "Connection sucessful!";
        sendData(message);//envia uma menssagem de conexão bem sucedida

        //ativa a enterField de modo que o usuário do servidor possa enviar menssagens

        //processa as menssagens enviadas pelo cliente
        do{

            try{//lê e exibe a menssagem
                message = (String) input.readObject();//lê uma nova menssagem
                if(message.equals("start")){
                    setar_pecas();
                }

                displayMessage("\n"+message);
            }catch(ClassNotFoundException c){
                displayMessage("\nUnknowm object type received");
            }

        }while(!message.equals("CLIENT>>> TERMINATE"));
    }

    //fecha os fluxos e os sockets
    private void closeConection(){

        displayMessage("\nTerminating connection\n");

        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException io){}

    }

    //envia menssagem ao cliente
    private void sendComando(String message){

        try{
            output.writeObject(message);
            output.flush();//esvazia a saida para o cliente
            displayMessage("\nSERVER>> "+message);
        }catch(IOException io){displayMessage("\nError writing objetc");}

    }

    //envia menssagem ao cliente
    private void sendData(String message){

        try{
            output.writeObject("SERVER>> " +message);
            output.flush();//esvazia a saida para o cliente
            displayMessage("\nSERVER>> "+message);
        }catch(IOException io){displayMessage("\nError writing objetc");}

    }

    //manipula a displayArea na  thread de despacho de eventos
    private void displayMessage(final String messageToDisplay){
        System.out.println("LOG = > "+messageToDisplay);
        tx_area.append(messageToDisplay);
    }




}
