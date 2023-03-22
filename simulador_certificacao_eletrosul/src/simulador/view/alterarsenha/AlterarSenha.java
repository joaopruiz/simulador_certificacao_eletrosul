package simulador.view.alterarsenha;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import simulador.mode.usuarios.Usuarios_metodos;
import simulador.mode.usuarios.Usuariotb;
import simulador.model.autores.Subaux;
import simulador.view.JanelaPai;
import simulador.view.teste.Md5;

public class AlterarSenha extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelinferior = null;
	private JPanel jPanel_botoes = null;
	private JButton jButton_Atualizar = null;
	private JButton jButton_sair = null;
	private JTextField jTextField_id_subestacoes = null;
	private JPasswordField jPasswordField_senha = null;
	private JLabel jLabel_senha = null;
	private JLabel jLabel_redsenha = null;
	private JPasswordField jPasswordField_redsenha = null;
	private static JanelaPai telapai;

	/**
	 * @param owner
	 */
	public AlterarSenha(JanelaPai tela) {
		super();
		telapai = tela;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(423, 207);
		this.setTitle("Simulação Certificação - Alterar Senha");
		this.setContentPane(getJContentPane());
		this.getRootPane().setDefaultButton(jButton_Atualizar);
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanelinferior(), BorderLayout.NORTH);
		}
		return jContentPane;
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
			gridBagConstraints19.gridx = 1;
			gridBagConstraints19.gridy = 2;
			gridBagConstraints19.weightx = 1.0;
			gridBagConstraints19.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.anchor = GridBagConstraints.EAST;
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 2;
			gridBagConstraints18.insets = new Insets(10, 10, 10, 10);
			jLabel_redsenha = new JLabel();
			jLabel_redsenha.setText("Redigite a senha:");
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.anchor = GridBagConstraints.EAST;
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.gridy = 1;
			gridBagConstraints17.insets = new Insets(20, 10, 10, 10);
			jLabel_senha = new JLabel();
			jLabel_senha.setText("Senha:");
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridx = 1;
			gridBagConstraints16.gridy = 1;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.insets = new Insets(20, 10, 10, 10);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 4;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 5;
			jPanelinferior = new JPanel();
			jPanelinferior.setLayout(new GridBagLayout());
			jPanelinferior.add(getJPanel_botoes(), gridBagConstraints8);
			jPanelinferior.add(getJTextField_id_subestacoes(), gridBagConstraints11);
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
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints12.gridy = 1;
			gridBagConstraints12.gridx = 4;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.gridx = 2;
			jPanel_botoes = new JPanel();
			jPanel_botoes.setLayout(new GridBagLayout());
			jPanel_botoes.add(getJButton_Atualizar(), gridBagConstraints1);
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
								sub1.AlterarSenhausuario(md5.converterpraMD5(jPasswordField_senha.getText()), telapai.id_usuario);
								AlterarSenha.this.dispose();
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
					AlterarSenha.this.dispose();
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
