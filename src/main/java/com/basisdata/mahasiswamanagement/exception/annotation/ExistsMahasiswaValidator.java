package com.basisdata.mahasiswamanagement.exception.annotation;

import com.basisdata.mahasiswamanagement.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsMahasiswaValidator implements ConstraintValidator<ExistsMahasiswa, String> {
    private final MahasiswaRepository repository;

    @Autowired
    public ExistsMahasiswaValidator(MahasiswaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(ExistsMahasiswa constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.isBlank()) return true;
        return repository.existsById(s);
    }
}
