package simulador.model.autores;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import simulador.dao.Conexao;
import simulador.view.Mensagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Autores_metodos {
	 private Connection con;
	 private JComboBox combo;
	    
	 public Autores_metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }
	 public String retornaSubestação(int sube){
		 String i="erro";
		 try {
			  PreparedStatement stmt = con.prepareStatement("select nomeid_SubestacaoTB from subestacaotb where id_SubestacaoTB=?");
			  stmt.setInt(1, sube);
			    ResultSet rs = stmt.executeQuery();
			    if ( rs.next() ) {
					i=rs.getString("nomeid_SubestacaoTB");
			    }
			   rs.close();
			   stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
		return i;
	 }
	 
	public DefaultTableModel PreencheraJtable(){
		String[] colunasTabela = new String[]{"ID_Autor", "Nome Autor", "Nome Subestação", "ID_Sub"};  
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
			PreparedStatement stmt = con.prepareStatement("select * from autortb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					//System.out.println("entrou no while"); 
					modelo.addRow(new Object[]{
						rs.getInt("id_AutorTB"),
						rs.getString("nome_AutorTB"),
						retornaSubestação(rs.getInt("subestacao_AutorTB")),
						rs.getInt("subestacao_AutorTB")
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
	public JComboBox PreencheojCombobox(){  
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from subestacaotb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					String a = rs.getString("nomeid_SubestacaoTB");
					String b = rs.getString("id_SubestacaoTB");
					combo.addItem(new Subaux(a, b));
				}
				while( rs.next() );{}
			}
      rs.close();
      stmt.close();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return combo;
	}
	public JComboBox PreencheojComboboxComvalorinicial(Subaux sub1){
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from subestacaotb where id_SubestacaoTB<>?");
			stmt.setInt(1, Integer.parseInt(sub1.getUf()));
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				combo.addItem(sub1);
				do{
					String a = rs.getString("nomeid_SubestacaoTB");
					String b = rs.getString("id_SubestacaoTB");
					combo.addItem(new Subaux(a, b));
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
    return combo;
	}
	public void Salvar_novo_registroJtable(Autortb autortb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into autortb (nome_AutorTB, subestacao_AutorTB) values(?,?)");
 
			 	stmt.setString(1, autortb.getNome_AutorTB());
			 	stmt.setInt(2, autortb.getSubestacao_AutorTB());
 
			 stmt.executeUpdate();
			 stmt.close();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	public void atualizar_registroJtable(Autortb autortb){
		try {
			PreparedStatement stmt = con.prepareStatement("update autortb set nome_AutorTB=?, subestacao_AutorTB=?"+
			" where id_AutorTB=?");
 
				stmt.setString(1, autortb.getNome_AutorTB());
		 		stmt.setInt(2, autortb.getSubestacao_AutorTB());
			 	stmt.setInt(3, autortb.getId_AutorTB());
 
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
			PreparedStatement stmt = con.prepareStatement("delete from autortb where id_AutorTB=?");
 
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
