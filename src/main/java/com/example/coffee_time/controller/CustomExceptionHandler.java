package com.example.coffee_time.controller;

import com.example.coffee_time.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
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

}