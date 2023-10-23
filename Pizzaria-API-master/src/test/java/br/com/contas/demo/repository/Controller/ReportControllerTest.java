package br.com.contas.demo.ControllerTest;

import br.com.contas.demo.controller.ReportController;
import br.com.contas.demo.entity.Report;
import br.com.contas.demo.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReportControllerTest {

    @InjectMocks
    private ReportController controller;

    @Mock
    private ReportService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getPeriodReport() {
        // Arrange
        LocalDate startDate = LocalDate.of(2023, 9, 1);
        LocalDate endDate = LocalDate.of(2023, 9, 10);
        Report report = new Report(1L
                , LocalDateTime.now()
                , 5
                , 10
                , 3
                , 500.0f
                , 200.0f);

        // Configure the mock to return the expected ResponseEntity
        ResponseEntity<Report> expectedResponse = new ResponseEntity<>(report, HttpStatus.OK);
        when(service.GetReport(startDate, endDate)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<Report> result = controller.periodReport("2023-09-01", "2023-09-10");

        // Assert
    }

    @Test
    void getDailyReport() {
        // Arrange
        LocalDate day = LocalDate.of(2023, 9, 5);
        Report report = new Report(1L, LocalDateTime.now(), 2, 8, 1, 300.0f, 100.0f);
        when(service.GetReportDay(day)).thenReturn(new ResponseEntity<>(report, HttpStatus.OK));

        // Act
        ResponseEntity<Report> result = controller.periodReport("2023-09-05");

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(report, result.getBody());
    }
}