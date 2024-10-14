package com.example.swagger.controller;

import com.example.swagger.dto.PhotoResponseDTO;
import com.example.swagger.entity.Photo;
import com.example.swagger.service.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "사진 API")
@RestController
@RequestMapping("/picto/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @Operation(summary = "사진 업로드", description = "새로운 사진을 업로드합니다.")
    @PostMapping("/upload")
    public ResponseEntity<PhotoResponseDTO> uploadPhoto(@RequestBody Photo photo) {
        Photo uploadedPhoto = photoService.uploadPhoto(photo);
        PhotoResponseDTO responseDTO = new PhotoResponseDTO(
                uploadedPhoto.getPhotoPath(),
                uploadedPhoto.getUserId(),
                uploadedPhoto.getTitle(),
                uploadedPhoto.getLat(),
                uploadedPhoto.getLng(),
                uploadedPhoto.getLocation(),
                uploadedPhoto.getRegisterTime(),
                uploadedPhoto.getTag(),
                uploadedPhoto.isActive(),
                uploadedPhoto.getLike(),
                uploadedPhoto.getViews()
        );
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "사진 조회", description = "특정 사용자의 사진을 조회합니다.")
    @GetMapping
    public ResponseEntity<PhotoResponseDTO> getPhoto(@RequestParam int userId) {
        Optional<Photo> photo = photoService.getPhoto(userId);
        if (photo.isPresent()) {
            Photo foundPhoto = photo.get();
            PhotoResponseDTO responseDTO = new PhotoResponseDTO(
                    foundPhoto.getPhotoPath(),
                    foundPhoto.getUserId(),
                    foundPhoto.getTitle(),
                    foundPhoto.getLat(),
                    foundPhoto.getLng(),
                    foundPhoto.getLocation(),
                    foundPhoto.getRegisterTime(),
                    foundPhoto.getTag(),
                    foundPhoto.isActive(),
                    foundPhoto.getLike(),
                    foundPhoto.getViews()
            );
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "사진 수정", description = "사진의 정보를 수정합니다.")
    @PatchMapping
    public ResponseEntity<PhotoResponseDTO> updatePhoto(@RequestBody Photo updatedPhoto) {
        Optional<Photo> photo = photoService.updatePhoto(updatedPhoto);
        if (photo.isPresent()) {
            Photo updated = photo.get();
            PhotoResponseDTO responseDTO = new PhotoResponseDTO(
                    updated.getPhotoPath(),
                    updated.getUserId(),
                    updated.getTitle(),
                    updated.getLat(),
                    updated.getLng(),
                    updated.getLocation(),
                    updated.getRegisterTime(),
                    updated.getTag(),
                    updated.isActive(),
                    updated.getLike(),
                    updated.getViews()
            );
            return ResponseEntity.ok(responseDTO);
        }
        return ResponseEntity.notFound().build();
    }
}
