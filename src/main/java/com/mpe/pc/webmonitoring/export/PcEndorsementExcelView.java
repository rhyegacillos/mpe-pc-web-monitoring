package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.PCSpare;
import com.mpe.pc.webmonitoring.domains.PcEndorse;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PcEndorsementExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"pc-endorsement.xlsx\"");

        @SuppressWarnings("unchecked")
        List<PcEndorse> pcEndorseList = (List<PcEndorse>) model.get("pcEndorseList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("PC Endorsement Table Records");
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
        header.createCell(0).setCellValue("DATE ENDORSED");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("LINE");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("PROCESS");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("HDD CONTROL NO");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("NG CODE");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("SOURCE");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("ENDORSED BY");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("REMARKS");
        header.getCell(7).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (PcEndorse pcEndorse : pcEndorseList){
            Row pcRepairRow = sheet.createRow(rowCount++);
            pcRepairRow.createCell(0).setCellValue(pcEndorse.getDateEndorsed());
            pcRepairRow.getCell(0).setCellStyle(dataStyle);
            pcRepairRow.createCell(1).setCellValue(pcEndorse.getLine());
            pcRepairRow.getCell(1).setCellStyle(dataStyle);
            pcRepairRow.createCell(2).setCellValue(pcEndorse.getProcess());
            pcRepairRow.getCell(2).setCellStyle(dataStyle);
            pcRepairRow.createCell(3).setCellValue(pcEndorse.getControlNo());
            pcRepairRow.getCell(3).setCellStyle(dataStyle);
            pcRepairRow.createCell(4).setCellValue(pcEndorse.getNgCode());
            pcRepairRow.getCell(4).setCellStyle(dataStyle);
            pcRepairRow.createCell(5).setCellValue(pcEndorse.getSource());
            pcRepairRow.getCell(5).setCellStyle(dataStyle);
            pcRepairRow.createCell(6).setCellValue(pcEndorse.getEndorsedBy());
            pcRepairRow.getCell(6).setCellStyle(dataStyle);
            pcRepairRow.createCell(7).setCellValue(pcEndorse.getRemarks());
            pcRepairRow.getCell(7).setCellStyle(dataStyle);
        }


    }
}
