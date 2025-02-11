package com.BookApplication.config;


import com.BookApplication.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Service
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("JWT filter triggered");
        String authHeader= request.getHeader("Authorization");
        String token=null;
        String username=null;

        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            token=authHeader.substring(7);
            username=jwtService.extractUsername(token);
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userDetailsService.loadUserByUsername(username);
            //username is correct , and we are going to get UNAuthToeken and put that in SecurityContextHolder ....
            if(jwtService.validateToken(token, userDetails)){

                UsernamePasswordAuthenticationToken authToken=
                        new  UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                //authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
            else
            {
                System.out.println("JWT validation failed");
            }
            System.out.println("Received request: " + request.getMethod() + " " + request.getRequestURI());
            System.out.println("Authorization Header: " + request.getHeader("Authorization"));

        }
        filterChain.doFilter(request, response);
    }
}
