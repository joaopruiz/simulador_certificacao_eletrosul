package simulador.view.relatorios;

import simulador.model.relatorios.ReportUtils;
import simulador.view.Mensagens;
import simulador.dao.Conexao;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class Relatorio1 {

    /*public static void main(String[] args) {
        new Jasper_teste().abrirRelatorioClientes();
    }*/

    public void abrirRelatorio(Integer id) {
    	System.out.println("id= "+id);
    	InputStream inputStream = getClass().getResourceAsStream("/estatisticas_do_simulado.jasper");
    	//InputStream inputStream = getClass().getResourceAsStream("/teste.jasper");

        // mapa de parâmetros do relatório 
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put( "id_Usuario", id );
        
        try {

            // abre o relatório
        	Conexao conexao1 = new Conexao();
        	ReportUtils.openReport( "Simulador Certificação - Estatísticas dos Simulados", inputStream, parametros,
                   conexao1.getConexao() );

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