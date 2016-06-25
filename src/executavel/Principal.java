/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executavel;

import pi.log.LerArquivo;

/**
 *
 * @author Edu Rodrigues; Higor Rocha; Mateus Matias; Nildismeire Faria Classe Excutavel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Lendo o arquivo de log
        LerArquivo arquivo = new LerArquivo();
        arquivo.carregarArquivo("C:\\Users\\DUDU\\Desktop\\logs\\access-logs.txt");
    }
}
