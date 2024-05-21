
public class Main {
	public static void main(String[] args) {

		MediadorConcreto mediador = new MediadorConcreto();
		
		Usuario usuario1 = new Usuario("Alex");
		usuario1.setMediador(mediador);
		Ui ui1 = new Ui(usuario1);
		mediador.setUser1(usuario1);
		
		Usuario usuario2 = new Usuario("Marco");
		usuario2.setMediador(mediador);
		Ui ui2 = new Ui(usuario2);
		mediador.setUser2(usuario2);
		
		ui1 = new Ui(usuario1);
		ui2 = new Ui(usuario2);
		
		ui1.window();
		ui2.window();
	}
}
