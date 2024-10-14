package com.example.swagger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhotoResponseDTO {
    private String photoPath;
    private int userId;
    private String title;
    private float lat;
    private float lng;
    private String location;
    private long registerTime;
    private String tag;
    private boolean active;
    private int like;
    private int views;
}