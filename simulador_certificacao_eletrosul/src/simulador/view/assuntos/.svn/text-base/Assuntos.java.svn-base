package simulador.view.assuntos;

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

import simulador.model.assuntos.Assuntos_metodos;
import simulador.model.assuntos.Assuntotb;
import simulador.view.CellRenderer;
import java.awt.Dimension;

public class Assuntos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel SubestacoesDialog = null;
	private JPanel jPanelSubestacoes = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JPanel jPanelinferior = null;
	private JLabel jLabel_subestacaonome = null;
	private JTextField jTextField_subestacaonometxt = null;
	private JPanel jPanel_botoes = null;
	private JButton jButton_Atualizar = null;
	private JButton jButton_Apagar = null;
	private JButton jButton_salvar = null;
	private JButton jButton_novo = null;
	private JButton jButton_sair = null;
	private JTextField jTextField_id_subestacoes = null;
	/**
	 * @param owner
	 */
	public Assuntos(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getSubestacoesDialog());
		this.setSize(new Dimension(883, 376));
		this.setTitle("Simulador de Certificação - Gerenciar Assuntos");
		AtualizarJTable();
		jButton_Apagar.setEnabled(false);
		jButton_salvar.setEnabled(false);
		jButton_Atualizar.setEnabled(false);
		jButton_Apagar.setEnabled(false);
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
			Assuntos_metodos sub1 = new Assuntos_metodos();
			jTable.setModel(sub1.PreencheraJtable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void LimpareDesabilitarCampos(){
		jTextField_id_subestacoes.setText("");
		jTextField_subestacaonometxt.setText("");
		jTextField_subestacaonometxt.setEnabled(false);
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
					jTextField_subestacaonometxt.setEnabled(true);
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String f = (jTable.getModel().getValueAt(i, 0)).toString();
					String a = (jTable.getModel().getValueAt(i, 1)).toString();
					//String b = (jTable.getModel().getValueAt(i, 2)).toString();
					//System.out.println("row: "+i+" dado: "+a);
					jTextField_id_subestacoes.setText(f);
					jTextField_subestacaonometxt.setText(a);
				}
			});
			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					jTextField_subestacaonometxt.setEnabled(true);
					jButton_salvar.setEnabled(false);
					jButton_Atualizar.setEnabled(true);
					jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String f = (jTable.getModel().getValueAt(i, 0)).toString();
					String a = (jTable.getModel().getValueAt(i, 1)).toString();
					//String b = (jTable.getModel().getValueAt(i, 2)).toString();
					//System.out.println("row: "+i+" dado: "+a);
					jTextField_id_subestacoes.setText(f);
					jTextField_subestacaonometxt.setText(a);
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
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 2;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 3;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 0;
			jLabel_subestacaonome = new JLabel();
			jLabel_subestacaonome.setText("Assunto:");
			jPanelinferior = new JPanel();
			jPanelinferior.setLayout(new GridBagLayout());
			jPanelinferior.add(jLabel_subestacaonome, gridBagConstraints6);
			jPanelinferior.add(getJTextField_subestacaonometxt(), gridBagConstraints7);
			jPanelinferior.add(getJPanel_botoes(), gridBagConstraints8);
			jPanelinferior.add(getJTextField_id_subestacoes(), gridBagConstraints11);
		}
		return jPanelinferior;
	}

	/**
	 * This method initializes jTextField_subestacaonometxt	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_subestacaonometxt() {
		if (jTextField_subestacaonometxt == null) {
			jTextField_subestacaonometxt = new JTextField();
		}
		return jTextField_subestacaonometxt;
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
			gridBagConstraints12.gridy = 0;
			gridBagConstraints12.gridx = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints2.gridy = -1;
			gridBagConstraints2.gridx = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(20, 10, 20, 10);
			gridBagConstraints1.gridy = -1;
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
					if(jTextField_subestacaonometxt.getText().equals("") || jTextField_subestacaonometxt.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						Assuntos_metodos sub1 = new Assuntos_metodos();
						Assuntotb assuntotb = new Assuntotb(Integer.parseInt(jTextField_id_subestacoes.getText()), jTextField_subestacaonometxt.getText());
						sub1.atualizar_registroJtable(assuntotb);
						jButton_Atualizar.setEnabled(false);
						jButton_Apagar.setEnabled(false);
						LimpareDesabilitarCampos();
						AtualizarJTable();
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
						Assuntos_metodos sub1 = new Assuntos_metodos();
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
					if(jTextField_subestacaonometxt.getText().equals("") || jTextField_subestacaonometxt.getText().equals(null)){
						JOptionPane.showMessageDialog(null,"Campos em branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						Assuntos_metodos sub1 = new Assuntos_metodos();
						int i=0;
						Assuntotb assuntotb = new Assuntotb(i, jTextField_subestacaonometxt.getText());
						sub1.Salvar_novo_registroJtable(assuntotb);
						LimpareDesabilitarCampos();
						AtualizarJTable();
						jButton_salvar.setEnabled(false);
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
					LimpareDesabilitarCampos();
					jButton_salvar.setEnabled(true);
					jButton_Atualizar.setEnabled(false);
					jButton_Apagar.setEnabled(false);
					jTextField_subestacaonometxt.setEnabled(true);
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
					Assuntos.this.dispose();
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

}  //  @jve:decl-index=0:visual-constraint="10,10"
