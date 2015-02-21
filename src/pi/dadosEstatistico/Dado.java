/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pi.dadosEstatistico;

/**
 *
 * @author Edu Rodrigues; Higor Rocha; Mateus Matias; Nildismeire Faria.
 * Esta Classe Dado tem os atributos "tipo" que recebe tipo de dado do arquivo de logs 
 * que pode ser:ip da maquina cliente,usuario remoto,etc...
 *  E o atributo repetição que o numero de vezes que o tipo de dado se repetite no 
 *  arquivo de logs.
 */
public class Dado {
    
    private String tipo;
    private int repeticao;
           

    public Dado(String tipo, int repeticao) {
        this.tipo = tipo;
        this.repeticao = repeticao;
       
    }

    public Dado() {
    }

    /**
     * @return the ip
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the repeticoesIp
     */
    public int getRepeticao() {
        return repeticao;
    }
    
    @Override
    public String toString() {
        return "Dados Estatisticos de: "  + tipo + ", se repete " + repeticao + " vezes";
    }

    
}
