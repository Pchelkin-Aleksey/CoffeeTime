package com.example.coffee_time.controller;

import com.example.coffee_time.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handleAccessDeniedException(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error/access_denied");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView allException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error/generic_error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView notFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView("error/not_found");
        modelAndView.addObject("exception", exception.getMessage());
        return modelAndView;
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleException(Exception ex, Model model) {
//        model.addAttribute("message", ex.getMessage());
//        model.addAttribute("stackTrace", ex.getStackTrace());
//        return "error/generic_error";
//    }
}