package com.mycompany.calculadoradematrizes;

public class TestaEscalonamento {

    public static void main(String[] args) {
        SistemaMatriz sistema = new SistemaMatriz();
        EscalonamentoMatriz escalona = new EscalonamentoMatriz();

        float[][] matriz = new float[3][4];

        matriz[0][0] = 1;
        matriz[0][1] = 1;
        matriz[0][2] = 0;
        matriz[0][3] = 0;

        matriz[1][0] = 0;
        matriz[1][1] = 1;
        matriz[1][2] = -1;
        matriz[1][3] = 2;


        matriz[2][0] = 1;
        matriz[2][1] = 0;
        matriz[2][2] = -1;
        matriz[2][3] = 0;


        sistema.exibirMatriz(matriz);
        System.out.println();
        sistema.exibirMatriz(escalona.escalonar(matriz));




    }
}
