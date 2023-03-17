package net.softsociety.blog.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	// 설정하기
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() //csrf 토큰은 POST 방식을 사용함
		.authorizeRequests()
		.antMatchers("/",
				
				//블로그 관련
				"/board",
				"/board/read",
				"/board/recommend",
				
				//회원관련
				"/member/",
				"/member/register",
				"/member/enter",
				"/member/memberlist",
				"/member/idCheck",
				
				//template
				"/images/**",
				"/css/**",
				"/script/**"
				
				).permitAll() //위에서 설정한 리소스의 접근은 인증절차 없이 허용
		.anyRequest().authenticated() //위의 경로 이외에는 모두 로그인을 해야 함
		.and()
		.formLogin()
		.loginPage("/member/enter") //시큐리티에서 제공하는 로그인 폼 대신 직접 제작한 폼을 사용하겠다는 의미
		.loginProcessingUrl("/member/login").permitAll() //로그인 폼의 액션명. 이 값은 인증으로 처리
		.usernameParameter("blogid") // 로그인 폼의 아이디 입력란의 name
		.passwordParameter("blogpwd") // 로그인 폼의 비밀번호 입력란의 name
		.and()
		.logout()
		.logoutSuccessUrl("/").permitAll()
		.and()
		.cors()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	// 인증을 위한 쿼리문
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		// 로그인 인증
		.usersByUsernameQuery(
			"SELECT blogid username, blogpwd password, enabled " +
			"FROM blog_member " + 
			"WHERE blogid = ?"
		)
		// 권한
		.authoritiesByUsernameQuery(
			"SELECT blogid username, rolename role_name " +
			"FROM blog_member " +
			"WHERE blogid = ?"
		);
	}
	
	// 단방향 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
