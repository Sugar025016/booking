package com.example.booking.conf;


import org.springframework.security.core.context.SecurityContextHolder;


public class ContextHolderHandler {

    private static Object getUserResponseHandler() {
        return  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getName() {
        return getUserResponseHandler().toString();
    }





}
