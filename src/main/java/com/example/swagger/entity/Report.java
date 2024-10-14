package com.example.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {
    private int reportId;
    private int reportingUserId;
    private int reportedUserId;
    private String reportType;
    private String reportCategory;
    private String content;
    private long reportTime;
}