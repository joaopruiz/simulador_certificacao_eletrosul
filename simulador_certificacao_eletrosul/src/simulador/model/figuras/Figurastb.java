package simulador.model.figuras;

import java.sql.Blob;

public class Figurastb {
	private int id;
	private String descricao;
	private Blob figura;
	public Figurastb(int id, String descricao, Blob figura) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.figura = figura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Blob getFigura() {
		return figura;
	}
	public void setFigura(Blob figura) {
		this.figura = figura;
	}
	
}
