package com.trairas.nig;

import sun.security.krb5.internal.PAData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nig on 23/09/17.
 */
public class tabu_game extends JPanel {

    mv_util u;
    pecas p;

    private servidor ser;
    private cliente cli;


    private int vez_brancas = 1;
    private int vez_pretas = -1;
    private int jogada = vez_brancas;

    final int op_servidor = 0;
    final int op_cliente = 1;
    final int op_jogar_so = 2;


    private static final int _WIDTH = 500;
    private static final int _HEIGTH = 500;

    //graficos
    JPanel painel_log_server;
    JPanel painel_game;
    JButton bt_start;


    // painel de log com os elementos de sonfiguracao do usuario
    private JPanel panel_servidor(){

        ser = new servidor();
        ser.start();


        JLabel title = new JLabel("Game Servidor");
        title.setBounds(80,10,150,30);

        JLabel lb_ip = new JLabel("Ip Servidor : ");//+ser.server_getIP()
        lb_ip.setBounds(30,50,200,30);


        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.add(title);
        painel.add(lb_ip);
        painel.add(ser.getPainel());
        painel.setOpaque(true);
        painel.setVisible(true);
        painel.setBounds(0,0,300, _HEIGTH-10);


        return painel;
    }


    // painel de log com os elementos de sonfiguracao do usuario
    private JPanel panel_cliente(){


        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setVisible(true);
        painel.setOpaque(true);

        JLabel title = new JLabel("Game Cliente");
        title.setBounds(80,10,100,30);

        JLabel lb_ip = new JLabel("Ip Servidor : ");
        lb_ip.setBounds(30,50,100,30);

        JTextField tf_ip = new JTextField("0.0.0.0");
        tf_ip.setBounds(130,50,150,30);

        bt_start = new JButton(" Start  ");
        bt_start.setEnabled(false);
        bt_start.setBounds(150,120,120,30);
        bt_start.setBackground(u.azul);
        bt_start.setForeground(u.branca);
        bt_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cli.sendComando("start");
                cli.setar_pecas();
            }
        });

        JButton bt_ip = new JButton(" Conectar  ");
        bt_ip.setBounds(150,90,120,30);
        bt_ip.setBackground(u.azul);
        bt_ip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cli = new cliente(tf_ip.getText());
                    cli.start();
                    painel.add(cli.getPainel());
                    trocar_painel(cli.getPainelGame());
                    bt_start.setEnabled(true);
                }catch (Exception erro){
                    u.print("Erro -> \n "+erro);
                }
            }
        });

        painel.add(title);
        painel.add(lb_ip);
        painel.add(tf_ip);
        painel.add(bt_ip);
        painel.add(bt_start);

        painel.setBounds(0,0,300, _HEIGTH-10);

        return painel;
    }



    private JPanel panel_log_game_so(JLabel label){

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setVisible(true);
        painel.setOpaque(true);


        // adicionar os labels das jogadas
        // adicionando a informação - adicionar depois um JScrollPane
        if (label != null)
            painel.add(label);


        painel.setBounds(0,0,300, _HEIGTH-10);
        return  painel;
    }



    private void trocar_painel(JPanel painel){
        this.remove(painel_game);
        this.add(painel);
        this.updateUI();
    }

    public tabu_game(int conexao){


        u = new mv_util();
        p = new pecas();

        // painel de log
        painel_log_server = new JPanel();
        painel_log_server.setBounds(_WIDTH+10, 10, 300, _HEIGTH-10);
        painel_log_server.setOpaque(true);
        painel_log_server.setLayout(null);


        if (conexao == op_servidor) {
            painel_log_server.add(panel_servidor());
            painel_game = ser.getPainelGame();
        }

       else if (conexao == op_cliente) {
            painel_log_server.add(panel_cliente());
            painel_game = new JPanel();
            painel_game.setBounds(0, 0, _WIDTH, _HEIGTH);
            painel_game.setBackground(u.azul);
        }

        else if(conexao == op_jogar_so){
            //opcao de jogar sozinho
            painel_log_server.add(panel_log_game_so(null));

            painel_game = new GameXadrezSo().painel_game();
            painel_game.setBounds(0, 0, _WIDTH, _HEIGTH);
            painel_game.setBackground(u.azul);

        }


        int size_painel_x = (_WIDTH+painel_log_server.getWidth()+20);
        int size_painel_y = _HEIGTH+50;


        this.add(painel_game);
        this.add(painel_log_server);
        this.setLayout(null);
        this.setBackground(new Color(55,55,55));
        this.setVisible(true);
        this.setSize(size_painel_x,size_painel_y);

    }


}
