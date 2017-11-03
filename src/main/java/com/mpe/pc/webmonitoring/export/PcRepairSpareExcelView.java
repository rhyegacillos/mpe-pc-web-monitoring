package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.PCRepair;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PcRepairSpareExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"pc-repair-spare.xlsx\"");

        @SuppressWarnings("unchecked")
        List<PCSpare> pcSpareList = (List<PCSpare>) model.get("pcSpareList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Repaired PC Spare Table");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.DARK_TEAL.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.index);
        style.setFont(font);
        style.setBorderTop(BorderStyle.THICK);
        style.setBorderRight(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.DARK_BLUE.index);
        style.setRightBorderColor(IndexedColors.DARK_BLUE.index);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBottomBorderColor(IndexedColors.DARK_BLUE.index);

        // create style for data cells
        Font dataFont = workbook.createFont();
        dataFont.setColor(IndexedColors.GREY_80_PERCENT.index);
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setFont(dataFont);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setBottomBorderColor(IndexedColors.GREY_80_PERCENT.index);
        dataStyle.setRightBorderColor(IndexedColors.GREY_80_PERCENT.index);

        // create header row
        Row header = sheet.createRow(0);
        header.setHeight((short) 500);
        header.createCell(0).setCellValue("HDD CONTROL NUMBER");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("DATE REPAIRED");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("REPAIRED BY");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("LOCATION");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("DATE WITHDRAWN");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("WITHDRAWN BY");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("USE FOR");
        header.getCell(6).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (PCSpare pcSpare : pcSpareList){
            Row pcRepairRow = sheet.createRow(rowCount++);
            pcRepairRow.createCell(0).setCellValue(pcSpare.getControlNumber());
            pcRepairRow.getCell(0).setCellStyle(dataStyle);
            pcRepairRow.createCell(1).setCellValue(pcSpare.getDate());
            pcRepairRow.getCell(1).setCellStyle(dataStyle);
            pcRepairRow.createCell(2).setCellValue(pcSpare.getRepairedBy());
            pcRepairRow.getCell(2).setCellStyle(dataStyle);
            pcRepairRow.createCell(3).setCellValue(pcSpare.getLocation());
            pcRepairRow.getCell(3).setCellStyle(dataStyle);
            pcRepairRow.createCell(4).setCellValue(pcSpare.getDateWithdrawn());
            pcRepairRow.getCell(4).setCellStyle(dataStyle);
            pcRepairRow.createCell(5).setCellValue(pcSpare.getWithdrawnBy());
            pcRepairRow.getCell(5).setCellStyle(dataStyle);
            pcRepairRow.createCell(6).setCellValue(pcSpare.getUseFor());
            pcRepairRow.getCell(6).setCellStyle(dataStyle);
        }


    }
}
