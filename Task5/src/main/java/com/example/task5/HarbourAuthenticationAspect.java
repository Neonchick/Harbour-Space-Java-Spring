package com.example.task5;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HarbourAuthenticationAspect {

    @Autowired
    HttpServletRequest request;

    @Around("execution(* com.example.task5.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String header = request.getHeader("x-harbour-auth");
        if ("GET".equals(request.getMethod())) {
            if ("read".equals(header)) {
                return joinPoint.proceed();
            } else {
                return "No x-harbour-auth header equals to read for GET request";
            }
        }
        if ("POST".equals(request.getMethod())) {
            if ("write".equals(header)) {
                return joinPoint.proceed();
            } else {
                return "No x-harbour-auth header equals to write for POST request";
            }
        }
        return joinPoint.proceed();
    }

}
