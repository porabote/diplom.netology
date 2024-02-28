package ru.porabote.springbootrestauth.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {

        String xAuth = request.getHeader("auth-token");//here is your token value
        if (xAuth == null) {

        }
        //Place here your redis checks, get Authentication and so on
      //  SecurityContextHolder.getContext().setAuthentication(auth);

        filterChain.doFilter(request, response);
    }


}