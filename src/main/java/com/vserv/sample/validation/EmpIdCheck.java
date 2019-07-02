package com.vserv.sample.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/*
public interface EmpIdCheck {

}*/
@Documented
@Constraint(validatedBy = EmpConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmpIdCheck {
 
    String message() default "Invalid empId number";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
}

class EmpConstraintValidator implements ConstraintValidator<EmpIdCheck, String> {
	 
    @Override
    public void initialize(EmpIdCheck phonew) { }
 
    @Override
    public boolean isValid(String id, ConstraintValidatorContext cxt) {
        if(id == null) {
            return false;
        }
        return id.matches("[0-9()-\\.]*");
    }
 
}