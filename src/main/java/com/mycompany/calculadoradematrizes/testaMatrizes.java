/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

import java.util.Scanner;

/**
 *
 * @author joaom
 */
public class testaMatrizes {
    public static void main(String[] args) {
        
        
       boolean sair = false;
       Scanner scan = new Scanner(System.in);
       
       SistemaMatriz sistema = new SistemaMatriz();
       
       while(!sair){
           System.out.println("Calculadora de matrizes");
           System.out.println("");
           System.out.println("[1] Gerar matriz\n[2] Sair");
           
           String opcaoPrincipal = scan.nextLine();
           
           if(opcaoPrincipal == "1"){
               
                System.out.println("[1] Inserir matriz\n[2] Gerar Matriz Aleatória\n[3]\n Voltar");
                String opcaoGerador = scan.nextLine();

                System.out.println("Informe a quantidade de linhas:");
                int linhas = scan.nextInt();

                System.out.println("Informe a quantidade de colunas:");
                int colunas = scan.nextInt();

                float[][] matriz = new float[linhas][colunas];
                
               if(opcaoGerador == "1"){
                   for(int i = 0; i < matriz.length ; i++){
                       for(int j = 0 ; j < matriz.length; j++){
                           System.out.println("informe o elemento da "+i+"° Linha e "+j+"° coluna: ");
                           matriz[i][j] = scan.nextInt();
                       }
                   }
               }
               if(opcaoGerador == "2"){
                   
                    matriz = sistema.gerarMatriz(linhas, colunas);    
               }
               sistema.exibirMatriz(matriz);
               
               System.out.println("[1] Exibir informações\n[2] Operações");
               String menuManipular = scan.nextLine();
               
               if(menuManipular == "1"){
                   System.out.println("1 Determinante da matriz: "+sistema.calcularDeterminante(matriz));
                   System.out.println("2 ");
               }
           }
       }
    }
}
