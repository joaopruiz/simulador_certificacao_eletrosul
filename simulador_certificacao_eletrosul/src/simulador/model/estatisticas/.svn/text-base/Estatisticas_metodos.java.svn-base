package simulador.model.estatisticas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import simulador.dao.Conexao;
import simulador.view.Mensagens;

public class Estatisticas_metodos {
	 private Connection con;
	    
	 public Estatisticas_metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }
	 public void apagar_registroJtable(int id){
			try {
				PreparedStatement stmt = con.prepareStatement("delete from pontuacaotb where id_PontuacaoTB=?");
	 
				 	stmt.setInt(1, id);
	 
				stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}

		}
}
