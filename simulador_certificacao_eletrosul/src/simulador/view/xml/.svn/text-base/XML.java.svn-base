package simulador.view.xml;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import simulador.dao.xml.Configuracao_xml;
import simulador.dao.xml.Server_xml;
import javax.swing.JPasswordField;

public class XML extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_center = null;
	private JPanel jPanel_inferior = null;
	private JButton jButton_salvar = null;
	private JButton jButton_sair = null;
	private JLabel jLabel_user = null;
	private JLabel jLabel_password = null;
	private JLabel jLabel_url = null;
	private JLabel jLabel_driver = null;
	private JTextField jTextField_user = null;
	private JTextField jTextField_url = null;
	private JTextField jTextField_driver = null;
	private JPasswordField jPasswordField = null;

	/**
	 * @param owner
	 */
	public XML() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(634, 394);
		this.setContentPane(getJContentPane());
		this.setTitle("Simulador de Certificação - Gerenciar Conexão com o Banco de Dados");
		PreencherosCampos();
		this.getRootPane().setDefaultButton(jButton_salvar);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private void PreencherosCampos(){
		Configuracao_xml server = new Configuracao_xml();
		try {
			Server_xml s1 = server.LeroXml();
			jTextField_user.setText(s1.getUser());
			jPasswordField.setText(s1.getPassword());
			jTextField_url.setText(s1.getUrl());
			jTextField_driver.setText(s1.getDriver());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_center(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_inferior(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_center	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_center() {
		if (jPanel_center == null) {
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.insets = new Insets(10, 0, 10, 300);
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			gridBagConstraints9.gridy = 3;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.insets = new Insets(10, 0, 10, 50);
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 2;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.insets = new Insets(10, 0, 10, 50);
			gridBagConstraints8.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.insets = new Insets(10, 0, 10, 300);
			gridBagConstraints6.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(10, 50, 10, 10);
			gridBagConstraints5.gridy = 3;
			jLabel_driver = new JLabel();
			jLabel_driver.setText("Driver:");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.insets = new Insets(10, 50, 10, 10);
			gridBagConstraints4.gridy = 2;
			jLabel_url = new JLabel();
			jLabel_url.setText("URL:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.EAST;
			gridBagConstraints3.insets = new Insets(10, 50, 10, 10);
			gridBagConstraints3.gridy = 1;
			jLabel_password = new JLabel();
			jLabel_password.setText("Password:");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.insets = new Insets(10, 50, 10, 10);
			gridBagConstraints2.gridy = 0;
			jLabel_user = new JLabel();
			jLabel_user.setText("User:");
			jPanel_center = new JPanel();
			jPanel_center.setLayout(new GridBagLayout());
			jPanel_center.add(jLabel_user, gridBagConstraints2);
			jPanel_center.add(jLabel_password, gridBagConstraints3);
			jPanel_center.add(jLabel_url, gridBagConstraints4);
			jPanel_center.add(jLabel_driver, gridBagConstraints5);
			jPanel_center.add(getJTextField_user(), gridBagConstraints6);
			jPanel_center.add(getJTextField_url(), gridBagConstraints8);
			jPanel_center.add(getJTextField_driver(), gridBagConstraints9);
			jPanel_center.add(getJPasswordField(), gridBagConstraints10);
		}
		return jPanel_center;
	}

	/**
	 * This method initializes jPanel_inferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_inferior() {
		if (jPanel_inferior == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			jPanel_inferior = new JPanel();
			jPanel_inferior.setLayout(new GridBagLayout());
			jPanel_inferior.add(getJButton_salvar(), gridBagConstraints);
			jPanel_inferior.add(getJButton_sair(), gridBagConstraints1);
		}
		return jPanel_inferior;
	}

	/**
	 * This method initializes jButton_salvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_salvar() {
		if (jButton_salvar == null) {
			jButton_salvar = new JButton();
			jButton_salvar.setText("Salvar");
			jButton_salvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextField_user.getText().equals("") || jTextField_user.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campo 'User' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jPasswordField.getText().equals("") || jPasswordField.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campo 'Password' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							if(jTextField_url.getText().equals("") || jTextField_url.getText().equals(null)){
								JOptionPane.showMessageDialog(null,"Campo 'URL' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
							}else{
								if(jTextField_driver.getText().equals("") || jTextField_driver.getText().equals(null)){
									JOptionPane.showMessageDialog(null,"Campo 'Driver' em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
								}else{
									Configuracao_xml server = new Configuracao_xml();
									Server_xml s1 = new Server_xml();
									s1.setUser(jTextField_user.getText());
									s1.setPassword(jPasswordField.getText());
									s1.setUrl(jTextField_url.getText());
									s1.setDriver(jTextField_driver.getText());
									server.GravaroXml(s1);
									XML.this.dispose();
								}
							}
						}
					}
				}
			});
		}
		return jButton_salvar;
	}

	/**
	 * This method initializes jButton_sair	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_sair() {
		if (jButton_sair == null) {
			jButton_sair = new JButton();
			jButton_sair.setText("Fechar");
			jButton_sair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					XML.this.dispose();
				}
			});
		}
		return jButton_sair;
	}

	/**
	 * This method initializes jTextField_user	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_user() {
		if (jTextField_user == null) {
			jTextField_user = new JTextField();
		}
		return jTextField_user;
	}

	/**
	 * This method initializes jTextField_url	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_url() {
		if (jTextField_url == null) {
			jTextField_url = new JTextField();
		}
		return jTextField_url;
	}

	/**
	 * This method initializes jTextField_driver	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_driver() {
		if (jTextField_driver == null) {
			jTextField_driver = new JTextField();
		}
		return jTextField_driver;
	}

	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
		}
		return jPasswordField;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
