package simulador.view.figuras;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import simulador.model.figuras.Figuras_Metodos;
import simulador.model.figuras.Figurastb;
import simulador.model.simulado.Simulado_Metodos;
import simulador.view.CellRenderer;
import simulador.view.Mensagens;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class Figuras extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_meio = null;
	private JPanel jPanel_inferior = null;
	private JButton jButton_salvar = null;
	private JTextField jTextField_endereco = null;
	private JButton jButton_enviar = null;
	private JLabel jLabel_imagem = null;
	private JTextField jTextField_descricao = null;
	private JLabel jLabel_ende = null;
	private JLabel jLabel_descricao = null;
	private JPanel jPanel_jt = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private Blob blob = null; //is our blob object
	private JButton jButton_Apagar = null;
	private JButton jButton_fechar = null;
	/**
	 * @param owner
	 */
	public Figuras(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(900, 600);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		AtualizarJTable();
		this.getRootPane().setDefaultButton(jButton_enviar);
		this.setTitle("Simulador de Certifica��o - Gerenciar Figuras");
	}
	public void AtualizarJTable(){
		try {
			Figuras_Metodos sub1 = new Figuras_Metodos();
			jTable.setModel(sub1.PreencheraJtable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
			jContentPane.add(getJPanel_meio(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_inferior(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_jt(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_meio	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	
	private JPanel getJPanel_meio() {
		if (jPanel_meio == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.insets = new Insets(10, 10, 10, 10);
			jPanel_meio = new JPanel();
			jPanel_meio.setLayout(new GridBagLayout());
			jPanel_meio.add(getLabel_Imagem(), gridBagConstraints1);
		}
		return jPanel_meio;
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
			gridBagConstraints2.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints2.gridy = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints13.gridy = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints7.gridy = 1;
			jLabel_descricao = new JLabel();
			jLabel_descricao.setText("Descri��o:");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints6.gridy = 0;
			jLabel_ende = new JLabel();
			jLabel_ende.setText("Endere�o:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 1;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints5.gridx = 3;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = GridBagConstraints.BOTH;
			gridBagConstraints31.gridx = 3;
			gridBagConstraints31.gridy = 0;
			gridBagConstraints31.weightx = 1.0;
			gridBagConstraints31.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.gridx = 1;
			jPanel_inferior = new JPanel();
			jPanel_inferior.setLayout(new GridBagLayout());
			jPanel_inferior.add(getJButton_salvar(), gridBagConstraints);
			jPanel_inferior.add(getJButton_enviar(), gridBagConstraints11);
			jPanel_inferior.add(getJTextField_endereco(), gridBagConstraints31);
			jPanel_inferior.add(getJTextField_descricao(), gridBagConstraints5);
			jPanel_inferior.add(jLabel_ende, gridBagConstraints6);
			jPanel_inferior.add(jLabel_descricao, gridBagConstraints7);
			jPanel_inferior.add(getJButton_Apagar(), gridBagConstraints13);
			jPanel_inferior.add(getJButton_fechar(), gridBagConstraints2);
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
					if(blob==null){
						JOptionPane.showMessageDialog(null,"Foto n�o carregada na mem�ria. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(jTextField_descricao.getText().equals("") ||jTextField_descricao.getText().equals(null)){
							JOptionPane.showMessageDialog(null,"Campo 'Descri��o' em Branco. \n","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
						}else{
							int i=0;
							Figurastb figura = new Figurastb(i, jTextField_descricao.getText(), blob);
							Figuras_Metodos f1 = new Figuras_Metodos();
							f1.Salvar_novo_registroJtable(figura);
							LimparCampos();
							AtualizarJTable();
						}
					}
				}
			});
		}
		return jButton_salvar;
	}
	private void LimparCampos(){
		jLabel_imagem.setIcon(null);
		jTextField_descricao.setText("");
		jTextField_endereco.setText("");
	}
	/**
	 * This method initializes jTextField_endereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_endereco() {
		if (jTextField_endereco == null) {
			jTextField_endereco = new JTextField();
			jTextField_endereco.setEditable(false);
		}
		return jTextField_endereco;
	}
	
	private JLabel getLabel_Imagem() {
		if (jLabel_imagem  == null) {
			jLabel_imagem = new JLabel("",JLabel.CENTER);
			//jLabel_imagem = new JLabel("", new ImageIcon(getClass().getResource("/banner_simulado.jpg")), JLabel.CENTER);
			//ImageIcon img = new ImageIcon("D:/celta.jpg");
			//jLabel_imagem.setIcon(img);
		}
		return jLabel_imagem;
	}
	/**
	 * This method initializes jButton_enviar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_enviar() {
		if (jButton_enviar == null) {
			jButton_enviar = new JButton();
			jButton_enviar.setText("Abrir");
			jButton_enviar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					LimparCampos();
					JFileChooser fc = new JFileChooser();
                    // restringe a amostra a diretorios apenas
                    //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int res = fc.showOpenDialog(null);
                    if(res == JFileChooser.APPROVE_OPTION){
                        File diretorio = fc.getSelectedFile();
                        //JOptionPane.showMessageDialog(null, "Voce escolheu o diret�rio: " + diretorio.getName());
                        jTextField_endereco.setText(diretorio.getPath());
                        File img = new File(diretorio.getPath());
                        byte[] imagem=null;
						try {
							imagem = getBytesFromFile(img);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} 
                       
                        try {
							blob = new SerialBlob(imagem);
							//System.out.println(blob);
						} catch (SerialException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						int tempInt;
						try {
							tempInt = (int) blob.length();
							imagem = blob.getBytes(1, tempInt);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}  
						ImageIcon icon = new ImageIcon(imagem);
						//ImageIcon teste = new ImageIcon(getScaledImage(icon.getImage(), 400, 300));
                        //jLabel_imagem.setIcon(teste);
                        jLabel_imagem.setIcon(icon);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo."); 
					}
				
			});
		}
		return jButton_enviar;
	}
	private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
	public byte[] getBytesFromFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    // Get the size of the file
	    long length = file.length();

	    // You cannot create an array using a long type.
	    // It needs to be an int type.
	    // Before converting to an int type, check
	    // to ensure that file is not larger than Integer.MAX_VALUE.
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }

	    // Create the byte array to hold the data
	    byte[] bytes = new byte[(int)length];

	    // Read in the bytes
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    // Ensure all the bytes have been read in
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    // Close the input stream and return bytes
	    is.close();
	    return bytes;
	}

	/**
	 * This method initializes jTextField_descricao	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField_descricao() {
		if (jTextField_descricao == null) {
			jTextField_descricao = new JTextField();
		}
		return jTextField_descricao;
	}

	/**
	 * This method initializes jPanel_jt	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_jt() {
		if (jPanel_jt == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridy = 0;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.weighty = 1.0;
			gridBagConstraints12.insets = new Insets(30, 30, 30, 30);
			jPanel_jt = new JPanel();
			jPanel_jt.setLayout(new GridBagLayout());
			jPanel_jt.setPreferredSize(new Dimension(400, 479));
			jPanel_jt.add(getJScrollPane(), gridBagConstraints12);
		}
		return jPanel_jt;
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
			//jTable.setPreferredSize(new Dimension(200, 80));
			jTable.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent e) {
					int i = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(i, 0)).toString();
					String b = (jTable.getModel().getValueAt(i, 1)).toString();
					jTextField_descricao.setText(b);
					int tempInt;
					byte[] imagem=null;
					Figuras_Metodos f1 = new Figuras_Metodos(); 
					/*try {
						tempInt = (int) blob.length();
						imagem = blob.getBytes(1, tempInt);
						//System.out.println("entrou");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					ImageIcon icon = new ImageIcon(f1.retornaFigura(Integer.parseInt(a)));
					ImageIcon teste = new ImageIcon(getScaledImage(icon.getImage(), 400, 300));
                    jLabel_imagem.setIcon(teste);
				}
			});
			jTable.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					int i = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(i, 0)).toString();
					String b = (jTable.getModel().getValueAt(i, 1)).toString();
					jTextField_descricao.setText(b);
					int tempInt;
					byte[] imagem=null;
					Figuras_Metodos f1 = new Figuras_Metodos();
					/*blob = f1.retornaFigura(Integer.parseInt(a));
					try {
						tempInt = (int) blob.length();
						imagem = blob.getBytes(1, tempInt);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					ImageIcon icon = new ImageIcon(f1.retornaFigura(Integer.parseInt(a)));
					ImageIcon teste = new ImageIcon(getScaledImage(icon.getImage(), 400, 300));
                    jLabel_imagem.setIcon(teste);
				}
			});
			jTable.setDefaultRenderer(Object.class, new CellRenderer());
		}
		return jTable;
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
					Figuras_Metodos f1 = new Figuras_Metodos();
					int i = jTable.getSelectedRow();
					String a = (jTable.getModel().getValueAt(i, 0)).toString();
					int g = JOptionPane.showConfirmDialog(null ,"Realmente deseja excluir o registro N� "+a,
							"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
					if(g == 0){	
						boolean boliano=false;
						boliano=f1.apagar_registroJtable(Integer.parseInt(a));
						if(boliano==true){
							AtualizarJTable();
							LimparCampos();
							Mensagens mensagens = new Mensagens();
							mensagens.MensagemdeSucesso();
						}else{
							Mensagens mensagens = new Mensagens();
							mensagens.MensagemdeErro("Opera��o de exclus�o n�o conclu�da: ERRO");
						}
					}
					
				}
			});
		}
		return jButton_Apagar;
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
					Figuras.this.dispose();
				}
			});
		}
		return jButton_fechar;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
