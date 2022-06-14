package ultimoprojeto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Resultado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultado frame = new Resultado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static void leitor(String path) throws IOException {
		
		try {	
		
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		String n="";
						
		while (true) {
			if (linha != null) {
				try {
					n = n + linha + "\n";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
		
		JTextArea textArea = new JTextArea(n);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 300, 300 ) );
		JOptionPane.showMessageDialog(null, scrollPane, "Resultado"+n, JOptionPane.INFORMATION_MESSAGE);
		}
		
		catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erro", "Ocorreu um erro, tente novamente!", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	public Resultado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Resultado da Edi\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(144, 11, 171, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnAbrir = new JButton("Apresentar Cadastro");
		btnAbrir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAbrir.addActionListener(new ActionListener() {
			
			
			
			
			public void actionPerformed(ActionEvent e) {
					String path= "teste.txt";
					try {
						leitor(path);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			}
		});
		btnAbrir.setBounds(129, 69, 186, 42);
		contentPane.add(btnAbrir);
		
		JButton btnAbrir2 = new JButton("Apresentar Agenda");
		btnAbrir2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAbrir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path="Prática.txt";
				try {
					leitor(path);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAbrir2.setBounds(129, 123, 186, 42);
		contentPane.add(btnAbrir2);
		
		JButton voltartudo = new JButton("Voltar");
		voltartudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fim telaDeCadastro = new fim();
				telaDeCadastro.setVisible(true);
			}
		});
		voltartudo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		voltartudo.setBounds(129, 176, 186, 35);
		contentPane.add(voltartudo);
	}
}

