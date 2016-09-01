/**
 * @author hacker-Z
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Copy 
{
	private String cpFile = "";
	private final static int readByteLimit = 64000;
	
	public Copy()
	{
		
	}
	
	/**
	 * Metodo che salva una copia del file.xml troncando l'output stream a 64kb
	 * (per motivi di compatibilità database Oracle 10.0.0.) 
	 *  
	 *  @str nome del file da copiare
	 *  
	 *  */
	static public void backup(String str) throws FileNotFoundException, IOException
	{
		File inputFile = new File(str);
		System.out.println(str.substring(0, str.length()-4));
		//if(inputFile.exists())
//		{
			File outputFile = new File(str+".backup");
			
//		} else {
//			System.out.println("Qualcosa è andato storito...");
//			System.exit(1);
//		}
		
		/** Leggo e scrivo direttamente lo stream del file, selezionando byte per byte */	
		try ( FileInputStream fis = new FileInputStream(inputFile); 
				FileOutputStream fos = new FileOutputStream(outputFile) )
		{ 
			int b = 0;
			int count = 0; 
			
			while ( (b = fis.read())  !=-1 && count <= readByteLimit) 
			{ 
				count++;
				fos.write(b);
			} 
		}
		
	}
}
