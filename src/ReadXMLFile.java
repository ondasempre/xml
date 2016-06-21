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

class ReadXMLFile 
{

	/** Main */ 
	public static void main(String argv[]) 	
	{
		Directory cartella = new Directory();
		
        try 
        {
    	    /** File XML da analizzare */
    	   	File fXmlFile = new File("/Users/hacker-Z/Desktop/ReadXMLFile/file_1.xml");
    	   	
    	   	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	   	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	   	Document doc = dBuilder.parse(fXmlFile); 
	        /** optional, but recommended read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work */
    	   	doc.getDocumentElement().normalize(); 
	        //System.out.println("--------------------------------------------------------");
	        //System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
	        NodeList nList = doc.getElementsByTagName("FatturaElettronicaHeader");
	        NodeList nListBody = doc.getElementsByTagName("FatturaElettronicaBody");
	        //System.out.println("--------------------------------------------------------");

//	            for (int temp = 0; temp < nList.getLength(); temp++) 
//	            {
//	            	Node nNode = nList.item(temp);
//	                System.out.println("\nCurrent Element :: " + nNode.getNodeName());
//	        
//	                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
//	                {
//					        Element eElement = (Element) nNode;
//					        System.out.println("DatiTrasmissione :: " + eElement.getElementsByTagName("DatiTrasmissione"));
////					        System.out.println("IdTrasmittente :: " + eElement.getElementsByTagName("IdTrasmittente").item(0).getTextContent());					        System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//					        System.out.println("IdPaese :: " + eElement.getElementsByTagName("IdPaese").item(0).getTextContent());
//					        System.out.println("IdCodice :: " + eElement.getElementsByTagName("IdCodice").item(0).getTextContent());
//					        System.out.println("ProgressivoInvio :: " + eElement.getElementsByTagName("ProgressivoInvio").item(0).getTextContent());
//					        System.out.println("FormatoTrasmissione :: " + eElement.getElementsByTagName("FormatoTrasmissione").item(0).getTextContent());
//					        System.out.println("CodiceDestinatario :: " + eElement.getElementsByTagName("CodiceDestinatario").item(0).getTextContent());
//					        System.out.println("ContattiTrasmittente :: " + eElement.getElementsByTagName("ContattiTrasmittente").item(0).getTextContent());
//					        System.out.println("Telefono :: " + eElement.getElementsByTagName("Telefono").item(0).getTextContent());
//					        System.out.println("Email :: " + eElement.getElementsByTagName("Email").item(0).getTextContent());
//					        //System.out.println("CedentePrestatore :: " + eElement.getElementsByTagName("CedentePrestatore").item(0).getTextContent());
//					        System.out.println("-------------------- ALLEGATI ----------------------" + eElement.getElementsByTagName("NomeAttachment").item(0));
//					        
////					        for(int j=0; j< eElement.getElementsByTagName("Allegati").getLength(); j++)
////					        {
////					        	//System.out.println("NomeAttachment :: " + eElement.getElementsByTagName("Allegati").item(j).getTextContent());
////					        }
//	                }
//	            }
	        
	        //new Directory();
	        
	        for (int temp = 0; temp < nListBody.getLength(); temp++) 
            {
            	Node nNode = nListBody.item(temp);
                //System.out.println("Current Element :: " + nNode.getNodeName());
        
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
				        Element eElement = (Element) nNode;
				        System.out.println("---------------------- A L L E G A T I ("+eElement.getElementsByTagName("Attachment").getLength()+") ------------------------");
				        
				        for(int j=0; j< eElement.getElementsByTagName("Attachment").getLength();j++)
				        {
				        	
				        	System.out.println(j+1 +")NomeAttachment :: " + eElement.getElementsByTagName("NomeAttachment").item(j).getTextContent());
					        System.out.println("FormatoAttachment :: " + eElement.getElementsByTagName("FormatoAttachment").item(j).getTextContent());
				        	try
				            {
				                 FileOutputStream allegato = new FileOutputStream("/Users/hacker-Z/Desktop/ReadXMLFile/allegati/allegato_"+j+".txt");
				                 PrintStream scrivi = new PrintStream(allegato);
				                 scrivi.print(eElement.getElementsByTagName("Attachment").item(j).getTextContent());
				            }
				            catch (Exception e)
				            {
				                 System.out.println("Errore: " + e);
				                 System.exit(1);
				            }	
				        }
				        
                }
            }
	            
       } catch (Exception e) {
        e.printStackTrace();
       }
       System.out.println(cartella.getNameFileDir());
    }
	

}