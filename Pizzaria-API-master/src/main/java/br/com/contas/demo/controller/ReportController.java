package br.com.contas.demo.controller;

import br.com.contas.demo.entity.Report;
import br.com.contas.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RestController
@RequestMapping("/Report")
public class ReportController {

    @Autowired
    private ReportService service;

@GetMapping ( "/Period")
public ResponseEntity<Report> periodReport(@RequestParam String day1, String day2) {
    LocalDate start = LocalDate.parse(day1);
    LocalDate end = LocalDate.parse(day1);
    return service.GetReport(start,end);

}

    @GetMapping ( "/day")
    public ResponseEntity<Report> periodReport(@RequestParam String day1) {
        LocalDate day = LocalDate.parse(day1);
        return service.GetReportDay(day);
    }
}
