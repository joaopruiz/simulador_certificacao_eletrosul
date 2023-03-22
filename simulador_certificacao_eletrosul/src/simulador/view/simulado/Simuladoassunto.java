package simulador.view.simulado;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;
import simulador.model.autores.Autores_metodos;
import simulador.model.perguntas.Perguntas_metodos;
import simulador.model.perguntas.Perguntastb;
import simulador.model.simulado.EstatisticasTB;
import simulador.model.simulado.SimuladoTB;
import simulador.model.simulado.Simulado_Metodos;
import simulador.view.JanelaPai;
import simulador.view.figuras.Figura;
import simulador.view.relatorios.Relatorio6;

import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class Simuladoassunto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_central = null;
	private JPanel jPanel_botoes = null;
	private JButton jButton_Voltar = null;
	private JButton jButton_Avancar = null;
	private JTextArea jTextPane = null;
	private JScrollPane scrolingarea = null;
	private JLabel jLabel = null;
	private JPanel jPanel_respostas = null;
	private JLabel jLabel1_Assunto = null;
	private JLabel jLabel1_autor = null;
	private JLabel jLabel1_subestacao = null;
	private JPanel jPanel_botoesdeavaco = null;
	private JPanel jPanel_informacoessobreapergunta = null;
	private JLabel jLabel1_assunto_array = null;
	private JLabel jLabel1_autor_array = null;
	private JLabel jLabel1_subestacao_array = null;
	private JRadioButton jRadioButton_A = null;
	private JRadioButton jRadioButton_B = null;
	private JRadioButton jRadioButton_C = null;
	private JRadioButton jRadioButton_D = null;
	private JRadioButton jRadioButton_E = null;
	private JRadioButton jRadioButton_F = null;
	private JRadioButton jRadioButton_G = null;
	private Perguntas_metodos perguntasmetodos = null;  //  @jve:decl-index=0:
	private ArrayList<Perguntastb> pergunta = null;
	private int tamanhodoarray = 0;
	private int posicaodoarray = 0;
	private ButtonGroup grupo = null;  //  @jve:decl-index=0:
	private String perguntaselecionada= "";  //  @jve:decl-index=0:
	private int acertos = 0;
	private int erros = 0;
	private Random randomNum = null;  //  @jve:decl-index=0:
	private int numerodeperguntas = 0;
	@SuppressWarnings("unused")
	private int tamanhodoarrayaux = 0;
	private int numerodeperguntasdb=0;
	private String verificarandomico = "";  //  @jve:decl-index=0:
	private int[] arrayint = null;
	private static JanelaPai telapai;
	private Figura figura = null;
	private int iddafigura=0;
	@SuppressWarnings("unused")
	private Toolkit tk = null;  //  @jve:decl-index=0:
	@SuppressWarnings("unused")
	private Dimension screenSize = null;
	EstatisticasTB estatisticastb = new EstatisticasTB(0, 0, 0, 0, "", "", 0);  //  @jve:decl-index=0:
	private int num_simulado=0;
	private int acertou=0;
	

	/**
	 * @param owner
	 */
	public Simuladoassunto(JanelaPai tela) {
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Simulador de Certificação - Simulado");
		this.getRootPane().setDefaultButton(jButton_Avancar);
		this.setUndecorated(true);
		//this.setModal(true); //seta modal  
		this.setResizable(false);
		//inicializando as variaveis
		grupo = new ButtonGroup();
		randomNum = new Random();
		perguntasmetodos = new Perguntas_metodos();  //  @jve:decl-index=0:
		pergunta = perguntasmetodos.getListadePerguntasporassunto(telapai.id_assunto);
		numerodeperguntasdb = pergunta.size();
		tamanhodoarray = pergunta.size();
		//System.out.println("pergunta.size(): "+pergunta.size());
		posicaodoarray = 0;
		numerodeperguntas = 50;
		//figura = new Figura(1);
		arrayint = new int[numerodeperguntas];
		//termino das inicialização das variáveis
		//System.out.println("até aki foi beleza");
		JOptionPane.showMessageDialog(null,"ATENÇÃO!\n\n O simulado não possui tempo limite.\n " +
				//"Porém voçê não poderá retrocesseder, pense bem antes de marcar a sua resposta.\n " +
				"O Simulado possui o máximo de 50 perguntas.\n\n " +
				"Boa Sorte!!!","Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
		jButton_Voltar.setEnabled(false);
		jButton_terminar.setEnabled(false);
		jTextPane.setEditable(false);
		//
		grupo.add(getJRadioButton_A());
		grupo.add(getJRadioButton_B());
		grupo.add(getJRadioButton_C());
		grupo.add(getJRadioButton_D());
		grupo.add(getJRadioButton_E());
		grupo.add(getJRadioButton_F());
		grupo.add(getJRadioButton_G());
		// esconder pergutas em branco
		//System.out.println("arrayint.length: "+arrayint.length+" tamanhodoarray: "+tamanhodoarray);
		//System.out.println(pergunta.size());
		for(int i=0;i<arrayint.length;i++){
			arrayint[i]=tamanhodoarray+10;
		}
		int i = 0;
		i = getPerguntaAleatória();
		//arrayint[posicaodoarray] = i;
		//PreenchecomoArraylist(arrayint[posicaodoarray]);
		PreenchecomoArraylist(i);
		arrayint[posicaodoarray]=i;
		//System.out.println("arrayint[posicaodoarray]: "+arrayint[posicaodoarray]);
		//
		jButton_Voltar.setVisible(false);
		verificarandomico+=(pergunta.get(i).getId_PerguntasTB());
		verificarandomico+=", ";
		jLabel1_randomico1.setText(verificarandomico);
		jLabel1_n_da_pergunta.setText(((posicaodoarray)+1)+")");
		// iniciando a implementação dos relatorios
		Simulado_Metodos simu1 = new Simulado_Metodos();
		num_simulado=simu1.retornaUltimoSimulador();
		num_simulado++;
		estatisticastb.setNum_simulado(num_simulado);
		
		
	}
	public int getPerguntaAleatória(){
		int randomico = randomNum.nextInt(numerodeperguntasdb);
		return randomico;
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
			jContentPane.add(getJPanel_central(), BorderLayout.NORTH);
			jContentPane.add(getJPanel_botoes(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel_respostas(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_central	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_central() {
		if (jPanel_central == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints31.gridy = 1;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridx = 1;
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 0;
			gridBagConstraints28.insets = new Insets(20, 10, 10, 0);
			gridBagConstraints28.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints28.gridy = 0;
			jLabel1_n_da_pergunta = new JLabel();
			jLabel1_n_da_pergunta.setText("100");
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 1;
			gridBagConstraints29.insets = new Insets(0, 30, 0, 10);
			gridBagConstraints29.anchor = GridBagConstraints.WEST;
			gridBagConstraints29.gridy = 3;
			jLabel1_randomico1 = new JLabel();
			jLabel1_randomico1.setText("JLabel");
			jLabel1_randomico1.setFont(new Font("Dialog", Font.BOLD, 10));
			//if(telapai.tipodousuario==2){
				//jLabel1_randomico1.setVisible(true);				
			//}else{
				jLabel1_randomico1.setVisible(false);				
			//}
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints3.gridy = 2;
			jLabel = new JLabel();
			jLabel.setText("Assinale a alternativa correta:");
			jLabel.setFont(new Font("Arial", Font.BOLD, 14));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.NONE;
			//gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.insets = new Insets(20, 10, 10, 10);
			//gridBagConstraints2.weightx = 1.0;
			jPanel_central = new JPanel();
			jPanel_central.setLayout(new GridBagLayout());
			jPanel_central.setBackground(Color.white);
			jPanel_central.add(getjScrollingpane(), gridBagConstraints2);
			jPanel_central.add(jLabel, gridBagConstraints3);
			jPanel_central.add(jLabel1_randomico1, gridBagConstraints29);
			jPanel_central.add(jLabel1_n_da_pergunta, gridBagConstraints28);
			jPanel_central.add(getJButton_exibir_imagem(), gridBagConstraints31);
		}
		return jPanel_central;
	}

	/**
	 * This method initializes jPanel_botoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_botoes() {
		if (jPanel_botoes == null) {
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.gridx = 8;
			gridBagConstraints30.gridy = 0;
			jLabel1_correta = new JLabel();
			jLabel1_correta.setText("JLabel");
			jLabel1_correta.setVisible(false);
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 0;
			gridBagConstraints26.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints26.gridy = 0;
			jLabel1_codigo = new JLabel();
			jLabel1_codigo.setText("Código:");
			jLabel1_codigo.setFont(new Font("Arial", Font.BOLD, 14));
			jLabel1_codigo.setVisible(false);
			jLabel1_subestacao_array = new JLabel();
			jLabel1_subestacao_array.setText("JLabel");
			jLabel1_subestacao_array.setForeground(Color.red);
			jLabel1_subestacao_array.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel1_autor_array = new JLabel();
			jLabel1_autor_array.setText("JLabel");
			jLabel1_autor_array.setForeground(Color.red);
			jLabel1_autor_array.setFont(new Font("Dialog", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 7;
			gridBagConstraints11.gridy = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 7;
			gridBagConstraints7.gridy = 2;
			jLabel1_subestacao = new JLabel();
			jLabel1_subestacao.setText("Subestação:");
			jLabel1_subestacao.setFont(new Font("Arial", Font.BOLD, 14));
			jLabel1_autor = new JLabel();
			jLabel1_autor.setText("Autor:");
			jLabel1_autor.setFont(new Font("Arial", Font.BOLD, 14));
			jLabel1_Assunto = new JLabel();
			jLabel1_Assunto.setText("Assunto:");
			jLabel1_Assunto.setFont(new Font("Arial", Font.BOLD, 14));
			jPanel_botoes = new JPanel();
			jPanel_botoes.setLayout(new GridBagLayout());
			jPanel_botoes.setBackground(Color.white);
			jPanel_botoes.add(getJPanel_botoesdeavaco(), gridBagConstraints7);
			jPanel_botoes.add(getJPanel_informacoessobreapergunta(), gridBagConstraints11);
			jPanel_botoes.add(jLabel1_codigo, gridBagConstraints26);
			jPanel_botoes.add(jLabel1_correta, gridBagConstraints30);
		}
		return jPanel_botoes;
	}

	/**
	 * This method initializes jButton_Voltar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Voltar() {
		if (jButton_Voltar == null) {
			jButton_Voltar = new JButton();
			jButton_Voltar.setText("<< Voltar");
			jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButton_Avancar.setEnabled(true);
					grupo.clearSelection();
					if(posicaodoarray == 0){
						PreenchecomoArraylist(posicaodoarray);
						jButton_Voltar.setEnabled(false);
					}else{
						if(posicaodoarray > 0 && posicaodoarray <= tamanhodoarray){
							posicaodoarray--;
							PreenchecomoArraylist(posicaodoarray);
						}
					}
					
				}
			});
		}
		return jButton_Voltar;
	}

	/**
	 * This method initializes jButton_Avancar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Avancar() {
		if (jButton_Avancar == null) {
			jButton_Avancar = new JButton();
			jButton_Avancar.setText("Avançar >> ");
			jButton_Avancar.setPreferredSize(new Dimension(101, 26));
			jButton_Avancar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(perguntaselecionada.equals("")){
						JOptionPane.showMessageDialog(null,"ERRO. É preciso selecionar uma RESPOSTA.","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						jButton_Voltar.setEnabled(true);
						grupo.clearSelection();
						//System.out.println(perguntaselecionada+" "+jLabel1_correta.getText());
						if(perguntaselecionada.equals(jLabel1_correta.getText())){
							acertos++;
							acertou=1;
						}else{
							erros++;
							acertou=0;
						}
						estatisticastb.setResposta_assinalada(perguntaselecionada);
						estatisticastb.setResposta_correta(jLabel1_correta.getText());
						estatisticastb.setAcertou(acertou);
						estatisticastb.setId_usuario(telapai.id_usuario);
						//implementando o save das estatisticas
						Simulado_Metodos simu1 = new Simulado_Metodos();
						simu1.Salvar_Estatisticas(estatisticastb);
						if(tamanhodoarray>numerodeperguntas){
							tamanhodoarrayaux = tamanhodoarray;
							tamanhodoarray = numerodeperguntas;
						}
						if(posicaodoarray < (tamanhodoarray-1)){
							posicaodoarray++;
							//códigos randomicos
							int rand;
							boolean flag = false;
							do{
								rand = getPerguntaAleatória();
								flag=false;
								for(int i=0;i<arrayint.length;i++){
									//System.out.println("arrayint[i]: "+arrayint[i]+" rand: "+rand);
									if(arrayint[i]==rand){
										flag=true;
									}
								}
								//System.out.println(flag);
							}while(flag==true);
							//System.out.println("posicaodoarray: "+posicaodoarray+
									//" rand: "+rand+" arrayint[posicaodoarray]: "+arrayint[posicaodoarray]);
							arrayint[posicaodoarray]=rand;
							PreenchecomoArraylist(rand);
							//
							verificarandomico += pergunta.get(rand).getId_PerguntasTB();
							verificarandomico += ", ";
							jLabel1_randomico1.setText(verificarandomico);
							jLabel1_n_da_pergunta.setText(((posicaodoarray)+1)+")");
							if(((posicaodoarray)+1)>=5){
								jButton_terminar.setEnabled(true);
							}
						}else{
							if(figura!=null){
								figura.dispose();
							}
							jButton_Avancar.setEnabled(false);
							int aproveitamento = (acertos*100)/tamanhodoarray;
							int i=0;
							if(aproveitamento >= 70 && aproveitamento < 100){
								i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Parabéns!  Passou OPERADOR.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
											"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
							}
							if(aproveitamento <70){
								i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Precisa estudar mais Operador.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
											"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
							}
							if(aproveitamento==100){
								i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Ótimo! VOÇÊ É BOM.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
											"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
							}
							Simulado_Metodos simuladormetodos = new Simulado_Metodos();
							SimuladoTB simu = new SimuladoTB(telapai.id_usuario, telapai.usuario, acertos, erros, tamanhodoarray, num_simulado);
							simuladormetodos.Salvar_novo_Estatisticas(simu);
							Simuladoassunto.this.dispose();
							if(i == 0){
								Relatorio6 r4 = new Relatorio6();
								r4.abrirRelatorio(num_simulado);
							}
						}
						perguntaselecionada="";
					}
				}
			});
		}
		return jButton_Avancar;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextArea getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextArea();
			jTextPane.setFont(new Font("Arial", Font.BOLD, 18));
			jTextPane.setLineWrap(true);
			jTextPane.setWrapStyleWord(true);
			//jTextPane.setPreferredSize(new Dimension(970, 100));
			jTextPane.setAutoscrolls(true);
		}
		return jTextPane;
	}

	/**
	 * This method initializes jPanel_respostas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_respostas() {
		if (jPanel_respostas == null) {
			
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.fill = GridBagConstraints.NONE;
			gridBagConstraints25.gridy = 6;
			gridBagConstraints25.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints25.gridx = 2;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.NONE;
			gridBagConstraints24.gridy = 5;
			gridBagConstraints24.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints24.gridx = 2;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.fill = GridBagConstraints.NONE;
			gridBagConstraints23.gridy = 4;
			gridBagConstraints23.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints23.gridx = 2;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.fill = GridBagConstraints.NONE;
			gridBagConstraints22.gridy = 3;
			gridBagConstraints22.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints22.gridx = 2;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.NONE;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints21.gridx = 2;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.NONE;
			gridBagConstraints20.gridy = 1;
			gridBagConstraints20.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints20.gridx = 2;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.fill = GridBagConstraints.NONE;
			gridBagConstraints19.gridy = 0;
			gridBagConstraints19.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints19.gridx = 2;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints18.anchor = GridBagConstraints.NORTH;
			gridBagConstraints18.gridy = 6;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints17.anchor = GridBagConstraints.NORTH;
			gridBagConstraints17.gridy = 5;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints16.anchor = GridBagConstraints.NORTH;
			gridBagConstraints16.gridy = 4;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints15.anchor = GridBagConstraints.NORTH;
			gridBagConstraints15.gridy = 3;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints14.anchor = GridBagConstraints.NORTH;
			gridBagConstraints14.gridy = 2;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints13.anchor = GridBagConstraints.NORTH;
			gridBagConstraints13.gridy = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints12.anchor = GridBagConstraints.NORTH;
			gridBagConstraints12.gridy = 0;
			jPanel_respostas = new JPanel();
			jPanel_respostas.setLayout(new GridBagLayout());
			jPanel_respostas.setBackground(Color.white);
			jPanel_respostas.add(getJRadioButton_A(), gridBagConstraints12);
			jPanel_respostas.add(getJRadioButton_B(), gridBagConstraints13);
			jPanel_respostas.add(getJRadioButton_C(), gridBagConstraints14);
			jPanel_respostas.add(getJRadioButton_D(), gridBagConstraints15);
			jPanel_respostas.add(getJRadioButton_E(), gridBagConstraints16);
			jPanel_respostas.add(getJRadioButton_F(), gridBagConstraints17);
			jPanel_respostas.add(getJRadioButton_G(), gridBagConstraints18);
			
			jPanel_respostas.add(getJTextPane_A(), gridBagConstraints19);
			jPanel_respostas.add(getJTextPane_B(), gridBagConstraints20);
			jPanel_respostas.add(getJTextPane_C(), gridBagConstraints21);
			jPanel_respostas.add(getJTextPane_D(), gridBagConstraints22);
			jPanel_respostas.add(getJTextPane_E(), gridBagConstraints23);
			jPanel_respostas.add(getJTextPane_F(), gridBagConstraints24);
			jPanel_respostas.add(getJTextPane_G(), gridBagConstraints25);
		}
		return jPanel_respostas;
	}

	/**
	 * This method initializes jPanel_botoesdeavaco	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_botoesdeavaco() {
		if (jPanel_botoesdeavaco == null) {
			GridBagConstraints gridBagConstraints81 = new GridBagConstraints();
			gridBagConstraints81.gridx = 2;
			gridBagConstraints81.insets = new Insets(0, 10, 20, 10);
			gridBagConstraints81.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(0, 10, 20, 10);
			gridBagConstraints.gridy = 1;
			gridBagConstraints.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(0, 10, 20, 10);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.gridx = -1;
			jPanel_botoesdeavaco = new JPanel();
			jPanel_botoesdeavaco.setLayout(new GridBagLayout());
			jPanel_botoesdeavaco.setBackground(Color.white);
			jPanel_botoesdeavaco.add(getJButton_Voltar(), gridBagConstraints1);
			jPanel_botoesdeavaco.add(getJButton_Avancar(), gridBagConstraints);
			jPanel_botoesdeavaco.add(getJButton_terminar(), gridBagConstraints81);
		}
		return jPanel_botoesdeavaco;
	}

	/**
	 * This method initializes jPanel_informacoessobreapergunta	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_informacoessobreapergunta() {
		if (jPanel_informacoessobreapergunta == null) {
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 0;
			gridBagConstraints27.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints27.gridy = 0;
			jLabel1_codigo_array = new JLabel();
			jLabel1_codigo_array.setText("ffff");
			jLabel1_codigo_array.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel1_codigo_array.setVisible(false);
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridx = 6;
			gridBagConstraints9.gridy = -1;
			gridBagConstraints9.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 5;
			gridBagConstraints6.gridy = -1;
			gridBagConstraints6.insets = new Insets(10, 10, 10, 0);
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.gridx = 4;
			gridBagConstraints8.gridy = -1;
			gridBagConstraints8.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = -1;
			gridBagConstraints5.insets = new Insets(10, 10, 10, 0);
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.anchor = GridBagConstraints.WEST;
			gridBagConstraints10.gridx = 2;
			gridBagConstraints10.gridy = -1;
			gridBagConstraints10.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.gridy = -1;
			gridBagConstraints4.insets = new Insets(10, 10, 10, 0);
			jLabel1_assunto_array = new JLabel();
			jLabel1_assunto_array.setText("JLabel");
			jLabel1_assunto_array.setForeground(Color.red);
			jLabel1_assunto_array.setFont(new Font("Dialog", Font.BOLD, 12));
			jPanel_informacoessobreapergunta = new JPanel();
			jPanel_informacoessobreapergunta.setLayout(new GridBagLayout());
			jPanel_informacoessobreapergunta.setBackground(Color.white);
			jPanel_informacoessobreapergunta.add(jLabel1_Assunto, gridBagConstraints4);
			jPanel_informacoessobreapergunta.add(jLabel1_assunto_array, gridBagConstraints10);
			jPanel_informacoessobreapergunta.add(jLabel1_autor, gridBagConstraints5);
			jPanel_informacoessobreapergunta.add(jLabel1_autor_array, gridBagConstraints8);
			jPanel_informacoessobreapergunta.add(jLabel1_subestacao, gridBagConstraints6);
			jPanel_informacoessobreapergunta.add(jLabel1_subestacao_array, gridBagConstraints9);
			jPanel_informacoessobreapergunta.add(jLabel1_codigo_array, gridBagConstraints27);
		}
		return jPanel_informacoessobreapergunta;
	}

	/**
	 * This method initializes jRadioButton_A	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	protected void radioButtonActionPerformed(ActionEvent evt) {            
	       perguntaselecionada=evt.getActionCommand();
	    }

	ActionListener radioButtonActionListener = new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            radioButtonActionPerformed(evt);  //  @jve:decl-index=0:
        }
    };
	private JTextPane jTextPane_A = null;
	private JTextPane jTextPane_B = null;
	private JTextPane jTextPane_C = null;
	private JTextPane jTextPane_D = null;
	private JTextPane jTextPane_E = null;
	private JTextPane jTextPane_F = null;
	private JTextPane jTextPane_G = null;
	private JLabel jLabel1_codigo = null;
	private JLabel jLabel1_codigo_array = null;
	private JLabel jLabel1_randomico1 = null;
	private JLabel jLabel1_n_da_pergunta = null;
	private JButton jButton_terminar = null;
	private JLabel jLabel1_correta = null;
	private JButton jButton_exibir_imagem = null;
	private JRadioButton getJRadioButton_A() {
		if (jRadioButton_A == null) {
			jRadioButton_A = new JRadioButton("A:");
			jRadioButton_A.setBackground(Color.white);
			jRadioButton_A.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_A.setActionCommand("A");
			jRadioButton_A.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_A;
	}

	/**
	 * This method initializes jRadioButton_B	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_B() {
		if (jRadioButton_B == null) {
			jRadioButton_B = new JRadioButton("B:");
			jRadioButton_B.setBackground(Color.white);
			jRadioButton_B.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_B.setActionCommand("B");
			jRadioButton_B.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_B;
	}

	/**
	 * This method initializes jRadioButton_C	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_C() {
		if (jRadioButton_C == null) {
			jRadioButton_C = new JRadioButton("C:");
			jRadioButton_C.setBackground(Color.white);
			jRadioButton_C.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_C.setActionCommand("C");
			jRadioButton_C.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_C;
	}

	/**
	 * This method initializes jRadioButton_D	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_D() {
		if (jRadioButton_D == null) {
			jRadioButton_D = new JRadioButton("D:");
			jRadioButton_D.setBackground(Color.white);
			jRadioButton_D.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_D.setActionCommand("D");
			jRadioButton_D.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_D;
	}

	/**
	 * This method initializes jRadioButton_E	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_E() {
		if (jRadioButton_E == null) {
			jRadioButton_E = new JRadioButton("E:");
			jRadioButton_E.setBackground(Color.white);
			jRadioButton_E.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_E.setActionCommand("E");
			jRadioButton_E.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_E;
	}

	/**
	 * This method initializes jRadioButton_F	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_F() {
		if (jRadioButton_F == null) {
			jRadioButton_F = new JRadioButton("F:");
			jRadioButton_F.setBackground(Color.white);
			jRadioButton_F.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_F.setActionCommand("F");
			jRadioButton_F.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_F;
	}

	/**
	 * This method initializes jRadioButton_G	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_G() {
		if (jRadioButton_G == null) {
			jRadioButton_G = new JRadioButton("G:");
			jRadioButton_G.setBackground(Color.white);
			jRadioButton_G.setFont(new Font("Arial", Font.BOLD, 14));
			jRadioButton_G.setActionCommand("G");
			jRadioButton_G.addActionListener(radioButtonActionListener);
		}
		return jRadioButton_G;
	}
	private void Carregar_Perguntas(){
		if(jTextPane_A.getText().equals(null) || jTextPane_A.getText().equals("")){
			jRadioButton_A.setVisible(false);
			jTextPane_A.setVisible(false);
		}else{
			jRadioButton_A.setVisible(true);
			jTextPane_A.setVisible(true);
		}
		if(jTextPane_B.getText().equals(null) || jTextPane_B.getText().equals("")){
			jRadioButton_B.setVisible(false);
			jTextPane_B.setVisible(false);
		}else{
			jRadioButton_B.setVisible(true);
			jTextPane_B.setVisible(true);
		}
		if(jTextPane_C.getText().equals(null) || jTextPane_C.getText().equals("")){
			jRadioButton_C.setVisible(false);
			jTextPane_C.setVisible(false);
		}else{
			jRadioButton_C.setVisible(true);
			jTextPane_C.setVisible(true);
		}
		if(jTextPane_D.getText().equals(null) || jTextPane_D.getText().equals("")){
			jRadioButton_D.setVisible(false);
			jTextPane_D.setVisible(false);
		}else{
			jRadioButton_D.setVisible(true);
			jTextPane_D.setVisible(true);
		}
		if(jTextPane_E.getText().equals(null) || jTextPane_E.getText().equals("")){
			jRadioButton_E.setVisible(false);
			jTextPane_E.setVisible(false);
		}else{
			jRadioButton_E.setVisible(true);
			jTextPane_E.setVisible(true);
		}
		if(jTextPane_F.getText().equals(null) || jTextPane_F.getText().equals("")){
			jRadioButton_F.setVisible(false);;
			jTextPane_F.setVisible(false);
		}else{
			jRadioButton_F.setVisible(true);;
			jTextPane_F.setVisible(true);
		}
		if(jTextPane_G.getText().equals(null) || jTextPane_G.getText().equals("")){
			jRadioButton_G.setVisible(false);
			jTextPane_G.setVisible(false);
		}else{
			jRadioButton_G.setVisible(true);
			jTextPane_G.setVisible(true);
		}
	}
	private void PreenchecomoArraylist(int i){
		Autores_metodos autoresmetodos = new Autores_metodos();
		jTextPane.setText(pergunta.get(i).getEnunciado_PerguntasTB());
		//combo box subestação
		int iddasubestacao = pergunta.get(i).getSubestacaoTBTB_id_SubestacaoTB();
		String nomedasubestacao = autoresmetodos.retornaSubestação(iddasubestacao);
		jLabel1_subestacao_array.setText(nomedasubestacao);
		//combo box autores
		int iddoautor = pergunta.get(i).getAutorTBTB_id_AutorTB();
		String nomedoautor = perguntasmetodos.retornaNomedoAutor(iddoautor);
		jLabel1_autor_array.setText(nomedoautor);
		//combo box assuntos
		int iddoassunto = pergunta.get(i).getAssuntoTBTB_id_AssuntoTB();
		estatisticastb.setNum_pergunta(pergunta.get(i).getId_PerguntasTB());
		estatisticastb.setAssunto_pergunta(iddoassunto);
		String descricaodoassunto = perguntasmetodos.retornaAssunto(iddoassunto);
		jLabel1_assunto_array.setText(descricaodoassunto);
		//combo box codigo da pergunta
		jLabel1_codigo_array.setText(Integer.toString(pergunta.get(i).getId_PerguntasTB()));
		jLabel1_correta.setText(pergunta.get(i).getCorreta_PerguntasTB());
		//combo resposta correta
		//String correta = pergunta.get(0).getCorreta_PerguntasTB();
		//
		jTextPane_A.setText(pergunta.get(i).getResposta_a_PerguntasTB());
		jTextPane_B.setText(pergunta.get(i).getResposta_b_PerguntasTB());
		jTextPane_C.setText(pergunta.get(i).getResposta_c_PerguntasTB());
		jTextPane_D.setText(pergunta.get(i).getResposta_d_PerguntasTB());
		jTextPane_E.setText(pergunta.get(i).getResposta_e_PerguntasTB());
		jTextPane_F.setText(pergunta.get(i).getResposta_f_PerguntasTB());
		jTextPane_G.setText(pergunta.get(i).getResposta_g_PerguntasTB());
		//
		Carregar_Perguntas();
		//ser houver uma imagem, chama a janela Figura
		//System.out.println(pergunta.get(i).getId_figuratb());
		if(pergunta.get(i).getId_figuratb()!=0){
			iddafigura=pergunta.get(i).getId_figuratb();
			jButton_exibir_imagem.setVisible(true);
		}else{
			jButton_exibir_imagem.setVisible(false);
		}
	}

	/**
	 * This method initializes jTextPane_A	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_A() {
		if (jTextPane_A == null) {
			jTextPane_A = new JTextPane();
			jTextPane_A.setPreferredSize(new Dimension(800, 40));
			//jTextPane_A.setText("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		}
		return jTextPane_A;
	}

	/**
	 * This method initializes jTextPane_B	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_B() {
		if (jTextPane_B == null) {
			jTextPane_B = new JTextPane();
			jTextPane_B.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_B;
	}

	/**
	 * This method initializes jTextPane_C	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_C() {
		if (jTextPane_C == null) {
			jTextPane_C = new JTextPane();
			jTextPane_C.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_C;
	}

	/**
	 * This method initializes jTextPane_D	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_D() {
		if (jTextPane_D == null) {
			jTextPane_D = new JTextPane();
			jTextPane_D.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_D;
	}

	/**
	 * This method initializes jTextPane_E	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_E() {
		if (jTextPane_E == null) {
			jTextPane_E = new JTextPane();
			jTextPane_E.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_E;
	}

	/**
	 * This method initializes jTextPane_F	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_F() {
		if (jTextPane_F == null) {
			jTextPane_F = new JTextPane();
			jTextPane_F.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_F;
	}

	/**
	 * This method initializes jTextPane_G	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane_G() {
		if (jTextPane_G == null) {
			jTextPane_G = new JTextPane();
			jTextPane_G.setPreferredSize(new Dimension(800, 40));
		}
		return jTextPane_G;
	}
	private JScrollPane getjScrollingpane(){
		if (scrolingarea == null){
			scrolingarea = new JScrollPane(getJTextPane());
			scrolingarea.setPreferredSize(new Dimension(800, 200));
			scrolingarea.setBorder(null);
		}
	return scrolingarea;
	}

	/**
	 * This method initializes jButton_terminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_terminar() {
		if (jButton_terminar == null) {
			jButton_terminar = new JButton();
			jButton_terminar.setText("Terminar");
			jButton_terminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(perguntaselecionada.equals("")){
						JOptionPane.showMessageDialog(null,"ERRO. É preciso selecionar uma RESPOSTA.","Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
					}else{
						if(figura!=null){
							figura.dispose();
						}
						tamanhodoarray=((posicaodoarray)+1);
						//System.out.println(perguntaselecionada+" "+jLabel1_correta.getText());
						if(perguntaselecionada.equals(jLabel1_correta.getText())){
							acertos++;
							acertou=1;
						}else{
							erros++;
							acertou=0;
						}
						estatisticastb.setAcertou(acertou);
						//implementando o save das estatisticas
						Simulado_Metodos simu1 = new Simulado_Metodos();
						simu1.Salvar_Estatisticas(estatisticastb);
						int aproveitamento = (acertos*100)/tamanhodoarray;
						int i=0;
						if(aproveitamento >= 70 && aproveitamento < 100){
							i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Parabéns!  Passou OPERADOR.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
										"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
						}
						if(aproveitamento <70){
							i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Precisa estudar mais Operador.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
										"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
						}
						if(aproveitamento==100){
							i = JOptionPane.showConfirmDialog(null ," Aproveitamento: "+aproveitamento+"%\n Ótimo! VOÇÊ É BOM.\n\n Total de perguntas: "+tamanhodoarray+"\n Acertos: "+acertos+"\n Erros: "+erros+"\n\n Voçê deseja exibir o Relatório de Erros e Acertos?",
										"Mensagem do Sistema",JOptionPane.YES_NO_OPTION);
						}
						Simulado_Metodos simuladormetodos = new Simulado_Metodos();
						SimuladoTB simu = new SimuladoTB(telapai.id_usuario, telapai.usuario, acertos, erros, tamanhodoarray, num_simulado);
						simuladormetodos.Salvar_novo_Estatisticas(simu);
						Simuladoassunto.this.dispose();
						if(i == 0){
							Relatorio6 r4 = new Relatorio6();
							r4.abrirRelatorio(num_simulado);
						}
					}
						
					}
			});
		}
		return jButton_terminar;
	}

	/**
	 * This method initializes jButton_exibir_imagem	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_exibir_imagem() {
		if (jButton_exibir_imagem == null) {
			jButton_exibir_imagem = new JButton();
			jButton_exibir_imagem.setText("Exibir Imagem");
			//jButton_exibir_imagem.setVisible(false);
			jButton_exibir_imagem.setPreferredSize(new Dimension(105, 20));
			jButton_exibir_imagem.setFont(new Font("Dialog", Font.BOLD, 10));
			jButton_exibir_imagem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(figura!=null){
						figura.dispose();
					}
					figura = new Figura(iddafigura);
					figura.setVisible(true);
				}
			});
		}
		return jButton_exibir_imagem;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10" 
