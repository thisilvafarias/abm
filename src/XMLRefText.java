import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLRefText {


    public static void main(String[] args){

        try{

            String[] searching =  {"MWB", "TRV", "CAR"};

            File inputFile = new File("ex2.xml");

            //Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            //Create a Document from the file
            Document doc = dBuilder.parse(inputFile);

            //Normalize the XML Structure;
            doc.getDocumentElement().normalize();


            //Get all references add to a list
            NodeList nList = doc.getElementsByTagName("Reference");
            System.out.println("============================");

            //Iterating over array against XML file
            for (int i = 0; i < nList.getLength(); i++)
            {
                //Passing Node Value to a string
                String xlmNodeValue = nList.item(i).getAttributes().getNamedItem("RefCode").getNodeValue();

                for (int j = 0; j < searching.length; j++){
                    //Comparing node value in RefCode against Array searching
                    if(xlmNodeValue.equals(searching[j]) ){
                        System.out.println("");    //Just a separator
                     //   System.out.print(xlmNodeValue + ": "+ nList.item(i).getTextContent());
                        System.out.println(xlmNodeValue + ": "+ nList.item(i).getTextContent());

                    }

                }

            }


        }catch (Exception e) {
            e.printStackTrace();
        }








    }
}

