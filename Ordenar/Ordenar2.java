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
//import ordenar2.Estructura;


/**
 *
 * @author FRANKLIN
 */
public class Ordenar2 {

    /**
     * @param args the command line arguments
     */
	
	static ArrayList<Estructura> wordcount=new ArrayList();

    public static void Ordenar(String file) throws FileNotFoundException, IOException {
	String palabra1, palabra2;
        int cantidad=0,numero=0;
        int cont=1;
        File archivo = new File (file);
	Scanner sc=new Scanner(archivo);
	Scanner s=null;
	FileWriter fichero = new FileWriter("./Data_Ordenado2.txt");
	PrintWriter pw = new PrintWriter(fichero);
	while(sc.hasNext()){
		Estructura struct=new Estructura();
                palabra1=sc.next();
                palabra2=sc.next();
                //cantidad=Integer.parseInt(sc.next());
                try{
		
                if (isNumeric(palabra2) == true) {
                numero = Integer.parseInt(palabra2);
                palabra1=sc.next();
                palabra2=sc.next();
                cantidad=Integer.parseInt(sc.next());
                //System.out.println("Numero: " + numero);
                } else {
                //System.out.println("No es un numero");
                cantidad=Integer.parseInt(sc.next());
                }
		}catch(NumberFormatException e){
		System.out.println("...");
		}
        if(cantidad>=5000){
                System.out.println(cont+" ["+palabra1+"-"+palabra2+"]="+cantidad);
                cont++;
		//struct.setWord(sc.next()+" "+sc.next());
		//struct.setCount(Integer.parseInt(sc.next()));
                struct.setWord(palabra1+" "+palabra2);
                struct.setCount(cantidad);
				wordcount.add(struct);
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
		Ordenar("./part-r-00001.txt");		
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

   
}
