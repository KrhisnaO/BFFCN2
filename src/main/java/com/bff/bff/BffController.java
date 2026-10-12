package com.bff.bff;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class BffController {

    private final RestTemplate restTemplate = new RestTemplate();

    // --- VARIABLES REST ---
    @Value("${azure.functions.usuarios}")
    private String usuariosUrl;

    @Value("${azure.functions.roles}")
    private String rolesUrl;

    // --- VARIABLES GRAPHQL ---
    @Value("${azure.functions.graphql.usuarios}")
    private String usuariosGraphqlUrl;

    @Value("${azure.functions.graphql.roles}")
    private String rolesGraphqlUrl;

    // ==========================================
    //        ENDPOINTS REST DE USUARIOS
    // ==========================================

    @GetMapping("/usuarios")
    public ResponseEntity<String> getUsuarios() {
        return restTemplate.getForEntity(usuariosUrl, String.class);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<String> postUsuarios(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(usuariosUrl, entity, String.class);
    }

    @PutMapping("/usuarios")
    public ResponseEntity<String> putUsuarios(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(usuariosUrl, HttpMethod.PUT, entity, String.class);
    }

    @DeleteMapping("/usuarios")
    public ResponseEntity<String> deleteUsuarios(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(usuariosUrl, HttpMethod.DELETE, entity, String.class);
    }

    // ==========================================
    //          ENDPOINTS REST DE ROLES
    // ==========================================

    @GetMapping("/roles")
    public ResponseEntity<String> getRoles() {
        return restTemplate.getForEntity(rolesUrl, String.class);
    }

    @PostMapping("/roles")
    public ResponseEntity<String> postRoles(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(rolesUrl, entity, String.class);
    }

    @PutMapping("/roles")
    public ResponseEntity<String> putRoles(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(rolesUrl, HttpMethod.PUT, entity, String.class);
    }

    @DeleteMapping("/roles")
    public ResponseEntity<String> deleteRoles(@RequestBody String body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(rolesUrl, HttpMethod.DELETE, entity, String.class);
    }

    // ==========================================
    //             ENDPOINTS GRAPHQL
    // ==========================================

    @PostMapping("/graphql/usuarios")
    public ResponseEntity<String> graphqlUsuarios(@RequestBody String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(query, headers);
        return restTemplate.postForEntity(usuariosGraphqlUrl, entity, String.class);
    }

    @PostMapping("/graphql/roles")
    public ResponseEntity<String> graphqlRoles(@RequestBody String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(query, headers);
        return restTemplate.postForEntity(rolesGraphqlUrl, entity, String.class);
    }
}