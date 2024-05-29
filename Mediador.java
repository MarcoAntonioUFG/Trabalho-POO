import java.util.ArrayList;

public interface Mediador {
	void Notificar(Usuario user);
	void addMessage(Usuario remetente, String mensagem);
	ArrayList<String> getHistorico();
	void addUsuario(Usuario usuario);
	String getOutroUsuario(Usuario user);
}
