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

        while (!sair) {
            System.out.println("Calculadora de matrizes");
            System.out.println("");
            System.out.println("[1] Selecionar matriz\n[2] Sair");

            String opcaoPrincipal = scan.nextLine();

            if (opcaoPrincipal.equals("1")) {

                String opcaoGerador = "";

                while (!opcaoGerador.equals("3")) {

                    boolean temMatriz = false;

                    System.out.println("[1] Inserir matriz\n[2] Gerar Matriz Aleatória\n[3] Voltar");
                    opcaoGerador = scan.nextLine();
                    float[][] matriz = null;

                    if (opcaoGerador.equals("1")) {
                        System.out.println("Informe a quantidade de linhas:");
                        int linhas = scan.nextInt();

                        System.out.println("Informe a quantidade de colunas:");
                        int colunas = scan.nextInt();

                        float[][] matrizInserida = new float[linhas][colunas];

                        for (int i = 0; i < matrizInserida.length; i++) {
                            for (int j = 0; j < matrizInserida.length; j++) {
                                System.out.println("informe o elemento da " + i + "° Linha e " + j + "° coluna: ");
                                matrizInserida[i][j] = scan.nextInt();
                            }
                        }
                        matriz = matrizInserida;
                        temMatriz = true;
                    }
                    if (opcaoGerador.equals("2")) {
                        System.out.println("Informe a quantidade de linhas:");
                        int linhas = scan.nextInt();

                        System.out.println("Informe a quantidade de colunas:");
                        int colunas = scan.nextInt();

                        float[][] matrizGerada = sistema.gerarMatriz(linhas, colunas);
                        matriz = matrizGerada;
                        temMatriz = true;

                    }

                    if(temMatriz){
                        sistema.exibirMatriz(matriz);
                        System.out.println(" ");
                        System.out.println("Selecione a operação:\n [1] Calcular determinante\n [2]");
                    }

                }

            }
            if(opcaoPrincipal.equals("2")){
                sair = true;
            }
        }
    }
}
