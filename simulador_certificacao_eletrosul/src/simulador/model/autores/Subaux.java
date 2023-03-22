package simulador.model.autores;

public class Subaux {
	 private String cidade;  
	       private String uf;  
	         
	       public Subaux() {  
	            
	       }  
	         
	       public Subaux(String cidade, String uf) {  
	          this.setCidade(cidade);  
	          this.setUf(uf);  
	       }  
	         
	       public String getCidade() {  
	          return this.cidade;  
	       }  
	         
	       public void setCidade(String cidade) {  
	          this.cidade = cidade;  
	       }  
	         
	       public String getUf() {  
	          return uf;  
	       }  
	         
	       public void setUf(String uf) {  
	          this.uf = uf;  
	       }  
	         
	       public String toString() {  
	          return this.getCidade();  
	       }    
}
