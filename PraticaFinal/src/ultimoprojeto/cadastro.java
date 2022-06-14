package ultimoprojeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtObjetivo;
	private JTextField txtEndereco;
	private JTextField txtData1;
	private JTextField txtStatus;
	
	@SuppressWarnings("unused")
	private MaskFormatter setMascara(String mascara) {
		MaskFormatter mask=null;
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
		try (Scanner ler = new Scanner(System.in)) {
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro frame = new cadastro();
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
	public cadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrando Dados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(141, 11, 151, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo do Projeto:");
		lblNewLabel_1.setBounds(41, 47, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(141, 44, 199, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Objetivo:");
		lblNewLabel_2.setBounds(41, 83, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setBounds(141, 80, 199, 20);
		contentPane.add(txtObjetivo);
		txtObjetivo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o Completo:");
		lblNewLabel_3.setBounds(30, 119, 136, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(141, 116, 258, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data de In\u00EDcio:");
		lblNewLabel_4.setBounds(41, 158, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		try {
			txtData1 = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
			
			e2.printStackTrace();
		}
		txtData1.setBounds(141, 155, 76, 20);
		contentPane.add(txtData1);
		txtData1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Status do Projeto:");
		lblNewLabel_5.setBounds(30, 198, 113, 14);
		contentPane.add(lblNewLabel_5);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(141, 195, 131, 20);
		contentPane.add(txtStatus);
		txtStatus.setColumns(10);
		
		JButton salvar1 = new JButton("Salvar");
		salvar1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> cadastro = new ArrayList<String>();
				String titulo = txtTitulo.getText();
				String objetivo = txtObjetivo.getText();
				String endereco = txtEndereco.getText();
				String data1 = txtData1.getText();
				String status = txtStatus.getText();
				
				cadastro.add( titulo+";"+objetivo+";"+endereco+";"+data1+";"+status);	
				try {
					ManipuladorArquivo.escritor("teste.Txt",cadastro.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso.");
				JOptionPane.showMessageDialog(null, "Obrigado por sua preferencia! /(^3^)/");
				fim telaDeCadastro = new fim();
				telaDeCadastro.setVisible(true);
			}
		});
		salvar1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salvar1.setBounds(150, 226, 131, 23);
		contentPane.add(salvar1);
	}
}
