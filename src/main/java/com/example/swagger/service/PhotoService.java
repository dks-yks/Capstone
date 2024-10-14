package com.example.swagger.service;

import com.example.swagger.entity.Photo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    private List<Photo> photos = new ArrayList<>();

    // 사진 업로드
    public Photo uploadPhoto(Photo photo) {
        photos.add(photo);
        return photo;
    }

    // 사진 조회
    public Optional<Photo> getPhoto(int userId) {
        return photos.stream()
                .filter(p -> p.getUserId() == userId)
                .findFirst();
    }

    // 사진 수정
    public Optional<Photo> updatePhoto(Photo updatedPhoto) {
        Optional<Photo> photoOptional = photos.stream()
                .filter(p -> p.getUserId() == updatedPhoto.getUserId())
                .findFirst();

        if (photoOptional.isPresent()) {
            Photo photo = photoOptional.get();
            photo.setTitle(updatedPhoto.getTitle());
            photo.setTag(updatedPhoto.getTag());
            photo.setPhotoPath(updatedPhoto.getPhotoPath());
            photo.setLat(updatedPhoto.getLat());
            photo.setLng(updatedPhoto.getLng());
            photo.setLocation(updatedPhoto.getLocation());
            return Optional.of(photo);
        }
        return Optional.empty();
    }
}
