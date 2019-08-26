package org.openapex.samples.springboot.template.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DiceValidator.class)
public @interface DiceConstraint {

    String message() default "You have to choose between dice with 2,4,6,8,10,12,20 or 100 sides";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}