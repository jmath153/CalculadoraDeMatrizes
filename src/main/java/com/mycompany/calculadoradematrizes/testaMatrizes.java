/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

import com.mycompany.calculadoradematrizes.exceptions.InversaNaoExisteException;
import com.mycompany.calculadoradematrizes.exceptions.MatrizNaoEQuadradaException;

import java.util.Scanner;

/**
 *
 * @author joaom
 */
public class testaMatrizes {

    public static void clearConsole(){
        try {
            final String os = System.getProperty("os.name");

            if(os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e){

        }
    }
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

                    if(temMatriz) {
                        String menuOperacoes = scan.nextLine();

                        while (!menuOperacoes.equals("7")) {
                            System.out.println("Matriz original: ");
                            sistema.exibirMatriz(matriz);

                            System.out.println(" ");
                            System.out.println("Selecione a operação:\n [1] Calcular determinante\n [2] Calcular matriz transposta\n" +
                                    " [3] Calcular matriz de cofatores\n [4] Calcular matriz adjunta\n [5] Escalonar matriz\n [6] Calcular matriz inversa\n [7] Voltar");

                            menuOperacoes = scan.nextLine();

                            switch (menuOperacoes) {
                                case "1":
                                    try {
                                        System.out.println("Determinante da matriz: ");
                                        System.out.println(sistema.calcularDeterminante(matriz));
                                    } catch (MatrizNaoEQuadradaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "2":
                                    System.out.println("Matriz transposta: ");
                                    sistema.exibirMatriz(sistema.matrizTransposta(matriz));
                                    System.out.println();
                                    break;
                                case "3":
                                    try {
                                        System.out.println("Matriz de cofatores: ");
                                        sistema.exibirMatriz(sistema.matrizDeCofatores(matriz));
                                        System.out.println();
                                    } catch (MatrizNaoEQuadradaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case "4":
                                    try {
                                        System.out.println("Matriz adjunta: ");
                                        sistema.exibirMatriz(sistema.matrizAdjunta(matriz));
                                        System.out.println();
                                    } catch (MatrizNaoEQuadradaException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;

                                case "5":
                                    System.out.println("Matriz escalonada: ");
                                    sistema.exibirMatriz(sistema.escalonar(matriz));
                                    System.out.println();
                                    break;
                                case "6":
                                    try {
                                        System.out.println("Matriz inversa: ");
                                        sistema.exibirMatriz(sistema.calcularInversa(matriz));
                                        System.out.println();
                                    } catch (InversaNaoExisteException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                default:
                                    System.out.println("Informe uma opção válida");
                            }
                        }
                    }

                }

            }
            if(opcaoPrincipal.equals("2")){
                sair = true;
            }
        }
    }
}
