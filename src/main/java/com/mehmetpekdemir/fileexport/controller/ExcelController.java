package com.mehmetpekdemir.fileexport.controller;

import com.mehmetpekdemir.fileexport.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExcelController {

    private final ExcelService excelService;

    @GetMapping("tutorials-download")
    public ResponseEntity<Resource> downloadTutorials() {
        final String filename = "tutorials.xlsx";
        final var file = new InputStreamResource(excelService.loadTutorials());

        return ResponseEntity.ok() //
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename =" + filename) //
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel")) //
                .body(file);
    }

}
