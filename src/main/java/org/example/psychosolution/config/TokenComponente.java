package org.example.psychosolution.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.example.psychosolution.entity.Pacientes;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenComponente {


    @Value("${movieflix.security.secret}")
    private String secret;

    public String gerartoken(Pacientes pacientes){
        Algorithm algo = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(pacientes.getEmail())
                .withClaim("pacienteId",pacientes.getId().toString())
                .withClaim("email", pacientes.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API PsychoSolution")
                .sign(algo);
    }

    public Optional<JWTUserData> verificarToken(String token){
        try{
            Algorithm algo = Algorithm.HMAC256(secret);
            DecodedJWT jwt =JWT.require(algo)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserData
                    .builder()
                    .id(UUID.fromString("pacienteid"))
                    .senha(jwt.getClaim("senha").asString())
                    .email(jwt.getSubject())
                    .build());
        }catch (JWTVerificationException ex){
            return Optional.empty();
        }
    }
}