package com.mehmetpekdemir.fileexport.service;

import com.mehmetpekdemir.fileexport.entity.TutorialEntity;
import com.mehmetpekdemir.fileexport.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    private final TutorialRepository tutorialRepository;

    @Override
    @Transactional
    public ByteArrayInputStream loadTutorials() {
        return tutorialsToExcel(tutorialRepository.findAll());
    }

    private ByteArrayInputStream tutorialsToExcel(List<TutorialEntity> tutorials) {
        final String[] HEADERS = {"Title", "Description", "Published"};
        final String SHEET = "Tutorials";

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream output = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            Row headerRow = sheet.createRow(0);

            createColumn(headerRow, HEADERS);
            createRow(tutorials, sheet);

            workbook.write(output);
            return new ByteArrayInputStream(output.toByteArray());
        } catch (IOException ioException) {
            throw new RuntimeException(ioException.getMessage());
        }

    }

    private void createColumn(Row headerRow, String[] HEADERS) {
        for (int column = 0; column < HEADERS.length; column++) {
            Cell cell = headerRow.createCell(column);
            cell.setCellValue(HEADERS[column]);
        }
    }

    private void createRow(List<TutorialEntity> tutorials, Sheet sheet) {
        int rowX = 1;

        for (TutorialEntity tutorial : tutorials) {
            Row row = sheet.createRow(rowX++);

            row.createCell(0).setCellValue(tutorial.getTitle());
            row.createCell(1).setCellValue(tutorial.getDescription());
            row.createCell(2).setCellValue(tutorial.getPublished());
        }
    }

}
