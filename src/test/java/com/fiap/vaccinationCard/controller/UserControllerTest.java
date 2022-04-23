package com.fiap.vaccinationCard.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.vaccinationCard.dto.UserVaccinesDto;
import com.fiap.vaccinationCard.entities.User;
import com.fiap.vaccinationCard.entities.Vaccine;
import com.fiap.vaccinationCard.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

   static String getUserCardVaccines = "/api/v1/user/Vaccines/{id}";

    @Autowired
    MockMvc mvc;

    @MockBean
    private UserService service;

    private UserController controller;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.controller = new UserController(service);
    }


    @Test
    @DisplayName("Trazer a carteira de vacinação completa do usuário, sem endereço")
    void getUserCardVaccinesTest() throws Exception {
        User usuario = new User(null, "Beatriz", "44955855682", null, "Evelyn@Fiap.com.br");
        Vaccine v1 = new Vaccine(1l, "Covid", null, null);
        Vaccine v2 = new Vaccine(1l, "Covid 2 ", null,null);
        usuario.setVaccines(Arrays.asList(v1, v2));
        usuario.setId(1l);

        UserVaccinesDto usuarioDTO = new UserVaccinesDto("Beatriz", 12, "44955855682", "bprovi@Outlook.com", null, null, null, null, null, null, null, null);
        usuarioDTO.setVaccines(Arrays.asList(v1, v2));


        BDDMockito.given(service.getUserVaccines(usuario.getId()))
                .willReturn(usuario);

        String json = new ObjectMapper().writeValueAsString(usuarioDTO);


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(getUserCardVaccines.concat("/1"))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
