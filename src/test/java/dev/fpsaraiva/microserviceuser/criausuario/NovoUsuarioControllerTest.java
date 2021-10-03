package dev.fpsaraiva.microserviceuser.criausuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(NovoUsuarioController.class)
public class NovoUsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void deveCriarNovoUsuarioComSucesso() throws Exception {
        NovoUsuarioRequest usuario_1 = new NovoUsuarioRequest("Fernando", "00011122233", "Rua das Flores",
                "fernando@fpsaraiva.dev", "33334444");
        NovoUsuario novoUsuario = usuario_1.paraUsuario();

        Mockito.when(usuarioRepository.save(novoUsuario)).thenReturn(novoUsuario);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(usuario_1));

        MvcResult resultado = mockMvc.perform(mockRequest).andReturn();

        MockHttpServletResponse resposta = resultado.getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), resposta.getStatus());
    }

    @Test
    public void deveNaoCriarUsuarioComNomeEmBranco() throws Exception {
        NovoUsuarioRequest usuario_1 = new NovoUsuarioRequest("", "00011122233", "Rua das Flores",
                "fernando@fpsaraiva.dev", "33334444");
        NovoUsuario novoUsuario = usuario_1.paraUsuario();

        Mockito.when(usuarioRepository.save(novoUsuario)).thenReturn(novoUsuario);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(usuario_1));

        MvcResult resultado = mockMvc.perform(mockRequest).andReturn();

        MockHttpServletResponse resposta = resultado.getResponse();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), resposta.getStatus());
    }

}
