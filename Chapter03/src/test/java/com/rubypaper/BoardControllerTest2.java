package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.rubypaper.service.BoardService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)//이 설정에 의해 서블릿 컨테이너가 모킹된다. mock 서블릿 컨테이너없이, port는 서블릿 컨테이너 구동
@AutoConfigureMockMvc
// @Controller, @RestControlloer가 설정된 클래스들을 찾아서 메모리에 생성함
public class BoardControllerTest2 {
	@Autowired
	private TestRestTemplate restT;
	
	
	@Test
	public void testHello(Model model) throws Exception{
		String result=restT.getForObject("/hello?name=둘리", String.class);
				//assertEquals(null, null);
	}
	
	
	
	
	/*@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BoardService boardService;
	
	@Test
	public void testHello() throws Exception {
		when(boardService.hello("ss")).thenReturn("Hello : ss");
		
		mockMvc.perform(get("/hello").param("name", "ss"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello : ss"))
		//.andExpect(view().name("ss"))
		//.andExpect(redirectedUrl("/index"))
		.andDo(print());	
	}*/
}

//MockMvc가 제공하는 perfrom메소드는 브라우저를 여는것 처럼

