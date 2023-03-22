package simulador.view.relatorios;

import simulador.model.relatorios.ReportUtils;
import simulador.view.Mensagens;
import simulador.dao.Conexao;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

public class Relatorio55 {

    /*public static void main(String[] args) {
        new Jasper_teste().abrirRelatorioClientes();
    }*/

    public void abrirRelatorio(int id) {
    	//relatorio55MenuItem.setText("Peruntas com mais Erros");
    	InputStream inputStream = getClass().getResourceAsStream("/perguntas_erros_pizza_meu.jasper");

        // mapa de par�metros do relat�rio 
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put( "id_usuario", id );
        
        try {

            // abre o relat�rio
        	Conexao conexao1 = new Conexao();
        	ReportUtils.openReport( "Simulador Certifica��o - Relat�rio - Assuntos com mais Acertos", inputStream, parametros,
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