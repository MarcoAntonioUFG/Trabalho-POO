import java.util.ArrayList;

public class Usuario{
	private String nome;
	private Mediador mediador;
	private Ui ui;
	
	public Usuario(String nome, Mediador mediador) {
		this.nome = nome;
		this.mediador = mediador;
		mediador.addUsuario(this);
	}
	
	public Ui getUi() {
		return ui;
	}

	public void setUi(Ui ui) {
		this.ui = ui;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Mediador getMediador() {
		return mediador;
	}

	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}
	
	public void enviarMensagem(String mensagem) {
       		mediador.addMessage(this, mensagem);
    	}

	public void addText(String mensagem) {
		ui.addText(mensagem);
	}

	public String enviarOutroUsuario() {
		return mediador.getOutroUsuario(this);
	}
}
