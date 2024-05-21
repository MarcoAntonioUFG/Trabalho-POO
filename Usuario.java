import java.util.ArrayList;

public class Usuario {
	private String nome;
	private Mediador mediador;
	private Ui ui;
	
	
	public Usuario(String nome) {
		this.nome = nome;
	}
	
	public Ui getUi() {
		return ui;
	}

	public void setUi(Ui ui) {
		this.ui = ui;
	}
	
	public void enviarMensagem(String mensagem, Usuario dest) {
        ((MediadorConcreto)mediador).receberMensagem(this, mensagem);
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
}
