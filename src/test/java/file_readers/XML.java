package file_readers;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class XML {

    private static Document document;
    private static String xmlFilename;

    public static void readDocument(String fileName) {
        if (document == null) {
            try {
                File inputFile = new File(fileName);//file readDocument has to be called before others
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                document = dBuilder.parse(inputFile);
                document.getDocumentElement().normalize();

                xmlFilename = fileName;
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public static void updatePreDefined(String... preDefinedKeys) {
        if (document != null) {
            for (String tag : preDefinedKeys) {
                NodeList nList = document.getElementsByTagName(tag);
                switch (tag) {
                    case "MessageDate":
                        for (int i = 0; i < nList.getLength(); i++) {
                            nList.item(i).setTextContent(LocalDateTime.now().withNano(0).toString());
                            // generate new date each time

                        }
                        break;
                    case "MessageID":
                        for (int i = 0; i < nList.getLength(); i++) {
                            nList.item(i).setTextContent(UUID.randomUUID().toString());
                            //generate random unique id
                        }
                        break;
                    case "IdNumber":
                        for (int i = 0; i < nList.getLength(); i++) {
                            String oldTextValue = nList.item(i).getTextContent();
                            String num = oldTextValue.replaceAll("([^0-9])", "");
                            long id = Long.valueOf(num.length() == 0 ? "0" : num); // grab the old number
                            String replaceWith = oldTextValue.replaceAll("\\d+", "") + (++id);
                            //increment by one and append to old value
                            nList.item(i).setTextContent(replaceWith);
                        }
                        break;
                    default:
                        System.err.println("Tag : " + tag + " not defined in XML.updatePreDefined()");
                }
            }
        } else {
            System.err.println("Call first XML.readDocument(\"path to file\")");
        }
        saveXMLDoc();
    }

    /**
     * <name>John<name/>
     * <date>2019-01-21T05:47:08</date>
     *
     * @param preDefinedKeys . tag's should be fed to varargs tagNames as key=value
     *                       EX: "name=Different Name"
     *                       EX: "date=2019-01-21T05:47:08"
     */
    public static void updateValuesOf(Map<String, String> keyValues, String... preDefinedKeys) {
        if (preDefinedKeys != null) {
            updatePreDefined(preDefinedKeys);
        }
        if (keyValues != null & keyValues.size() > 0) {
            for (Map.Entry<String, String> a : keyValues.entrySet()) {
                NodeList nList = document.getElementsByTagName(a.getKey());
                for (int i = 0; i < nList.getLength(); i++) {
                    nList.item(i).setTextContent(a.getValue());
                }

            }
        }
        saveXMLDoc();
    }
    public static void updateValuesOf(Map<String, String> keyValues) {
        if (keyValues != null & keyValues.size() > 0) {
            for (Map.Entry<String, String> a : keyValues.entrySet()) {
                NodeList nList = document.getElementsByTagName(a.getKey());
                for (int i = 0; i < nList.getLength(); i++) {
                    nList.item(i).setTextContent(a.getValue());
                }
            }
        }
        saveXMLDoc();
    }

    public static void saveXMLDoc() {
        if (document != null & xmlFilename != null) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File(xmlFilename));
                transformer.transform(source, result);
                StreamResult consoleResult = new StreamResult(System.out);
                transformer.transform(source, consoleResult);
            } catch (TransformerConfigurationException e) {

                e.printStackTrace();
            } catch (TransformerException e) {

                e.printStackTrace();
            }
        }

    }


}
