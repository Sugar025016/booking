package com.example.booking.exception;

import com.example.booking.model.request.UserRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
//    public  WebResult resolveConstraintViolationException(ConstraintViolationException ex){
//        WebResult errorWebResult = new WebResult(WebResult.FAILED);
//        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
//        if(!CollectionUtils.isEmpty(constraintViolations)){
//            StringBuilder msgBuilder = new StringBuilder();
//            for(ConstraintViolation constraintViolation :constraintViolations){
//                msgBuilder.append(constraintViolation.getMessage()).append(",");
//            }
//            String errorMessage = msgBuilder.toString();
//            if(errorMessage.length()>1){
//                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
//            }
//            errorWebResult.setInfo(errorMessage);
//            return errorWebResult;
//        }
//        errorWebResult.setInfo(ex.getMessage());
//        return errorWebResult;
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public WebResult resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//        WebResult errorWebResult = new WebResult(WebResult.FAILED);
//        List<ObjectError>  objectErrors = ex.getBindingResult().getAllErrors();
//        if(!CollectionUtils.isEmpty(objectErrors)) {
//            StringBuilder msgBuilder = new StringBuilder();
//            for (ObjectError objectError : objectErrors) {
//                msgBuilder.append(objectError.getDefaultMessage()).append(",");
//            }
//            String errorMessage = msgBuilder.toString();
//            if (errorMessage.length() > 1) {
//                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
//            }
//            errorWebResult.setInfo(errorMessage);
//            return errorWebResult;
//        }
//        errorWebResult.setInfo(ex.getMessage());
//        return errorWebResult;
//    }
}
