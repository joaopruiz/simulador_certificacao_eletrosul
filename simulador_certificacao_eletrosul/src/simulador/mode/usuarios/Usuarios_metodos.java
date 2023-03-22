package simulador.mode.usuarios;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import simulador.dao.Conexao;
import simulador.model.autores.Autortb;
import simulador.model.autores.Subaux;
import simulador.view.Mensagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuarios_metodos {
	 private Connection con;
	 private JComboBox combo;
	    
	 public Usuarios_metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }
	public String retornaTipoUsuario(int i){
		String tipo="";
		if(i==1){
			tipo="USU�RIO";
		}
		if(i==2){
			tipo="ADMINISTRADOR";
		}
		return tipo;
	}
	public DefaultTableModel PreencheraJtable(){
		String[] colunasTabela = new String[]{"ID_Usuarios", "Nome Usu�rio", "Tipo"};  
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
			PreparedStatement stmt = con.prepareStatement("select * from usuariostb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{ 
					modelo.addRow(new Object[]{
						rs.getInt("idUsuariosTB"),
						rs.getString("usuarios"),
						rs.getInt("tipo"),
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
	public String RetornaaSenha(int i){
		String senha="";
        try {
			PreparedStatement stmt = con.prepareStatement("select * from usuariostb where idUsuariosTB=?");
			stmt.setInt(1, i);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				senha=rs.getString("senha");
			}
      rs.close();
      stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return senha;
	}
	public void Salvar_novo_registroJtable(Usuariotb usuariotb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into usuariostb (usuarios, senha, tipo) values(?,?,?)");
 
			 	stmt.setString(1, usuariotb.getUsuarios());
			 	stmt.setString(2, usuariotb.getSenha());
			 	stmt.setInt(3, usuariotb.getTipo());
 
			 stmt.executeUpdate();
			 stmt.close();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	public void atualizar_registroJtable(Usuariotb usuarios){
		try {
			PreparedStatement stmt = con.prepareStatement("update usuariostb set usuarios=?, senha=?, tipo=?"+
			" where idUsuariosTB=?");
 
				stmt.setString(1, usuarios.getUsuarios());
		 		stmt.setString(2, usuarios.getSenha());
			 	stmt.setInt(3, usuarios.getTipo());
			 	stmt.setInt(4, usuarios.getIdUsuariosTB());
 
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}

	}
	public void AlterarSenhausuario(String senha, int id){
		try {
			PreparedStatement stmt = con.prepareStatement("update usuariostb set senha=?"+
			" where idUsuariosTB=?");
 
		 		stmt.setString(1, senha);
			 	stmt.setInt(2, id);
 
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
			PreparedStatement stmt = con.prepareStatement("delete from usuariostb where idUsuariosTB=?");
 
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
