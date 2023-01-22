package com.basisdata.mahasiswamanagement.exception.annotation;

import com.basisdata.mahasiswamanagement.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNIMValidator implements ConstraintValidator<UniqueNIM, Long> {
    private final MahasiswaRepository repository;

    @Autowired
    public UniqueNIMValidator(MahasiswaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(UniqueNIM constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null) return true;
        return repository.findByNim(aLong) == null;
    }
}
