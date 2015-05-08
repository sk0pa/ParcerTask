package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 08.05.2015.
 */
import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class JAXBParse {
    public static void main(String[] args) throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(GemJABX.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        GemJABX gem = (GemJABX)unmarshaller.unmarshal(new File("Gems.xml"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ArrayList<Gem> gemArrayList = new ArrayList<Gem>();
        for(GemElements gemElement: gem.gemElementsArrayList) {
            String name = gemElement.name;
            String precious = gemElement.precious;
            String origin = gemElement.origin;
            double value = Double.parseDouble(gemElement.value);
            String color = "";
            int cut = 0;
            int opacity = 0;
            for (VisualParametrs visualPar : gemElement.visualParametrses){
                color = visualPar.color;
                opacity = Integer.parseInt(visualPar.opacity);
                cut = Integer.parseInt(visualPar.cut);
            }
            Gem tempGem = new Gem(name, precious, origin, color, opacity, cut, value);
            System.out.println(tempGem);
            gemArrayList.add(tempGem);
        }
    }
}

@XmlRootElement(name="Gem")
@XmlAccessorType(XmlAccessType.FIELD)
class GemJABX{
    @XmlElement(name="gem")
    public ArrayList<GemElements> gemElementsArrayList;
}

@XmlAccessorType
class GemElements{

    @XmlElement(name = "name")
    public String name;

    @XmlElement(name="preciousness")
    public String precious;

    @XmlElement(name="origin")
    public String origin;

    @XmlElement(name="value")
    public String value;

    @XmlElement(name="visualparametrs")
    public ArrayList<VisualParametrs> visualParametrses;
}

class VisualParametrs{
    @XmlElement(name="color")
    public String color;

    @XmlElement(name="opacity")
    public String opacity;

    @XmlElement(name="cut")
    public String cut;
}