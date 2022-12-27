package com.brico.ExtractToCsv.expo;

import com.brico.ExtractToCsv.model.Student;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class UserExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Student> studentList;

    public UserExcelExporter(List<Student> studentList){
        this.studentList=studentList;

        workbook = new XSSFWorkbook();


    }
    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Long){
            cell.setCellValue((Long) value);
        }else if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if( value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else if( value instanceof String){
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    private void writeHeaderLine(){
        sheet=workbook.createSheet("Student");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Student_Info", style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        font.setFontHeight((short)10);

        row =sheet.createRow(1);
        font.setFontHeight(16);
        createCell(row, 0,"Student Id", style);
        createCell(row, 1,"Student Name", style);
        createCell(row, 2,"Student Address", style);
        createCell(row, 3,"Student City", style);
        createCell(row, 4,"Student PIN", style);
    }
    private void writeDataLines(){
        int rowCount =2;
        CellStyle style =workbook.createCellStyle();
        XSSFFont font =workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Student std : studentList){
            Row row =sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, std.getStudentId(), style);
            createCell(row, columnCount++, std.getName(), style);
            createCell(row, columnCount++, std.getAddress(), style);
            createCell(row, columnCount++, std.getCity(), style);
            createCell(row, columnCount++, std.getPin(), style);
        }
    }
    public  void export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
