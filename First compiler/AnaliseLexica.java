import java.io.*;

enum TokenType{ NUM,SOMA, MULT, SUB, DIV,APar,FPar, EOF}

class Token{
  char lexema;
  TokenType token;

 Token (char l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		String s;
		char currchar;
		char currchar3;
		int currchar1;
		int currchar4;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;

				// if (currchar >= '0' && currchar1 != eof) {

				// 	while(true) {
				// 		currchar4 =  arquivo.read();
				// 		currchar3 = (char) currchar4;

				// 		if (currchar3 >= '0' && currchar4 != eof) {
				// 			s = new StringBuilder().append(currchar).append(currchar3);
				// 		} else {
				// 			break;
				// 		}
				// 	}
				// } else {
				// 	s = "";
				// }
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
								
	
				if (currchar >= '0' && currchar <= '9') {
					// if (s != "") {
						// return (new Token (s, TokenType.NUM));
					// } else {
					return (new Token (currchar, TokenType.NUM));
					// }
				} else
					switch (currchar){
						case '(':
							return (new Token (currchar,TokenType.APar));
						case ')':
							return (new Token (currchar,TokenType.FPar));
						case '+':
							return (new Token (currchar,TokenType.SOMA));
						case '*':
							return (new Token (currchar,TokenType.MULT));
						case '-':
							return (new Token (currchar,TokenType.SUB));
						case '/':
							return (new Token (currchar,TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}
