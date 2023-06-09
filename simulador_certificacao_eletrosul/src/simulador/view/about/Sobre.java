package simulador.view.about;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JLabel aboutNomeLabel = null;
	private JPanel jPanel = null;
	private JButton jButton_logotipo = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JPanel jPanel1 = null;

	/**
	 * @param owner
	 */
	public Sobre(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("Simulador de Certifica��o - Sobre");
		this.setSize(new Dimension(657, 314));
		this.setLocationRelativeTo(null);
		this.getRootPane().setDefaultButton(jButton_logotipo);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(0);
			jContentPane = new JPanel();
			jContentPane.setBackground(Color.white);
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanel1(), BorderLayout.WEST);
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 2.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}
	private JLabel getAboutNomeLabel() {
		if (aboutNomeLabel == null) {
			aboutNomeLabel = new JLabel();
			aboutNomeLabel.setText("Autor: Jo�o Paulo Ruiz");
			aboutNomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			aboutNomeLabel.setVisible(true);
		}
		return aboutNomeLabel;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints1.gridx = 1;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBackground(Color.white);
			jPanel.add(getAboutVersionLabel(), gridBagConstraints1);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints3.gridy = 1;
			jLabel2 = new JLabel();
			jLabel2.setText("Linguagem de Programa��o: JAVA");
			jPanel.add(jLabel2, gridBagConstraints3);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints11.gridy = 2;
			jLabel = new JLabel();
			jLabel.setText("IDE de Desenvolvimento: ECLIPSE");
			jPanel.add(jLabel, gridBagConstraints11);
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints21.gridy = 3;
			jLabel1 = new JLabel();
			jLabel1.setText("Banco de Dados:  DERBY");
			jPanel.add(jLabel1, gridBagConstraints21);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = 4;
			jPanel.add(getAboutNomeLabel(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton_logotipo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_logotipo() {
		if (jButton_logotipo == null) {
			jButton_logotipo = new JButton();
			jButton_logotipo.setIcon(new ImageIcon(getClass().getResource("/banner_simulado.jpg")));
			jButton_logotipo.setBackground(Color.white);
			jButton_logotipo.setPreferredSize(new Dimension(208, 141));
			jButton_logotipo.setEnabled(true);
			jButton_logotipo.setBorder(null);
			jButton_logotipo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Sobre.this.dispose();
				}
			});
		}
		return jButton_logotipo;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridx = -1;
			gridBagConstraints2.gridy = -1;
			gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBackground(Color.white);
			jPanel1.add(getJButton_logotipo(), gridBagConstraints2);
		}
		return jPanel1;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
