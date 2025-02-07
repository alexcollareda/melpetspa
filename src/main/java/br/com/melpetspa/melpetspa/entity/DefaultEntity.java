package br.com.melpetspa.melpetspa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class DefaultEntity {
    private LocalDateTime dateTimeInsert;
    private LocalDateTime dateTimeUpdate;
    private String userInsert;
    private String userUpdate;
}
