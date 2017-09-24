package com.trairas.nig;

import javax.swing.*;

/**
 * Created by nig on 23/09/17.
 */

public class pecas {

    public  final int casa_branca = 0;
    public  final int casa_preta = 1;

    public  final int peao_white = 22;
    public  final int torre_white = 23;
    public  final int cavalo_white = 24;
    public  final int bispo_white = 25;
    public  final int rei_white = 26;
    public  final int rainha_white = 27;

    public final int peao_black = 32;
    public final int torre_black = 33;
    public final int cavalo_black = 34;
    public final int bispo_black = 35;
    public final int rei_black = 36;
    public final int rainha_black = 37;



    public final ImageIcon ic_peao_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/peao_white.png"));
    public final ImageIcon ic_torre_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/torre_white.png"));
    public final ImageIcon ic_cavalo_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/cavalo_white.png"));
    public final ImageIcon ic_bispo_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/bispo_white.png"));
    public final ImageIcon ic_rei_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/rei_white.png"));
    public final ImageIcon ic_rainha_white = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/rainha_white.png"));


    public final ImageIcon ic_peao_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/peao_black.png"));
    public final ImageIcon ic_torre_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/torre_black.png"));

    public final ImageIcon ic_cavalo_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/cavalo_black.png"));
    public final ImageIcon ic_bispo_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/bispo_black.png"));
    public final ImageIcon ic_rei_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/rei_black.png"));
    public final ImageIcon ic_rainha_black = new ImageIcon(getClass().getResource("asserts/data/pecas/fancy/rainha_black.png"));


    ImageIcon tema_1_personagem = new ImageIcon(getClass().getResource("asserts/r_blue.png"));
    ImageIcon tema_2_personagem = new ImageIcon(getClass().getResource("asserts/r_red.png"));

    ImageIcon tema_1_icone = new ImageIcon(getClass().getResource("asserts/x_red.png"));
    ImageIcon tema_2_icone = new ImageIcon(getClass().getResource("asserts/x_.png"));


    public pecas(){}

}
