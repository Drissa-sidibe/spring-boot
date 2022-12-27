package com.brico.ExtractToCsv.controller;

import com.brico.ExtractToCsv.expo.UserExcelExporter;
import com.brico.ExtractToCsv.model.Student;
import com.brico.ExtractToCsv.repo.StudentRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/web")
public class HomeController {

    public String homePage(){
        return "HomePage";
    }
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachment; filename=Student_Info.xlsx";
        response.setHeader(headerKey, headerValue);

        List<Student> studentList = studentRepository.findAll();
        UserExcelExporter exporter = new UserExcelExporter(studentList);
        exporter.export(response);
    }
}
