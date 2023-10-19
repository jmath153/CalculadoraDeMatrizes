/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

/**
 *
 * @author joaom
 */
public class SistemaMatriz <T> implements operacoes {

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
    public int[][] gerarMatriz(int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        
        for(int i = 0; i<matriz.length;i++){
            for(int j = 0; j<matriz[i].length;j++){
               matriz[i][j] = i+j;
            }
        }
        return matriz;
    }

    @Override
    public int calcularDeterminante(float[][] matriz) {
        if(matriz.length == 1 ){
            return matriz[0][0];
        } else if(matriz.length == 2){
            return (matriz[0][0] * matriz[1][1]) + (-1*(matriz[1][0]*matriz[0][1]));
        } else if(matriz.length == 3){
            T diagonaisPrincipais = (matriz[0][0]*matriz[1][1]*matriz[2][2] + matriz[0][1]*matriz[1][2]*matriz[2][0]+
                    matriz[0][2]*matriz[1][0]*matriz[2][1]);
            int diagonaisSecundarias = (matriz[2][0]*matriz[1][1]*matriz[0][2] + matriz[2][1]*matriz[1][2]*matriz[0][0]+
                    matriz[2][2]*matriz[1][0]*matriz[0][1]);
            
            return diagonaisPrincipais - diagonaisSecundarias;
            
        } else if(matriz.length >= 4){
            int det = 0;
            for(int i = 0; i < matriz.length;i++){
              det += (matriz[0][i]) * ((int) Math.pow(-1,1+(i+1))) * (calcularDeterminante(removerLinhasColunas(matriz, i)));
              
            }
            return det;
        }
        
        return 0;
            
    }
    public int[][] removerLinhasColunas(int[][] matriz, int coluna){
        int[][] removida = new int[matriz.length-1][matriz.length-1];
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