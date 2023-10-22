/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

import com.mycompany.calculadoradematrizes.exceptions.InversaNaoExisteException;
import com.mycompany.calculadoradematrizes.exceptions.MatrizNaoEQuadradaException;

/**
 *
 * @author joaom
 */
public interface operacoes {
     void exibirMatriz(float[][] matriz);
     float[][] gerarMatriz(int linhas, int colunas);
     float calcularDeterminante(float[][] matriz) throws MatrizNaoEQuadradaException;
     float[][] matrizTransposta(float[][] matriz);
     float[][] matrizDeCofatores(float[][] matriz) throws MatrizNaoEQuadradaException;
     float[][] matrizAdjunta(float[][] matriz) throws MatrizNaoEQuadradaException;
     float[][] escalonar(float[][] matriz);
     float[][] calcularInversa(float[][] matriz) throws InversaNaoExisteException;

}
