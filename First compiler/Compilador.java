import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			Integer resultado = backend.geraResultado(arv);
			System.out.println(codigo);
			System.out.println("Resultado em inteiro: " + resultado);

			try {
				File myObj = new File("testeparamaquina.txt");
				if (myObj.createNewFile()) {
					FileWriter myWriter = new FileWriter("testeparamaquina.txt");
					myWriter.write(codigo);
					myWriter.close();
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
