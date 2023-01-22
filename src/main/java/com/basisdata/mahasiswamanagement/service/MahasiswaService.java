package com.basisdata.mahasiswamanagement.service;

import com.basisdata.mahasiswamanagement.dto.PerbaruiMahasiswaDTO;
import com.basisdata.mahasiswamanagement.dto.TambahMahasiswaDTO;
import com.basisdata.mahasiswamanagement.model.Mahasiswa;
import com.basisdata.mahasiswamanagement.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class MahasiswaService {
    private final MahasiswaRepository repository;

    @Autowired
    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.repository = mahasiswaRepository;
    }

    public Mahasiswa tambahMahasiswa(TambahMahasiswaDTO dto) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setJurusan(dto.getJurusan());
        mahasiswa.setCreated_at(new Date());

        return repository.save(mahasiswa);
    }

    public List<Mahasiswa> dapatSemuaMahasiswa() {
        return repository.findAll();
    }

    public Mahasiswa dapatDenganId(String id) {
        return repository.findById(id).orElse(null);
    }

    public void hapus(String id) {
        Mahasiswa mahasiswa = repository.findById(id).orElse(null);

        assert mahasiswa != null;
        repository.delete(mahasiswa);
    }

    public Mahasiswa perbarui(PerbaruiMahasiswaDTO dto) {
        Mahasiswa mahasiswa = repository.findById(dto.getId()).orElse(null);

        assert mahasiswa != null;
        mahasiswa.setNama(dto.getNama());
        mahasiswa.setNim(dto.getNim());
        mahasiswa.setJurusan(dto.getJurusan());

        return repository.save(mahasiswa);
    }
}
