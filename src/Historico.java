import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "historico")
public class Historico {
	private int id;
	private Date data;
	private Date duracao;
	private String dificuldade;
	
	public Historico() {
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Historico(int id, Date data, Date duracao, String dificuldade) {
		super();
		this.id = id;
		this.data = data;
		this.duracao = duracao;
		this.dificuldade = dificuldade;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

}
