package com.syc.china.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String applicationPath;

    public SecurityConfig(AdminServerProperties properties){
        this.applicationPath=properties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //带有保存功能的请求处理器
        SavedRequestAwareAuthenticationSuccessHandler successHandler=new SavedRequestAwareAuthenticationSuccessHandler();
        //采用重定向的跳转策略
        successHandler.setTargetUrlParameter("redirectTo");

        http.authorizeRequests()
                .antMatchers(applicationPath+"/asserts/**")
                .permitAll()//对以上资源直接放行
                .antMatchers(applicationPath+"/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()//其它任意请求都必须经过认证
                .loginPage(applicationPath+"/login")//登录界面
                .successHandler(successHandler)//登录成功，进行重定向
                .and()
                .logout()
                .logoutUrl(applicationPath+"/logout")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
