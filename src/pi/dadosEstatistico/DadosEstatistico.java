/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dadosEstatistico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pi.log.FormatoLog;

/**
 *
 * @author Edu Rodrigues; Higor Rocha; Mateus Matias; Nildismeire Faria.
 * Esta Classe Dados Estatisticos tem apenas os de calulo e emissão dos relatorios de
 * dados.Que implementa a interface Comparator que compara objetos do tipo Formatolog.
 */
public class DadosEstatistico  implements Comparator<FormatoLog>{

// Este metodo recebe um list com dados do tipo Formato logs, e realiza os calculos de ip
    public void relatorioCalculosEstatisticoIp(List<FormatoLog> logs) {
        DadosEstatistico dadoIp = new DadosEstatistico();
        //Este comando pega os ips repitidos e os coloca em ordem seguida 
        Collections.sort(logs, dadoIp);
        //cria um objeto Arraylist que recebe obejetos da classe Dado
        List<Dado> listaDados = new ArrayList<>();
        double mediaAritimetica;// media
        double desvioPadrao;//desvio padrão
        double coeficienteVariacao; //Coeficiente de variação
        double indice; // indice(%)
        double variancia;// variancia
        String ip = null;//ip da maquina cliente
        int repeticoesIp = 1;//numero de repetições

        //Percorrer todo o List<FormatoLog> logs
        for (int i = 0; i < logs.size() - 1; i++) {
            ip = logs.get(i).getMaquinacliente();//Armazena o primeiro ip(FormatoLog) em ip(Dado)
            if (ip.equalsIgnoreCase(logs.get(i + 1).getMaquinacliente())) {//verifica se existem ips repetidos 
                repeticoesIp++;// cada vez que o ip se repete soma masi um repetição
            } else {
                //se não se repetir cria uma nova linha do ArrayList com obejetos da Classe Dado
                listaDados.add(new Dado(ip, repeticoesIp));
                ip = logs.get(i + 1).getMaquinacliente();//Armazena um novo ip(FormatoLog) em ip(Dado)
                repeticoesIp = 1;//inicia a contagem desse novo ip(Dado)
            }
        }
        System.out.println();
        System.out.println("---RELATORIO DE DADOS ESTATISTICO DE ACESSO DE IP DE MAQUINAS CLIENTES ---");
        //o objeto Arraylist da classe Dado recebe os ultimos tipos de dados
        listaDados.add(new Dado(ip, repeticoesIp));
        for (Dado dadosIp : listaDados) {
            System.out.println("------------------------------------------");
            System.out.println(dadosIp);
            mediaAritimetica = dadosIp.getRepeticao() / 7.0;//calcula a media do ip na semana
            indice = dadosIp.getRepeticao() * 100.00 / logs.size();//calucla o inddice(%)

            //calcula a variancia
            variancia = (1 / Double.valueOf(logs.size() - 1)) * (Math.pow(dadosIp.getRepeticao(), 4)
                    - (Math.pow(dadosIp.getRepeticao(), 4) / Double
                    .valueOf(logs.size())));

            desvioPadrao = Math.sqrt(variancia);//calcula o desvio padrão 
            coeficienteVariacao = desvioPadrao / mediaAritimetica;// calcula o coeficiente de variação
            //Exibe as informações 
            System.out.printf("MÉDIA  ACESSOS REALIZADOS NA SEMANA AO SERVIDOR é de: %.2f .\n", mediaAritimetica);
            System.out.printf("ÍNDICE DE ACESSO desse IP é de:  %.2f%%\n", indice);
            System.out.printf("VARIÂNCIA: %.3f\n", variancia);
            System.out.printf("DESVIO PADRÃO: %.3f\n", desvioPadrao);
            System.out.printf("COEFICIENTE DE VARIAÇÃO: %f \n", coeficienteVariacao);
        }

    }
   //Metodo que verifica se os ips se repetem 
    @Override
    public int compare(FormatoLog o1, FormatoLog o2) {
       return o1.getMaquinacliente().compareTo(o2.getMaquinacliente());
    }


}

