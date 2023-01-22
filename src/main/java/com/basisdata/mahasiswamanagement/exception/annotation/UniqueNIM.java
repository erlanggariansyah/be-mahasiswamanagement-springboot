package com.basisdata.mahasiswamanagement.exception.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNIMValidator.class)
@Target({
        ElementType.FIELD, ElementType.PARAMETER
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNIM {
    String message() default "nim is already registered.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
