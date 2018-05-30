package com.example.interaction_management.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {
    static final String SIGNING_KEY = "EventPageBestApp";
    static final String HEADER_STRING = "Authorization";

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null && !token.isEmpty()) {
            String user = extractUserFromToken(token);
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
        }
        return null;
    }

    public static String extractUserFromToken(String token) {
        if (token != null && !token.isEmpty()) {
            try {
                if (token.split(" ").length > 1) {
                    token = token.split(" ")[1];
                }
                return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody().getSubject();
            } catch (MalformedJwtException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
