package simulador.model.subestacoes;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import simulador.dao.Conexao;
import simulador.view.Mensagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Subestacoes_metodos {
	 private Connection con;
	    
	 public Subestacoes_metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }

	public DefaultTableModel PreencheraJtable(){
		String[] colunasTabela = new String[]{"ID_Subestação", "Nome Subestação", "Controladora"};  
		DefaultTableModel modelo = new DefaultTableModel(null, colunasTabela) {    
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int mColIndex){  
					return false;  
					}           
				};  
				try {
			PreparedStatement stmt = con.prepareStatement("select * from subestacaotb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					//System.out.println("entrou no while"); 
					modelo.addRow(new Object[]{
						rs.getInt("id_SubestacaoTB"),
						rs.getString("nomeid_SubestacaoTB"),
						rs.getString("controladoraid_SubestacaoTB")
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
	public void Salvar_novo_registroJtable(Subestacaotb Subestacaotb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into subestacaotb (nomeid_SubestacaoTB, controladoraid_SubestacaoTB) values(?,?)");
 
			 	stmt.setString(1, Subestacaotb.getNomeid_SubestacaoTB());
			 	stmt.setString(2, Subestacaotb.getControladoraid_SubestacaoTB());
 
			 	stmt.executeUpdate();
			    stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
	}
	public void atualizar_registroJtable(Subestacaotb Subestacaotb){
		try {
			PreparedStatement stmt = con.prepareStatement("update subestacaotb set nomeid_SubestacaoTB=?, controladoraid_SubestacaoTB=?"+
			" where id_SubestacaoTB=?");
 
				stmt.setString(1, Subestacaotb.getNomeid_SubestacaoTB());
				stmt.setString(2, Subestacaotb.getControladoraid_SubestacaoTB());
			 	stmt.setInt(3, Subestacaotb.getId_SubestacaoTB());
 
			 	stmt.executeUpdate();
			    stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
	}
	public void apagar_registroJtable(int id){
		try {
			PreparedStatement stmt = con.prepareStatement("delete from subestacaotb where id_SubestacaoTB=?");
 
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
