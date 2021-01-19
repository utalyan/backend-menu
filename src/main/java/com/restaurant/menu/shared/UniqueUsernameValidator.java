package com.restaurant.menu.shared;

import com.restaurant.menu.entity.Firm;
import com.restaurant.menu.entity.User;
import com.restaurant.menu.repository.FirmRepository;
import com.restaurant.menu.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    public static final Logger log = LoggerFactory.getLogger(UniqueUsernameValidator.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    FirmRepository firmRepository;

    String table;
    String column;
    String message;
    boolean returnValue = true;

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        table = constraintAnnotation.table();
        column = constraintAnnotation.column();
        message = constraintAnnotation.message();
        returnValue=true;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {



        if (value == null)
        {
            return true;
        }

        if (table.contentEquals("USER") & column.contentEquals("USERNAME") )
        {
            Optional<User> user = userRepository.findByUsername(value);

            if (user.isPresent()){
                returnValue = false;
            }
        }

        if (table.contentEquals("FIRM") & column.contentEquals("NAME") )
        {
            Optional<Firm> firm = firmRepository.findByName(value);

            if (firm.isPresent()){

                returnValue = false;
            }
        }

        if (table.contentEquals("FIRM") & column.contentEquals("EMAIL") )
        {
            Optional<Firm> firm = firmRepository.findByEmail(value);

            if (firm.isPresent()){

                returnValue = false;
            }
        }

        if (!returnValue)
        {
            message = String.format(message,value);

            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();

            return  returnValue;
        }

        return true;
    }
}
