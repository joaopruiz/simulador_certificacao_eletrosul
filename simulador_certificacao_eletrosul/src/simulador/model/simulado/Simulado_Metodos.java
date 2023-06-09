package simulador.model.simulado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import simulador.dao.Conexao;
import simulador.view.Mensagens;

public class Simulado_Metodos {
	 private Connection con;
	    
	 public Simulado_Metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }
	 public void Salvar_novo_Estatisticas(SimuladoTB simuladotb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into pontuacaotb (nome_PontuacaoTB, " +
					"acertos_PontuacaoTB, erros_PontuacaoTB, pontuacao_PontuacaoTB, UsuariosTB_idUsuariosTB, id_simulado_estatisticastb) values(?,?,?,?,?,?)");
 
			 	stmt.setString(1, simuladotb.getNome_PontuacaoTB());
			 	stmt.setDouble(2, simuladotb.getAcertos_PontuacaoTB());
			 	stmt.setDouble(3, simuladotb.getErros_PontuacaoTB());
			 	stmt.setDouble(4, simuladotb.getPontuacao_PontuacaoTB());
			 	stmt.setInt(5, simuladotb.getUsuariosTB_idUsuariosTB());
			 	stmt.setInt(6, simuladotb.getId_simulado_estatisticastb());
			 stmt.executeUpdate();
			 stmt.close();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	 public void Salvar_Estatisticas(EstatisticasTB estatisticastb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into estatisticastb (num_simulado, num_pergunta, " +
					"acertou, assunto_pergunta, resposta_correta, resposta_assinalada, id_usuario) values(?,?,?,?,?,?,?)");
			 	stmt.setInt(1, estatisticastb.getNum_simulado());
			 	stmt.setInt(2, estatisticastb.getNum_pergunta());
			 	stmt.setInt(3, estatisticastb.getAcertou());
			 	stmt.setInt(4, estatisticastb.getAssunto_pergunta());
			 	stmt.setString(5, estatisticastb.getResposta_correta());
			 	stmt.setString(6, estatisticastb.getResposta_assinalada());
			 	stmt.setInt(7, estatisticastb.getId_usuario());
 
			 stmt.executeUpdate();
			 stmt.close();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			System.out.println("deu erro ao gravar as estat�sticas");
			e.printStackTrace();
		}

	}
	 public DefaultTableModel PreencheraJtable(int id){
			String[] colunasTabela = new String[]{"ID", "NOME DO UTILIZADOR", "ACERTOS", "ERROS", "N� QUEST�ES","APROVEITAMENTO", "ID_SIM"};  
			DefaultTableModel modelo = new DefaultTableModel(null, colunasTabela){    
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int mColIndex){  
					return false;  
					}           
				};  
	        try {
				PreparedStatement stmt = con.prepareStatement("select * from pontuacaotb where UsuariosTB_idUsuariosTB = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if ( rs.next() ) {
					do{
						int total = rs.getInt("pontuacao_PontuacaoTB");
						int acertos = rs.getInt("acertos_PontuacaoTB");
						int aproveitamento = (acertos*100)/total;
						String media = Integer.toString(aproveitamento)+"%";
						modelo.addRow(new Object[]{
							rs.getInt("id_PontuacaoTB"),
							rs.getString("nome_PontuacaoTB"),
							rs.getInt("acertos_PontuacaoTB"),
							rs.getInt("erros_PontuacaoTB"),
							rs.getInt("pontuacao_PontuacaoTB"),
							media,
							rs.getInt("id_simulado_estatisticastb")
						});	
					}
					while( rs.next() );{}
				}
	      rs.close();
	      stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}
	    return modelo;
		}
	 public int retornaUltimoSimulador(){
		 int ultimo=0;
	        try {
				PreparedStatement stmt = con.prepareStatement("select MAX(num_simulado) from estatisticastb");
				//stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if ( rs.next() ) {
					do{
						//ultimo = rs.getInt("MAX(num_simulado)");
						ultimo = rs.getInt(1);
					}
					while( rs.next() );{}
				}
	      rs.close();
	      stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}
	    return ultimo;
		}
}
