package com.basisdata.mahasiswamanagement.repository;

import com.basisdata.mahasiswamanagement.model.Mahasiswa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MahasiswaRepository extends MongoRepository<Mahasiswa, String> {
    Mahasiswa findByNim(Long nim);
}
