package com.mycompany.calculadoradematrizes;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        setSize(1366,727);
        setTitle("Calculadora de Matrizes");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan = new JPanel();
       // pan.setLayout();
        pan.setSize(200,200);
        pan.setVisible(true);
        pan.setBackground(Color.BLACK);

        JPanel pan2 = new JPanel();

        this.add(pan);


    }
}
