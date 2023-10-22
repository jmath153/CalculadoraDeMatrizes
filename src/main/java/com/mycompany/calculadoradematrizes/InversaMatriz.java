package com.mycompany.calculadoradematrizes;

public class InversaMatriz {

    public float[][] criarIdentidade(float[][] matriz){

        float[][] identidade = new float[matriz.length][matriz.length];

        for(int i = 0; i<matriz.length;i++){
            for(int j =0; j<matriz.length;j++){
                if(i == j){
                    identidade[i][j] = 1;
                } else {
                    identidade[i][j] = 0;
                }
            }
        }
        return identidade;
    }

    public float[][] juntarMatrizComAIdentidade(float[][] matriz){

        float[][] matrizComIdentidade = new float[matriz.length][matriz.length*2];
        float[][] identidade = this.criarIdentidade(matriz);

        for(int i = 0; i<matriz.length;i++){
            for(int j =0; j<matriz.length;j++) {
                matrizComIdentidade[i][j] = matriz[i][j];
            }
        }
        for(int k = 0;k < matriz.length;k++){
            for(int l = matriz.length; l < matriz.length*2; l++){
                    matrizComIdentidade[k][l] = identidade[k][l-matriz.length];
            }
        }
        return matrizComIdentidade;
    }
    public float[][] separarIdentidade(float[][] matriz){
        float[][] inversa = new float[matriz.length][matriz[0].length/2];

        for(int i = 0; i < inversa.length; i++){
            for(int j = 0; j < inversa.length;j++){
                inversa[i][j] = matriz[i][j+inversa.length];
            }
        }
        return inversa;
    }


}
