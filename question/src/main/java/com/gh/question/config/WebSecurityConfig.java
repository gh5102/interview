package com.gh.question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author
 * @date 2019/12/15 10:38
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    /**
     * 授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，其他一律不放出。
        http.authorizeRequests()
                //经营范围查询放出-网厅使用
                .antMatchers("/back/jyfw/search*")
                .permitAll()

                //登陆错误地址放行
                //.antMatchers("/back/loginError")
                //.permitAll()

                // 后台url需要做登录拦截
//                .antMatchers("/back/**")
//                .authenticated()

                .anyRequest() // 其他（即网厅部分）放行
                .permitAll()

                // 登录地址放行
                .and()
                .formLogin()
                .loginPage("/back/login")
                .failureUrl("/back/loginError") // 登录失败跳转到/loginError做处理。如果不做处理默认跳转页面是/login?error
                .defaultSuccessUrl("/back/index") // 登录成功跳转页面


                .usernameParameter("username")
                .passwordParameter("password") // // 默认为username和password，参数名相同时，可以忽略
                .permitAll()

                .and()
                .logout()
                .logoutUrl("/back/logout") // 退出登录url
                .deleteCookies("JSESSIONID") // 删除cookie
                .logoutSuccessUrl("/back/login") // 退出成功跳转url
                .permitAll();
        http.csrf().disable();

        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/back/loginInvalid", "/back/test");
    }
}
