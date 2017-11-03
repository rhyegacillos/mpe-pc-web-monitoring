package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.Hdd;
import com.mpe.pc.webmonitoring.domains.NgPcParts;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class NgPcPartsExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"pc-parts-disposal-monitoring.xlsx\"");

        @SuppressWarnings("unchecked")
        List<NgPcParts> ngPcPartsList = (List<NgPcParts>) model.get("ngPcPartsList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("PC Parts Disposal Monitoring");
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
        header.createCell(0).setCellValue("MONTH");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("DATE DEFECT");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("SOURCE");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("DEFECTIVE PARTS");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("BRAND");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("SERIAL NUMBER");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("PROCESS");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("PC NAME");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("DEFECT");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("DATE PURCHASED");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("DATE INSTALLED");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("LIFESPAN");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("DISPOSED BY");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("REMARKS");
        header.getCell(13).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (NgPcParts ngPcParts : ngPcPartsList){
            Row pcPartsRow = sheet.createRow(rowCount++);
            pcPartsRow.createCell(0).setCellValue(ngPcParts.getMonth());
            pcPartsRow.getCell(0).setCellStyle(dataStyle);
            pcPartsRow.createCell(1).setCellValue(ngPcParts.getDateDefect());
            pcPartsRow.getCell(1).setCellStyle(dataStyle);
            pcPartsRow.createCell(2).setCellValue(ngPcParts.getSource());
            pcPartsRow.getCell(2).setCellStyle(dataStyle);
            pcPartsRow.createCell(3).setCellValue(ngPcParts.getDefectiveParts());
            pcPartsRow.getCell(3).setCellStyle(dataStyle);
            pcPartsRow.createCell(4).setCellValue(ngPcParts.getBrand());
            pcPartsRow.getCell(4).setCellStyle(dataStyle);
            pcPartsRow.createCell(5).setCellValue(ngPcParts.getSerialNumber());
            pcPartsRow.getCell(5).setCellStyle(dataStyle);
            pcPartsRow.createCell(6).setCellValue(ngPcParts.getProcess());
            pcPartsRow.getCell(6).setCellStyle(dataStyle);
            pcPartsRow.createCell(7).setCellValue(ngPcParts.getPcName());
            pcPartsRow.getCell(7).setCellStyle(dataStyle);
            pcPartsRow.createCell(8).setCellValue(ngPcParts.getDefect());
            pcPartsRow.getCell(8).setCellStyle(dataStyle);
            pcPartsRow.createCell(9).setCellValue(ngPcParts.getDatePurchased());
            pcPartsRow.getCell(9).setCellStyle(dataStyle);
            pcPartsRow.createCell(10).setCellValue(ngPcParts.getInstalledDate());
            pcPartsRow.getCell(10).setCellStyle(dataStyle);
            pcPartsRow.createCell(11).setCellValue(ngPcParts.getLifespan());
            pcPartsRow.getCell(11).setCellStyle(dataStyle);
            pcPartsRow.createCell(12).setCellValue(ngPcParts.getDisposedBy());
            pcPartsRow.getCell(12).setCellStyle(dataStyle);
            pcPartsRow.createCell(13).setCellValue(ngPcParts.getRemarks());
            pcPartsRow.getCell(13).setCellStyle(dataStyle);
        }


    }
}
