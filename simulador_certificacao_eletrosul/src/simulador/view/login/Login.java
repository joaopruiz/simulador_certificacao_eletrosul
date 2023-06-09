package simulador.view.login;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import simulador.model.Janelapai_metodos;
import simulador.view.JanelaPai;
import simulador.view.teste.Md5;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel1_login = null;
	private JLabel jLabel_usuario = null;
	private JTextField jTextField_usuario = null;
	private JLabel jLabel_senha = null;
	private JButton jButton1_ok = null;
	private static JanelaPai telapai;
	private JPanel jPanel_inferior = null;
	//private JButton jButton_configs = null;
	private JButton jButton1_logo = null;
	private JPanel jPanel_logo = null;
	private JPasswordField jPasswordField = null;
	/**
	 * @param owner
	 */
	public Login(JanelaPai tela) {
		super();
		telapai = tela;
		initialize();
		addWindowListener( new WindowAdapter() {
			   public void windowOpened( WindowEvent e ){
				   jTextField_usuario.requestFocus();
			     }
		} ); 
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(548, 319);
		this.setTitle("Simulador de Certifica��o");
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getRootPane().setDefaultButton(jButton1_ok);
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
			jContentPane.add(getJPanel1_login(), BorderLayout.EAST);
			jContentPane.add(getJPanel_inferior(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_logo(), BorderLayout.WEST);
		}
		return jContentPane;
	}
	private JButton getJButton1_logo() {
		if (jButton1_logo == null) {
			jButton1_logo = new JButton();
			jButton1_logo.setIcon(new ImageIcon(getClass().getResource("/banner_simulado.jpg")));
			jButton1_logo.setBackground(Color.white);
			jButton1_logo.setPreferredSize(new Dimension(208, 141));
			jButton1_logo.setEnabled(true);
			jButton1_logo.setBorder(null);
		}
		return jButton1_logo;
	}
	/**
	 * This method initializes jPanel1_login	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1_login() {
		if (jPanel1_login == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(10, 0, 10, 10);
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			jLabel_senha = new JLabel();
			jLabel_senha.setText("Senha:");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.NONE;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.insets = new Insets(10, 0, 10, 10);
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.NONE;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 10);
			jLabel_usuario = new JLabel();
			jLabel_usuario.setText("Usu�rio:");
			jPanel1_login = new JPanel();
			jPanel1_login.setLayout(new GridBagLayout());
			jPanel1_login.setBorder(BorderFactory.createTitledBorder(null, "Autentica��o", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel1_login.add(jLabel_usuario, gridBagConstraints5);
			jPanel1_login.add(getJTextField_usuario(), gridBagConstraints2);
			jPanel1_login.add(jLabel_senha, gridBagConstraints3);
			jPanel1_login.add(getJPasswordField(), gridBagConstraints4);
		}
		return jPanel1_login;
	}

	/**
	 * This method initializes jTextField_usuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_usuario() {
		if (jTextField_usuario == null) {
			jTextField_usuario = new JTextField();
			jTextField_usuario.setPreferredSize(new Dimension(200, 20));
			jTextField_usuario.setText("");
		}
		return jTextField_usuario;
	}

	/**
	 * This method initializes jButton1_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1_ok() {
		if (jButton1_ok == null) {
			jButton1_ok = new JButton();
			jButton1_ok.setText("Entrar");
			jButton1_ok.addActionListener(new java.awt.event.ActionListener() {
				@SuppressWarnings({ "static-access", "deprecation" })
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Janelapai_metodos j1 = new Janelapai_metodos();
					boolean flag=false;
					Md5 md5 = new Md5();
					flag=j1.Verifica_Usuario(jTextField_usuario.getText(), md5.converterpraMD5(jPasswordField.getText()));
					if(flag==true){
						telapai.mostraNomedoUsuario(jTextField_usuario.getText());
						telapai.usuario=jTextField_usuario.getText();
						telapai.id_usuario=j1.retornID(jTextField_usuario.getText());
						//System.out.println(telapai.id_usuario);
						telapai.tipodousuario=j1.retornTipo(jTextField_usuario.getText());
						telapai.atualizapeloPerfil();
						telapai.mostrarAplica��o();
						Login.this.dispose();
					}else{
						jPasswordField.setText("");
						JOptionPane.showMessageDialog(null,"Usu�rio ou Senha incorreto. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return jButton1_ok;
	}

	/**
	 * This method initializes jPanel_inferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_inferior() {
		if (jPanel_inferior == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = -1;
			gridBagConstraints.gridx = -1;
			jPanel_inferior = new JPanel();
			jPanel_inferior.setLayout(new GridBagLayout());
			jPanel_inferior.add(getJButton1_ok(), gridBagConstraints);
			//jPanel_inferior.add(getJButton_configs(), gridBagConstraints6);
		}
		return jPanel_inferior;
	}

	/**
	 * This method initializes jButton_configs	
	 * 	
	 * @return javax.swing.JButton	
	 */
	/*private JButton getJButton_configs() {
		if (jButton_configs == null) {
			jButton_configs = new JButton();
			jButton_configs.setText("Configura��es");
			jButton_configs.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					XML xml = new XML();
					xml.setLocationRelativeTo(null);
					xml.setVisible(true);
				}
			});
		}
		return jButton_configs;
	}*/

	/**
	 * This method initializes jPanel_logo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_logo() {
		if (jPanel_logo == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(20, 20, 20, 10);
			jPanel_logo = new JPanel();
			jPanel_logo.setLayout(new GridBagLayout());
			jPanel_logo.add(getJButton1_logo(), gridBagConstraints1);
		}
		return jPanel_logo;
	}

	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setText("");
		}
		return jPasswordField;
	}

}  //  @jve:decl-index=0:visual-constraint="28,11"
