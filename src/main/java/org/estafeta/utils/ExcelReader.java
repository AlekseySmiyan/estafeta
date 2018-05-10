package org.estafeta.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Aleksey Smiyan on 02.05.18.
 */
public class ExcelReader {

    private static File file = new File(PropertiesReader.getProperties("drivers.excel"));
    private XSSFWorkbook workbook;

    public void openWorkBook(File nameFile) {
        workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWorkBook() {
        if (workbook != null) try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readCellValue(String sheetName, String rowName, String colName) {
        Sheet sheet = workbook.getSheet(sheetName);
        int rowStart = 0;
        int rowNum = 1;
        int rowEnd = sheet.getLastRowNum();
        for (int r=rowStart + 1; r<rowEnd; r++) {
            if(sheet.getRow(r).getCell(r).getStringCellValue().trim().equals(rowName.trim())) {
                rowNum = r;
            }
        }
        int colStart = 0;
        int colNum = 1;
        int colEnd = sheet.getRow(rowNum).getLastCellNum();
        for(int c=colStart + 1; c<colEnd; c++) {
            if(sheet.getRow(rowStart).getCell(c).getStringCellValue().trim().equals(colName.trim())) {
                colNum = c;
            }
        }
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        String value = null;
        if(cell.getCellTypeEnum() == CellType.STRING) {
            value = cell.getStringCellValue();
        } else if(cell.getCellTypeEnum() == CellType.NUMERIC) {
            value = String.valueOf(cell.getNumericCellValue());
        } else if(cell.getCellTypeEnum() == CellType.BLANK) {
            value = "";
        }
        return value;
    }
}

