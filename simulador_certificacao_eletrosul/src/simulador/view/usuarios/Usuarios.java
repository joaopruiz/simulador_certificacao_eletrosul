package simulador.view.usuarios;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import simulador.dao.Conexao;
import simulador.mode.usuarios.Usuarios_metodos;
import simulador.mode.usuarios.Usuariotb;
import simulador.model.autores.Autores_metodos;
import simulador.model.autores.Autortb;
import simulador.model.autores.Subaux;
import simulador.view.CellRenderer;
import simulador.view.teste.Md5;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class Usuarios extends JDialog {

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
	private JTextField jTextField_nomecontroladoratxt = null;
	private JTextField jTextField_id_subestacoes = null;
	private JComboBox jComboBox = null;
	private Connection con;  //  @jve:decl-index=0:
	private JPasswordField jPasswordField_senha = null;
	private JLabel jLabel_senha = null;
	private JLabel jLabel_redsenha = null;
	private JPasswordField jPasswordField_redsenha = null;
	/**
	 * @param owner
	 */
	public Usuarios(Frame owner) {
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
		this.setSize(new Dimension(774, 647));
		this.setTitle("Simulador de Certificações - Usuários");
		this.setLocationRelativeTo(null);
		AtualizarJTable();
		jButton_Apagar.setEnabled(false);
		jButton_salvar.setEnabled(false);
		jButton_Atualizar.setEnabled(false);
		jButton_Apagar.setEnabled(false);
		jComboBox.setEnabled(false);
		LimpareDesabilitarCampos();
		atualizaroComboBox();
		this.getRootPane().setDefaultButton(jButton_salvar);
	}

	/**
	 * This method initializes SubestacoesDialog	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private void AtualizarJTable(){
		try {
			Usuarios_metodos sub1 = new Usuarios_metodos();
			jTable.setModel(sub1.PreencheraJtable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void LimpareDesabilitarCampos(){
		jTextField_id_subestacoes.setText("");
		jTextField_nomecontroladoratxt.setText("");
		jPasswordField_senha.setText("");
		jPasswordField_senha.setEnabled(false);
		jPasswordField_redsenha.setText("");
		jPasswordField_redsenha.setEnabled(false);
		jTextField_nomecontroladoratxt.setEnabled(false);
		jComboBox.setEnabled(false);
	}
	private JPanel getSubestacoesDialog() {
		if (SubestacoesDialog == null) {
			SubestacoesDialog = new JPanel();
			SubestacoesDialog.setLayout(new BorderLayout());
			SubestacoesDialog.add(getJPanelSubestacoes(), java.awt.BorderLayout.CENTER);
			SubestacoesDialog.add(getJPanelinferior(), java.awt.BorderLayout.SOUTH);
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
					jTextField_nomecontroladoratxt.setEnabled(true);
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					jPasswordField_senha.setEnabled(true);
					jPasswordField_redsenha.setEnabled(true);
					int i = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(i, 0)).toString();
					String b = (jTable.getModel().getValueAt(i, 1)).toString();
					//String c = (jTable.getModel().getValueAt(i, 2)).toString();
					jTextField_id_subestacoes.setText(a);
					jTextField_nomecontroladoratxt.setText(b);
					Usuarios_metodos usuarios = new Usuarios_metodos();
					jPasswordField_senha.setText(usuarios.RetornaaSenha(Integer.parseInt(a)));
					jPasswordField_redsenha.setText(jPasswordField_senha.getText());
					jComboBox.setEnabled(true);
					String c = (jTable.getModel().getValueAt(i, 2)).toString();
					atualizaroCombocomvariavel(c);
					
				}
			});
			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextField_nomecontroladoratxt.setEnabled(true);
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					jPasswordField_senha.setEnabled(true);
					int i = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(i, 0)).toString();
					String b = (jTable.getModel().getValueAt(i, 1)).toString();
					//String c = (jTable.getModel().getValueAt(i, 2)).toString();
					jTextField_id_subestacoes.setText(a);
					jTextField_nomecontroladoratxt.setText(b);
					Usuarios_metodos usuarios = new Usuarios_metodos();
					jPasswordField_senha.setText(usuarios.RetornaaSenha(Integer.parseInt(a)));
					jComboBox.setEnabled(true);
					String c = (jTable.getModel().getValueAt(i, 2)).toString();
					atualizaroCombocomvariavel(c);
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
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.fill = GridBagConstraints.BOTH;
			gridBagConstraints19.gridy = 2;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.insets = new Insets(10, 10, 10, 264);
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints18.anchor = GridBagConstraints.EAST;
			gridBagConstraints18.gridy = 2;
			jLabel_redsenha = new JLabel();
			jLabel_redsenha.setText("Redigite a senha:");
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.anchor = GridBagConstraints.EAST;
			gridBagConstraints17.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints17.gridy = 1;
			jLabel_senha = new JLabel();
			jLabel_senha.setText("Senha:");
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 1;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.insets = new Insets(10, 10, 10, 264);
			gridBagConstraints16.gridx = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			gridBagConstraints13.gridy = 3;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(10, 10, 10, 388);
			gridBagConstraints13.gridx = 1;
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
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridx = 1;
			gridBagConstraints10.gridy = 0;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.insets = new Insets(10, 10, 10, 264);
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.anchor = GridBagConstraints.EAST;
			gridBagConstraints9.gridx = 0;
			jLabel_nomecontroladora = new JLabel();
			jLabel_nomecontroladora.setText("Usuário:");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 5;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints6.gridy = 3;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 0;
			jLabel_subestacaonome = new JLabel();
			jLabel_subestacaonome.setText("Perfil:");
			jPanelinferior = new JPanel();
			jPanelinferior.setLayout(new GridBagLayout());
			jPanelinferior.add(jLabel_subestacaonome, gridBagConstraints6);
			jPanelinferior.add(getJPanel_botoes(), gridBagConstraints8);
			jPanelinferior.add(jLabel_nomecontroladora, gridBagConstraints9);
			jPanelinferior.add(getJTextField_nomecontroladoratxt(), gridBagConstraints10);
			jPanelinferior.add(getJTextField_id_subestacoes(), gridBagConstraints11);
			jPanelinferior.add(getJComboBox(), gridBagConstraints13);
			jPanelinferior.add(getJPasswordField_senha(), gridBagConstraints16);
			jPanelinferior.add(jLabel_senha, gridBagConstraints17);
			jPanelinferior.add(jLabel_redsenha, gridBagConstraints18);
			jPanelinferior.add(getJPasswordField_redsenha(), gridBagConstraints19);
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
					if(jPasswordField_senha.getText().equals("") || jPasswordField_senha.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jPasswordField_redsenha.getText().equals("") || jPasswordField_redsenha.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							if(jPasswordField_senha.getText().equals(jPasswordField_redsenha.getText())){
								Md5 md5 = new Md5();
								Usuarios_metodos sub1 = new Usuarios_metodos();
								Subaux sub = (Subaux)jComboBox.getSelectedItem();
								Usuariotb usuariotb= new Usuariotb(Integer.parseInt(jTextField_id_subestacoes.getText()), jTextField_nomecontroladoratxt.getText(), md5.converterpraMD5(jPasswordField_senha.getText()), Integer.parseInt(sub.getUf()));
								sub1.atualizar_registroJtable(usuariotb);
								jButton_Atualizar.setEnabled(false);
								jButton_Apagar.setEnabled(false);
								LimpareDesabilitarCampos();
								AtualizarJTable();
							}else{
								JOptionPane.showMessageDialog(null,"As senhas não conferem. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
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
					Usuarios_metodos sub1 = new Usuarios_metodos();
						sub1.apagar_registroJtable(Integer.parseInt(jTextField_id_subestacoes.getText()));
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
					if(jPasswordField_senha.getText().equals("") || jPasswordField_senha.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jPasswordField_redsenha.getText().equals("") || jPasswordField_redsenha.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							if(jPasswordField_senha.getText().equals(jPasswordField_redsenha.getText())){
								Md5 md5 = new Md5();
								Usuarios_metodos sub1 = new Usuarios_metodos();
								Subaux sub = (Subaux)jComboBox.getSelectedItem();
								int i=0;
								Usuariotb usuariotb = new Usuariotb(i, jTextField_nomecontroladoratxt.getText(), md5.converterpraMD5(jPasswordField_senha.getText()), Integer.parseInt(sub.getUf()));
								sub1.Salvar_novo_registroJtable(usuariotb);
								LimpareDesabilitarCampos();
								AtualizarJTable();
								jButton_salvar.setEnabled(false);
							}else{
								JOptionPane.showMessageDialog(null,"As senhas não conferem. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
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
					jTextField_nomecontroladoratxt.setEnabled(true);
					jButton_salvar.setEnabled(true);
					jButton_Atualizar.setEnabled(false);
					jButton_Apagar.setEnabled(false);
					jComboBox.setEnabled(true);
					jTextField_id_subestacoes.setText("");
					jTextField_nomecontroladoratxt.setText("");
					jPasswordField_senha.setText("");
					jPasswordField_senha.setEnabled(true);
					jPasswordField_redsenha.setText("");
					jPasswordField_redsenha.setEnabled(true);
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
					Usuarios.this.dispose();
				}
			});

		}
		return jButton_sair;
	}

	/**
	 * This method initializes jTextField_nomecontroladoratxt	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_nomecontroladoratxt() {
		if (jTextField_nomecontroladoratxt == null) {
			jTextField_nomecontroladoratxt = new JTextField();
		}
		return jTextField_nomecontroladoratxt;
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
	private void atualizaroCombocomvariavel(String d){
			int c = Integer.parseInt(d);
			jComboBox.removeAllItems();
			if(c==1){
				jComboBox.addItem(new Subaux("USUÁRIOS", "1"));
				jComboBox.addItem(new Subaux("ADMINISTRADOR", "2"));
			}
			if(c==2){
				jComboBox.addItem(new Subaux("ADMINISTRADOR", "2"));
				jComboBox.addItem(new Subaux("USUÁRIOS", "1"));
			}
	}
	private void atualizaroComboBox(){
			jComboBox.removeAllItems();
			jComboBox.addItem(new Subaux("USUÁRIOS", "1"));
			jComboBox.addItem(new Subaux("ADMINISTRADOR", "2"));
	}
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
		}
		return jComboBox;
	}

	/**
	 * This method initializes jPasswordField_senha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_senha() {
		if (jPasswordField_senha == null) {
			jPasswordField_senha = new JPasswordField();
		}
		return jPasswordField_senha;
	}

	/**
	 * This method initializes jPasswordField_redsenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField_redsenha() {
		if (jPasswordField_redsenha == null) {
			jPasswordField_redsenha = new JPasswordField();
		}
		return jPasswordField_redsenha;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
