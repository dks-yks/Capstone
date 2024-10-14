package com.example.swagger.controller;

import com.example.swagger.dto.ApiResponse;
import com.example.swagger.entity.CustomTag;  // CustomTag 임포트
import com.example.swagger.entity.Category;
import com.example.swagger.entity.Sort;
import com.example.swagger.service.FilterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "필터 API")
@RestController
@RequestMapping("/picto/api/filters")
public class FilterController {

    private final FilterService filterService;

    public FilterController(FilterService filterService) {
        this.filterService = filterService;
    }

    @Operation(summary = "카테고리 목록 조회", description = "사진 카테고리 목록을 조회합니다.")
    @GetMapping("/category")
    public ResponseEntity<ApiResponse<List<Category>>> getCategoryList() {
        List<Category> categories = filterService.getCategories();
        ApiResponse<List<Category>> response = new ApiResponse<>(true, 200, "카테고리 목록", categories);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "정렬순 목록 조회", description = "정렬 옵션 목록을 조회합니다.")
    @GetMapping("/sort")
    public ResponseEntity<ApiResponse<List<Sort>>> getSortList() {
        List<Sort> sortOptions = filterService.getSortOptions();
        ApiResponse<List<Sort>> response = new ApiResponse<>(true, 200, "정렬순 목록", sortOptions);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "태그 목록 조회", description = "태그 목록을 조회합니다.")
    @GetMapping("/tags")
    public ResponseEntity<ApiResponse<List<CustomTag>>> getTagList() {
        List<CustomTag> tags = filterService.getTags();  // CustomTag 사용
        ApiResponse<List<CustomTag>> response = new ApiResponse<>(true, 200, "태그 목록", tags);
        return ResponseEntity.ok(response);
    }
}