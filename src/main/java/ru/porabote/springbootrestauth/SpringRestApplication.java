package ru.porabote.springbootrestauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.porabote.springbootrestauth.model.UserModel;

import java.util.List;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@RestController
@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

//    @Override
//    public Integer formLogin() {
//        return 89;
//    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(antMatcher(HttpMethod.POST, "/login")).permitAll()
                        .requestMatchers("/file", "/test").authenticated()
                );
        //http.j
       // http.formLogin(withDefaults());
        //http.httpBasic(withDefaults());
        return http.build();
    }

    @PostMapping("/login")
    public String login(@RequestBody UserModel userDetails) {
       // System.out.println(userDetails);
        String resp = new String("{\"auth-token\": \"kjhsdfkjhaskjdf\"}");
        return resp;
    }

//    @PostMapping("/login")
//    @Secured({"READ"})
//    public String login(@RequestParam("user") String user, @RequestParam("password") String password) {
//        String resp = new String("{\"auth-token\": \"kjhsdfkjhaskjdf\"}");
//        return "ui";
//    }

//    @GetMapping("/home")
//    @Secured({"ROLE_ADMIN"})
//    public String hi() {
//        return "home";
//    }

//    @GetMapping("/login")
//    @Secured({"READ"})
//    public String bye() {
//        return "login";
//    }

    //    @GetMapping("/write")
//    @RolesAllowed({"WRITE"})
//    public String write() {
//        return "write";
//    }
//
//    @GetMapping("/update")
//    @PreAuthorize("hasAuthority('WRITE') or hasAuthority('DELETE')")
//    public String update() {
//        return "update";
//    }
//
//    @GetMapping("/profile")
//    @PreAuthorize("#username == authentication.principal.username")
//    public String profile(String username) {
//        return "It profile " + username;
//    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("https://diplom.porabote.ru"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}