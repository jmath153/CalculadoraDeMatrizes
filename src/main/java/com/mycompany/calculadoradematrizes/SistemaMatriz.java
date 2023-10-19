/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

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
        
        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[i].length;j++){
               matriz[i][j] = i+j;
            }
        }
        return matriz;
    }

    @Override
    public float calcularDeterminante(float[][] matriz) {
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
              det += (matriz[0][i]) * ((int) Math.pow(-1,1+(i+1))) * (calcularDeterminante(removerLinhasColunas(matriz, i)));
              
            }
            return det;
        }
        
        return 0;
            
    }

    @Override
    public float[][] escalonar(float[][] matriz) {

        EscalonamentoMatriz escalonador = new EscalonamentoMatriz();

        matriz = escalonador.ordenarLinhas(matriz);

        for (int i = 0; i < matriz.length; i++) {

            float pivo = escalonador.encontrarPivo(matriz, i);
            int colunaPivo = 0;

            for(int j =0; j < matriz[i].length; j++){
                if(matriz[i][j] == pivo){
                    colunaPivo = j;
                    break;
                }
            }

            if (pivo != 1) {
                matriz = escalonador.multiplicarPorEscalar(matriz,i);

            }

            matriz = escalonador.zerarColuna(matriz,i,colunaPivo);

        }

        return escalonador.formatarValor(matriz);
    }

    @Override
    public float[][] calcularInversa(float[][] matriz) {
        InversaMatriz inversaCalc = new InversaMatriz();
        float[][] matrizComIdentidade = inversaCalc.juntarMatrizComAIdentidade(matriz);
        float[][] escalonada = escalonar(matrizComIdentidade);
        float[][] inversa = inversaCalc.separarIdentidade(escalonada);

        return inversa;
    }

    public float[][] removerLinhasColunas(float[][] matriz, int coluna){
        float[][] removida = new float[matriz.length-1][matriz.length-1];
        for(int i = 1; i < matriz.length;i++){
            for(int j = 0; j < matriz[i].length;j++){
                if(j != coluna){
                    if(j>coluna){
                        removida[i-1][j-1] = matriz[i][j];
                    }
                    else{
                        removida[i-1][j] = matriz[i][j];
                    }
                } else {
                }
            }
        }
        return removida;
    }


}