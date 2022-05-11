package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //메인 클래스에 선언된 @SpringBootapplication(사용자가 작성한 빈과 자동설정 빈들을 모두 초기화)과 비슷한 어노테이션, 테스트에 필요한 모든 설정과 빈들을 자동 초기화하는 역할
public class Chapter03Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter03Application.class, args);
	}

}
