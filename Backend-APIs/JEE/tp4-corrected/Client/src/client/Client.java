package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Client {

    private static final String API_URL = "http://localhost:8080/ReservationTrains/webapi/trains";

    public static void main(String[] args) {
        try {
            System.out.println("--- Starting Train Reservation Client ---");

            System.out.println("\n[Test 1] Listing all trains...");
            String allTrainsXml = sendGet(API_URL);
            System.out.println(allTrainsXml);

            String depart = "Rabat";
            String arrivee = "Casablanca";
            System.out.println(
                    "\n[Test 2] Searching for trains from " + depart + " to " + arrivee + "...");

            String searchUrl = API_URL + "/search?depart=" + depart + "&arrivee=" + arrivee;
            String searchResult = sendGet(searchUrl);
            System.out.println(formatXML(searchResult));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sendGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            output.append(line);
        }
        conn.disconnect();
        return formatXML(output.toString());
    }
    public static String formatXML(String input) {
    try {
        Source xmlInput = new StreamSource(new StringReader(input));
        StringWriter stringWriter = new StringWriter();
        StreamResult xmlOutput = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(xmlInput, xmlOutput);
        return stringWriter.toString();
    } catch (Exception e) {
        return input; // If formatting fails, return raw XML
    }
}
}
