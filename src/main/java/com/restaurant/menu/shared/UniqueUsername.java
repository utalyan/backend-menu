package com.restaurant.menu.shared;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqueUsernameValidator.class}
)
public @interface UniqueUsername {

    String table() default "";
    String column() default "";

    String message() default "{%s} daha önce kullanılmış.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
