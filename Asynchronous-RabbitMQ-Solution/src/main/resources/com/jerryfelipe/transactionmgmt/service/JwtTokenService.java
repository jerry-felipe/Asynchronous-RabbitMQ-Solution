package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.model.JwtToken;
import com.jerryfelipe.transactionmgmt.model.User;
import com.jerryfelipe.transactionmgmt.repository.JwtTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JwtTokenService {

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    // Generar un token JWT para un usuario
    public JwtToken generateJwtToken(User user, String token, LocalDateTime expiryTime) {
        JwtToken jwtToken = new JwtToken();
        jwtToken.setUser(user);
        jwtToken.setJwtToken(token);
        jwtToken.setExpiresAt(expiryTime);
        jwtToken.setCreatedAt(LocalDateTime.now());

        return jwtTokenRepository.save(jwtToken);
    }
}
