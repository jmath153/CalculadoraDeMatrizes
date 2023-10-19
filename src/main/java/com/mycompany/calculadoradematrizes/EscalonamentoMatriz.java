/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author joaom
 */
public class EscalonamentoMatriz {

    public float[][] permutarLinhas(float[][] matriz, int linha1, int linha2) {
        SistemaMatriz sis = new SistemaMatriz();

        float temp = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            temp = matriz[linha1][j];
            matriz[linha1][j] = matriz[linha2][j];
            matriz[linha2][j] = temp;
        }
        System.out.println("Linhas permutadas");
        sis.exibirMatriz(matriz);
        System.out.println();
        return matriz;
    }

    public float encontrarPivo(float[][] matriz, int linha) {
        for (int i = 0; i < matriz[linha].length; i++) {
            if (matriz[linha][i] != 0) {
                return matriz[linha][i];
            }
        }
        return 0;
    }

    public float[][] zerarColuna(float[][] matriz, int linhaPivo, int colunaPivo) {

        for(int i = 0; i < matriz.length; i++) {
            if(matriz[i][colunaPivo] != 0){
                if(i != linhaPivo){
                    float escalar = matriz[i][colunaPivo];
                    for(int j = 0;j<matriz[i].length;j++){
                      //  System.out.println(matriz[i][j] +"= "+"("+ matriz[i][j]+"- ("+matriz[i][colunaPivo] + "*"+matriz[linhaPivo][j]+")");
                        matriz[i][j] = (matriz[i][j] - (escalar * matriz[linhaPivo][j]));

                    }
                }
            }
                                
        }
        return matriz;
    }

    public float[][] multiplicarPorEscalar(float[][] matriz, int linha) {

        float pivo = this.encontrarPivo(matriz, linha);
        for (int i = 0; i < matriz[linha].length; i++) {
            System.out.println(matriz[linha][i] + "/" + pivo + "= ");

            matriz[linha][i] = (matriz[linha][i]/pivo);
            System.out.println(matriz[linha][i]);
        }
        return matriz;
    }

    public float[][] ordenarLinhas(float[][] matriz) {
        int[][] zerosLinhas = new int[matriz.length][2];
        int trocas;

        do {
            for (int i = 0; i < matriz.length; i++) {
                int cont = 0;
                float pivoLinha = this.encontrarPivo(matriz,i);

                for (int j = 0; j < matriz[i].length; j++) {
                    if(matriz[i][j] != pivoLinha) {
                        if (matriz[i][j] == 0) {
                            cont++;
                        }
                    } else {
                        break;
                    }
                }
                zerosLinhas[i][1] = cont;
                zerosLinhas[i][0] = i;
            }
            trocas = 0;
            for(int k = 0; k < zerosLinhas.length - 1; k++) {

                if(zerosLinhas[k][1] > zerosLinhas[k + 1][1]) {
                    matriz = this.permutarLinhas(matriz, k, k + 1);
                    trocas++;

                }
            }
        } while (trocas != 0);

        return matriz;
    }

    public float[][] escalonar(float[][] matriz) {
        SistemaMatriz sis = new SistemaMatriz();
        matriz = this.ordenarLinhas(matriz);

        for (int i = 0; i < matriz.length; i++) {

            float pivo = this.encontrarPivo(matriz, i);
            int colunaPivo = 0;

            for(int j =0; j < matriz[i].length; j++){
                if(matriz[i][j] == pivo){
                    colunaPivo = j;
                    break;
                }
            }
            //Deixando pivô igual a 1
            if (pivo != 1) {
                matriz = this.multiplicarPorEscalar(matriz,i);

            }
            
            matriz = this.zerarColuna(matriz,i,colunaPivo);
            sis.exibirMatriz(matriz);
            System.out.println();
        }

        return formatarValor(matriz);
    }
   public float[][] formatarValor(float[][] matriz){
        float[][] novaMatriz = new float[matriz.length][matriz[0].length];
        DecimalFormat formato = new DecimalFormat("#.##");

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                novaMatriz[i][j] = Float.parseFloat(formato.format(matriz[i][j]).replace(",","."));

            }
        }
        return novaMatriz;
   }
}
