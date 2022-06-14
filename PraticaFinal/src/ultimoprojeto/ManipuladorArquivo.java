package ultimoprojeto;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class ManipuladorArquivo {
	

	public static void escritor(String path, String conteudo) throws IOException {
		BufferedWriter escrever = new BufferedWriter(new FileWriter(path));
		escrever.append(conteudo);
		escrever.close();

	}
}