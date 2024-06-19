import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
	
		MediadorConcreto mediador = new MediadorConcreto();
		
		String nome1 = JOptionPane.showInputDialog("Insira seu nome:");
		String nome2 = JOptionPane.showInputDialog("Insira seu nome:");
		
		
		Usuario usuario1 = new Usuario(nome1, mediador);
		Usuario usuario2 = new Usuario(nome2, mediador);
		
		Ui ui1 = new Ui(usuario1);
		Ui ui2 = new Ui(usuario2);
		
	}
}
