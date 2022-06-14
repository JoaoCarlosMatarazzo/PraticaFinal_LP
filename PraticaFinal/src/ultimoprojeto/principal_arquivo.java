package ultimoprojeto;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class principal_arquivo {

	public static void main(String[] args) throws IOException  {
		//String path = "AulaLP.txt";
		Path dir = Paths.get("C:", "Prática");

		
		Path path = dir.resolve("AulaLP.doc");
		
		System.out.println(path);
		ManipuladorArquivo.escritor(path.toString(), null);
		//ManipuladorArquivo.leitor(path.toString());

	}

}