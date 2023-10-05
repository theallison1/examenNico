package com.example.Examen_nicolasEpinosa;

import com.example.Examen_nicolasEpinosa.controller.ControllerProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestController {
  @Autowired
    private ControllerProduct controllerProduct;
  @Test
    public void contexLoad()throws Exception{
    assertThat(controllerProduct).isNotNull();
  }

}
