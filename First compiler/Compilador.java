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

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
