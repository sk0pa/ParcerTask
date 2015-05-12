package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 12.05.2015.
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class JSONParse {
    public static void main(String[] args) throws Exception {
        JSONParser parser = new JSONParser();
        BufferedReader read = new BufferedReader(new FileReader(new File("gems.json")));
        String s = read.readLine();
        try {
            Object obj = parser.parse(s);
            JSONObject array = (JSONObject) obj;
            System.out.println("Name: - " + array.get("name"));
            System.out.println("Preciousness: - " + array.get("preciousness"));
            System.out.println("Origin: - " + array.get("origin"));
            System.out.println("Value: - " + array.get("value"));
            System.out.println("Color: - " + array.get("color"));
            System.out.println("Opacity: - " + array.get("opacity"));
            System.out.println("Cut: - " + array.get("cut"));
            System.out.println();
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
}
