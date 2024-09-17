package br.com.testefcamara.backendtestjava.config.security;

import br.com.testefcamara.backendtestjava.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe com configurações de PRODUÇÃO para restrição de rotas.
 */
@EnableWebSecurity
@Configuration
@Profile("prod")
public class SecurityConfigurations {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityConfigurations(AuthenticationService authenticationService, TokenService tokenService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    /**
     * Configuração do AuthenticationManager para injeção em outros lugares.
     *
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Configuração de senha para ser usada na aplicação.
     *
     * @return BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura as permissões das rotas e a política de sessões.
     *
     * @param http
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desativa CSRF
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Define política de sessão
                .authorizeHttpRequests(auth -> auth  // Configuração de autorizações
                        .antMatchers(HttpMethod.GET, "/api/company").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/company*").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/vehicle").permitAll()
                        .antMatchers(HttpMethod.GET, "/api/vehicle*").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/auth").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/auth/*").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new AuthenticationTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
