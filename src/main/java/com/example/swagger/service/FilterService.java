package com.example.swagger.service;

import com.example.swagger.entity.Category;
import com.example.swagger.entity.Sort;
import com.example.swagger.entity.CustomTag;  // CustomTag 임포트
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FilterService {

    // 카테고리 목록
    public List<Category> getCategories() {
        return Arrays.asList(
                new Category(1, "풍경"),
                new Category(2, "동물")
        );
    }

    // 정렬순 목록
    public List<Sort> getSortOptions() {
        return Arrays.asList(
                new Sort(1, "좋아요순"),
                new Sort(2, "조회순")
        );
    }

    // 태그 목록
    public List<CustomTag> getTags() {
        return Arrays.asList(
                new CustomTag(1, "고양이"),
                new CustomTag(2, "강아지")
        );
    }
}