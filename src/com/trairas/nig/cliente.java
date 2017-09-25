package com.trairas.nig;

import com.trairas.nig.mv_util;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by nig on 23/09/17.
 */
public class cliente extends Thread {


    private ObjectOutputStream output; //gera o fluxo de saida para o servidor
    private ObjectInputStream input; //gera o fluxo de entrada a partir do servidor
    private String message = "";//mensagem do servidor
    private String chatServer; //servidor de host para esse aplicativo
    private Socket client; //socket para comunicação


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


    public cliente(String host){

        this.chatServer = host;

        painel_game = new painel_tabu();

        tx_area =  new JTextArea();
        tx_area.setEditable(false);
        scrollPane = new JScrollPane(tx_area);
        scrollPane.setBounds(0,0,200,200);

        painel = new JPanel();
        painel.setLayout(null);
        painel.add(scrollPane);
        painel.setBounds(30,200,250,200);


    }

    public void run(){

        try{//config o servidor para receber conexões; processa as conexoes

            connectToServer();//cria um socket para fazer a conexao
            getStreams(); //obtem os fluxos de entrada e saida
            ProcessConection();//processa a conexao
        }catch(EOFException e){
            displayMessage("\nClient Termined connection");
        }
        catch(IOException oi){
            oi.printStackTrace();
        }
        finally{
            closeConection(); //fecha a conexao
        }
    }

    //processa a conexão com o cliente
    private void  ProcessConection() throws IOException{


        //processa as menssagens enviadas pelo cliente
        do{

            try{//lê e exibe a menssagem
                message = (String) input.readObject();//lê uma nova menssagem
                displayMessage("\n"+message);
            }catch(ClassNotFoundException c){
                displayMessage("\nUnknowm object type received");
            }

        }while(!message.equals("CLIENT>>> TERMINATE"));
    }


    //ontém fluxos para enviar e receber dados
    private void getStreams() throws IOException{
        //configura o fluxo de saida de dados
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();//esvazia o buffer de saida para enviar as informações
        //configura o fluxo de entrada de dados
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\n I/O streams\n");
    }


    private void connectToServer()throws IOException{

        displayMessage("Attemping connection\n");
        //cria um socket para fazer a connexão
        //client = new Socket(InetAddress.getByName(chatServer),12345);
        client = new Socket(chatServer,12345);

        //exibe informções sobre a connexão
        displayMessage("Connected to "+client.getInetAddress().getHostName());

    }


    private void sendData(String message){

        try{
            output.writeObject("CLIENTE>> " +message);
            output.flush();//esvazia a saida para o cliente
            displayMessage("\nCLIENTE>> "+message);
        }catch(IOException io){
            displayMessage("\nError writing objetc");
        }

    }

    //fecha os fluxos e os sockets
    private void closeConection(){

        displayMessage("\nTerminating connection\n");

        try{
            output.close();
            input.close();
            client.close();
        }catch(IOException io){
            System.out.println("erro -> "+io);
        }

    }



    //manipula a displayArea na  thread de despacho de eventos
    private void displayMessage(final String messageToDisplay){
        System.out.println("LOG = > "+messageToDisplay);
        tx_area.append(messageToDisplay);
    }





}
