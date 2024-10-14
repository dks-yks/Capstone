package com.example.swagger.service;

import com.example.swagger.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    // 회원가입 로직
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    // 로그인 로직
    public User loginUser(String email, String password) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    // 사용자 정보 수정 로직
    public User updateUser(User updatedUser) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId().equals(updatedUser.getId()))
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(updatedUser.getName());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            return user;
        }
        return null;
    }

    // 프로필 정보 수정 로직
    public User updateProfile(Integer userId, String profilePhoto, String intro, String title) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // 프로필 사진, 소개, 칭호 등 수정
            return user;
        }
        return null;
    }

    // 차단된 사용자 목록 조회 로직
    public List<User> getBlockedUsers() {
        List<User> blockedUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isBlocked()) {
                blockedUsers.add(user);
            }
        }
        return blockedUsers;
    }

    // 즐겨찾기한 사용자 목록 조회 로직
    public List<User> getMarkedUsers() {
        List<User> markedUsers = new ArrayList<>();
        for (User user : users) {
            if (user.isMarked()) {
                markedUsers.add(user);
            }
        }
        return markedUsers;
    }

    // 사용자 차단 설정 로직
    public User blockUser(Integer userId) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setBlocked(true);
            return user;
        }
        return null;
    }

    // 사용자 즐겨찾기 설정 로직
    public User markUser(Integer userId) {
        Optional<User> userOptional = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setMarked(true);
            return user;
        }
        return null;
    }
}