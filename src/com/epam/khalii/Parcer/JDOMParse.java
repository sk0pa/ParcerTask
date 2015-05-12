package com.epam.khalii.Parcer;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * Created by Anhelina_Khalii on 12.05.2015.
 */
public class JDOMParse {
    public static void main(String[] args) throws Exception{
            SAXBuilder parser = new SAXBuilder();
            FileReader fr = new FileReader("Gems.xml");
            Document rDoc = parser.build(fr);
            System.out.println(rDoc.getRootElement().getName());
            List<Element> temp = rDoc.getRootElement().getChildren();

            List<Gem> list = new ArrayList<Gem>();

            for (int i = 0; i < temp.size(); ++i) {
                Gem gem = new Gem();
                List<Element> tempElement = temp.get(i).getChildren();
                for (int j = 0; j < tempElement.size(); ++j) {
                    if (tempElement.get(j).getName().equals("name"))
                        gem.setName(tempElement.get(j).getValue());
                    if (tempElement.get(j).getName().equals("preciousness"))
                        gem.setPrecious(tempElement.get(j).getValue());
                    if(tempElement.get(j).getName().equals("origin"))
                        gem.setOrigin(tempElement.get(j).getValue());
                    if(tempElement.get(j).getName().equals("value"))
                        gem.setValue(Double.parseDouble(tempElement.get(j).getValue()));
                    List<Element> tempChildElement = tempElement.get(j).getChildren();
                    for (int k = 0; k < tempChildElement.size(); k++) {
                        if (tempChildElement.get(k).getName().equals("color"))
                            gem.visualComponents.setColor(tempChildElement.get(k)
                                    .getValue());
                        if (tempChildElement.get(k).getName().equals("opacity"))
                            gem.visualComponents.setOpacity(Integer.parseInt(tempChildElement.get(k)
                                    .getValue()));
                        if (tempChildElement.get(k).getName().equals("cut"))
                            gem.visualComponents.setCut(Integer.parseInt(tempChildElement.get(k)
                                    .getValue()));
                    }
                }
                System.out.println(gem);
                list.add(gem);
            }
    }
}
