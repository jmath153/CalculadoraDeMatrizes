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
    public void exibirMatriz(float[][] matriz);
    public T[][] gerarMatriz(int linhas, int colunas);
    public T calcularDeterminante(int[][] matriz);
}
