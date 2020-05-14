package com.example.booking.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tgfc.tw.controller.exception.enums.AuthenticationErrorCode;
//import com.tgfc.tw.entity.model.response.advice.CommonResponse;
//import com.tgfc.tw.security.CustomProvider;
//import com.tgfc.tw.security.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.savedrequest.NullRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
    public static class ApiConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        CustomProvider provider;

        private ObjectMapper mapper = new ObjectMapper();

        /**
         * 初始化 security 配置檔案
         *
         * @param http security 配置檔案
         * @throws Exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().sameOrigin();
            http.cors().and().antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers("/api/**")
                    .authenticated()//符合 /api/** 的 url 皆需要登入驗證
                    .and()
                    .requestCache()
                    .requestCache(new NullRequestCache())
                    .and()
                    .logout().logoutUrl("/api/logout").deleteCookies("JSESSIONID", "XSRF-TOKEN")
                    .logoutSuccessHandler((HttpServletRequest var1, HttpServletResponse response, Authentication var3) -> {
//                        CommonResponse logoutOk = new CommonResponse(true, null, "logout ok");
                        response.setHeader("Content-type", "application/json;charset=UTF-8");
                        response.getWriter().print(mapper.writeValueAsString("logoutOk"));
                    });//定義匿名用戶(未登入)權限不足的錯誤訊息
            //啟用csrf防護
            http.csrf().ignoringAntMatchers("/api/login*");//設定忽略的url
            http.csrf().ignoringAntMatchers("/api/logout*");//設定忽略的url
            http.csrf().ignoringAntMatchers("/api/user/add*");//設定忽略的url
            http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository());
            //建立CsrfToken 工廠

            http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);

            http.exceptionHandling()
                    .authenticationEntryPoint((request, response, exception) -> {
//                        CommonResponse mustLogin = new CommonResponse(AuthenticationErrorCode.MUST_LOGIN, exception.getMessage());
                        response.setStatus(401);
                        response.setHeader("Content-type", "application/json;charset=UTF-8");
                        response.getWriter().print(mapper.writeValueAsString("mustLogin"));
                    })
                    .accessDeniedHandler((request, response, accessDeniedException) -> {
//                        CommonResponse permission_denied = new CommonResponse(AuthenticationErrorCode.PERMISSION_DENIED, accessDeniedException.getMessage());
                        response.setStatus(403);
                        response.setHeader("Content-type", "application/json;charset=UTF-8");
                        response.getWriter().print(mapper.writeValueAsString("permission_denied"));
                    });

        }


        @Bean
        public LoginFilter loginFilter() throws Exception {
            LoginFilter filter = new LoginFilter("/api/login");
            filter.setAuthenticationManager(authenticationManager());
            System.out.println("loginFilter");
            return filter;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(provider);  //設定驗證器
            System.out.println("configure provider");
        }
    }

    @Configuration
    @Order(2)
    public static class WebSocketConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

//            http.cors().and().csrf().disable().antMatcher("/footprint-websocket*").authorizeRequests().anyRequest().permitAll();
//在application.properties裡面下這個直令也可以server.servlet.session.timeout=15m
//15分後自動登出

        }
    }
}
