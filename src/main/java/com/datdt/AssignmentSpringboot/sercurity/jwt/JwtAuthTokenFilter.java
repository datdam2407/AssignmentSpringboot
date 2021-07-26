package com.datdt.AssignmentSpringboot.sercurity.jwt;

import java.io.IOException;
import com.datdt.AssignmentSpringboot.sercurity.service.accountDeatailService;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter{

    private final JwtUtils jwtUtils;

    private final accountDeatailService accountDeatailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    public JwtAuthTokenFilter(JwtUtils jwtUtils,
            com.datdt.AssignmentSpringboot.sercurity.service.accountDeatailService accountDeatailService) {
        this.jwtUtils = jwtUtils;
        this.accountDeatailService = accountDeatailService;
    }

    private String parseJwt(HttpServletRequest request){
        String headerAuth = request.getHeader("authorization");

        if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")){
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if(jwt != null && jwtUtils.validateJwtToken(jwt)){
                String username = jwtUtils.getUsernameFromJwtToken(jwt);

                UserDetails userDetails = accountDeatailService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                 new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            LOGGER.error("Cannot Set User Authentication: {}", e);
        }
        
        filterChain.doFilter(request, response);

    }
    
}

