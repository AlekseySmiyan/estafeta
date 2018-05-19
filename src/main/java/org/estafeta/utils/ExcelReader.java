package org.estafeta.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Aleksey Smiyan on 02.05.18.
 */
public class ExcelReader {

    private File file;
    private XSSFWorkbook workbook;
    private String sheetName;

    public ExcelReader(File file, String sheetName) {
        this.file = file;
        this.sheetName = sheetName;
    }

    public Workbook openWorkBook() {
        workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public void closeWorkBook() {
        if (workbook != null) try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readCellValue(String rowName, String colName) {
        Sheet sheet = openWorkBook().getSheet(sheetName);
        int rowStart = 0;
        int colStart = 0;
        int rowNum = 1;
        int rowEnd = sheet.getLastRowNum();
        for (int r=rowStart + 1; r<rowEnd + 1; r++) {
            if(sheet.getRow(r).getCell(colStart).getStringCellValue().trim().equals(rowName.trim())) {
                rowNum = r;
                break;
            }
        }
        int colNum = 1;
        int colEnd = sheet.getRow(rowNum).getLastCellNum();
        for(int c=colStart + 1; c<colEnd; c++) {
            if(sheet.getRow(rowStart).getCell(c).getStringCellValue().trim().equals(colName.trim())) {
                colNum = c;
                break;
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
        closeWorkBook();
        return value;
    }
}

