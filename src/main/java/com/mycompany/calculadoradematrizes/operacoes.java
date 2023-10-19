/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculadoradematrizes;

/**
 *
 * @author joaom
 */
public interface operacoes {
     void exibirMatriz(float[][] matriz);
     float[][] gerarMatriz(int linhas, int colunas);
     float calcularDeterminante(float[][] matriz);
     float[][] escalonar(float[][] matriz);
     float[][] calcularInversa(float[][] matriz);
}
