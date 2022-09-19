
package com.portfolio.backend.basededatos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import static java.lang.Integer.parseInt;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    
    @Value("${app.jwt-secret}")
    private String jwtSecret;
    
    @Value("${app.jwt-expiration-milliseconds}")
    private String jwtExpiratioInMs;
    
    public String generarToken(Authentication authentication){
        String email = authentication.getName();
        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + parseInt(jwtExpiratioInMs));
        
        String token = Jwts.builder().setSubject(email).setIssuedAt(new Date())
                .setExpiration(fechaExpiracion).signWith(SignatureAlgorithm
                        .HS512, jwtSecret).compact();
        return token;
    }
    
    public String obtenerEmailDelJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    
    public boolean validarToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Firma JWT no valida");
        }
        catch (MalformedJwtException e) {
            System.out.println("Token JWT no valido");
        }
        catch (ExpiredJwtException e) {
            System.out.println("Token JWT caducado");
        }
        catch (IllegalArgumentException e) {
            System.out.println("La cadena claims JWT esta vacia");
        }
        return false;
    }
}
