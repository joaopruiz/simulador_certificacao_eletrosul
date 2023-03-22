package simulador.view;

import javax.swing.JOptionPane;

public class Mensagens {
	public void MensagemdeErro(String e){
		JOptionPane.showMessageDialog(null,"Ocorreu um erro na operação. \n"+ e,"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
	}
	public void MensagemdeSucesso(){
		JOptionPane.showMessageDialog(null,"Sucesso!!!","Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
	}
	public void MensagemdeErroDB(String e){
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao tentar conectar com o Banco de Dados. \n"+ e,"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
	}
}
