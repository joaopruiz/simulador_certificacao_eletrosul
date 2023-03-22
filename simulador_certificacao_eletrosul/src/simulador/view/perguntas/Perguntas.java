package simulador.view.perguntas;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import simulador.dao.Conexao;
import simulador.model.autores.Autores_metodos;
import simulador.model.autores.Subaux;
import simulador.model.figuras.Figuras_Metodos;
import simulador.model.perguntas.Perguntas_metodos;
import simulador.model.perguntas.Perguntastb;
import simulador.view.CellRenderer;
import simulador.view.Mensagens;
import simulador.view.figuras.Figura;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class Perguntas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel SubestacoesDialog = null;
	private JPanel jPanelSubestacoes = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JPanel jPanelinferior = null;
	private JLabel jLabel_subestacaonome = null;
	private JPanel jPanel_botoes = null;
	private JButton jButton_Atualizar = null;
	private JButton jButton_Apagar = null;
	private JButton jButton_salvar = null;
	private JButton jButton_novo = null;
	private JButton jButton_sair = null;
	private JLabel jLabel_nomecontroladora = null;
	private JTextField jTextField_id_subestacoes = null;
	private JComboBox jComboBox_subestacao = null;
	private Connection con;  //  @jve:decl-index=0:
	private JLabel jLabel_assunto = null;
	private JComboBox jComboBox_assunto = null;
	private JLabel jLabel_enunciado = null;
	private JComboBox jComboBox_autor = null;
	private JLabel jLabel_repostaa = null;
	private JTextField jTextField_repostaa = null;
	private JLabel jLabel_repostab = null;
	private JTextField jTextField_repostab = null;
	private JLabel jLabel_repostac = null;
	private JTextField jTextField_repostac = null;
	private JLabel jLabel_repostad = null;
	private JTextField jTextField_repostad = null;
	private JLabel jLabel_repostae = null;
	private JTextField jTextField_repostaf = null;
	private JLabel jLabel_repostaf = null;
	private JTextField jTextField_repostae = null;
	private JLabel jLabel_repostag = null;
	private JTextField jTextField_repostag = null;
	private JLabel jLabel_correta = null;
	private JComboBox jComboBox_correta = null;
	private JTextArea jTextPane = null;
	private JScrollPane scrolingarea = null;
	private JLabel jLabel_figura = null;
	private JComboBox jComboBox_figura = null;
	private JButton jButton_mostrar_figura = null;
	private JPanel jPanel_combo_figura = null;
	
	/**
	 * @param owner
	 */
	public Perguntas(Frame owner) {
		super(owner);
		initialize();
		try {
			con = new Conexao().getConexao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getSubestacoesDialog());
		this.setSize(new Dimension(961, 706));
		this.setTitle("Simulador de Certificação - Gerenciar Perguntas");
		AtualizarJTable();
		LimpareDesabilitarCampos();
		this.getRootPane().setDefaultButton(jButton_salvar);
	}

	/**
	 * This method initializes SubestacoesDialog	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private void AtualizarJTable(){
		try {
			Perguntas_metodos sub1 = new Perguntas_metodos();
			jTable.setModel(sub1.PreencheraJtable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void LimpareDesabilitarCampos(){
		jTextField_id_subestacoes.setText("");
		jTextPane.setText("");
		jTextField_repostaa.setText("");
		jTextField_repostab.setText("");
		jTextField_repostac.setText("");
		jTextField_repostad.setText("");
		jTextField_repostae.setText("");
		jTextField_repostaf.setText("");
		jTextField_repostag.setText("");
		
		jTextPane.setEnabled(false);
		jTextField_repostaa.setEnabled(false);
		jTextField_repostab.setEnabled(false);
		jTextField_repostac.setEnabled(false);
		jTextField_repostad.setEnabled(false);
		jTextField_repostae.setEnabled(false);
		jTextField_repostaf.setEnabled(false);
		jTextField_repostag.setEnabled(false);
		
		jButton_Apagar.setEnabled(false);
		jButton_salvar.setEnabled(false);
		jButton_Atualizar.setEnabled(false);
		jButton_Apagar.setEnabled(false);
		jComboBox_subestacao.setEnabled(false);
		jComboBox_assunto.setEnabled(false);
		jComboBox_autor.setEnabled(false);
		jComboBox_correta.setEnabled(false);
		jComboBox_figura.setEnabled(false);
		jButton_mostrar_figura.setEnabled(false);
	}
	private void LimpaeAbilitaCampos(){
		jTextField_id_subestacoes.setText("");
		jTextPane.setText("");
		jTextField_repostaa.setText("");
		jTextField_repostab.setText("");
		jTextField_repostac.setText("");
		jTextField_repostad.setText("");
		jTextField_repostae.setText("");
		jTextField_repostaf.setText("");
		jTextField_repostag.setText("");
		jTextPane.setEnabled(true);
		jTextField_repostaa.setEnabled(true);
		jTextField_repostab.setEnabled(true);
		jTextField_repostac.setEnabled(true);
		jTextField_repostad.setEnabled(true);
		jTextField_repostae.setEnabled(true);
		jTextField_repostaf.setEnabled(true);
		jTextField_repostag.setEnabled(true);
		jButton_Apagar.setEnabled(false);
		jButton_salvar.setEnabled(false);
		jButton_Atualizar.setEnabled(false);
		jButton_Apagar.setEnabled(false);
		jComboBox_subestacao.setEnabled(true);
		jComboBox_assunto.setEnabled(true);
		jComboBox_autor.setEnabled(true);
		jComboBox_correta.setEnabled(true);
		jComboBox_figura.setEnabled(true);
		jButton_mostrar_figura.setEnabled(true);
	}
	private void AbilitaCampos(){
		jTextPane.setEnabled(true);
		jTextField_repostaa.setEnabled(true);
		jTextField_repostab.setEnabled(true);
		jTextField_repostac.setEnabled(true);
		jTextField_repostad.setEnabled(true);
		jTextField_repostae.setEnabled(true);
		jTextField_repostaf.setEnabled(true);
		jTextField_repostag.setEnabled(true);
		jComboBox_subestacao.setEnabled(true);
		jComboBox_assunto.setEnabled(true);
		jComboBox_autor.setEnabled(true);
		jComboBox_correta.setEnabled(true);
		jComboBox_figura.setEnabled(true);
		jButton_mostrar_figura.setEnabled(true);
	}
	private JPanel getSubestacoesDialog() {
		if (SubestacoesDialog == null) {
			SubestacoesDialog = new JPanel();
			SubestacoesDialog.setLayout(new BorderLayout());
			SubestacoesDialog.add(getJPanelSubestacoes(), java.awt.BorderLayout.WEST);
			SubestacoesDialog.add(getJPanelinferior(), java.awt.BorderLayout.CENTER);
			SubestacoesDialog.add(getJPanel_botoes(), BorderLayout.SOUTH);
		}
		return SubestacoesDialog;
	}

	/**
	 * This method initializes jPanelSubestacoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSubestacoes() {
		if (jPanelSubestacoes == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.weightx = 1.0;
			jPanelSubestacoes = new JPanel();
			jPanelSubestacoes.setLayout(new GridBagLayout());
			jPanelSubestacoes.add(getJScrollPane(), gridBagConstraints);
		}
		return jPanelSubestacoes;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mousePressed(java.awt.event.MouseEvent e) {    
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String ID = (jTable.getModel().getValueAt(i, 0)).toString();
					jTextField_id_subestacoes.setText(ID);
					jComboBox_subestacao.setEnabled(true);
					Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
					ArrayList<Perguntastb> pergunta = perguntasmetodos.getPerguntasporID(Integer.parseInt(ID));
					Autores_metodos autoresmetodos = new Autores_metodos();
					jTextPane.setText(pergunta.get(0).getEnunciado_PerguntasTB());
					jTextField_repostaa.setText(pergunta.get(0).getResposta_a_PerguntasTB());
					jTextField_repostab.setText(pergunta.get(0).getResposta_b_PerguntasTB());
					jTextField_repostac.setText(pergunta.get(0).getResposta_c_PerguntasTB());
					jTextField_repostad.setText(pergunta.get(0).getResposta_d_PerguntasTB());
					jTextField_repostae.setText(pergunta.get(0).getResposta_e_PerguntasTB());
					jTextField_repostaf.setText(pergunta.get(0).getResposta_f_PerguntasTB());
					jTextField_repostag.setText(pergunta.get(0).getResposta_g_PerguntasTB());
					//combo box subestação
					int iddasubestacao = pergunta.get(0).getSubestacaoTBTB_id_SubestacaoTB();
					String nomedasubestacao = autoresmetodos.retornaSubestação(iddasubestacao);
					Subaux sub1 = new Subaux();
					sub1.setCidade(nomedasubestacao);
					sub1.setUf(Integer.toString(iddasubestacao));
					//combo box autores
					int iddoautor = pergunta.get(0).getAutorTBTB_id_AutorTB();
					String nomedoautor = perguntasmetodos.retornaNomedoAutor(iddoautor);
					Subaux sub2 = new Subaux();
					sub2.setCidade(nomedoautor);
					sub2.setUf(Integer.toString(iddoautor));
					//combo box assuntos
					int iddoassunto = pergunta.get(0).getAssuntoTBTB_id_AssuntoTB();
					String descricaodoassunto = perguntasmetodos.retornaAssunto(iddoassunto);
					Subaux sub3 = new Subaux();
					sub3.setCidade(descricaodoassunto);
					sub3.setUf(Integer.toString(iddoassunto));
					//combo box figuras
					int iddafigura = pergunta.get(0).getId_figuratb();
					//System.out.println("iddafigura: "+iddafigura);
					String descricaodafigura = perguntasmetodos.retornaDescricadaFigura(iddafigura);
					//System.out.println("descricaodafigura: "+descricaodafigura);
					Subaux sub4 = new Subaux();
					sub4.setCidade(descricaodafigura);
					sub4.setUf(Integer.toString(iddafigura));
					//combo resposta correta
					String correta = pergunta.get(0).getCorreta_PerguntasTB();
					//
					atualizaroCombocomvariavel(sub1, sub2, sub3, sub4, correta);
					AbilitaCampos();
				}
			});
			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String ID = (jTable.getModel().getValueAt(i, 0)).toString();
					jTextField_id_subestacoes.setText(ID);
					jComboBox_subestacao.setEnabled(true);
					Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
					ArrayList<Perguntastb> pergunta = perguntasmetodos.getPerguntasporID(Integer.parseInt(ID));
					Autores_metodos autoresmetodos = new Autores_metodos();
					jTextPane.setText(pergunta.get(0).getEnunciado_PerguntasTB());
					jTextField_repostaa.setText(pergunta.get(0).getResposta_a_PerguntasTB());
					jTextField_repostab.setText(pergunta.get(0).getResposta_b_PerguntasTB());
					jTextField_repostac.setText(pergunta.get(0).getResposta_c_PerguntasTB());
					jTextField_repostad.setText(pergunta.get(0).getResposta_d_PerguntasTB());
					jTextField_repostae.setText(pergunta.get(0).getResposta_e_PerguntasTB());
					jTextField_repostaf.setText(pergunta.get(0).getResposta_f_PerguntasTB());
					jTextField_repostag.setText(pergunta.get(0).getResposta_g_PerguntasTB());
					//combo box subestação
					int iddasubestacao = pergunta.get(0).getSubestacaoTBTB_id_SubestacaoTB();
					String nomedasubestacao = autoresmetodos.retornaSubestação(iddasubestacao);
					Subaux sub1 = new Subaux();
					sub1.setCidade(nomedasubestacao);
					sub1.setUf(Integer.toString(iddasubestacao));
					//combo box autores
					int iddoautor = pergunta.get(0).getAutorTBTB_id_AutorTB();
					String nomedoautor = perguntasmetodos.retornaNomedoAutor(iddoautor);
					Subaux sub2 = new Subaux();
					sub2.setCidade(nomedoautor);
					sub2.setUf(Integer.toString(iddoautor));
					//combo box assuntos
					int iddoassunto = pergunta.get(0).getAssuntoTBTB_id_AssuntoTB();
					String descricaodoassunto = perguntasmetodos.retornaAssunto(iddoassunto);
					Subaux sub3 = new Subaux();
					sub3.setCidade(descricaodoassunto);
					sub3.setUf(Integer.toString(iddoassunto));
					//combo box figuras
					int iddafigura = pergunta.get(0).getId_figuratb();
					String descricaodafigura = perguntasmetodos.retornaDescricadaFigura(iddafigura);
					Subaux sub4 = new Subaux();
					sub4.setCidade(descricaodafigura);
					sub4.setUf(Integer.toString(iddafigura));
					//combo resposta correta
					String correta = pergunta.get(0).getCorreta_PerguntasTB();
					//
					atualizaroCombocomvariavel(sub1, sub2, sub3, sub4, correta);
					AbilitaCampos();
				}
			});
			jTable.setDefaultRenderer(Object.class, new CellRenderer());
		

		}
		return jTable;
	}

	/**
	 * This method initializes jPanelinferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelinferior() {
		if (jPanelinferior == null) {
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 6;
			gridBagConstraints38.anchor = GridBagConstraints.WEST;
			gridBagConstraints38.fill = GridBagConstraints.BOTH;
			gridBagConstraints38.gridy = 15;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints19.gridy = 15;
			gridBagConstraints19.anchor = GridBagConstraints.EAST;
			gridBagConstraints19.gridx = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 5;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.weighty = 1.0;
			gridBagConstraints8.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints8.gridx = 6;
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.fill = GridBagConstraints.BOTH;
			gridBagConstraints35.gridy = 14;
			gridBagConstraints35.weightx = 1.0;
			gridBagConstraints35.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints35.gridx = 6;
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.gridx = 0;
			gridBagConstraints34.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints34.anchor = GridBagConstraints.EAST;
			gridBagConstraints34.gridy = 14;
			jLabel_correta = new JLabel();
			jLabel_correta.setText("Resposta CORRETA:");
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.fill = GridBagConstraints.BOTH;
			gridBagConstraints33.gridy = 13;
			gridBagConstraints33.weightx = 1.0;
			gridBagConstraints33.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints33.gridx = 6;
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 0;
			gridBagConstraints32.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints32.anchor = GridBagConstraints.EAST;
			gridBagConstraints32.gridy = 13;
			jLabel_repostag = new JLabel();
			jLabel_repostag.setText("Resposta \"G\":");
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = GridBagConstraints.BOTH;
			gridBagConstraints31.gridy = 11;
			gridBagConstraints31.weightx = 1.0;
			gridBagConstraints31.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints31.gridx = 6;
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.gridx = 0;
			gridBagConstraints30.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints30.anchor = GridBagConstraints.EAST;
			gridBagConstraints30.gridy = 12;
			jLabel_repostaf = new JLabel();
			jLabel_repostaf.setText("Resposta \"F\":");
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.fill = GridBagConstraints.BOTH;
			gridBagConstraints29.gridy = 12;
			gridBagConstraints29.weightx = 1.0;
			gridBagConstraints29.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints29.gridx = 6;
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints28.anchor = GridBagConstraints.EAST;
			gridBagConstraints28.gridy = 11;
			jLabel_repostae = new JLabel();
			jLabel_repostae.setText("Resposta \"E\":");
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.fill = GridBagConstraints.BOTH;
			gridBagConstraints27.gridy = 10;
			gridBagConstraints27.weightx = 1.0;
			gridBagConstraints27.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints27.gridx = 6;
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 0;
			gridBagConstraints26.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints26.anchor = GridBagConstraints.EAST;
			gridBagConstraints26.gridy = 10;
			jLabel_repostad = new JLabel();
			jLabel_repostad.setText("Resposta \"D\":");
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.fill = GridBagConstraints.BOTH;
			gridBagConstraints25.gridy = 9;
			gridBagConstraints25.weightx = 1.0;
			gridBagConstraints25.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints25.gridx = 6;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 0;
			gridBagConstraints24.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints24.anchor = GridBagConstraints.EAST;
			gridBagConstraints24.gridy = 9;
			jLabel_repostac = new JLabel();
			jLabel_repostac.setText("Resposta \"C\":");
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.fill = GridBagConstraints.BOTH;
			gridBagConstraints23.gridy = 8;
			gridBagConstraints23.weightx = 1.0;
			gridBagConstraints23.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints23.gridx = 6;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 0;
			gridBagConstraints22.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints22.anchor = GridBagConstraints.EAST;
			gridBagConstraints22.gridy = 8;
			jLabel_repostab = new JLabel();
			jLabel_repostab.setText("Resposta \"B\":");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridy = 7;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints21.gridx = 6;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 0;
			gridBagConstraints20.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints20.anchor = GridBagConstraints.EAST;
			gridBagConstraints20.gridy = 7;
			jLabel_repostaa = new JLabel();
			jLabel_repostaa.setText("Resposta \"A\":");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints10.gridx = 6;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints18.anchor = GridBagConstraints.EAST;
			gridBagConstraints18.gridy = 5;
			jLabel_enunciado = new JLabel();
			jLabel_enunciado.setText("Enunciado:");
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.BOTH;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints17.gridx = 6;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints16.anchor = GridBagConstraints.EAST;
			gridBagConstraints16.gridy = 0;
			jLabel_assunto = new JLabel();
			jLabel_assunto.setText("Assunto:");
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			gridBagConstraints13.gridy = 2;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints13.gridx = 6;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.gridy = 1;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 4;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 6;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints9.gridy = 1;
			gridBagConstraints9.anchor = GridBagConstraints.EAST;
			gridBagConstraints9.gridx = 0;
			jLabel_nomecontroladora = new JLabel();
			jLabel_nomecontroladora.setText("Autor:");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints6.gridy = 2;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 0;
			jLabel_subestacaonome = new JLabel();
			jLabel_subestacaonome.setText("Subestação:");
			jPanelinferior = new JPanel();
			jPanelinferior.setLayout(new GridBagLayout());
			jPanelinferior.add(jLabel_subestacaonome, gridBagConstraints6);
			jPanelinferior.add(jLabel_nomecontroladora, gridBagConstraints9);
			jPanelinferior.add(getJTextField_id_subestacoes(), gridBagConstraints11);
			jPanelinferior.add(getJComboBox_subestacao(), gridBagConstraints13);
			jPanelinferior.add(jLabel_assunto, gridBagConstraints16);
			jPanelinferior.add(getJComboBox_assunto(), gridBagConstraints17);
			jPanelinferior.add(jLabel_enunciado, gridBagConstraints18);
			jPanelinferior.add(getJComboBox_autor(), gridBagConstraints10);
			jPanelinferior.add(jLabel_repostaa, gridBagConstraints20);
			jPanelinferior.add(getJTextField_repostaa(), gridBagConstraints21);
			jPanelinferior.add(jLabel_repostab, gridBagConstraints22);
			jPanelinferior.add(getJTextField_repostab(), gridBagConstraints23);
			jPanelinferior.add(jLabel_repostac, gridBagConstraints24);
			jPanelinferior.add(getJTextField_repostac(), gridBagConstraints25);
			jPanelinferior.add(jLabel_repostad, gridBagConstraints26);
			jPanelinferior.add(getJTextField_repostad(), gridBagConstraints27);
			jPanelinferior.add(jLabel_repostae, gridBagConstraints28);
			jPanelinferior.add(getJTextField_repostaf(), gridBagConstraints29);
			jPanelinferior.add(jLabel_repostaf, gridBagConstraints30);
			jPanelinferior.add(getJTextField_repostae(), gridBagConstraints31);
			jPanelinferior.add(jLabel_repostag, gridBagConstraints32);
			jPanelinferior.add(getJTextField_repostag(), gridBagConstraints33);
			jPanelinferior.add(jLabel_correta, gridBagConstraints34);
			jPanelinferior.add(getJComboBox_correta(), gridBagConstraints35);
			jPanelinferior.add(getjScrollingpane(), gridBagConstraints8);
			jPanelinferior.add(getLabelFigura(), gridBagConstraints19);
			jPanelinferior.add(getJPanel_combo_figura(), gridBagConstraints38);
		}
		return jPanelinferior;
	}

	/**
	 * This method initializes jPanel_botoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_botoes() {
		if (jPanel_botoes == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.BOTH;
			gridBagConstraints15.gridy = 1;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints15.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridx = -1;
			gridBagConstraints7.gridy = -1;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.gridx = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.gridx = 2;
			jPanel_botoes = new JPanel();
			jPanel_botoes.setLayout(new GridBagLayout());
			jPanel_botoes.add(getJButton_Atualizar(), gridBagConstraints1);
			jPanel_botoes.add(getJButton_Apagar(), gridBagConstraints2);
			jPanel_botoes.add(getJButton_salvar(), gridBagConstraints3);
			jPanel_botoes.add(getJButton_novo(), gridBagConstraints5);
			jPanel_botoes.add(getJButton_sair(), gridBagConstraints12);
		}
		return jPanel_botoes;
	}

	/**
	 * This method initializes jButton_Atualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Atualizar() {
		if (jButton_Atualizar == null) {
			jButton_Atualizar = new JButton();
			jButton_Atualizar.setText("Atualizar");
			jButton_Atualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextPane.getText().equals("") || jTextPane.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campo 'Enunciado' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jTextField_repostaa.getText().equals("") || jTextField_repostaa.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campo 'Resposta A' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							if(jTextField_repostab.getText().equals("") || jTextField_repostab.getText().equals(null)){
								JOptionPane.showMessageDialog(null,"Campo 'Resposta B' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
							}else{
								Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
								Subaux combo_assuntos = (Subaux)jComboBox_assunto.getSelectedItem();
								Subaux combo_autores = (Subaux)jComboBox_autor.getSelectedItem();
								Subaux combo_subestacoes = (Subaux)jComboBox_subestacao.getSelectedItem();
								Subaux combo_figuras = (Subaux)jComboBox_figura.getSelectedItem();
								Perguntastb perguntastb = new Perguntastb(Integer.parseInt(jTextField_id_subestacoes.getText()), Integer.parseInt(combo_assuntos.getUf()), Integer.parseInt(combo_autores.getUf()),
								Integer.parseInt(combo_subestacoes.getUf()), Integer.parseInt(combo_figuras.getUf()), jTextPane.getText(), jTextField_repostaa.getText(), 
								jTextField_repostab.getText(), jTextField_repostac.getText(), jTextField_repostad.getText(), 
								jTextField_repostae.getText(), jTextField_repostaf.getText(), jTextField_repostag.getText(), 
								jComboBox_correta.getSelectedItem().toString());
								perguntasmetodos.atualizar_registroJtable(perguntastb);
								AtualizarJTable();
								jButton_Atualizar.setEnabled(false);
								jButton_Apagar.setEnabled(false);
								LimpareDesabilitarCampos();
							}
						}
					}	
				}
			});

		}
		return jButton_Atualizar;
	}

	/**
	 * This method initializes jButton_Apagar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Apagar() {
		if (jButton_Apagar == null) {
			jButton_Apagar = new JButton();
			jButton_Apagar.setText("Apagar");
			jButton_Apagar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int i = JOptionPane.showConfirmDialog(null ,"Realmente deseja excluir o registro N° "+jTextField_id_subestacoes.getText(),
							"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
					if(i == 0){	
						Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
						perguntasmetodos.apagar_registroJtable(Integer.parseInt(jTextField_id_subestacoes.getText()));
						jButton_Atualizar.setEnabled(false);
						jButton_Apagar.setEnabled(false);
						LimpareDesabilitarCampos();
						AtualizarJTable();
					}
				}
			});

		}
		return jButton_Apagar;
	}

	/**
	 * This method initializes jButton_salvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_salvar() {
		if (jButton_salvar == null) {
			jButton_salvar = new JButton();
			jButton_salvar.setPreferredSize(new Dimension(75, 26));
			jButton_salvar.setText("Salvar");
			jButton_salvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextPane.getText().equals("") || jTextPane.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campo 'Enunciado' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jTextField_repostaa.getText().equals("") || jTextField_repostaa.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campo 'Resposta A' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							if(jTextField_repostab.getText().equals("") || jTextField_repostab.getText().equals(null)){
								JOptionPane.showMessageDialog(null,"Campo 'Resposta B' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
							}else{
								Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
								Subaux combo_assuntos = (Subaux)jComboBox_assunto.getSelectedItem();
								Subaux combo_autores = (Subaux)jComboBox_autor.getSelectedItem();
								Subaux combo_subestacoes = (Subaux)jComboBox_subestacao.getSelectedItem();
								Subaux combo_figuras = (Subaux)jComboBox_figura.getSelectedItem();
								int i=0;
								Perguntastb perguntastb = new Perguntastb(i, Integer.parseInt(combo_assuntos.getUf()), Integer.parseInt(combo_autores.getUf()),
								Integer.parseInt(combo_subestacoes.getUf()), Integer.parseInt(combo_figuras.getUf()), jTextPane.getText(), jTextField_repostaa.getText(), 
								jTextField_repostab.getText(), jTextField_repostac.getText(), jTextField_repostad.getText(), 
								jTextField_repostae.getText(), jTextField_repostaf.getText(), jTextField_repostag.getText(), 
								jComboBox_correta.getSelectedItem().toString());
								perguntasmetodos.Salvar_novo_registroJtable(perguntastb);
								LimpareDesabilitarCampos();
								AtualizarJTable();
								jButton_salvar.setEnabled(false);
							}
						}
					}
				}
			});

		}
		return jButton_salvar;
	}

	/**
	 * This method initializes jButton_novo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_novo() {
		if (jButton_novo == null) {
			jButton_novo = new JButton();
			jButton_novo.setPreferredSize(new Dimension(75, 26));
			jButton_novo.setText("Novo");
			jButton_novo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LimpaeAbilitaCampos();
					jButton_salvar.setEnabled(true);
					atualizaroComboBox();
				}
			});

		}
		return jButton_novo;
	}

	/**
	 * This method initializes jButton_sair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_sair() {
		if (jButton_sair == null) {
			jButton_sair = new JButton();
			jButton_sair.setPreferredSize(new Dimension(75, 26));
			jButton_sair.setText("Fechar");
			jButton_sair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Perguntas.this.dispose();
				}
			});

		}
		return jButton_sair;
	}

	/**
	 * This method initializes jTextField_id_subestacoes	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_id_subestacoes() {
		if (jTextField_id_subestacoes == null) {
			jTextField_id_subestacoes = new JTextField();
			jTextField_id_subestacoes.setVisible(false);
		}
		return jTextField_id_subestacoes;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private void atualizaroCombocomvariavel(Subaux sub1, Subaux sub2, Subaux sub3, Subaux sub4, String correta){
	     //System.out.println(sub4.getCidade()+sub4.getUf());
		 if(correta.equals("A")){
			 jComboBox_correta.setSelectedIndex(0);
		 }
		 if(correta.equals("B")){
			 jComboBox_correta.setSelectedIndex(1);
		 }
		 if(correta.equals("C")){
			 jComboBox_correta.setSelectedIndex(2);
		 }
		 if(correta.equals("D")){
			 jComboBox_correta.setSelectedIndex(3);
		 }
		 if(correta.equals("E")){
			 jComboBox_correta.setSelectedIndex(4);
		 }
		 if(correta.equals("F")){
			 jComboBox_correta.setSelectedIndex(5);
		 }
		 if(correta.equals("G")){
			 jComboBox_correta.setSelectedIndex(6);
		 }
		try {
			jComboBox_assunto.removeAllItems();
	        PreparedStatement stmt = con.prepareStatement("select * from assuntotb where id_AssuntoTB<>?");
	        stmt.setInt(1, Integer.parseInt(sub3.getUf()));
	        ResultSet rs = stmt.executeQuery();
	        if ( rs.next() ) {
	        	jComboBox_assunto.addItem(sub3);
	        	do{
	        		String a = rs.getString("descricaoid_AssuntoTB");
					String b = rs.getString("id_AssuntoTB");
	        		jComboBox_assunto.addItem(new Subaux(a, b));
	        	}
	    		while( rs.next() );{}
	        }
	       rs.close();
	       stmt.close();
		} catch (SQLException e) {
			Mensagens me = new Mensagens();
			me.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
		try {
			jComboBox_autor.removeAllItems();
	        PreparedStatement stmt = con.prepareStatement("select * from autortb where id_AutorTB<>?");
	        stmt.setInt(1, Integer.parseInt(sub2.getUf()));
	        ResultSet rs = stmt.executeQuery();
	        if ( rs.next() ) {
	        	jComboBox_autor.addItem(sub2);
	        	do{
	        		String a = rs.getString("nome_AutorTB");
					String b = rs.getString("id_AutorTB");
	        		jComboBox_autor.addItem(new Subaux(a, b));
	        	}
	    		while( rs.next() );{}
	        }
	       rs.close();
	       stmt.close();
		} catch (SQLException e) {
			Mensagens me = new Mensagens();
			me.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
		try {
			jComboBox_subestacao.removeAllItems();
	        PreparedStatement stmt = con.prepareStatement("select * from subestacaotb where id_SubestacaoTB<>?");
	        stmt.setInt(1, Integer.parseInt(sub2.getUf()));
	        ResultSet rs = stmt.executeQuery();
	        if ( rs.next() ) {
	        	jComboBox_subestacao.addItem(sub1);
	        	do{
	        		String a = rs.getString("nomeid_SubestacaoTB");
	        		String b = rs.getString("id_SubestacaoTB");
	        		jComboBox_subestacao.addItem(new Subaux(a, b));
	        	}
	    		while( rs.next() );{}
	        }
	       rs.close();
	       stmt.close();
		} catch (SQLException e) {
			Mensagens me = new Mensagens();
			me.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
		try {
			//System.out.println("entro no try da figura");
			jComboBox_figura.removeAllItems();
			jComboBox_figura.addItem(sub4);
			/*if(sub4.getUf()!="0"){
				jComboBox_figura.addItem(new Subaux("", "0"));
			}*/
	        PreparedStatement stmt = con.prepareStatement("select * from figurastb where id_figura<>?");
	        stmt.setInt(1, Integer.parseInt(sub4.getUf()));
	        ResultSet rs = stmt.executeQuery();
	        if ( rs.next() ) {
	        	//System.out.println("Rone :"+sub4.getCidade()+sub4.getUf());
	        	do{
	        		String a = rs.getString("descricao");
	        		String b = rs.getString("id_figura");
	        		jComboBox_figura.addItem(new Subaux(a, b));
	        	}
	    		while( rs.next() );{}
	        }else{
	        	jComboBox_figura.addItem(new Subaux("", "0"));
	        }
	       rs.close();
	       stmt.close();
		} catch (SQLException e) {
			Mensagens me = new Mensagens();
			me.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
	}
	private void atualizaroComboBox(){
		jComboBox_correta.removeAllItems();
		String[] modelo = new String[]{"A", "B", "C", "D", "E", "F", "G"};
		jComboBox_correta.addItem(modelo[0]);
		jComboBox_correta.addItem(modelo[1]);
		jComboBox_correta.addItem(modelo[2]);
		jComboBox_correta.addItem(modelo[3]);
		jComboBox_correta.addItem(modelo[4]);
		jComboBox_correta.addItem(modelo[5]);
		jComboBox_correta.addItem(modelo[6]);
		try {
			jComboBox_assunto.removeAllItems();
	        PreparedStatement stmt1 = con.prepareStatement("select * from assuntotb");
	        ResultSet rs1 = stmt1.executeQuery();
	        if ( rs1.next() ) {
	        	do{
	        		String a = rs1.getString("descricaoid_AssuntoTB");
	        		String b = rs1.getString("id_AssuntoTB");
	        		jComboBox_assunto.addItem(new Subaux(a, b));
	        	}
	    		while( rs1.next() );{}
	        }
	       rs1.close();
	       stmt1.close();
	       jComboBox_autor.removeAllItems();
	        PreparedStatement stmt2 = con.prepareStatement("select * from autortb");
	        ResultSet rs2 = stmt2.executeQuery();
	        if ( rs2.next() ) {
	        	do{
	        		String a = rs2.getString("nome_AutorTB");
	        		String b = rs2.getString("id_AutorTB");
	        		jComboBox_autor.addItem(new Subaux(a, b));
	        	}
	    		while( rs2.next() );{}
	        }
	       rs2.close();
	       stmt2.close();
			jComboBox_subestacao.removeAllItems();
	        PreparedStatement stmt = con.prepareStatement("select * from subestacaotb");
	        ResultSet rs = stmt.executeQuery();
	        if ( rs.next() ) {
	        	do{
	        		String a = rs.getString("nomeid_SubestacaoTB");
	        		String b = rs.getString("id_SubestacaoTB");
	        		jComboBox_subestacao.addItem(new Subaux(a, b));
	        	}
	    		while( rs.next() );{}
	        }
	       rs.close();
	       stmt.close();
	       jComboBox_figura.removeAllItems();
	       PreparedStatement stmt3 = con.prepareStatement("select * from figurastb");
	       ResultSet rs3 = stmt3.executeQuery();
				if ( rs3.next() ) {
					jComboBox_figura.addItem(new Subaux("", "0"));
					do{
						String a = rs3.getString("descricao");
						String b = rs3.getString("id_figura");
						jComboBox_figura.addItem(new Subaux(a, b));
					}
					while( rs3.next() );{}
				}
	      rs3.close();
	      stmt3.close();
		} catch (SQLException e) {
			Mensagens me = new Mensagens();
			me.MensagemdeErro(e.toString());
			e.printStackTrace();
		}
	}
	private JComboBox getJComboBox_subestacao() {
		if (jComboBox_subestacao == null) {
			//jComboBox_subestacao = new JComboBox();
			try {
				Autores_metodos autoresmetodos = new Autores_metodos();
				jComboBox_subestacao = autoresmetodos.PreencheojCombobox();
				//jComboBox.setModel(autoresmetodos.PreencheojComboboxComModel());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jComboBox_subestacao;
	}

	/**
	 * This method initializes jComboBox_assunto	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_assunto() {
		if (jComboBox_assunto == null) {
			try {
				Perguntas_metodos perguntasmetodos = new Perguntas_metodos();
				jComboBox_assunto = perguntasmetodos.PreencheojComboboxcomAssuntos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jComboBox_assunto;
	}

	/**
	 * This method initializes jComboBox_autor	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_autor() {
		if (jComboBox_autor == null) {
			try {
				Perguntas_metodos autoresmetodos = new Perguntas_metodos();
				jComboBox_autor = autoresmetodos.PreencheojComboboxcomAutores();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jComboBox_autor;
	}

	/**
	 * This method initializes jTextField_repostaa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostaa() {
		if (jTextField_repostaa == null) {
			jTextField_repostaa = new JTextField();
		}
		return jTextField_repostaa;
	}

	/**
	 * This method initializes jTextField_repostab	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostab() {
		if (jTextField_repostab == null) {
			jTextField_repostab = new JTextField();
		}
		return jTextField_repostab;
	}

	/**
	 * This method initializes jTextField_repostac	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostac() {
		if (jTextField_repostac == null) {
			jTextField_repostac = new JTextField();
		}
		return jTextField_repostac;
	}

	/**
	 * This method initializes jTextField_repostad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostad() {
		if (jTextField_repostad == null) {
			jTextField_repostad = new JTextField();
		}
		return jTextField_repostad;
	}

	/**
	 * This method initializes jTextField_repostaf	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostaf() {
		if (jTextField_repostaf == null) {
			jTextField_repostaf = new JTextField();
		}
		return jTextField_repostaf;
	}

	/**
	 * This method initializes jTextField_repostae	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostae() {
		if (jTextField_repostae == null) {
			jTextField_repostae = new JTextField();
		}
		return jTextField_repostae;
	}

	/**
	 * This method initializes jTextField_repostag	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_repostag() {
		if (jTextField_repostag == null) {
			jTextField_repostag = new JTextField();
		}
		return jTextField_repostag;
	}

	/**
	 * This method initializes jComboBox_correta	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_correta() {
		if (jComboBox_correta == null) {
			String[] modelo = new String[]{"A", "B", "C", "D", "E", "F", "G"};
			jComboBox_correta = new JComboBox();
			jComboBox_correta.addItem(modelo[0]);
			jComboBox_correta.addItem(modelo[1]);
			jComboBox_correta.addItem(modelo[2]);
			jComboBox_correta.addItem(modelo[3]);
			jComboBox_correta.addItem(modelo[4]);
			jComboBox_correta.addItem(modelo[5]);
			jComboBox_correta.addItem(modelo[6]);
		}
		return jComboBox_correta;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextArea getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextArea();
			jTextPane.setLineWrap(true);
			jTextPane.setWrapStyleWord(true);
			jTextPane.setAutoscrolls(true);
		}
		return jTextPane;
	}
	private JScrollPane getjScrollingpane(){
		if (scrolingarea == null){
			scrolingarea = new JScrollPane(getJTextPane());
		}
	return scrolingarea;
	}

	/**
	 * This method initializes jPanel_figura	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JLabel getLabelFigura() {
		if (jLabel_figura == null) {
			jLabel_figura = new JLabel();
			jLabel_figura.setText("Figura:");
		}
		return jLabel_figura;
	}

	/**
	 * This method initializes jComboBox_figura	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox_figura() {
		if (jComboBox_figura == null) {
			try {
				Figuras_Metodos metodos = new Figuras_Metodos();
				jComboBox_figura = metodos.PreencheojCombobox();
				//jComboBox.setModel(autoresmetodos.PreencheojComboboxComModel());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//jComboBox_figura.setPreferredSize(new Dimension(230, 25));
			jComboBox_figura.setEnabled(false);
		}
		return jComboBox_figura;
	}

	/**
	 * This method initializes jButton_mostrar_figura	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_mostrar_figura() {
		if (jButton_mostrar_figura == null) {
			jButton_mostrar_figura = new JButton();
			jButton_mostrar_figura.setText("Mostrar");
			jButton_mostrar_figura.setEnabled(false);
			jButton_mostrar_figura.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Subaux combo_figuras = (Subaux)jComboBox_figura.getSelectedItem();
					Figura figura = new Figura(Integer.parseInt(combo_figuras.getUf()));
					figura.setVisible(true);
				}
			});
		}
		return jButton_mostrar_figura;
	}

	/**
	 * This method initializes jPanel_combo_figura	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_combo_figura() {
		if (jPanel_combo_figura == null) {
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.insets = new Insets(0, 10, 0, 10);
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.fill = GridBagConstraints.BOTH;
			gridBagConstraints36.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints36.weightx = 1.0;
			jPanel_combo_figura = new JPanel();
			jPanel_combo_figura.setLayout(new GridBagLayout());
			jPanel_combo_figura.add(getJComboBox_figura(), gridBagConstraints36);
			jPanel_combo_figura.add(getJButton_mostrar_figura(), gridBagConstraints37);
		}
		return jPanel_combo_figura;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
