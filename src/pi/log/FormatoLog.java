/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.log;

/**
 *
 * @author Edu Rodrigues; Higor Rocha; Mateus Matias; Nildismeire Faria.
 * Esta Classe define a ordem e os tipos de dados a receber do arquivo de logs
 */
public class FormatoLog {
    /* 
     Formato do log a ser lindo
     %h | %u | %t | %U | %p
     */
    private String Maquinacliente; //(%h - Máquina cliente)
    private String usuarioRemoto; //(%u - Usuário remoto)
    private String data; //(%t - Hora, no formato do arquivo de log) 
    private String url; //(%U - O caminho da URL requisitada )
    private String porta; //(%p - A porta do servidor servindo a requisição)
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the porta
     */
    public String getPorta() {
        return porta;
    }

    /**
     * @param porta the porta to set
     */
    public void setPorta(String porta) {
        this.porta = porta;
    }

    /**
     * @return the Maquinacliente
     */
    public String getMaquinacliente() {
        return Maquinacliente;
    }

    /**
     * @param Maquinacliente the Maquinacliente to set
     */
    public void setMaquinacliente(String Maquinacliente) {
        this.Maquinacliente = Maquinacliente;
    }

    /**
     * @return the usuarioRemoto
     */
    public String getUsuarioRemoto() {
        return usuarioRemoto;
    }

    /**
     * @param usuarioRemoto the usuarioRemoto to set
     */
    public void setUsuarioRemoto(String usuarioRemoto) {
        this.usuarioRemoto = usuarioRemoto;
    }

}
