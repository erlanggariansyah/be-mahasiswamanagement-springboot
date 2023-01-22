package com.basisdata.mahasiswamanagement.controller;

import com.basisdata.mahasiswamanagement.dto.PerbaruiMahasiswaDTO;
import com.basisdata.mahasiswamanagement.dto.TambahMahasiswaDTO;
import com.basisdata.mahasiswamanagement.exception.annotation.ExistsMahasiswa;
import com.basisdata.mahasiswamanagement.model.Mahasiswa;
import com.basisdata.mahasiswamanagement.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/mahasiswa")
public class MahasiswaController {
    private final MahasiswaService service;

    @Autowired
    public MahasiswaController(MahasiswaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mahasiswa>> getAll() {
        return ResponseEntity.ok(service.dapatSemuaMahasiswa());
    }

    @GetMapping("/get")
    public ResponseEntity<Mahasiswa> getById(
            @RequestParam @Valid @NotNull(message = "id field is mandatory.") @ExistsMahasiswa String id
    ) {
        return ResponseEntity.ok(service.dapatDenganId(id));
    }

    @PostMapping
    public ResponseEntity<Mahasiswa> insert(
            @Valid @RequestBody TambahMahasiswaDTO dto
    ) {
        return ResponseEntity.ok(service.tambahMahasiswa(dto));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> delete(
            @RequestParam @Valid @NotNull(message = "id field is mandatory.") @ExistsMahasiswa String id
    ) {
        service.hapus(id);
        return ResponseEntity.ok(new HashMap<>(){{
            put("status", "success");
        }});
    }

    @PutMapping
    public ResponseEntity<Mahasiswa> update(
            @Valid @RequestBody PerbaruiMahasiswaDTO dto
    ) {
        return ResponseEntity.ok(service.perbarui(dto));
    }
}
