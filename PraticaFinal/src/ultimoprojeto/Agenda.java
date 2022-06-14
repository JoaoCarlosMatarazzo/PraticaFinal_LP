package ultimoprojeto;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtData2;
	private JTextField txtHora;
	private JTextField txtDescricao;
	private JTextField textAcao;

	@SuppressWarnings("unused")
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter(mascara);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return mask;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Agenda() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrando Agenda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(127, 11, 155, 20);
		contentPane.add(lblNewLabel);
		
		
		txtData2 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData2.setBounds(127, 42, 104, 20);
		contentPane.add(txtData2);
		txtData2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Hora:");
		lblNewLabel_2.setBounds(92, 86, 38, 14);
		contentPane.add(lblNewLabel_2);
		
		txtHora = new JFormattedTextField(new MaskFormatter("##:##"));
		txtHora.setBounds(127, 83, 81, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_3.setBounds(68, 117, 78, 14);
		contentPane.add(lblNewLabel_3);
		//try {
		txtDescricao = new JTextField();
		//new JFormattedTextField(setMascara("ULLLL");
		
		/*}catch(ParseExeption e2) {
			String caracteres="0987654321";
			AWTEvent evt;
			if(caracteres.contains(evt.getKeyChar()+"")){
			evt.consume();
			}*/
		
		txtDescricao.setBounds(127, 114, 145, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(50);
		
		JButton salvar2 = new JButton("Salvar");
		salvar2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<String> Agenda = new ArrayList<String>();
				String hora = txtHora.getText();
				String descricao = txtDescricao.getText();
				String acao = textAcao.getText();
				String data2 = txtData2.getText();
				
				Agenda.add( hora+";"+descricao+";"+acao+";"+data2);				
				try {
					ManipuladorArquivo.escritor("Prática.Txt",Agenda.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
												
				JOptionPane.showMessageDialog(null, "Ihow, deu certo! Partiu fazer outra rodada?");
				JOptionPane.showMessageDialog(null, " Então tá né? Bora lá b(;-;)b");
				
				fim telaDeCadastro = new fim();
				telaDeCadastro.setVisible(true);
			}
				
			
		});
		salvar2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salvar2.setBounds(46, 198, 155, 23);
		contentPane.add(salvar2);
		
		JLabel acao = new JLabel("A\u00E7\u00E3o:");
		acao.setBounds(92, 156, 46, 14);
		contentPane.add(acao);
		
		textAcao = new JTextField();
		textAcao.setBounds(127, 153, 145, 20);
		contentPane.add(textAcao);
		textAcao.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Agradeço pela preferência de nossos serviços.(^-^)");
				
				fim telaDeCadastro = new fim();
				telaDeCadastro.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(241, 200, 145, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Data:");
		lblNewLabel_6.setBounds(97, 45, 38, 14);
		contentPane.add(lblNewLabel_6);
	}
}
