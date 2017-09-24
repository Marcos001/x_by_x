package com.trairas.nig;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by nig on 23/09/17.
 */
public class mv_util {

    public Color preta = new Color(55,55,55);
    public Color branca = new Color(255,255,255);
    public Color verde = new Color(200,255,255);

    public mv_util(){}

    public Image get_img_Icon(String path_img){
        URL url = this.getClass().getResource(path_img);
        Image image = Toolkit.getDefaultToolkit().getImage(url);
        return image;
    }

    public ImageIcon tratar_icone( ImageIcon imageIcon, int size_x, int size_y){

        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(size_x, size_y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        return new ImageIcon(newimg);
    }


    public void print(String m){
        System.out.println(m);
    }

}
