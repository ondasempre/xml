import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class Directory 
{
	/** @listXML contiene i nomi dei file XML da analizzare */
	private ArrayList<String> listXML = new ArrayList<String>();
	
	public Directory()
	{
		/** Crea cartella per l'inserimento dei dati estratti. */
		File file = new File("/Users/hacker-Z/Desktop/ReadXMLFile/allegati");
	        if (!file.exists()) 
	        {
	            if (file.mkdir()) 
	            {
	                System.out.println("Directory is created!");
	            } else 
	            {
	                System.out.println("Failed to create directory! (..)");
	            }
	        }      
	}
	
	/** Costruttore con parametro stringa 
	 * 
	 * @str nome della directory da creare
	 * 
	 * */
	public Directory(String str)
	{
		/** Crea cartella per l'inserimento dei dati estratti. */
		File file = new File("/Users/hacker-Z/Desktop/ReadXMLFile/");
	        if (!file.exists()) 
	        {
	            if (file.mkdir()) 
	            {
	                System.out.println("Directory is created!");
	            } else 
	            {
	                System.out.println("Failed to create directory! (..)");
	            }
	        }      
	}
	
	/** Pulisce la lista dei nomi */
	public void remove()
	{
		listXML.clear();
	}
	
	/** Ritorna la lunghezza della lista creata */
	public int lenArrayList()
	{
		return listXML.size();
	}
	
	//File file = new File(argv[0]);
	
	/** Recupera i nomi dei file all'interno della directory */
	public ArrayList<String> getNameFileDir() 
	{
		File files = new File("/Users/hacker-Z/Desktop/ReadXMLFile/");
		
		if(files.isDirectory())
		{
			File[] filesInDir = files.listFiles();
			Arrays.sort(filesInDir);
			for(File f : filesInDir)
			{
				if(f.isFile())
				{
					String name = f.getName();
					if(name.contains(".xml"))
					{
						listXML.add(name);
					}
				}
			}
		}
		return listXML;
	}
} 

