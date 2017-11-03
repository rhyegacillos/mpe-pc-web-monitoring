package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.NewSparePC;
import com.mpe.pc.webmonitoring.domains.PCSpare;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PcNewSpareExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"pc-new-spare.xlsx\"");

        @SuppressWarnings("unchecked")
        List<NewSparePC> newSpareList = (List<NewSparePC>) model.get("newSpareList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("New PC Spare Table");
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
        header.createCell(1).setCellValue("MAC ADDRESS");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("PURPOSE");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("POWER SUPPLY");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("INTAKE FAN");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("EXHAUST");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("DATE WITHDRAWN");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("WITHDRAWN BY");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("LINE INSTALLED");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("USE FOR");
        header.getCell(9).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (NewSparePC newSparePC : newSpareList){
            Row pcRepairRow = sheet.createRow(rowCount++);
            pcRepairRow.createCell(0).setCellValue(newSparePC.getControlNum());
            pcRepairRow.getCell(0).setCellStyle(dataStyle);
            pcRepairRow.createCell(1).setCellValue(newSparePC.getMac());
            pcRepairRow.getCell(1).setCellStyle(dataStyle);
            pcRepairRow.createCell(2).setCellValue(newSparePC.getPurpose());
            pcRepairRow.getCell(2).setCellStyle(dataStyle);
            pcRepairRow.createCell(3).setCellValue(newSparePC.getPowerSupply());
            pcRepairRow.getCell(3).setCellStyle(dataStyle);
            pcRepairRow.createCell(4).setCellValue(newSparePC.getIntake());
            pcRepairRow.getCell(4).setCellStyle(dataStyle);
            pcRepairRow.createCell(5).setCellValue(newSparePC.getExhaust());
            pcRepairRow.getCell(5).setCellStyle(dataStyle);
            pcRepairRow.createCell(6).setCellValue(newSparePC.getDateWithdrawn());
            pcRepairRow.getCell(6).setCellStyle(dataStyle);
            pcRepairRow.createCell(7).setCellValue(newSparePC.getWithdrawnBy());
            pcRepairRow.getCell(7).setCellStyle(dataStyle);
            pcRepairRow.createCell(8).setCellValue(newSparePC.getLineInstalled());
            pcRepairRow.getCell(8).setCellStyle(dataStyle);
            pcRepairRow.createCell(9).setCellValue(newSparePC.getUseFor());
            pcRepairRow.getCell(9).setCellStyle(dataStyle);
        }


    }
}
