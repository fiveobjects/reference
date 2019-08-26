package org.openapex.samples.springboot.template.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class DiceValidator implements ConstraintValidator<DiceConstraint, Integer> {

    protected int validSides [] = {2,4,6,8,10,12,20,100};

    @Override
    public boolean isValid(Integer sides, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(validSides).anyMatch(i -> i == sides.intValue());

    }
}