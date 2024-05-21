import java.util.ArrayList;

public class MediadorConcreto implements Mediador {

	private ArrayList<String> historico;
	private Usuario user1;
	private Usuario user2;
	private String remetente;
	private String destinatario;
	
	public MediadorConcreto(Usuario user1, Usuario user2, String remetente, String destinatario) {
		setHistorico(new ArrayList<String>());
		this.user1 = user1;
		this.user2 = user2;
		this.remetente = remetente;
		this.destinatario = destinatario;
	}
	
	
	@Override
	public void EnviarMensagem(Usuario user1, Usuario user2) {
		remetente = user1.getNome();
		destinatario = user2.getNome();
		historico.add(remetente+user1.getMensagem());
	}

	@Override
	public void ReceberMensagem(Usuario user1, Usuario user2) {
		remetente = user2.getNome();
		destinatario = user1.getNome();
		historico.add(remetente+user1.getMensagem());
	}


	public ArrayList<String> getHistorico() {
		return historico;
	}


	public void setHistorico(ArrayList<String> historico) {
		this.historico = historico;
	}


	public Usuario getUser1() {
		return user1;
	}


	public void setUser1(Usuario user1) {
		this.user1 = user1;
	}


	public Usuario getUser2() {
		return user2;
	}


	public void setUser2(Usuario user2) {
		this.user2 = user2;
	}


	public String getRemetente() {
		return remetente;
	}


	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
}
