package simulador.view.figuras;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.JLabel;
import simulador.model.figuras.Figuras_Metodos;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;

@SuppressWarnings("unused")
public class Figura extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private int codigo=0;
	private JPanel jPanel_central = null;
	private JPanel jPanel_inferior = null;
	private JButton jButton_fechar = null;
	private JLabel jLabel_figura = null;
	private Blob blob = null; //is our blob object
	private int imagemHeight = 0;
	private int imagemWidth = 0;

	/**
	 * @param owner
	 */
	public Figura(int cod) {
		super();
		codigo = cod;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("Simulador de Certificação - Exibir Figura");
		this.getRootPane().setDefaultButton(jButton_fechar);
		int tempInt;
		byte[] imagem=null;
		Figuras_Metodos f1 = new Figuras_Metodos();
		/*blob = f1.retornaFigura(codigo);
		//System.out.println("conteúdo do blob= "+blob.toString());
		try {
			//System.out.println("entro no try");
			tempInt = (int) blob.length();
			//System.out.println("taunt 1");
			imagem = blob.getBytes(1, tempInt);
			//System.out.println("blob aki= ");
			//System.out.println("imagem aki= "+imagem);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		//System.out.println("dd= "+imagem);
		ImageIcon icon = new ImageIcon(f1.retornaFigura(codigo));
		//System.out.println("parou aki");
		//ImageIcon teste = new ImageIcon(getScaledImage(icon.getImage(), 400, 300));
		//jLabel_figura.setIcon(teste);
		imagemHeight = icon.getIconHeight();
		imagemWidth = icon.getIconWidth();
		this.setSize(imagemWidth+8, imagemHeight+48);
		jLabel_figura.setIcon(icon);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setBackground(Color.white);
			jContentPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			jContentPane.add(getJPanel_central(), BorderLayout.CENTER);
			jContentPane.add(getJPanel_inferior(), BorderLayout.SOUTH);
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
			jLabel_figura = new JLabel("", JLabel.CENTER);
			jPanel_central = new JPanel();
			jPanel_central.setLayout(new GridBagLayout());
			jPanel_central.add(jLabel_figura, new GridBagConstraints());
		}
		return jPanel_central;
	}

	/**
	 * This method initializes jPanel_inferior	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_inferior() {
		if (jPanel_inferior == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(0, 10, 0, 10);
			jPanel_inferior = new JPanel();
			jPanel_inferior.setLayout(new GridBagLayout());
			jPanel_inferior.setBackground(Color.white);
			jPanel_inferior.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel_inferior.add(getJButton_fechar(), gridBagConstraints);
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
					Figura.this.dispose();
				}
			});
		}
		return jButton_fechar;
	}

}
