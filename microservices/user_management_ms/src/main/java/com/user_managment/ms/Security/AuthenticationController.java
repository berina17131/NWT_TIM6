package com.user_managment.ms.Security;

import com.user_managment.ms.Models.User;
import com.user_managment.ms.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("userDetailsService")
    private UserService userDetailsService;

    @PostMapping(value = "/generate-token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUser loginUser) {

        final Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new AuthenticationException("Login failed for user: " + loginUser.getUsername());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userDetailsService.getByUserName(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok(new AuthToken(token));
    }
}
