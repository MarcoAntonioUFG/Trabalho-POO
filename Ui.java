import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

public class Ui {

	private JFrame frame;
	private JTextField textField;
	private Usuario usuario;
	private Mediador mediador;
	private JTextPane mensagens = new JTextPane();

	public Usuario getUsuario() { return usuario; }
	public void setUsuario(Usuario usuario) { this.usuario = usuario; }
	
	
	public Ui(Usuario usuario) {
		this.usuario = usuario;
		this.mediador = usuario.getMediador();
		usuario.setUi(this);
		initialize();
	}
	
	public void setMensagens(ArrayList<String> lista) {
		String aux = "";
		for (String item : lista) {
            aux += item;
        }
		this.mensagens.setText(aux);
	}
	
	public void atualizar() {
		setMensagens(((MediadorConcreto)mediador).getHistorico());
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		mensagens.setEditable(false);
		StyledDocument doc = mensagens.getStyledDocument();
        SimpleAttributeSet rightAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), rightAlign, false);
        
		JButton botao = new JButton("Enviar");
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	if(!textField.getText().isEmpty()) {
                		String caixaTexto = textField.getText();
                		((MediadorConcreto)mediador).receberMensagem(usuario, caixaTexto); 
                		textField.setText("");
                		atualizar();
                		((MediadorConcreto)mediador).Notificar();
                	}
                }
            }
		});
		
		ActionListener send;
		send = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
            		String caixaTexto = textField.getText();
            		((MediadorConcreto)mediador).receberMensagem(usuario, caixaTexto); 
            		textField.setText("");
            		atualizar();
            		((MediadorConcreto)mediador).Notificar();
            	}
			}
		};
		botao.addActionListener(send);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(mensagens, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botao)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(mensagens, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(botao, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void window() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui(usuario);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
