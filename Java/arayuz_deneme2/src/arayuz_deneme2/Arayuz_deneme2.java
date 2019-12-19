package arayuz_deneme2;

import java.awt.*;
import javax.swing.*;

public class Arayuz_deneme2{
    
    public static void main(String[] args) {
        arayuz_ciz();
    }
    
    public static void arayuz_ciz(){
        //çerçeveyi başlat
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //AnaSunucuKutu
        javax.swing.JTextPane AnaSunucuKutu1 = new javax.swing.JTextPane();
        AnaSunucuKutu1.setBounds(225,20,150,100);
        AnaSunucuKutu1.setBackground(new java.awt.Color(223, 245, 245));
        AnaSunucuKutu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AnaSunucuKutu1.setEnabled(false);
        AnaSunucuKutu1.setDisabledTextColor(new java.awt.Color(51,51,51));
        AnaSunucuKutu1.setText("Ana Sunucu");
        
        //AltSunucuKutu1
        javax.swing.JTextPane AltSunucuKutu1 = new javax.swing.JTextPane();
        AltSunucuKutu1.setBounds(20,150,120,100);
        AltSunucuKutu1.setBackground(new java.awt.Color(223, 245, 245));
        AltSunucuKutu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AltSunucuKutu1.setEnabled(false);
        AltSunucuKutu1.setDisabledTextColor(new java.awt.Color(51,51,51));
        AltSunucuKutu1.setText("AltSunucu1");
        
        //AltSunucuKutu2
        javax.swing.JTextPane AltSunucuKutu2 = new javax.swing.JTextPane();
        AltSunucuKutu2.setBounds(170,150,120,100);
        AltSunucuKutu2.setBackground(new java.awt.Color(223, 245, 245));
        AltSunucuKutu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AltSunucuKutu2.setEnabled(false);
        AltSunucuKutu2.setDisabledTextColor(new java.awt.Color(51,51,51));
        AltSunucuKutu2.setText("AltSunucu2");
        
        //AltSunucuKutu3
        javax.swing.JTextPane AltSunucuKutu3 = new javax.swing.JTextPane();
        AltSunucuKutu3.setBounds(320,150,120,100);
        AltSunucuKutu3.setBackground(new java.awt.Color(223, 245, 245));
        AltSunucuKutu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AltSunucuKutu3.setEnabled(false);
        AltSunucuKutu3.setDisabledTextColor(new java.awt.Color(51,51,51));
        AltSunucuKutu3.setText("AltSunucu3");
        
        frame.add(AnaSunucuKutu1);
        frame.add(AltSunucuKutu1);
        frame.add(AltSunucuKutu2);
        frame.add(AltSunucuKutu3);
        frame.setVisible(true);
        
    }
}
