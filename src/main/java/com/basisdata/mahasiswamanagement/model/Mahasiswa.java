package com.basisdata.mahasiswamanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Mahasiswa implements Serializable {
    @Id
    private String id;

    private String nama;
    private Long nim;
    private String jurusan;

    private Date created_at;
}
