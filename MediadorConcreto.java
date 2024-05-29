import java.util.ArrayList;

public class MediadorConcreto implements Mediador {
	
	private ArrayList<String> historico = new ArrayList<String>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public MediadorConcreto() {
		
	}
		
	@Override
	public ArrayList<String> getHistorico() {
		return historico;
	}

	@Override
	public void Notificar(Usuario user) {
		
	}
	
	@Override
	public void addMessage(Usuario remetente, String mensagem) {
		historico.add(remetente.getNome() + ": " + mensagem + "\n");
		System.out.println(remetente.getNome() + ": " + mensagem + "\n");
		for(Usuario user : usuarios) {
			user.addText(remetente.getNome() + ": " + mensagem + "\n");
		}
	}
	
	@Override 
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getOutroUsuario(Usuario user) {
		for(Usuario usuario : usuarios) {
			if(usuario != user) return usuario.getNome();
		}
		return "Error";
	}
}
