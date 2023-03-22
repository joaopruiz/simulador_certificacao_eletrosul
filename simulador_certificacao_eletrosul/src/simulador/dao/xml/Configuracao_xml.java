package simulador.dao.xml;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import simulador.view.Mensagens;
import simulador.view.teste.DesEncrypter;

import com.thoughtworks.xstream.XStream;

public class Configuracao_xml {
	public Server_xml LeroXml() throws IOException{
		Server_xml server = new Server_xml();
		String decrypted="erro na chave";
		try {
			XStream xstream = new XStream();
			String xml ="";
			// Lendo do arquivo
			//File arquivo;
			//arquivo = new File("/configuracoesderede.xml");
			//InputStream arquivo1 = getClass().getResourceAsStream("/configuracoesderede.xml");
			//System.out.println(xml);
			
			  //BufferedReader in = new BufferedReader(new FileReader(arquivo));
			  //BufferedReader in = new BufferedReader(getClass().getResourceAsStream("/configuracoesderede.xml"));
			  //FileInputStream in = new FileInputStream(getClass().getResource("/configuracoesderede.xml").getFile());
			  BufferedReader in = new BufferedReader(new FileReader(getClass().getResource("/configuracoesderede.xml").getFile()));
			             String line;  
			             while((line = in.readLine())!=null)  
			             {  
			                xml+=line;
			             }
			             try {
			            	 byte[] desKeyData = ("bergamot").getBytes();
			                 SecretKeySpec chave = new SecretKeySpec(desKeyData, "DES");
			                 DesEncrypter encrypter = new DesEncrypter(chave);
			         	    // Decrypt
			         	    decrypted = encrypter.decrypt(xml);
			         	} catch (Exception e) {
			         	}
			 server = (Server_xml) xstream.fromXML(decrypted);
		in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return server; 
	}
	public void GravaroXml(Server_xml server){
		String encrypted="";
		// Criando um objeto XStream		
		XStream xstream = new XStream();
		// Passando os dados de Objetos Java para XML
		String contatosEmXML = xstream.toXML(server);
		try {
    	    //SecretKey key = KeyGenerator.getInstance("DES").generateKey();
    	    byte[] desKeyData = ("bergamot").getBytes();
            SecretKeySpec chave = new SecretKeySpec(desKeyData, "DES");
            DesEncrypter encrypter = new DesEncrypter(chave);
    	    // Encrypt
    	    encrypted = encrypter.encrypt(contatosEmXML);
    	    // Decrypt
    	    //String decrypted = encrypter.decrypt(encrypted);
    	} catch (Exception e) {
    	}
		  try {  
			          // Gravando no arquivo  
			          //File arquivo;  
			   
			          //arquivo = new File("/configuracoesderede.xml");  
			          //FileOutputStream fos = new FileOutputStream(arquivo);
			          FileOutputStream fos = new FileOutputStream(getClass().getResource("/configuracoesderede.xml").getFile());
			          //BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(getClass().getResourceAsStream("/configuracoesderede.xml")));
			          //String texto = "quero gravar este texto no arquivo";  
			          //fos.write(texto.getBytes());  
			          //texto = "\nquero gravar este texto AQUI TAMBEM";  
			          fos.write(encrypted.getBytes());  
			          fos.close();  
			   
			          // Lendo do arquivo  
			          /*arquivo = new File("arquivo.txt");  
			          FileInputStream fis = new FileInputStream(arquivo);  
			   
			          int ln;  
			          while ( (ln = fis.read()) != -1 ) {  
			             System.out.print( (char)ln );  
			          }  
			   
			          fis.close();  */
			          Mensagens mensagens = new Mensagens();
			          mensagens.MensagemdeSucesso();
			       }  
			       catch (Exception ee) {  
			          ee.printStackTrace();  
			       }  
		
		// Passando os dados de XML para Objetos Java
		/*List amigos = (List) xstream.fromXML(contatosEmXML);
		Pessoa amigo = (Pessoa) amigos.get(0);
		Telefone foneDoAmigo = amigo.getFoneComercial();

		System.out.println("\nAmigo como Objeto Java:");
		System.out.println("Nome: " + amigo.getNome());
		System.out.println(
			"Fone Comercial: ("
				+ foneDoAmigo.getDdd()
				+ ") "
				+ foneDoAmigo.getNumero());*/
			       
	
	}
	
}

