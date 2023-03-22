package simulador.model.relatorios;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class ReportUtils {
	
    public static void openReport(
            String titulo,
            InputStream inputStream,
            Map<?, ?> parametros,
            Connection conexao ) throws JRException {

        /*
         * Cria um JasperPrint, que � a vers�o preenchida do relat�rio,
         * usando uma conex�o.
         */
        @SuppressWarnings("unchecked")
		JasperPrint print = JasperFillManager.fillReport(inputStream, (Map<String, Object>) parametros, conexao);
        //JasperPrint print = null;
        // abre o JasperPrint em um JFrame
        //viewReportFrame( titulo, print );
        viewReportFrame( titulo, print );

    }
    private static void viewReportFrame( String titulo, JasperPrint print ) {

        /*
         * Cria um JRViewer para exibir o relat�rio.
         * Um JRViewer � uma JPanel.
         */
        JRViewer viewer = new JRViewer( print );

        // cria o JFrame
        JFrame frameRelatorio = new JFrame( titulo );

        // adiciona o JRViewer no JFrame
        frameRelatorio.add( viewer, BorderLayout.CENTER );

        // configura o tamanho padr�o do JFrame
        frameRelatorio.setSize( 500, 500 );

        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );

        // configura a opera��o padr�o quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        // exibe o JFrame
        frameRelatorio.setVisible( true );

    }

}