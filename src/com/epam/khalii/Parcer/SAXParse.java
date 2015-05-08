package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 08.05.2015.
 */

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
import java.util.ArrayList;

public class SAXParse {
    public static void main(String[] args) throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        DefaultHandler defaultHandler = new DefaultHandler(){
            boolean bname = false;
            boolean bpreciousness = false;
            boolean borigin = false;
            boolean bvalue = false;
            boolean bcolor = false;
            boolean bopacity = false;
            boolean bcut = false;
            ArrayList<Gem> gemArrayList = new ArrayList<Gem>();
            Gem gem = new Gem();

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bname = true;
                }
                if (qName.equalsIgnoreCase("preciousness")) {
                    bpreciousness = true;
                }
                if (qName.equalsIgnoreCase("origin")) {
                    borigin = true;
                }
                if (qName.equalsIgnoreCase("value")) {
                    bvalue = true;
                }
                if (qName.equalsIgnoreCase("color")) {
                    bcolor = true;
                }
                if (qName.equalsIgnoreCase("opacity")) {
                    bopacity = true;
                }
                if (qName.equalsIgnoreCase("cut")) {
                    bcut = true;
                }
            }
            public void endElement(String uri, String localName, String qName) throws SAXException{
            }
            public void characters(char ch[], int start, int length) throws SAXException{

                if(bname){
                    gem.setName(new String(ch, start, length));
                    bname = false;
                }
                if(bpreciousness){
                    gem.setPrecious(new String(ch, start, length));
                    bpreciousness = false;
                }
                if(borigin){
                    gem.setOrigin(new String(ch, start, length));
                    borigin = false;
                }
                if(bvalue){
                    gem.setValue(Double.parseDouble(new String(ch, start, length)));
                    bvalue = false;
                }
                if(bcolor){
                    gem.visualComponents.setColor(new String(ch, start, length));
                    bcolor = false;
                }
                if(bopacity){
                    gem.visualComponents.setOpacity(Integer.parseInt(new String(ch, start, length)));
                    bopacity = false;
                }
                if(bcut){
                    gem.visualComponents.setCut(Integer.parseInt(new String(ch, start, length)));
                    bcut = false;
                    gemArrayList.add(gem);
                    System.out.println(gem);
                }
            }
        };
        File file = new File("Gems.xml");

        InputStream inputStream = new FileInputStream(file);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        InputSource inputSource = new InputSource(reader);
        inputSource.setEncoding("UTF-8");

        saxParser.parse(inputSource, defaultHandler);
    }
}
