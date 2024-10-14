package com.example.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Photo {
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
