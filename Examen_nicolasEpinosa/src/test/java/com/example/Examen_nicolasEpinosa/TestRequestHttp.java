package com.example.Examen_nicolasEpinosa;

import com.example.Examen_nicolasEpinosa.model.Product;
import com.example.Examen_nicolasEpinosa.model.dtoProduct.DtoProduct;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import net.bytebuddy.description.method.MethodDescription;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRequestHttp {
    @Value(value = "${local.server.port}")
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private java.lang.Object Object;

    @Test
    public void testAddProductSuccess() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+port+"/product";
        URI uri = new URI(baseUrl);
        DtoProduct dtoProduct = new DtoProduct( );
        dtoProduct.setName("pepe");
        dtoProduct.setPrice(200.2);

        HttpHeaders headers = new HttpHeaders();


        HttpEntity<DtoProduct> request = new HttpEntity<>(dtoProduct, headers);

        ResponseEntity<Product> result = this.testRestTemplate.postForEntity(uri, request, Product.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }
    @Test
    public void testGetAllProductSuccess() throws URISyntaxException, ParseException {
        final String baseUrl = "http://localhost:"+port+"/";
        URI uri = new URI(baseUrl);


        ResponseEntity<String> result = this.testRestTemplate.getForEntity(uri,String.class);
        JSONParser jsonParser = new JSONParser();
        Object json =jsonParser.parse(result.getBody());

        Gson gson = new Gson();
        Type productList=new TypeToken<List<Product>>(){}.getType();
        List<Product> products=gson.fromJson(json.toString(),productList);
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(products);
    }
    @Test
    public void testGetByIdProductSuccess() throws URISyntaxException, ParseException {
        final String baseUrl = "http://localhost:8080/product/1";
        URI uri = new URI(baseUrl);


        ResponseEntity<String> result = this.testRestTemplate.getForEntity(uri,String.class);
        JSONParser jsonParser = new JSONParser();
        Object json =jsonParser.parse(result.getBody());

        Gson gson = new Gson();
        Type product=new TypeToken<Product>(){}.getType();
        Product productFind=gson.fromJson(json.toString(),product);
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(productFind);
        Assertions.assertEquals(100.0,productFind.getPrice());
    } @Test
    public void testGetPrecioTotal() throws URISyntaxException, ParseException {
        final String baseUrl = "http://localhost:8080/precioTotal";
        URI uri = new URI(baseUrl);


        ResponseEntity<String> result = this.testRestTemplate.getForEntity(uri,String.class);
        JSONParser jsonParser = new JSONParser();
        Object json =jsonParser.parse(result.getBody());

        Gson gson = new Gson();
        Type price=new TypeToken<Double>(){}.getType();
        Double precioFinal=gson.fromJson(json.toString(),price);
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCode().value());
        Assertions.assertNotNull(precioFinal);
        Assertions.assertEquals(300.0,precioFinal.doubleValue());
    }


}
