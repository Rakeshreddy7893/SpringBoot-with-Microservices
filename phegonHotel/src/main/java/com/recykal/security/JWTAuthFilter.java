package com.recykal.security;


import com.recykal.service.CustomUserDetailsService;
import com.recykal.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//public class JWTAuthFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JWTUtils jwtUtils;
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//         final String authHeader = request.getHeader("Authorization");
//         final String jwtToken;
//         final String userEmail;
//
//         if(authHeader == null || !authHeader.isBlank()){
//             filterChain.doFilter(request,response);
//             return;
//         }
//
//         jwtToken= authHeader.substring(7);
//         userEmail=jwtUtils.extractUsername(jwtToken);
//
//         if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null){
//             UserDetails userDetails=customUserDetailsService.loadUserByUsername(userEmail);
//             if(jwtUtils.isValidToken(jwtToken,userDetails)){
//                  SecurityContext securityContextHolder = SecurityContextHolder.createEmptyContext();
//                 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//                 token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 securityContextHolder.setAuthentication(token);
//                 SecurityContextHolder.setContext(securityContextHolder);
//             }
//         }
//         filterChain.doFilter(request,response);
//
//    }
//}



@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        System.out.println("authHeader = " + authHeader);
        final String jwtToken;
        final String userEmail;


        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extract token and user email
        jwtToken = authHeader.substring(7);
        userEmail = jwtUtils.extractUsername(jwtToken);

        // Check if the user is authenticated and the SecurityContext is not already set
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userEmail);

            // Validate the token
            if (jwtUtils.isValidToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication to the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}


