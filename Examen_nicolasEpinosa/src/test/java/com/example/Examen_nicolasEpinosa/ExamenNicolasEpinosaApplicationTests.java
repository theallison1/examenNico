package com.example.Examen_nicolasEpinosa;

import com.example.Examen_nicolasEpinosa.model.Product;
import com.example.Examen_nicolasEpinosa.model.dtoProduct.DtoProduct;
import com.example.Examen_nicolasEpinosa.service.ServiceProduct;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;



@SpringBootTest

class ExamenNicolasEpinosaApplicationTests {

	@Autowired
	private ServiceProduct serviceProduct;

	@Test
	void contextLoads() {
	}



	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		DtoProduct product = new DtoProduct();
		product.setName("pepe");
		Mockito.when(serviceProduct.findAll()).thenReturn((List<Product>) any());
		List<Product> testName = serviceProduct.findAll();
		Assert.assertEquals(any(), testName);
	}

}
