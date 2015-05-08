package com.epam.khalii.Parcer;

import java.io.File;

/**
 * Created by Anhelina_Khalii on 08.05.2015.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParse {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("Gems.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();
        System.out.println("Document: " + document.getDocumentElement().getNodeName());
        NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).
                getNodeName());
        System.out.println("************************");
        ArrayList<Gem> arrayList = new ArrayList<>();

        for(int i = 0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                String precious = element.getElementsByTagName("preciousness").item(0).getChildNodes().item(0).getNodeValue();
                String origin = element.getElementsByTagName("origin").item(0).getChildNodes().item(0).getNodeValue();
                double value = Double.parseDouble(element.getElementsByTagName("value").item(0).getChildNodes().item(0).getNodeValue());
                String color = element.getElementsByTagName("color").item(0).getChildNodes().item(0).getNodeValue();
                int opacity = Integer.parseInt(element.getElementsByTagName("opacity").item(0).getChildNodes().item(0).getNodeValue());
                int cut = Integer.parseInt(element.getElementsByTagName("cut").item(0).getChildNodes().item(0).getNodeValue());

                Gem gem = new Gem(name, precious, origin, color, opacity, cut, value);
                arrayList.add(gem);
                System.out.println(gem);
            }
        }
    }
}
