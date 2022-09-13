package com.reihaneh.personalexpenses.web.rest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import com.reihaneh.personalexpenses.web.rest.util.CustomUtilities;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/users")
@Slf4j
@Tag(name = "User")
public class UserResource extends BaseResource<UserDto, UserService, Long> {

    private final UserService service;

    public UserResource(UserService service) {
        super(service, log);
        this.service = service;
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Refresh token is missing.");
        }
        try {
            String refresh_token = authorizationHeader.substring("Bearer ".length());
            Algorithm algorithm = CustomUtilities.getHMAC256Algorithm("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(refresh_token);
            String username = decodedJWT.getSubject();
            UserDto userDto = service.findByUsername(username);


            String access_token = JWT.create()
                    .withSubject(userDto.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("roles", new ArrayList<>().add("USER_ROLE"))
                    .sign(algorithm);

            Map<String, String> tokens = new HashMap<>();
            tokens.put("access_token", access_token);
            tokens.put("refresh_token", refresh_token);

            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), tokens);

        } catch (Exception e) {
            response.setHeader("error", e.getMessage());
//                response.sendError(FORBIDDEN.value());
            response.setStatus(FORBIDDEN.value());
            Map<String, String> errors = new HashMap<>();
            errors.put("error_message", e.getMessage());

            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), errors);
        }
    }
}
