package com.example.swagger.controller;

import com.example.swagger.dto.ApiResponse;
import com.example.swagger.entity.Report;
import com.example.swagger.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "신고 API")
@RestController
@RequestMapping("/picto/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @Operation(summary = "신고 접수", description = "신고를 접수합니다.")
    @PostMapping
    public ResponseEntity<ApiResponse<Report>> createReport(@RequestBody Report report) {
        Report createdReport = reportService.createReport(report);
        ApiResponse<Report> response = new ApiResponse<>(true, 200, "신고 접수 완료", createdReport);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "신고 내역 조회", description = "신고 내역을 조회합니다.")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Report>>> getReportList() {
        List<Report> reports = reportService.getReports();
        ApiResponse<List<Report>> response = new ApiResponse<>(true, 200, "신고 내역", reports);
        return ResponseEntity.ok(response);
    }
}
