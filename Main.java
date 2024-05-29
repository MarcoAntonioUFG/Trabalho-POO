
public class Main {
	public static void main(String[] args) {
	
		MediadorConcreto mediador = new MediadorConcreto();
		
		Usuario usuario1 = new Usuario("Alex", mediador);
		Usuario usuario2 = new Usuario("Marco", mediador);
		
		Ui ui1 = new Ui(usuario1);
		Ui ui2 = new Ui(usuario2);
		
	}
}
