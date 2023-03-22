package simulador.model.perguntas;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import simulador.dao.Conexao;
import simulador.model.autores.Subaux;
import simulador.view.Mensagens;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Perguntas_metodos {
	 private Connection con;
	 private JComboBox combo;
	    
	 public Perguntas_metodos(){
		 try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErroDB(e.toString());
			e.printStackTrace();
		}
	 }
	 public String retornaNomedoAutor(int sube){
		 String i="erro";
		  try {
			PreparedStatement stmt = con.prepareStatement("select nome_AutorTB from autortb where id_AutorTB=?");
			  stmt.setInt(1, sube);
			    ResultSet rs = stmt.executeQuery();
			    if ( rs.next() ) {
					i=rs.getString("nome_AutorTB");
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
	 public String retornaAssunto(int sube){
		 String i="erro";
		  try {
			PreparedStatement stmt = con.prepareStatement("select descricaoid_AssuntoTB from assuntotb where id_AssuntoTB=?");
			  stmt.setInt(1, sube);
			    ResultSet rs = stmt.executeQuery();
			    if ( rs.next() ) {
					i=rs.getString("descricaoid_AssuntoTB");
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
	 public String retornaDescricadaFigura(int sube){
		 String i="";
		  try {
			PreparedStatement stmt = con.prepareStatement("select descricao from figurastb where id_figura=?");
			  stmt.setInt(1, sube);
			    ResultSet rs = stmt.executeQuery();
			    if ( rs.next() ) {
					i=rs.getString("descricao");
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
		String[] colunasTabela = new String[]{"ID Perguntas", "Enunciado Perguntas", "Autor"};  
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
			PreparedStatement stmt = con.prepareStatement("select * from perguntastb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					//System.out.println("entrou no while"); 
					modelo.addRow(new Object[]{
						rs.getInt("id_PerguntasTB"),
						rs.getString("enunciado_PerguntasTB"),
						retornaNomedoAutor(rs.getInt("AutorTBTB_id_AutorTB"))
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
	 public ArrayList<Perguntastb> getListadePerguntas(){
	        ArrayList<Perguntastb> perguntas;
	        perguntas = new ArrayList<Perguntastb>();
			try {
				PreparedStatement stmt = con.prepareStatement("select * from perguntastb");
				ResultSet rs = stmt.executeQuery();
				//int i=0;
				while(rs.next()){
				    Perguntastb pergunta = new Perguntastb(rs.getInt("id_PerguntasTB"), rs.getInt("AssuntoTBTB_id_AssuntoTB"), rs.getInt("AutorTBTB_id_AutorTB"), 
				    rs.getInt("SubestacaoTBTB_id_SubestacaoTB"), rs.getInt("id_figuratb"), rs.getString("enunciado_PerguntasTB"), rs.getString("resposta_a_PerguntasTB"), 
				    rs.getString("resposta_b_PerguntasTB"), rs.getString("resposta_c_PerguntasTB"), rs.getString("resposta_d_PerguntasTB"), 
				    rs.getString("resposta_e_PerguntasTB"), rs.getString("resposta_f_PerguntasTB"), rs.getString("resposta_g_PerguntasTB"), 
				    rs.getString("correta_PerguntasTB"));
				    //i++;
				    perguntas.add(pergunta);

				}
				//System.out.println("marcação: "+i);
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}
	        
	        return perguntas;
	    }
	 public ArrayList<Perguntastb> getListadePerguntasporassunto(int id){
	        ArrayList<Perguntastb> perguntas;
	        perguntas = new ArrayList<Perguntastb>();
			try {
				PreparedStatement stmt = con.prepareStatement("select * from perguntastb where AssuntoTBTB_id_AssuntoTB=?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				//int i=0;
				while(rs.next()){
				    Perguntastb pergunta = new Perguntastb(rs.getInt("id_PerguntasTB"), rs.getInt("AssuntoTBTB_id_AssuntoTB"), rs.getInt("AutorTBTB_id_AutorTB"), 
				    rs.getInt("SubestacaoTBTB_id_SubestacaoTB"), rs.getInt("id_figuratb"), rs.getString("enunciado_PerguntasTB"), rs.getString("resposta_a_PerguntasTB"), 
				    rs.getString("resposta_b_PerguntasTB"), rs.getString("resposta_c_PerguntasTB"), rs.getString("resposta_d_PerguntasTB"), 
				    rs.getString("resposta_e_PerguntasTB"), rs.getString("resposta_f_PerguntasTB"), rs.getString("resposta_g_PerguntasTB"), 
				    rs.getString("correta_PerguntasTB"));
				    //i++;
				    perguntas.add(pergunta);

				}
				//System.out.println("marcação: "+i);
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}
	        
	        return perguntas;
	    }
	 public ArrayList<Perguntastb> getPerguntasporID(int ID){
	        ArrayList<Perguntastb> perguntas;
	        perguntas = new ArrayList<Perguntastb>();
			try {
				PreparedStatement stmt = con.prepareStatement("select * from perguntastb where id_PerguntasTB=?");
				stmt.setInt(1, ID);
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
				    Perguntastb pergunta = new Perguntastb(rs.getInt("id_PerguntasTB"), rs.getInt("AssuntoTBTB_id_AssuntoTB"), rs.getInt("AutorTBTB_id_AutorTB"), 
				    rs.getInt("SubestacaoTBTB_id_SubestacaoTB"), rs.getInt("id_figuratb"), rs.getString("enunciado_PerguntasTB"), rs.getString("resposta_a_PerguntasTB"), 
				    rs.getString("resposta_b_PerguntasTB"), rs.getString("resposta_c_PerguntasTB"), rs.getString("resposta_d_PerguntasTB"), 
				    rs.getString("resposta_e_PerguntasTB"), rs.getString("resposta_f_PerguntasTB"), rs.getString("resposta_g_PerguntasTB"), 
				    rs.getString("correta_PerguntasTB"));
				    /*AssuntoTBTB_id_AssuntoTB, AutorTBTB_id_AutorTB, "+ 
					"SubestacaoTBTB_id_SubestacaoTB, enunciado_PerguntasTB, resposta_a_PerguntasTB, resposta_b_PerguntasTB, resposta_c_PerguntasTB, " +
					"resposta_d_PerguntasTB, resposta_e_PerguntasTB, resposta_f_PerguntasTB, resposta_g_PerguntasTB, correta_PerguntasTB) " +*/
				    perguntas.add(pergunta);

				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				Mensagens mensagens = new Mensagens();
				mensagens.MensagemdeErro(e.toString());
				e.printStackTrace();
			}
	        
	        return perguntas;
	    }
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
    return combo;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox PreencheojComboboxcomAutores(){
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from autortb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					String a = rs.getString("nome_AutorTB");
					String b = rs.getString("id_AutorTB");
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox PreencheojComboboxcomAssuntos(){
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from assuntotb");
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				do{
					String a = rs.getString("descricaoid_AssuntoTB");
					String b = rs.getString("id_AssuntoTB");
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox PreencheojComboboxComvalorinicial(Subaux sub1){  
		combo = new JComboBox();  
        try {
			PreparedStatement stmt = con.prepareStatement("select * from subestacaotb");
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
	public void Salvar_novo_registroJtable(Perguntastb perguntastb){
		 try {
			PreparedStatement stmt = con.prepareStatement("insert into perguntastb (AssuntoTBTB_id_AssuntoTB, AutorTBTB_id_AutorTB, "+ 
			 		"SubestacaoTBTB_id_SubestacaoTB, id_figuratb, enunciado_PerguntasTB, resposta_a_PerguntasTB, resposta_b_PerguntasTB, resposta_c_PerguntasTB, " +
			 		"resposta_d_PerguntasTB, resposta_e_PerguntasTB, resposta_f_PerguntasTB, resposta_g_PerguntasTB, correta_PerguntasTB) " +
			 		"values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
 
			 	stmt.setInt(1, perguntastb.getAssuntoTBTB_id_AssuntoTB());
			 	stmt.setInt(2, perguntastb.getAutorTBTB_id_AutorTB());
			 	stmt.setInt(3, perguntastb.getSubestacaoTBTB_id_SubestacaoTB());
			 	stmt.setInt(4, perguntastb.getId_figuratb());
			 	stmt.setString(5, perguntastb.getEnunciado_PerguntasTB());
			 	stmt.setString(6, perguntastb.getResposta_a_PerguntasTB());
			 	stmt.setString(7, perguntastb.getResposta_b_PerguntasTB());
			 	stmt.setString(8, perguntastb.getResposta_c_PerguntasTB());
			 	stmt.setString(9, perguntastb.getResposta_d_PerguntasTB());
			 	stmt.setString(10, perguntastb.getResposta_e_PerguntasTB());
			 	stmt.setString(11, perguntastb.getResposta_f_PerguntasTB());
			 	stmt.setString(12, perguntastb.getResposta_g_PerguntasTB());
			 	stmt.setString(13, perguntastb.getCorreta_PerguntasTB());
			 	
			 stmt.executeUpdate();
			 stmt.close();
		} catch (SQLException e) {
			Mensagens mensagens = new Mensagens();
			mensagens.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
	}
	public void atualizar_registroJtable(Perguntastb perguntastb){
		try {
			PreparedStatement stmt = con.prepareStatement("update perguntastb set AssuntoTBTB_id_AssuntoTB=?, AutorTBTB_id_AutorTB=?, "+ 
			"SubestacaoTBTB_id_SubestacaoTB=?, id_figuratb=?, enunciado_PerguntasTB=?, resposta_a_PerguntasTB=?, resposta_b_PerguntasTB=?, resposta_c_PerguntasTB=?, " +
			"resposta_d_PerguntasTB=?, resposta_e_PerguntasTB=?, resposta_f_PerguntasTB=?, resposta_g_PerguntasTB=?, correta_PerguntasTB=?"+
			" where id_PerguntasTB=?");
 
			stmt.setInt(1, perguntastb.getAssuntoTBTB_id_AssuntoTB());
		 	stmt.setInt(2, perguntastb.getAutorTBTB_id_AutorTB());
		 	stmt.setInt(3, perguntastb.getSubestacaoTBTB_id_SubestacaoTB());
		 	stmt.setInt(4, perguntastb.getId_figuratb());
		 	stmt.setString(5, perguntastb.getEnunciado_PerguntasTB());
		 	stmt.setString(6, perguntastb.getResposta_a_PerguntasTB());
		 	stmt.setString(7, perguntastb.getResposta_b_PerguntasTB());
		 	stmt.setString(8, perguntastb.getResposta_c_PerguntasTB());
		 	stmt.setString(9, perguntastb.getResposta_d_PerguntasTB());
		 	stmt.setString(10, perguntastb.getResposta_e_PerguntasTB());
		 	stmt.setString(11, perguntastb.getResposta_f_PerguntasTB());
		 	stmt.setString(12, perguntastb.getResposta_g_PerguntasTB());
		 	stmt.setString(13, perguntastb.getCorreta_PerguntasTB());
		 	stmt.setInt(14, perguntastb.getId_PerguntasTB());
 
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
			PreparedStatement stmt = con.prepareStatement("delete from perguntastb where id_PerguntasTB=?");
 
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
