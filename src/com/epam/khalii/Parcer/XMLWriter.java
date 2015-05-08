package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 07.05.2015.
 */


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * —оздать приложение дл€ разбора XML-документа
 * и инициализации коллекции объектов информацией
 * из XML-файла. ƒл€ разбора использовать SAX, DOM
 * и StAX парсеры, DOM2, JSON.
 * ƒл€ сортировки объектов использовать интерфейс Comparator.
 * 2. јлмазный фонд.
 * ƒрагоценные и полудрагоценные камни,
 * содержащиес€ в павильоне, имеют следующие характеристики:
 * ЧName Ч название камн€;
 * ЧPreciousness Ч может быть драгоценным либо полудрагоценным;
 * ЧOrigin Ч место добывани€;
 * ЧVisual parameters (должно быть несколько)
 * Ч могут быть: цвет (зеленый, красный, желтый и т. д.),
 * прозрачность (измер€етс€ в процентах 0Ц100 %),
 * способы огранки (количество граней 4Ц15);
 * ЧValue Ч вес камн€ (измер€етс€ в каратах).
 *  орневой элемент назвать Gem.
 * */

public class XMLWriter {
    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element rootElement = document.createElement("Gem");
        document.appendChild(rootElement);
        Attr attr = null;

        for(int i=1;i<21;i++) {
            Element diamond = document.createElement("gem");
            rootElement.appendChild(diamond);

            Attr diamIdAttr = document.createAttribute("id");
            diamIdAttr.setValue("" + i);
            diamond.setAttributeNode(diamIdAttr);

            Element diamName = document.createElement("name");
            diamName.appendChild(document.createTextNode("Diamond"));
            diamond.appendChild(diamName);

            Element diamPrecious = document.createElement("preciousness");
            diamPrecious.appendChild(document.createTextNode("Precious"));
            diamond.appendChild(diamPrecious);

            Element diamOrigin = document.createElement("origin");
            diamOrigin.appendChild(document.createTextNode("Africa"));
            diamond.appendChild(diamOrigin);

            Element diamValue = document.createElement("value");
            diamValue.appendChild(document.createTextNode("5"));
            diamond.appendChild(diamValue);

            Element diamVP = document.createElement("visualparametrs");
            diamond.appendChild(diamVP);

            Element diamVPC = document.createElement("color");
            diamVPC.appendChild(document.createTextNode("White"));
            diamVP.appendChild(diamVPC);

            Element diamVPO = document.createElement("opacity");
            diamVPO.appendChild(document.createTextNode("80"));
            diamVP.appendChild(diamVPO);

            Element diamVPG = document.createElement("cut");
            diamVPG.appendChild(document.createTextNode("15"));
            diamVP.appendChild(diamVPG);


        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("Gems.xml"));

        transformer.transform(domSource, streamResult);
        System.out.println("File saved!");
    }
}
