package br.com.melpetspa.melpetspa.dto;

import lombok.Data;

@Data
public class UpdatePhotoRequest {
    private long petId;
    private String photoUrl;
}
