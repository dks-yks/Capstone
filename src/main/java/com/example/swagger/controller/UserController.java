package com.example.swagger.controller;

import com.example.swagger.entity.User;
import com.example.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "사용자 API")
@RestController
@RequestMapping("/picto/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원가입")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
        User foundUser = userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
        if (foundUser == null) {
            return ResponseEntity.status(401).body("로그인 실패");
        }
        return ResponseEntity.ok("로그인 성공");
    }

    @Operation(summary = "사용자 정보 수정")
    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        User user = userService.updateUser(updatedUser);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "프로필 정보 수정")
    @PatchMapping("/profile")
    public ResponseEntity<User> updateProfile(@RequestParam Integer userId, @RequestParam String profilePhoto, @RequestParam String intro, @RequestParam String title) {
        User user = userService.updateProfile(userId, profilePhoto, intro, title);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "차단한 사용자 조회")
    @GetMapping("/block")
    public ResponseEntity<List<User>> getBlockedUsers() {
        return ResponseEntity.ok(userService.getBlockedUsers());
    }

    @Operation(summary = "즐겨찾기한 사용자 조회")
    @GetMapping("/mark")
    public ResponseEntity<List<User>> getMarkedUsers() {
        return ResponseEntity.ok(userService.getMarkedUsers());
    }

    @Operation(summary = "사용자 차단")
    @PostMapping("/block")
    public ResponseEntity<User> blockUser(@RequestParam Integer userId) {
        User user = userService.blockUser(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "사용자 즐겨찾기")
    @PostMapping("/mark")
    public ResponseEntity<User> markUser(@RequestParam Integer userId) {
        User user = userService.markUser(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}