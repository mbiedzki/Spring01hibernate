package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MatureValidator implements ConstraintValidator<Mature, Integer> {

    @Override
    public void initialize(Mature mature) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer + 18 < LocalDate.now().getYear();

    }
}

