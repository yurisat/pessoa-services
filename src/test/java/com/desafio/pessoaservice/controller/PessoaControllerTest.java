package com.desafio.pessoaservice.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.desafio.pessoaservice.dto.MensagemDTO;
import com.desafio.pessoaservice.dto.PessoaDTO;
import com.desafio.pessoaservice.service.PessoaService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PessoaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaService pessoaService;
	
	private String examplePessoa = "{" + 
			"    \"id\": 1,\n" + 
			"    \"dataNascimento\": \"1982-07-30\"," + 
			"    \"nome\": \"Teste de alteracao\"," + 
			"    \"cpf\": \"12345678911\"" + 
			"}";
	
	@Test
	public void criaPessoaTest() throws Exception {
		
		MensagemDTO mensagem = new MensagemDTO("Entidade gravada com sucesso");
		
		PessoaDTO mockPessoa = new PessoaDTO();
		mockPessoa.setCpf("11111111111");
		mockPessoa.setNome("Teste");
		mockPessoa.setDataNascimento(new Date());

		Mockito.when(pessoaService.criaPessoa(mockPessoa)).thenReturn(mensagem);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/pessoa")
				.accept(MediaType.APPLICATION_JSON).content(examplePessoa)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost:8080/pessoa/1", response.getHeader(HttpHeaders.LOCATION));
		
	}
	
	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		
		PessoaDTO mockPessoa = new PessoaDTO();
		mockPessoa.setCpf("11111111111");
		mockPessoa.setNome("Teste");
		mockPessoa.setDataNascimento(new Date());

		Mockito.when(
				pessoaService.recuperaPessoa(new Long(1))).thenReturn(mockPessoa);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/pessoa/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"id\":\"2\",\"nome\":Spring,description:10Steps}";

		// {"id":"2","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
