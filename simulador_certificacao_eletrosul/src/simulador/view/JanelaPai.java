package simulador.view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import simulador.view.Autores.Autores;
import simulador.view.about.Sobre;
import simulador.view.alterarsenha.AlterarSenha;
import simulador.view.assuntos.Assuntos;
import simulador.view.assuntos.Assuntosselecao;
import simulador.view.estatisticas.Estatisticas;
import simulador.view.figuras.Figuras;
import simulador.view.login.Login;
import simulador.view.perguntas.Perguntas;
import simulador.view.relatorios.Relatorio2;
import simulador.view.relatorios.Relatorio3;
import simulador.view.relatorios.Relatorio5;
import simulador.view.relatorios.Relatorio4;
import simulador.view.simulado.Simulado;
import simulador.view.subestacoes.Subestacoes;
import simulador.view.teste.Derby_teste;
import simulador.view.usuarios.Usuarios;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

public class JanelaPai {

	private JFrame jFrame = null;  
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenu relatoriosMenu = null;
	@SuppressWarnings("unused")
	private JMenuItem relatorio1MenuItem = null;
	private JMenuItem relatorio2MenuItem = null;
	private JMenuItem relatorio3MenuItem = null;
	private JMenuItem relatorio4MenuItem = null;
	private JMenuItem relatorio5MenuItem = null;
	//private JMenuItem relatorio22MenuItem = null;
	//private JMenuItem relatorio33MenuItem = null;
	//private JMenuItem relatorio44MenuItem = null;
	//private JMenuItem relatorio55MenuItem = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem fileMenuEstatisticas = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem MenuGerenSub = null;
	//private JMenuItem MenuGerenCon = null;
	private JMenuItem MenuGerenSenha = null;
	private JMenuItem MenuGerenFiguras = null;
	private JMenuItem MenuAutores = null;
	private JMenuItem menuAssuntos = null;
	private JMenuItem saveMenuItem = null;
	private JMenuItem MenuPerguntas = null;
	private JMenuItem MenuGerenUsu = null;
	//private JMenu MenuMeusRelatorios = null;
	private JMenu MenuRelatoriosemGeral = null;
	private JPanel jPanel = null;
	private JButton jButton = null;
	private JSeparator jSeparator1 = null;
	private JSeparator jSeparator2 = null;
	private JPanel jPanel1_inferior = null;
	private JLabel jLabel_titulo = null;
	private JButton jButton1_logo = null;
	public String usuario="";
	public int id_usuario=0;
	public int id_assunto=0;
	private JLabel jLabel_nome_usuario = null;
	private JLabel jLabel_usuario = null;
	private JPanel jPanel1_status = null;
	public int tipodousuario=0;
	private JMenuItem mntmIniciarSimuladoPor;
	private JButton button;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel_nome_usuario = new JLabel();
			jLabel_nome_usuario.setText("");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(0, 20, 100, 20);
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 10, 10, 10);
			gridBagConstraints.gridy = 2;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBackground(Color.white);
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.insets = new Insets(0, 0, 5, 0);
			gbc_button.gridx = 0;
			gbc_button.gridy = 1;
			jPanel.add(getButton(), gbc_button);
			jPanel.add(getJButton(), gridBagConstraints);
			jPanel.add(getJButton1_logo(), gridBagConstraints11);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Iniciar Simulado por Assunto");
			//jButton.setEnabled(false);
			jButton.setFont(new Font("Arial", Font.BOLD, 40));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Assuntosselecao assuntos = new Assuntosselecao(JanelaPai.this);
					assuntos.setVisible(true);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel1_inferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1_inferior() {
		if (jPanel1_inferior == null) {
			jLabel_usuario = new JLabel();
			jLabel_usuario.setText("Usu�rio:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.NORTH;
			gridBagConstraints1.insets = new Insets(30, 30, 30, 30);
			jLabel_titulo = new JLabel();
			jLabel_titulo.setText("BANCO DE PERGUNTAS PARA A CERTIFICA��O");
			jLabel_titulo.setForeground(Color.blue);
			jLabel_titulo.setFont(new Font("Arial", Font.BOLD, 30));
			jPanel1_inferior = new JPanel();
			jPanel1_inferior.setLayout(new GridBagLayout());
			jPanel1_inferior.setBackground(Color.white);
			jPanel1_inferior.add(jLabel_titulo, gridBagConstraints1);
		}
		return jPanel1_inferior;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	
	/**
	 * This method initializes jButton1_logo	
	 * 	
	 * @return javax.swing.JButton	
	 */
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
	 * @param args
	 */
	private void mostratTelalogin(){
		Login login = new Login(JanelaPai.this);
		login.setVisible(true);
	}
	public void mostraNomedoUsuario(String usuario){
		jLabel_nome_usuario.setText(usuario);
	}
	public void atualizapeloPerfil(){
		if(tipodousuario==2){
			MenuGerenSub.setEnabled(true);
			MenuAutores.setEnabled(true);
			menuAssuntos.setEnabled(true);
			MenuPerguntas.setEnabled(true);
			MenuGerenUsu.setEnabled(true);
			MenuGerenFiguras.setEnabled(true);
		}
	}


	/**
	 * This method initializes jPanel1_status	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1_status() {
		if (jPanel1_status == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.insets = new Insets(0, 0, 0, 5);
			jPanel1_status = new JPanel();
			jPanel1_status.setLayout(new GridBagLayout());
			jPanel1_status.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel1_status.add(jLabel_usuario, gridBagConstraints2);
			jPanel1_status.add(jLabel_nome_usuario, gridBagConstraints3);
		}
		return jPanel1_status;
	}
	public void mostrarAplica��o(){
		this.getJFrame().setVisible(true);
	}
	public void carregaroBD(){
		//requisitando a classe do derby
		simulador.view.teste.Derby_teste Derby_teste = new Derby_teste();
		Derby_teste.main();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JanelaPai application = new JanelaPai();
				application.getJFrame().setVisible(false);
				//application.carregaroBD();
				application.mostratTelalogin();
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(797, 593);
			jFrame.setContentPane(getJContentPane());
			jFrame.setLocationRelativeTo(null);
			jFrame.setTitle("Simulador de Certifica��o");
			jFrame.getRootPane().setDefaultButton(jButton);
		}
		return jFrame;
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
			jContentPane.setBackground(Color.white);
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
			jContentPane.add(getJPanel1_inferior(), BorderLayout.NORTH);
			jContentPane.add(getJPanel1_status(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getRelatorio1());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("Arquivo");
			fileMenu.add(getIniciarSimula��o());
			fileMenu.add(getMntmIniciarSimuladoPor());
			//fileMenu.add(getMenuEstatisticas());
			jSeparator1 = new JSeparator();
			jSeparator1.setName("jSeparator1");
			fileMenu.add(jSeparator1);
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			jSeparator1 = new JSeparator();
			jSeparator1.setName("jSeparator1");
			editMenu.setText("Gerenciar");
			//editMenu.add(getMenuGerenCon());
			editMenu.add(getMenuGerenSenha());
			editMenu.add(getMenuGerenUsuarios());
			editMenu.add(jSeparator1);
			editMenu.add(getMenuGerenciarSub());
			editMenu.add(getMenuAutores());
			editMenu.add(getMenuAssuntos());
			jSeparator2 = new JSeparator();
			jSeparator2.setName("jSeparator2");
			editMenu.add(jSeparator2);
			editMenu.add(getMenuGerenFiguras());
			editMenu.add(getMenuPerguntas());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Ajuda");
			helpMenu.add(getAboutMenuItem());
			//helpMenu.add(getaboutMenuTeste());
		}
		return helpMenu;
	}
	private JMenu getRelatorio1() {
		if (relatoriosMenu == null) {
			relatoriosMenu = new JMenu();
			relatoriosMenu.setText("Relat�rios");
			relatoriosMenu.add(getMenuEstatisticas());
			jSeparator1 = new JSeparator();
			jSeparator1.setName("jSeparator1");
			//relatoriosMenu.add(jSeparator1);
			//relatoriosMenu.add(getMeusRelatorios());
			/*jSeparator2 = new JSeparator();
			jSeparator2.setName("jSeparator2");*/
			relatoriosMenu.add(jSeparator1);
			relatoriosMenu.add(getRelatoriosemGeral());
			//helpMenu.add(getaboutMenuTeste());
		}
		return relatoriosMenu;
	}
	/*private JMenu getMeusRelatorios() {
		if (MenuMeusRelatorios == null) {
			MenuMeusRelatorios = new JMenu();
			MenuMeusRelatorios.setText("Meus Relat�rios");
			MenuMeusRelatorios.add(getRelatorio22MenuItem());
			MenuMeusRelatorios.add(getRelatorio33MenuItem());
			MenuMeusRelatorios.add(getRelatorio44MenuItem());
			MenuMeusRelatorios.add(getRelatorio55MenuItem());
		}
		return MenuMeusRelatorios;
	}*/
	private JMenu getRelatoriosemGeral() {
		if (MenuRelatoriosemGeral == null) {
			MenuRelatoriosemGeral = new JMenu();
			MenuRelatoriosemGeral.setText("Relat�rios em Geral");
			MenuRelatoriosemGeral.add(getRelatorio2MenuItem());
			MenuRelatoriosemGeral.add(getRelatorio3MenuItem());
			MenuRelatoriosemGeral.add(getRelatorio4MenuItem());
			MenuRelatoriosemGeral.add(getRelatorio5MenuItem());
		}
		return MenuRelatoriosemGeral;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Sair do Sistema");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}
	private JMenuItem getMenuEstatisticas() {
		if (fileMenuEstatisticas == null) {
			fileMenuEstatisticas = new JMenuItem();
			fileMenuEstatisticas.setText("Estat�sticas dos Simulados");
			//fileMenuEstatisticas.setEnabled(false);
			fileMenuEstatisticas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Estatisticas esta1 = new Estatisticas(JanelaPai.this);
					esta1.setLocationRelativeTo(null);
					esta1.setVisible(true);
				}
			});
		}
		return fileMenuEstatisticas;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("Sobre...");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sobre aboutDialog = new Sobre(jFrame);
					aboutDialog.pack();
					//Point loc = getJFrame().getLocation();
					//loc.translate(20, 20);
					//aboutDialog.setLocation(loc);
					aboutDialog.setSize(new Dimension(550, 314));
					aboutDialog.setVisible(true);
					aboutDialog.setLocationRelativeTo(null);
				}
			});
		}
		return aboutMenuItem;
	}
	/*private JMenuItem getRelatorio1MenuItem() {
		if (relatorio1MenuItem == null) {
			relatorio1MenuItem = new JMenuItem();
			relatorio1MenuItem.setText("Estat�sticas dos Simulados");
			relatorio1MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio1 r1 = new Relatorio1();
					r1.abrirRelatorio(id_usuario);
				}
			});
		}
		return relatorio1MenuItem;
	}*/
	private JMenuItem getRelatorio2MenuItem() {
		if (relatorio2MenuItem == null) {
			relatorio2MenuItem = new JMenuItem();
			relatorio2MenuItem.setText("Assuntos com mais Acertos");
			relatorio2MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio2 r2 = new Relatorio2();
					r2.abrirRelatorio();
				}
			});
		}
		return relatorio2MenuItem;
	}
	/*private JMenuItem getRelatorio22MenuItem() {
		if (relatorio22MenuItem == null) {
			relatorio22MenuItem = new JMenuItem();
			relatorio22MenuItem.setText("Assuntos com mais Acertos");
			relatorio22MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio22 r22 = new Relatorio22();
					r22.abrirRelatorio(id_usuario);
				}
			});
		}
		return relatorio22MenuItem;
	}*/
	private JMenuItem getRelatorio3MenuItem() {
		if (relatorio3MenuItem == null) {
			relatorio3MenuItem = new JMenuItem();
			relatorio3MenuItem.setText("Assuntos com mais Erros");
			relatorio3MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio3 r3 = new Relatorio3();
					r3.abrirRelatorio();
				}
			});
		}
		return relatorio3MenuItem;
	}
	/*private JMenuItem getRelatorio33MenuItem() {
		if (relatorio33MenuItem == null) {
			relatorio33MenuItem = new JMenuItem();
			relatorio33MenuItem.setText("Assuntos com mais Erros");
			relatorio33MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio33 r33 = new Relatorio33();
					r33.abrirRelatorio(id_usuario);
				}
			});
		}
		return relatorio33MenuItem;
	}*/
	private JMenuItem getRelatorio4MenuItem() {
		if (relatorio4MenuItem == null) {
			relatorio4MenuItem = new JMenuItem();
			relatorio4MenuItem.setText("Perguntas com mais Acertos");
			relatorio4MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio5 r5 = new Relatorio5();
					r5.abrirRelatorio();
				}
			});
		}
		return relatorio4MenuItem;
	}
	/*private JMenuItem getRelatorio44MenuItem() {
		if (relatorio44MenuItem == null) {
			relatorio44MenuItem = new JMenuItem();
			relatorio44MenuItem.setText("Perguntas com mais Acertos");
			relatorio44MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio44 r44 = new Relatorio44();
					r44.abrirRelatorio(id_usuario);
				}
			});
		}
		return relatorio44MenuItem;
	}*/
	private JMenuItem getRelatorio5MenuItem() {
		if (relatorio5MenuItem == null) {
			relatorio5MenuItem = new JMenuItem();
			relatorio5MenuItem.setText("Perguntas com mais Erros");
			relatorio5MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio4 r4 = new Relatorio4();
					r4.abrirRelatorio();
				}
			});
		}
		return relatorio5MenuItem;
	}
	/*private JMenuItem getRelatorio55MenuItem() {
		if (relatorio55MenuItem == null) {
			relatorio55MenuItem = new JMenuItem();
			relatorio55MenuItem.setText("Perguntas com mais Erros");
			relatorio55MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Relatorio55 r55 = new Relatorio55();
					r55.abrirRelatorio(id_usuario);
				}
			});
		}
		return relatorio55MenuItem;
	}*/
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuGerenciarSub() {
		if (MenuGerenSub == null) {
			MenuGerenSub = new JMenuItem();
			MenuGerenSub.setText("Gerenciar Subesta��es");
			MenuGerenSub.setEnabled(false);
			//MenuGerenSub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					//Event.CTRL_MASK, true));
			MenuGerenSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Subestacoes subestacoes = new Subestacoes(jFrame);
					subestacoes.pack();
					subestacoes.setSize(new Dimension(620, 376));
					//subestacoes.setTitle("Simulador de Certifica��o - Eletrosul - Gerenciar Subesta��es");
					subestacoes.setLocationRelativeTo(null);
					subestacoes.setVisible(true);
				}
			});
		}
		return MenuGerenSub;
	}
	/*private JMenuItem getMenuGerenCon() {
		if (MenuGerenCon == null) {
			MenuGerenCon = new JMenuItem();
			MenuGerenCon.setText("Gerenciar conex�o com o Banco de Dados");
			//MenuGerenSub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					//Event.CTRL_MASK, true));
			MenuGerenCon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					XML xml = new XML();
					xml.setLocationRelativeTo(null);
					xml.setVisible(true);
				}
			});
		}
		return MenuGerenCon;
	}*/
	private JMenuItem getMenuGerenSenha() {
		if (MenuGerenSenha == null) {
			MenuGerenSenha = new JMenuItem();
			MenuGerenSenha.setText("Alterar a minha Senha");
			MenuGerenSenha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AlterarSenha alterarsenha = new AlterarSenha(JanelaPai.this);
					alterarsenha.setVisible(true);
				}
			});
		}
		return MenuGerenSenha;
	}
	
	private JMenuItem getMenuGerenFiguras() {
		if (MenuGerenFiguras == null) {
			MenuGerenFiguras = new JMenuItem();
			MenuGerenFiguras.setText("Gerenciar Figuras");
			MenuGerenFiguras.setEnabled(false);
			MenuGerenFiguras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Figuras figuras = new Figuras(jFrame);
					figuras.setVisible(true);
				}
			});
		}
		return MenuGerenFiguras;
	}
	private JMenuItem getMenuGerenUsuarios() {
		if (MenuGerenUsu == null) {
			MenuGerenUsu = new JMenuItem();
			MenuGerenUsu.setText("Gerenciar Usu�rios");
			MenuGerenUsu.setEnabled(false);
			//MenuGerenSub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					//Event.CTRL_MASK, true));
			MenuGerenUsu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Usuarios usuarios = new Usuarios(jFrame);
					usuarios.setVisible(true);
					
				}
			});
		}
		return MenuGerenUsu;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuAutores() {
		if (MenuAutores == null) {
			MenuAutores = new JMenuItem();
			MenuAutores.setText("Gerenciar Autores");
			MenuAutores.setEnabled(false);
			MenuAutores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Autores autores = new Autores(jFrame);
					autores.pack();
					autores.setSize(new Dimension(620, 376));
					//autores.setTitle("Simulador de Certifica��o - Eletrosul - Gerenciar Autores");
					autores.setLocationRelativeTo(null);
					autores.setVisible(true);
				}
			});
		}
		return MenuAutores;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMenuAssuntos() {
		if (menuAssuntos == null) {
			menuAssuntos = new JMenuItem();
			menuAssuntos.setText("Gerenciar Assuntos");
			menuAssuntos.setEnabled(false);
			menuAssuntos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Assuntos assuntos = new Assuntos(jFrame);
					assuntos.pack();
					assuntos.setSize(new Dimension(883, 376));
					//assuntos.setTitle("Simulador de Certifica��o - Eletrosul - Gerenciar Assuntos");
					assuntos.setLocationRelativeTo(null);
					assuntos.setVisible(true);
				}
			});
		}
		return menuAssuntos;
	}
	private JMenuItem getMenuPerguntas() {
		if (MenuPerguntas == null) {
			MenuPerguntas = new JMenuItem();
			MenuPerguntas.setText("Gerenciar Perguntas");
			MenuPerguntas.setEnabled(false);
			MenuPerguntas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Perguntas perguntas = new Perguntas(jFrame);
					perguntas.pack();
					perguntas.setSize(new Dimension(961, 706));
					//perguntas.setTitle("Simulador de Certifica��o - Eletrosul - Gerenciar Perguntas");
					perguntas.setLocationRelativeTo(null);
					//Toolkit toolkit = Toolkit.getDefaultToolkit();    
					//Dimension screenSize = toolkit.getScreenSize();   
					//perguntas.setBounds(0, 0, screenSize.width, screenSize.height);  
					perguntas.setVisible(true);
				}
			});
		}
		return MenuPerguntas;
	}
	
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getIniciarSimula��o() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Iniciar Simulado");
			//saveMenuItem.setEnabled(false);
			//saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					//Event.CTRL_MASK, true));
			saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Simulado simulador = new Simulado(JanelaPai.this);
					simulador.setVisible(true);
				}
			});
			
		}
		return saveMenuItem;
	}

	private JMenuItem getMntmIniciarSimuladoPor() {
		if (mntmIniciarSimuladoPor == null) {
			mntmIniciarSimuladoPor = new JMenuItem("Iniciar Simulado por Assunto");
			mntmIniciarSimuladoPor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Assuntosselecao assuntos = new Assuntosselecao(JanelaPai.this);
					assuntos.setVisible(true);
				}
			});
		}
		return mntmIniciarSimuladoPor;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Simulado simulador = new Simulado(JanelaPai.this);
					simulador.setVisible(true);
				}
			});
			button.setText("Iniciar Simulado");
			button.setFont(new Font("Arial", Font.BOLD, 40));
		}
		return button;
	}
}
