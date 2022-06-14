package ultimoprojeto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class fim extends JFrame {
/*
 Cadastrar dados de um Projeto Social como: 
 título, objetivo, endereço completo, data de início e status.

Cadastrar agenda do Projeto Social como: 
data, hora, descrição e ação (em execução, paralisado, executado, etc). 

*será possível cadastrar mais de uma agenda por projeto.

    
    
    Especificação Técnica:
    
    --Definir como será a estrutura de dados, pode-se utilizar ArrayList, por exemplo. 
    
    Salvar em arquivo (exemplo TXT) os dados  do projeto e a agenda.
    
    Será possível carregar os dados salvos e anexar mais detalhes da agenda.
    
    Tratamento de erros (Try, Catch, Finaly).
    
    Tipos primitivos e classes
    
    Interface gráfica 
*/
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) throws IOException {
		
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fim frame = new fim();
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
	public fim() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja Bem-Vindo(a)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(124, 35, 141, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Por favor, escolha a op\u00E7\u00E3o desejada:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(72, 78, 246, 36);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Projeto Social");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cadastro telaDeCadastro = new cadastro();
				telaDeCadastro.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(80, 125, 226, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Agenda do Projeto ");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Agenda telaDeAgenda = null;
				try {
					telaDeAgenda = new Agenda();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				telaDeAgenda.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(80, 159, 226, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Visualizar Projeto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Resultado telaDeResultado = new Resultado();
				telaDeResultado.setVisible(true);
			}
		});
		btnNewButton.setBounds(80, 193, 226, 23);
		contentPane.add(btnNewButton);
	}
}
