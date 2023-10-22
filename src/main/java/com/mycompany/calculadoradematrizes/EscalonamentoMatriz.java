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

        float[][] matrizPermutada = matriz;
        float temp = 0;

        for (int j = 0; j < matrizPermutada[0].length; j++) {
            temp = matrizPermutada[linha1][j];
            matrizPermutada[linha1][j] = matrizPermutada[linha2][j];
            matrizPermutada[linha2][j] = temp;
        }
        return matrizPermutada;
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
        float[][] colunaZerada = matriz;

        for(int i = 0; i < colunaZerada.length; i++) {
            if(colunaZerada[i][colunaPivo] != 0){
                if(i != linhaPivo){
                    float escalar = colunaZerada[i][colunaPivo];
                    for(int j = 0;j<colunaZerada[i].length;j++){
                        colunaZerada[i][j] = (colunaZerada[i][j] - (escalar * colunaZerada[linhaPivo][j]));
                    }
                }
            }
                                
        }
        return colunaZerada;
    }

    public float[][] multiplicarPorEscalar(float[][] matriz, int linha) {
        float[][] multiplicadaPorEscalar = matriz;

        float pivo = this.encontrarPivo(multiplicadaPorEscalar, linha);
        for (int i = 0; i < multiplicadaPorEscalar[linha].length; i++) {
            multiplicadaPorEscalar[linha][i] = (multiplicadaPorEscalar[linha][i]/pivo);
        }
        return multiplicadaPorEscalar;
    }

    public float[][] ordenarLinhas(float[][] matriz) {
        float [][] ordenada = matriz;
        int[][] zerosLinhas = new int[matriz.length][2];
        int trocas;

        do {
            for (int i = 0; i < ordenada.length; i++) {
                int cont = 0;
                float pivoLinha = this.encontrarPivo(ordenada,i);
                for (int j = 0; j < ordenada[i].length; j++) {
                    if(ordenada[i][j] != pivoLinha) {
                        if (ordenada[i][j] == 0) {
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
                    ordenada = this.permutarLinhas(ordenada, k, k + 1);
                    trocas++;

                }
            }
        } while (trocas != 0);

        return ordenada;
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
