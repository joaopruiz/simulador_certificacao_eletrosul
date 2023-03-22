package simulador.view.relatorios;

import simulador.model.relatorios.ReportUtils;
import simulador.view.Mensagens;
import simulador.dao.Conexao;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class Relatorio6 {

    /*public static void main(String[] args) {
        new Jasper_teste().abrirRelatorioClientes();
    }*/

    public void abrirRelatorio(Integer id) {
    	//System.out.println("id"+id);
    	//carregando o relatório
    	InputStream inputStream = null;
    	inputStream = getClass().getResourceAsStream("/estatisticas_do_simulado_perguntas.jasper");
    	
        // mapa de parâmetros do relatório 
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put("id_simulado", id);
        
        try {
        	//System.out.println("abre o relatório");
            // abre o relatório
        	Conexao conexao1 = new Conexao();
        	//System.out.println(inputStream);
        	//System.out.println(parametros);
        	//System.out.println(conexao1.getConexao());
        	ReportUtils.openReport("Simulador Certificação - Estatísticas dos Erros e Acertos", inputStream, parametros, conexao1.getConexao());
        	//System.out.println("abriu o relatório");

        } catch ( SQLException e ) {
        	Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
            e.printStackTrace();
        } catch ( JRException e ) {
        	Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
            e.printStackTrace();
        } catch (Exception e) {
        	Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

    }

}