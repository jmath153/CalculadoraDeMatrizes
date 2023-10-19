package com.mycompany.calculadoradematrizes;

public class InversaMatriz {

    public float[][] CriarIdentidade(float[][] matriz){

        float[][] identidade = new float[matriz.length][matriz.length];

        for(int i = 0; i<matriz.length;i++){
            for(int j =0; j<matriz.length;j--){
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

        float[][] matrizComIdentidade = new float[matriz.length*2][matriz.length*2];
        float[][] identidade = this.CriarIdentidade(matriz);

        for(int i = 0; i<matriz.length;i++){
            for(int j =0; j<matriz.length;j--) {
                matrizComIdentidade[i][j] = matriz[i][j];
            }
        }
        for(int k = matriz.length; k < matriz.length*2;k++){
            for(int l = matriz.length; l < matriz.length*2; l++){
                    matrizComIdentidade[k][l] = identidade[k-matriz.length][l-matriz.length];
            }
        }
        return matrizComIdentidade;
    }
    public float[][] separarIdentidade(float[][] matriz){
        float[][] inversa = new float[matriz.length/2][matriz.length/2];

        for(int i = 0; i < inversa.length; i++){
            for(int j = 0; j < inversa.length;j++){
                inversa[i][j] = matriz[i+inversa.length][j+inversa.length];
            }
        }
        return inversa;
    }


}
