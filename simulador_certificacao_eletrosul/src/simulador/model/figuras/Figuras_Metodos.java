package simulador.model.figuras;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;



import simulador.dao.Conexao;
import simulador.model.autores.Autortb;
import simulador.model.autores.Subaux;
import simulador.view.Mensagens;

public class Figuras_Metodos {
	 private Connection con;
	 private JComboBox combo;
	    
	 /*public Figuras_Metodos(){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }*/
	 
	public DefaultTableModel PreencheraJtable(){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		String[] colunasTabela = new String[]{"ID", "Descrição"};  
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
			PreparedStatement stmt = con.prepareStatement("select * from figurastb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					//System.out.println("entrou no while"); 
					modelo.addRow(new Object[]{
						rs.getInt("id_figura"),
						rs.getString("descricao"),
					});	
				}
				while( rs.next() );{}
			}
      rs.close();
      stmt.close();
      con.close();
      System.out.println("Fechou a conexao.");
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return modelo;
	}
	
	public JComboBox PreencheojCombobox(){  
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from figurastb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				combo.addItem(new Subaux("", "0"));
				do{
					String a = rs.getString("descricao");
					String b = rs.getString("id_figura");
					combo.addItem(new Subaux(a, b));
				}
				while( rs.next() );{}
			}
      rs.close();
      stmt.close();
      con.close();
      System.out.println("Fechou a conexao.");
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return combo;
	}
	
	public JComboBox PreencheojComboboxComvalorinicial(Subaux sub1){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from figurastb where id_figura<>?");
			stmt.setInt(1, Integer.parseInt(sub1.getUf()));
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				combo.addItem(sub1);
				do{
					String a = rs.getString("descricao");
					String b = rs.getString("id_figura");
					combo.addItem(new Subaux(a, b));
				}
				while( rs.next() );{}
			}
      rs.close();
      stmt.close();
      con.close();
      System.out.println("Fechou a conexao.");
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return combo;
	}
	
	public byte[] retornaFigura(int sube){
		 byte[] imagem=null;
		 System.out.println("toma g1");
		 try {
			 con = new Conexao().getConexao();
			
		 } catch (Exception e) {
			 Mensagens mensagens = new Mensagens();
			 mensagens.MensagemdeErroDB(e.toString());
			 e.printStackTrace();
		 }
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 Blob i = null;
		 System.out.println("toma g2");
		 try {
			  stmt = con.prepareStatement("select figura from figurastb where id_figura=?");
			  stmt.setInt(1, sube);
			  rs = stmt.executeQuery();
			    if ( rs.next() ) {
					i=rs.getBlob("figura");
					i=rs.getBlob("figura");
			    }
	   
		rs.close();
		stmt.close();
		} catch (SQLException e) {
			//Mensagens mensagens = new Mensagens();
			//mensagens.MensagemdeErro(e.toString());
			//e.printStackTrace();
		}
		 int tempInt;
			
		//Figuras_Metodos f1 = new Figuras_Metodos();
		Blob blob = i;
		try {
			tempInt = (int) blob.length();
			imagem = blob.getBytes(1, tempInt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			System.out.println("entrou w");
			
			con.close();
			System.out.println("Fechou a conexao.");
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return imagem;
	 }
	
	public void Salvar_novo_registroJtable(Figurastb figurastb){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into figurastb (descricao, figura) values(?,?)");
			 	stmt.setString(1, figurastb.getDescricao());
			 	stmt.setBlob(2, figurastb.getFigura());
 
			 stmt.executeUpdate();
			 stmt.close();
			 con.close();
		     System.out.println("Fechou a conexao.");
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	
	public void atualizar_registroJtable(Autortb autortb){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		try {
			PreparedStatement stmt = con.prepareStatement("update autortb set nome_AutorTB=?, subestacao_AutorTB=?"+
			" where id_AutorTB=?");
 
				stmt.setString(1, autortb.getNome_AutorTB());
		 		stmt.setInt(2, autortb.getSubestacao_AutorTB());
			 	stmt.setInt(3, autortb.getId_AutorTB());
 
			stmt.executeUpdate();
			stmt.close();
			con.close();
		    System.out.println("Fechou a conexao.");
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	
	public boolean apagar_registroJtable(int id){
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
		
		boolean bDeleted = false;
		try {
			try {
				con = new Conexao().getConexao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PreparedStatement stmt = con.prepareStatement("delete from figurastb where id_figura = ?");
			
				stmt.clearParameters();
			 	stmt.setInt(1, id);
			 	//stmt.getResultSet().toString();
			 	System.out.println("entrou "+"id ="+id);
			stmt.executeUpdate();
			//con.commit();
			///System.out.println(con.toString());
			stmt.close();
			con.close();
		    System.out.println("Fechou a conexao.");
			bDeleted = true;
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

		return bDeleted;
	}
}
