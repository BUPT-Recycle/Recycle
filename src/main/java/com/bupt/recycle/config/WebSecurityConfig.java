package com.bupt.recycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @anthor tanshangou
 * @time 2018/4/9
 * @description
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 在内存中创建一个名为user的用户，密码为pwd，拥有USER权限
     * @return
     */

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        User.UserBuilder users =User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("pwd").roles("USER").build());
        return manager;
    }


    /**
     * 匹配"/"路径，不需要权限即可访问
     * 匹配"/user"及其以下所有路径，需要USER权限
     * 匹配登陆和登出的页面及其跳转页面
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}
