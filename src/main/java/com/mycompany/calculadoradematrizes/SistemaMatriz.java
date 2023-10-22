/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

import com.mycompany.calculadoradematrizes.exceptions.InversaNaoExisteException;
import com.mycompany.calculadoradematrizes.exceptions.MatrizNaoEQuadradaException;

import java.util.Random;

/**
 *
 * @author joaom
 */
public class SistemaMatriz implements operacoes {

    @Override
    public void exibirMatriz(float[][] matriz) {
        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public float[][] gerarMatriz(int linhas, int colunas) {
        float[][] matriz = new float[linhas][colunas];
        Random ran = new Random();

        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[i].length;j++){
               matriz[i][j] = (float) ran.nextInt(10);
            }
        }
        return matriz;
    }

    @Override
    public float calcularDeterminante(float[][] matriz) throws MatrizNaoEQuadradaException {

        if(matriz.length != matriz[0].length){
            throw new MatrizNaoEQuadradaException("Só é possível calcular o determinante para matrizes quadradas");
        }
        if(matriz.length == 1 ){
            return matriz[0][0];
        } else if(matriz.length == 2){
            return (matriz[0][0] * matriz[1][1]) + (-1*(matriz[1][0]*matriz[0][1]));
        } else if(matriz.length == 3){
            float diagonaisPrincipais = (matriz[0][0]*matriz[1][1]*matriz[2][2] + matriz[0][1]*matriz[1][2]*matriz[2][0]+
                    matriz[0][2]*matriz[1][0]*matriz[2][1]);
            float diagonaisSecundarias = (matriz[2][0]*matriz[1][1]*matriz[0][2] + matriz[2][1]*matriz[1][2]*matriz[0][0]+
                    matriz[2][2]*matriz[1][0]*matriz[0][1]);
            
            return diagonaisPrincipais - diagonaisSecundarias;
            
        } else if(matriz.length >= 4){
            float det = 0;
            for(int i = 0; i < matriz.length;i++){
              det += (matriz[0][i]) * ((int) Math.pow(-1,1+(i+1))) * (calcularDeterminante(removerLinhasColunas(matriz,0,i)));
              
            }
            return det;
        }
        
        return 0;
            
    }

    @Override
    public float[][] matrizTransposta(float[][] matriz) {
        float[][] transposta = new float[matriz[0].length][matriz.length];

        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz[i].length; j++){
                transposta[i][j] = matriz[j][i];
            }
        }
        return transposta;
    }

    @Override
    public float[][] matrizDeCofatores(float[][] matriz) throws MatrizNaoEQuadradaException {
        if(matriz.length != matriz[0].length){
            throw new MatrizNaoEQuadradaException("Só é possível calcular a matriz de cofatores para matrizes quadradas");
        }

        float[][] matrizDeCof = new float[matriz.length][matriz.length];
        for(int i = 0; i < matriz.length;i++){
            for(int j = 0; j < matriz.length; j++){
                matrizDeCof[i][j] = ((float) Math.pow(-1,((i+1)+(j+1)))) * calcularDeterminante(removerLinhasColunas(matriz,i,j));
            }
        }
        return matrizDeCof;
    }

    @Override
    public float[][] matrizAdjunta(float[][] matriz) throws MatrizNaoEQuadradaException {
        if(matriz.length != matriz[0].length){
            throw new MatrizNaoEQuadradaException("Só é possível calcular a matriz adjunta para matrizes quadradas");
        }
        return (matrizTransposta(matrizDeCofatores(matriz)));
    }

    @Override
    public float[][] escalonar(float[][] matriz) {

        EscalonamentoMatriz escalonador = new EscalonamentoMatriz();
        float[][] matrizEscalonada = matriz;

        matrizEscalonada = escalonador.ordenarLinhas(matrizEscalonada);

        for (int i = 0; i < matrizEscalonada.length; i++) {

            float pivo = escalonador.encontrarPivo(matrizEscalonada, i);
            int colunaPivo = 0;

            for(int j =0; j < matrizEscalonada[i].length; j++){
                if(matrizEscalonada[i][j] == pivo){
                    colunaPivo = j;
                    break;
                }
            }
            if (pivo != 1) {
                matrizEscalonada = escalonador.multiplicarPorEscalar(matrizEscalonada,i);
            }
            matrizEscalonada = escalonador.zerarColuna(matrizEscalonada,i,colunaPivo);

        }

        return escalonador.formatarValor(matrizEscalonada);
    }

    @Override
    public float[][] calcularInversa(float[][] matriz) throws InversaNaoExisteException {

        try {
            if(calcularDeterminante(matriz) == 0){
                throw new InversaNaoExisteException("Esta matriz não possuí inversa");
            }
        } catch (MatrizNaoEQuadradaException e) {
            throw new InversaNaoExisteException("A inversa existe apenas para matrizes quadradas");
        }
        InversaMatriz inversaCalc = new InversaMatriz();

        float[][] matrizComIdentidade = inversaCalc.juntarMatrizComAIdentidade(matriz);
        float[][] escalonada = escalonar(matrizComIdentidade);
        float[][] inversa = inversaCalc.separarIdentidade(escalonada);

        return inversa;
    }

    public float[][] removerLinhasColunas(float[][] matriz,int linha, int coluna){
        float[][] removida = new float[matriz.length-1][matriz.length-1];

        for(int i = 0; i < matriz.length;i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i != linha) {
                    if (j != coluna){
                        if(i > linha){
                            if(j > coluna){
                                removida[i - 1][j - 1] = matriz[i][j];
                            }
                            if(j < coluna){
                                removida[i-1][j] = matriz[i][j];
                            }
                        }
                       if( i < linha){
                           if(j > coluna){
                               removida[i][j - 1] = matriz[i][j];
                           }
                           if(j < coluna){
                               removida[i][j] = matriz[i][j];
                           }
                       }
                    }
                }
            }
        }
        return removida;
    }


}