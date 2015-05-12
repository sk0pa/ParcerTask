package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 12.05.2015.
 */
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class JSONWriter {
    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();

        obj.put("name", "diamond");
        obj.put("preciousness", "Precious");
        obj.put("origin", "Africa");
        obj.put("value", "5");
        obj.put("color", "White");
        obj.put("opacity", "80");
        obj.put("cut", "15");

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        FileWriter write = new FileWriter(new File("gems.json"));
        write.write(jsonText);
        write.close();
        System.out.print(jsonText);
    }
}
