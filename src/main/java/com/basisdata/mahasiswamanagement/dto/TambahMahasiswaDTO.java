package com.basisdata.mahasiswamanagement.dto;

import com.basisdata.mahasiswamanagement.exception.annotation.UniqueNIM;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TambahMahasiswaDTO {
    @NotNull(message = "nama field is mandatory.")
    private String nama;

    @NotNull(message = "nim field is mandatory.")
    @UniqueNIM
    private Long nim;

    @NotNull(message = "jurusan field is mandatory.")
    private String jurusan;
}
