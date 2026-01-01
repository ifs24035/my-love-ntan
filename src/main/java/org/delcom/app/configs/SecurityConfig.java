package org.delcom.app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Matikan CSRF untuk menghindari error pada form input sederhana
            .csrf(csrf -> csrf.disable())

            // Atur apa yang terjadi jika user memaksa masuk halaman terlarang
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((req, res, e) -> {
                    System.out.println("Akses ditolak ke: " + req.getRequestURI()); // Debugging di Console
                    res.sendRedirect("/auth/login"); // Lempar ke login
                }))

            .authorizeHttpRequests(auth -> auth
                // 1. DAFTAR HALAMAN YANG BOLEH DIAKSES TANPA LOGIN (PUBLIC)
                // Wajib daftarkan semua URL sistem barumu disini
                .requestMatchers(
                    "/",                // Halaman awal (Gate 1)
                    "/check-gate1",     // Proses Gate 1
                    "/gate2",           // Halaman Gate 2
                    "/check-gate2",     // Proses Gate 2
                    "/gallery",         // Halaman Daftar Foto
                    "/gallery/**",      // Jaga-jaga jika ada slash
                    "/detail/**",       // Halaman Detail
                    "/uploads/**",      // Folder gambar/video/lagu
                    "/error"            // Halaman error bawaan Spring
                ).permitAll()

                // 2. DAFTAR HALAMAN SYSTEM LAMA & ASET (PUBLIC)
                .requestMatchers(
                    "/auth/**", 
                    "/assets/**", 
                    "/api/**", 
                    "/css/**", 
                    "/js/**"
                ).permitAll()

                // 3. SELAIN DI ATAS, WAJIB LOGIN
                .anyRequest().authenticated()
            )

            .formLogin(form -> form.disable())
            .logout(logout -> logout
                .logoutSuccessUrl("/auth/login")
                .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}