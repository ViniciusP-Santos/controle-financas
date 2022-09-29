package br.com.ifg.controlefinanca.models.config.security;

import br.com.ifg.controlefinanca.models.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private Environment env;

    @Autowired
    UsuarioService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final String[] PUBLIC_MATCHERS = {"/h2-console/**", "/api/v*/registration/**"};


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(Arrays.asList(env.getActiveProfiles()).contains("DEV")){
            http.headers().frameOptions().disable();

        }


        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(PUBLIC_MATCHERS)
                    .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }



    //    //TODO: Finalizar desenvolvimento de configuração da segurança da aplicação.
//    private static final String[] PUBLIC_MATCHERS = {"/h2-console/**"};
//
//    /** Criptografia de senha */
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//    /**
//     * Autenticação
//     * */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
//
//        /**Em Memória*/
////        auth.inMemoryAuthentication()
////                .withUser("user1").password(bCryptPasswordEncoder().encode("user1Pass")).roles("USER")
////                .and()
////                .withUser("user2").password(bCryptPasswordEncoder().encode("user2Pass")).roles("USER")
////                .and()
////                .withUser("admin").password(bCryptPasswordEncoder().encode("adminPass")).roles("ADMIN");
//
//    }
//
//    /**
//     * Autorização
//     * */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        if(Arrays.asList(env.getActiveProfiles()).contains("DEV")){
//            http.headers().frameOptions().disable();
//        }
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers(PUBLIC_MATCHERS).permitAll().
//                and()
//                .httpBasic();
//    }




    /**
     * ----------------------------------------------------------------------------------------
     * */



//
//    private static final String[] PUBLIC_MATCHERS = {"/h2-console/**", "/**"};
//
//    @Autowired
//    private Environment env;
//
//    /**
//     * Filtro EndPoint
//     * */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        if(Arrays.asList(env.getActiveProfiles()).contains("DEV")){
//            http.headers().frameOptions().disable();
//
//        }
//        http.cors().and().csrf().disable();
//        http.authorizeRequests()
//                        .antMatchers(PUBLIC_MATCHERS).permitAll()
//                        .anyRequest().authenticated();
//
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
////
////        auth
////                .inMemoryAuthentication()
////                .withUser("admin")
////                .password(encoder.encode("admin"))
////                .roles("ADMIN", "USER")
////                .and()
////                .withUser("user")
////                .password(encoder.encode("password"))
////                .roles("USER");
////    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
