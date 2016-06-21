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
import java.util.concurrent.ArrayBlockingQueue;

public class Attached 
{
	private ArrayList<String> al = new ArrayList<String>();
	
	public Attached()
	{
		
	}
	/** Aggiunge il nome del file alla lista */
	public void putAttachment(String str)
	{
		al.add(str);
	}
	/** Verifica se nella lista c'è il nome del file ricercato */
	public String getAttachmentByName(String str)
	{
		for(String x : al)
		{
			if(x.equals(str))
				return str;
		}
		return null;
	}
}
