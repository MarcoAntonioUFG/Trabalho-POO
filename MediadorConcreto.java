import java.util.ArrayList;

public class MediadorConcreto implements Mediador {

	private ArrayList<String> historico = new ArrayList<String>();
	private Usuario user1;
	private Usuario user2;
	
	
	public MediadorConcreto() {
	}
	
	@Override
	public void Notificar() {
		if (user1 != null && user1.getUi() != null) {
            user1.getUi().atualizar();
        }
        if (user2 != null && user2.getUi() != null) {
            user2.getUi().atualizar();
        }
	}
	
	@Override
	public void receberMensagem(Usuario user, String mensagem){
		historico.add(user.getNome() + ": " + mensagem + "\n");
		Notificar();
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


}
