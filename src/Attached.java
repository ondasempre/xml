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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;

public class Attached 
{
	private Map<String,String> attach = new HashMap<>();
	private ArrayList<String> al = new ArrayList<String>();
	
	/** Default */
	public Attached()
	{
		
	}
	/** 
	 * Aggiunge il nome del file alla lista 
	 * 
	 * */
	public void putAttachmentName(String str)
	{
		al.add(str);
	}
	/** 
	 * Verifica se nella lista c'è il nome del file ricercato 
	 * */
	public String getAttachmentByName(String str)
	{
		for(String x : al)
		{
			if(x.equals(str))
				return str;
		}
		return null;
	}
	
	/**
	 * @param k	key in map, represent file title
	 * @param str represent text in the file with title k
	 */
	public void putTextAttachment(String k, String str)
	{
		attach.put(k, str);
	}
	
	/**
	 * @param k
	 * @param str
	 * @return	text of the attachment
	 */
	public String getTextAttachment(String k, String str)
	{
		return attach.get(k);
	}
}
