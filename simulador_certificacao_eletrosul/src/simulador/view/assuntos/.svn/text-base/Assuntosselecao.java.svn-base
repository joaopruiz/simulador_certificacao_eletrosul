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
import simulador.view.JanelaPai;
import simulador.view.simulado.Simuladoassunto;

import java.awt.Dimension;

public class Assuntosselecao extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel SubestacoesDialog = null;
	private JPanel jPanelSubestacoes = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel_subestacaonome = null;
	@SuppressWarnings("unused")
	private static JanelaPai telapai;
	/**
	 * @param owner
	 */
	public Assuntosselecao(JanelaPai tela) {
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
		this.setContentPane(getSubestacoesDialog());
		this.setSize(new Dimension(883, 376));
		this.setTitle("Simulador de Certificação - Gerenciar Assuntos");
		AtualizarJTable();
		LimpareDesabilitarCampos();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	}
	private JPanel getSubestacoesDialog() {
		if (SubestacoesDialog == null) {
			SubestacoesDialog = new JPanel();
			SubestacoesDialog.setLayout(new BorderLayout());
			SubestacoesDialog.add(getJPanelSubestacoes(), java.awt.BorderLayout.CENTER);
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
					//jTextField_subestacaonometxt.setEnabled(true);
					//jButton_salvar.setEnabled(false);
					//jButton_Atualizar.setEnabled(true);
					//jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String f = (jTable.getModel().getValueAt(i, 0)).toString();
					//String a = (jTable.getModel().getValueAt(i, 1)).toString();
					int number = Integer.parseInt(f);
					telapai.id_assunto=number;
					Simuladoassunto simulador = new Simuladoassunto(telapai);
					simulador.setVisible(true);
					Assuntosselecao.this.dispose();
					//String b = (jTable.getModel().getValueAt(i, 2)).toString();
					//System.out.println("row: "+i+" dado: "+a);
					//jTextField_id_subestacoes.setText(f);
					//jTextField_subestacaonometxt.setText(a);
				}
			});
			/*jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					//jTextField_subestacaonometxt.setEnabled(true);
					//jButton_salvar.setEnabled(false);
					//jButton_Atualizar.setEnabled(true);
					//jButton_Apagar.setEnabled(true);
					int i = jTable.getSelectedRow();
					String f = (jTable.getModel().getValueAt(i, 0)).toString();
					String a = (jTable.getModel().getValueAt(i, 1)).toString();
					//String b = (jTable.getModel().getValueAt(i, 2)).toString();
					//System.out.println("row: "+i+" dado: "+a);
					//jTextField_id_subestacoes.setText(f);
					//jTextField_subestacaonometxt.setText(a);
				}
			});*/
			jTable.setDefaultRenderer(Object.class, new CellRenderer());


		}
		return jTable;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
