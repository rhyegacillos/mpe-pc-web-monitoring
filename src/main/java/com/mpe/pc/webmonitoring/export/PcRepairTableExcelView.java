package com.mpe.pc.webmonitoring.export;

import com.mpe.pc.webmonitoring.domains.PCRepair;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PcRepairTableExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"pc-repair-table.xlsx\"");

        @SuppressWarnings("unchecked")
        List<PCRepair> pcRepairList = (List<PCRepair>) model.get("pcRepairList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("PC Repair Table");
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
        header.createCell(2).setCellValue("MOBO SERIAL");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("PM DATE");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("STATION");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("PC NAME");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("NG DESCRIPTION");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("FINDING");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("WEAK COMPONENT");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("ACTION");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("HDD INSTALLED");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("HDD ORIENTATION");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("SOURCE");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("MONTH");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("CHANGE FAN");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("REMOVE INTAKE FAN");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("NG OCCURRENCE");
        header.getCell(16).setCellStyle(style);
        header.createCell(17).setCellValue("REMARKS");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("DATE REPAIR START");
        header.getCell(18).setCellStyle(style);
        header.createCell(19).setCellValue("DATE REPAIR END");
        header.getCell(19).setCellStyle(style);
        header.createCell(20).setCellValue("REPAIRED BY");
        header.getCell(20).setCellStyle(style);
        header.createCell(21).setCellValue("DATE ENDORSED");
        header.getCell(21).setCellStyle(style);

        // Create data cells
        int rowCount = 1;
        for (PCRepair pcRepair : pcRepairList){
            Row pcRepairRow = sheet.createRow(rowCount++);
            pcRepairRow.createCell(0).setCellValue(pcRepair.getControlNumber());
            pcRepairRow.getCell(0).setCellStyle(dataStyle);
            pcRepairRow.createCell(1).setCellValue(pcRepair.getMac());
            pcRepairRow.getCell(1).setCellStyle(dataStyle);
            pcRepairRow.createCell(2).setCellValue(pcRepair.getMobo());
            pcRepairRow.getCell(2).setCellStyle(dataStyle);
            pcRepairRow.createCell(3).setCellValue(pcRepair.getPmDate());
            pcRepairRow.getCell(3).setCellStyle(dataStyle);
            pcRepairRow.createCell(4).setCellValue(pcRepair.getStation());
            pcRepairRow.getCell(4).setCellStyle(dataStyle);
            pcRepairRow.createCell(5).setCellValue(pcRepair.getPcName());
            pcRepairRow.getCell(5).setCellStyle(dataStyle);
            pcRepairRow.createCell(6).setCellValue(pcRepair.getNgDescription());
            pcRepairRow.getCell(6).setCellStyle(dataStyle);
            pcRepairRow.createCell(7).setCellValue(pcRepair.getFinding());
            pcRepairRow.getCell(7).setCellStyle(dataStyle);
            pcRepairRow.createCell(8).setCellValue(pcRepair.getWeakComponent());
            pcRepairRow.getCell(8).setCellStyle(dataStyle);
            pcRepairRow.createCell(9).setCellValue(pcRepair.getActionTaken());
            pcRepairRow.getCell(9).setCellStyle(dataStyle);
            pcRepairRow.createCell(10).setCellValue(pcRepair.getHddInstalled());
            pcRepairRow.getCell(10).setCellStyle(dataStyle);
            pcRepairRow.createCell(11).setCellValue(pcRepair.getHddOrientation());
            pcRepairRow.getCell(11).setCellStyle(dataStyle);
            pcRepairRow.createCell(12).setCellValue(pcRepair.getSource());
            pcRepairRow.getCell(12).setCellStyle(dataStyle);
            pcRepairRow.createCell(13).setCellValue(pcRepair.getMonth());
            pcRepairRow.getCell(13).setCellStyle(dataStyle);
            pcRepairRow.createCell(14).setCellValue(pcRepair.getChangeFan());
            pcRepairRow.getCell(14).setCellStyle(dataStyle);
            pcRepairRow.createCell(15).setCellValue(pcRepair.getRemovedIntakeFan());
            pcRepairRow.getCell(15).setCellStyle(dataStyle);
            pcRepairRow.createCell(16).setCellValue(pcRepair.getNgOccurrence());
            pcRepairRow.getCell(16).setCellStyle(dataStyle);
            pcRepairRow.createCell(17).setCellValue(pcRepair.getRemarks());
            pcRepairRow.getCell(17).setCellStyle(dataStyle);
            pcRepairRow.createCell(18).setCellValue(pcRepair.getDateRepairStart());
            pcRepairRow.getCell(18).setCellStyle(dataStyle);
            pcRepairRow.createCell(19).setCellValue(pcRepair.getDateRepairEnd());
            pcRepairRow.getCell(19).setCellStyle(dataStyle);
            pcRepairRow.createCell(20).setCellValue(pcRepair.getRepairedBy());
            pcRepairRow.getCell(20).setCellStyle(dataStyle);
            pcRepairRow.createCell(21).setCellValue(pcRepair.getDateEndorsed());
            pcRepairRow.getCell(21).setCellStyle(dataStyle);
        }


    }
}
