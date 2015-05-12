package com.epam.khalii.Parcer;

/**
 * Created by Anhelina_Khalii on 12.05.2015.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class EXCELParse {
    public static void main(String[] args) throws Exception{
        Excel excel = new Excel("gem.xls");
        HashMap<Integer, ArrayList<String>> map = excel.getFullTable();

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}

class Excel{
    private String filePath;
    private HashMap<Integer, ArrayList<String>> table;

    Excel(String filePath){
        this.filePath = filePath;
    }

    public HashMap<Integer, ArrayList<String>> getFullTable() {
        HashMap<Integer, ArrayList<String>> table = new HashMap<Integer, ArrayList<String>>();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            HSSFRow currentRow = null;
            HSSFCell currentCell = null;
            int currentRowNumber = 0;
            int currentCellNumber = 0;
            int rowNumber = 1;
            while ((currentRow = sheet.getRow(currentRowNumber)) != null) {
                ArrayList<String> row = new ArrayList<String>();
                while ((currentCell = currentRow.getCell(currentCellNumber)) != null) {
                    row.add(currentCell.toString());
                    currentCellNumber++;
                }
                table.put(rowNumber,row);
                currentRowNumber++;
                currentCellNumber = 0;
                rowNumber++;
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }

    public ArrayList<String> getTableRow(Integer rowNumber) {
        ArrayList<String> row = new ArrayList<String>();
        if (table == null) {
            table = getFullTable();
        }
        if(rowNumber < table.keySet().size()) {
            row = table.get(rowNumber);
        }
        System.out.println(table.keySet().size());
        return row;
    }
}