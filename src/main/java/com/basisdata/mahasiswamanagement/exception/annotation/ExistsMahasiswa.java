package com.basisdata.mahasiswamanagement.exception.annotation;

import java.lang.annotation.*;

@Documented
@Target({
        ElementType.FIELD, ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsMahasiswa {
}
