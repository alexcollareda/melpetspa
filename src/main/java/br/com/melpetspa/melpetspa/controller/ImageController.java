package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.ImageUrlRequestDTO;
import br.com.melpetspa.melpetspa.service.FileS3Service;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final FileS3Service fileS3Service;

    public ImageController(FileS3Service fileS3Service) {
        this.fileS3Service = fileS3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = fileS3Service.uploadImage(file);
            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro no upload para S3: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete-by-url")
    public ResponseEntity<Void> deleteImageByUrl(@Valid @RequestBody ImageUrlRequestDTO request) {
        fileS3Service.deleteFileByUrl(request.getPhotoUrl());
        return ResponseEntity.noContent().build();
    }
}
