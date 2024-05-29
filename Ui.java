import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Ui {
	
	JFrame frame = new JFrame();
	Mediador mediador;
	private JTextField campoMensagem = new JTextField();
	private JTextArea textField_Mensagens = new JTextArea();
	private JButton enviarBtn = new JButton("ENVIAR");
	private JTextArea destinatarioUser = new JTextArea();
	Usuario usuario;
	
	
	public Ui(Usuario usuario) {
		this.usuario = usuario;
		usuario.setUi(this);
		
		mediador = usuario.getMediador();
		
		String usuario2 = usuario.enviarOutroUsuario();
		
		frame.getContentPane().setLayout(null);
		frame.setSize(450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField_Mensagens.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 414, 294);
		
		// BOTAO ENVIAR <-----
		enviarBtn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		enviarBtn.setBounds(353, 352, 71, 48);
		enviarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!campoMensagem.getText().isBlank()) {
					mediador.addMessage(usuario, campoMensagem.getText());
					campoMensagem.setText(null);
				}
			}
		});
		
		// CAMPO DE MENSAGENS (PARA ENVIAR) <----
		campoMensagem.setBounds(10, 352, 333, 48);
		frame.getContentPane().add(campoMensagem);
		campoMensagem.setColumns(10);
		campoMensagem.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					if(!campoMensagem.getText().isBlank()) {
						mediador.addMessage(usuario, campoMensagem.getText());
						campoMensagem.setText(null);
					}
		        }
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
		// CAMPO MENSAGENS (HISTORICO DE MENSAGENS) <----
		textField_Mensagens.setEditable(false);
		scrollPane.setViewportView(textField_Mensagens);
		textField_Mensagens.setColumns(10);
		
		// DESTINATARIO (COM QUEM VC ESTA FALANDO) <----
		destinatarioUser.setText(usuario.getNome()+"------->"+usuario2);
		destinatarioUser.setEditable(false);
		destinatarioUser.setBounds(10, 11, 414, 25);
		
		frame.getContentPane().add(destinatarioUser);
		frame.getContentPane().add(enviarBtn);
		frame.getContentPane().add(scrollPane);
		
		frame.setVisible(true);
	}


	public void addText(String mensagem) {
		String historico = textField_Mensagens.getText();
		historico += mensagem;
		textField_Mensagens.setText(historico);
	}
}
