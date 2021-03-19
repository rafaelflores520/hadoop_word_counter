import java.io.*;

public class Main{
	public static void main(String argv[]){
		try{
			afiliado scanner = new afiliado(new FileReader(argv[0]));
			scanner.yylex();
		}catch(Exception e){
			
		}
	}
}