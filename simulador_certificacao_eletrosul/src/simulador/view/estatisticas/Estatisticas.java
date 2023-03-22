package simulador.view.estatisticas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import simulador.model.estatisticas.Estatisticas_metodos;
import simulador.model.simulado.Simulado_Metodos;
import simulador.view.CellRenderer;
import simulador.view.JanelaPai;
import simulador.view.relatorios.Relatorio1;
import simulador.view.relatorios.Relatorio2;
import simulador.view.relatorios.Relatorio6;

public class Estatisticas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_inferior = null;
	private JButton jButton_fechar = null;
	private JPanel jPanel_meio = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JButton jButton_Apagar = null;
	private static JanelaPai telapai;
	private JButton jButton_versao_imprimir = null;
	private JButton jButton_relatorios_perguntas = null;

	/**
	 * @param owner
	 */
	public Estatisticas(JanelaPai tela) {
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
		this.setSize(1003, 379);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Simulador de Certificação - Estatísticas dos Simulados");
		AtualizarJTable();
		jButton_Apagar.setEnabled(false);
		this.getRootPane().setDefaultButton(jButton_fechar);
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
			jContentPane.add(getJPanel_inferior(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_meio(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_inferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_inferior() {
		if (jPanel_inferior == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.insets = new Insets(20, 20, 20, 20);
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.insets = new Insets(20, 20, 20, 20);
			gridBagConstraints7.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(20, 20, 20, 20);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridx = 4;
			jPanel_inferior = new JPanel();
			jPanel_inferior.setLayout(new GridBagLayout());
			jPanel_inferior.add(getJButton_fechar(), gridBagConstraints);
			jPanel_inferior.add(getJButton_Apagar(), gridBagConstraints7);
			jPanel_inferior.add(getJButton_versao_imprimir(), gridBagConstraints11);
			jPanel_inferior.add(getJButton_relatorios_perguntas(), gridBagConstraints2);
		}
		return jPanel_inferior;
	}

	/**
	 * This method initializes jButton_fechar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_fechar() {
		if (jButton_fechar == null) {
			jButton_fechar = new JButton();
			jButton_fechar.setText("Fechar");
			jButton_fechar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Estatisticas.this.dispose();
				}
			});
		}
		return jButton_fechar;
	}

	/**
	 * This method initializes jPanel_meio	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_meio() {
		if (jPanel_meio == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.insets = new Insets(30, 30, 30, 30);
			gridBagConstraints1.gridx = 0;
			jPanel_meio = new JPanel();
			jPanel_meio.setLayout(new GridBagLayout());
			jPanel_meio.add(getJScrollPane(), gridBagConstraints1);
		}
		return jPanel_meio;
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
				public void mouseReleased(java.awt.event.MouseEvent e) {
					jButton_Apagar.setEnabled(true);
					jButton_relatorios_perguntas.setEnabled(true);
				}
			});
			jTable.setDefaultRenderer(Object.class, new CellRenderer());
		}
		return jTable;
	}
	public void AtualizarJTable(){
		try {
			Simulado_Metodos sub1 = new Simulado_Metodos();
			jTable.setModel(sub1.PreencheraJtable(telapai.id_usuario));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
					int j = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(j, 0)).toString();
					int i = JOptionPane.showConfirmDialog(null ,"Realmente deseja excluir o registro N° "+a,
							"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
					if(i == 0){
						Estatisticas_metodos estatisticas_m = new Estatisticas_metodos();
						estatisticas_m.apagar_registroJtable(Integer.parseInt(a));
						AtualizarJTable();
						jButton_Apagar.setEnabled(false);
					}
				}
			});
		}
		return jButton_Apagar;
	}

	/**
	 * This method initializes jButton_versao_imprimir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_versao_imprimir() {
		if (jButton_versao_imprimir == null) {
			jButton_versao_imprimir = new JButton();
			jButton_versao_imprimir.setText("Versão para Imprimir");
			jButton_versao_imprimir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Relatorio1 r1 = new Relatorio1();
					r1.abrirRelatorio(telapai.id_usuario);
				}
			});
		}
		return jButton_versao_imprimir;
	}

	/**
	 * This method initializes jButton_relatorios_perguntas	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_relatorios_perguntas() {
		if (jButton_relatorios_perguntas == null) {
			jButton_relatorios_perguntas = new JButton();
			jButton_relatorios_perguntas.setText("Relatório de Erros e Acertos");
			jButton_relatorios_perguntas.setEnabled(false);
			jButton_relatorios_perguntas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							Relatorio6 r6 = new Relatorio6();
							int j = jTable.getSelectedRow();
							String a = (jTable.getModel().getValueAt(j, 6)).toString();
							r6.abrirRelatorio(Integer.parseInt(a));
						}
					});
		}
		return jButton_relatorios_perguntas;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
