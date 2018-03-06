package es.udc.fic.tfg.newHorse;

import es.udc.fic.tfg.horse.HorseRepository;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NicknameExistsValidator.class)
@Documented
public @interface NicknameExists {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

@Component
class NicknameExistsValidator implements ConstraintValidator<NicknameExists, String> {

    private final HorseRepository horseRepository;

    public NicknameExistsValidator(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }


    @Override
    public void initialize(NicknameExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !horseRepository.exists(value);
    }
}
