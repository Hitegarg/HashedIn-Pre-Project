//package com.example.conVRsationalAI.Config;
//
////
////import com.example.passwordmanagerapplication.Service.CustomUserDetailsService;
//////import com.example.springbootsecurity.Service.CustomUserDetailsService;
//import com.example.conVRsationalAI.Services.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private JwtAuthenticationFilter jwtFilter;
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .cors()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/token").permitAll()
//                .antMatchers("/user/credentials").permitAll()
//                .antMatchers("/user/credentials/*").permitAll()
//                .antMatchers("/size").permitAll()
//                //.antMatchers("/welcome").permitAll()
//
//                .antMatchers("/size/*").permitAll()
//                .antMatchers("/colour/*").permitAll()
//                .antMatchers("/colour").permitAll()
//                .antMatchers("/product").permitAll()
//                .antMatchers("/product/*").permitAll()
//                .antMatchers("/user/updateReview/*").permitAll()
//                .antMatchers("/products/*").permitAll()
//                .antMatchers("/get_by_colourname/*").permitAll()
//                .antMatchers("/get_by_colourid/*").permitAll()
//                .antMatchers("/get_by_sizename/*").permitAll()
//                .antMatchers("/get_by_sizeid/*").permitAll()
//                .antMatchers("/get_by_colournameandsizename/*/*").permitAll()
//                .antMatchers("/get_by_colournameandsizenameandcategory/*/*/*").permitAll()
//                .antMatchers("/get_by_colournameandsizenameandcategoryandfabrictype/*/*/*/*").permitAll()
//                .antMatchers("/get_by_colournameandcategory/*/*").permitAll()
//                .antMatchers("/get_by_sizenameandcategory/*/*").permitAll()
//                .antMatchers("/get_by_fabrictypeandcategory/*/*").permitAll()
//
//
//
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
//



package com.example.conVRsationalAI.Config;

//
//import com.example.passwordmanagerapplication.Service.CustomUserDetailsService;
////import com.example.springbootsecurity.Service.CustomUserDetailsService;
import com.example.conVRsationalAI.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationFilter jwtFilter;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/token").permitAll()
                .antMatchers("/user/credentials").permitAll()
                .antMatchers("/user/credentials/*").permitAll()
                .antMatchers("/user/credentials/forgot-password/*").permitAll()
                .antMatchers("/user/credentials/reset-password/*/*").permitAll()
                .antMatchers("/size").permitAll()
                //.antMatchers("/welcome").permitAll()

                .antMatchers("/size/*").permitAll()
                .antMatchers("/colour/*").permitAll()
                .antMatchers("/colour").permitAll()
                .antMatchers("/product").permitAll()
                .antMatchers("/product/*").permitAll()
                .antMatchers("/user/updateReview/*").permitAll()
                .antMatchers("/products/*").permitAll()
                .antMatchers("/get_by_colourname/*").permitAll()
                .antMatchers("/get_by_colourid/*").permitAll()
                .antMatchers("/get_by_sizename/*").permitAll()
                .antMatchers("/get_by_sizeid/*").permitAll()
                .antMatchers("/get_by_colournameandsizename/*/*").permitAll()
                .antMatchers("/get_by_colournameandsizenameandcategory/*/*/*").permitAll()
                .antMatchers("/get_by_colournameandsizenameandcategoryandfabrictype/*/*/*/*").permitAll()
                .antMatchers("/get_by_colournameandcategory/*/*").permitAll()
                .antMatchers("/get_by_sizenameandcategory/*/*").permitAll()
                .antMatchers("/get_by_fabrictypeandcategory/*/*").permitAll()



                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

