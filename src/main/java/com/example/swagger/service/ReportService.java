package com.example.swagger.service;

import com.example.swagger.entity.Report;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private List<Report> reportList = new ArrayList<>();

    // 신고 접수 처리
    public Report createReport(Report report) {
        reportList.add(report);
        return report;
    }

    // 신고 내역 조회
    public List<Report> getReports() {
        return reportList;
    }
}
