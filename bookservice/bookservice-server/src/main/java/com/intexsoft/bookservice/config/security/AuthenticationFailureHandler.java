package com.intexsoft.bookservice.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception)
            throws IOException {
        if (exception.getClass().isAssignableFrom(
                BadCredentialsException.class)) {
            response.setHeader("error", "Wrong Username Or Password !!!");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Wrong Username Or Password !!!");
        } else if (exception.getClass().isAssignableFrom(
                UsernameNotFoundException.class)) {
            response.setHeader("error", "Wrong Username Or Password !!!");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Wrong Username Or Password !!!");
        } else if (exception.getClass().isAssignableFrom(
                DisabledException.class)) {
            response.setHeader("error", "Your account not activated!!! Please activate your account.");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Your account not activated !!!");
        }
    }
}
