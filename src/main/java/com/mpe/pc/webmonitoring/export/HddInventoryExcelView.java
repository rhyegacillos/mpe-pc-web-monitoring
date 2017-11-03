package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.domains.NewSparePC;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class HddInventoryExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"hdd-inventory.xlsx\"");

        @SuppressWarnings("unchecked")
        List<Hdd> hddList = (List<Hdd>) model.get("hddList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("New PC Spare Table");
        sheet.setDefaultColumnWidth(40);

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
        header.createCell(0).setCellValue("MODULE NUMBER");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("HDD SIZE");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("BRAND");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("PURPOSE");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("DATE WITHDRAWN");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("WITHDRAWN BY");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("USE FOR");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("MAC ADDRESS");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("HDD CONTROL NUMBER");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("LINE INSTALLED");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("REMARKS");
        header.getCell(10).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (Hdd hdd : hddList){
            Row pcRepairRow = sheet.createRow(rowCount++);
            pcRepairRow.createCell(0).setCellValue(hdd.getModuleNo());
            pcRepairRow.getCell(0).setCellStyle(dataStyle);
            pcRepairRow.createCell(1).setCellValue(hdd.getHddSize());
            pcRepairRow.getCell(1).setCellStyle(dataStyle);
            pcRepairRow.createCell(2).setCellValue(hdd.getBrand());
            pcRepairRow.getCell(2).setCellStyle(dataStyle);
            pcRepairRow.createCell(3).setCellValue(hdd.getPurpose());
            pcRepairRow.getCell(3).setCellStyle(dataStyle);
            pcRepairRow.createCell(4).setCellValue(hdd.getDateWithdrawn());
            pcRepairRow.getCell(4).setCellStyle(dataStyle);
            pcRepairRow.createCell(5).setCellValue(hdd.getWithdrawnBy());
            pcRepairRow.getCell(5).setCellStyle(dataStyle);
            pcRepairRow.createCell(6).setCellValue(hdd.getUseFor());
            pcRepairRow.getCell(6).setCellStyle(dataStyle);
            pcRepairRow.createCell(7).setCellValue(hdd.getMac());
            pcRepairRow.getCell(7).setCellStyle(dataStyle);
            pcRepairRow.createCell(8).setCellValue(hdd.getHddNo());
            pcRepairRow.getCell(8).setCellStyle(dataStyle);
            pcRepairRow.createCell(9).setCellValue(hdd.getLineInstalled());
            pcRepairRow.getCell(9).setCellStyle(dataStyle);
            pcRepairRow.createCell(10).setCellValue(hdd.getRemarks());
            pcRepairRow.getCell(10).setCellStyle(dataStyle);
        }


    }
}
