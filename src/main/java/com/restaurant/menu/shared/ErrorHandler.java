package com.restaurant.menu.shared;


import antlr.collections.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ApiError handleAllException(WebRequest webRequest)
    {
        Map<String,Object> attributes = this.errorAttributes.getErrorAttributes(webRequest,ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));

        String message =  (String) attributes.get("message");
        String path = (String) attributes.get("path");
        int status = (int)attributes.get("status");

        ApiError apiError = new ApiError(status,message,path);

        if(attributes.containsKey("errors")) {

            @SuppressWarnings("unchecked")
            java.util.List<FieldError> fieldErrorList =  (java.util.List<FieldError>)attributes.get("errors");
            Map<String,String> validationErrors = new HashMap<>();

            for (FieldError fieldError:fieldErrorList
                 ) {
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            apiError.setValidationErrors(validationErrors);
        }

        return  apiError;

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
