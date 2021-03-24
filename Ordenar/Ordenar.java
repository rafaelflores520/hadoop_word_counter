import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import ordenar.Estructura;


/**
 *
 * @author FRANKLIN
 */
public class Ordenar {

    /**
     * @param args the command line arguments
     */
	
	static ArrayList<Estructura> wordcount=new ArrayList();

    public static void Ordenar(String file) throws FileNotFoundException, IOException {
	File archivo = new File (file);
	Scanner sc=new Scanner(archivo);
	Scanner s=null;
	int cantidad=0;
	FileWriter fichero = new FileWriter("./Data_Ordenado1.txt");
	PrintWriter pw = new PrintWriter(fichero);
	while(sc.hasNext()){
		Estructura struct=new Estructura();
		try{
		struct.setWord(sc.next());
		cantidad=Integer.parseInt(sc.next());
		if(cantidad>=5000){
			struct.setCount(cantidad);
			wordcount.add(struct);
		}
		}
		catch(NumberFormatException e){
			System.out.println("...");
		}
	}
	sc.close();
        Collections.sort(wordcount);
        for (Estructura e : wordcount) {
            pw.println(e.toString());
            System.out.println(e);
            
        }
        fichero.close();
    }
        

    public static void main(String[] args) throws IOException {
		Ordenar("./part-r-00000.txt");		
    }
}
