package pi.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import pi.dadosEstatistico.DadosEstatistico;

/**
 *
 * @author Edu Rodrigues; Higor Rocha; Mateus Matias; Nildismeire Faria. Esta
 * classe faz a leitura do arquivo de logs e armazena os tipos de dados em um
 * Arrylist do tipo Formatologs
 */
public class lerArquivo {

    //Este metodo recebe o caminho do arquivo de logs
    public void carregarArquivo(String path) {
        //Lendo o arquivo de log
        //cria um objeto ArrayList do tipo FormatoLog
        List<FormatoLog> logs = new ArrayList<FormatoLog>();
        File file = new File(path);//Cria um objeto File, que recebe o caminho do arquivo

        if (file.exists()) {
            System.out.println("-------RELATORIO DE LOGS DE ACESSO AO SERVIDOR ------");
            System.out.println("IP DA MAQUINA CLIENTE|USUARIO REMOTO|DATA DE ACESSO|URL DE ACESSO|PORTA DE ACESSO");
            try {//Faz a leitura de linha a linha verifica se a linha esta vazia se nã armazena a linha
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linha = null;
                while (true) {
                    linha = br.readLine();
                    if (linha == null) {
                        break;
                    }
                    System.out.println(linha);
                    logs.add(separadoCampo(linha));//Chma o metodo que separa as informações da linha 
                }
                System.out.println("TOTAL GERAL DE LOGS:" + logs.size());//exibe o total de linhas
                System.out.println("------------------------------------------------");
            } catch (IOException e) {
                System.err.println("Erro:" + e.getMessage());
            }
            DadosEstatistico dadoestatitiscos = new DadosEstatistico(); //cria o objeto dados estatisticos
            dadoestatitiscos.relatorioCalculosEstatisticoIp(logs);//chama o metodo de calculo dados 
        } else {//Resposta caso o camniho esteja errado ou o arquivo não exista
            System.out.println("ARQUIVO NÃO EXISTE!!!!");
        }

    }

    //O metodo separae armazena cada tipo de dado de cada linha.
    private static FormatoLog separadoCampo(String linha) {
        StringTokenizer st = new StringTokenizer(linha, "|");
        FormatoLog fl = new FormatoLog();
        fl.setMaquinacliente(st.nextToken());
        fl.setUsuarioRemoto(st.nextToken());
        fl.setData(st.nextToken());
        fl.setUrl(st.nextToken());
        fl.setPorta(st.nextToken());
        return fl;
    }
}
