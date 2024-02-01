package fr.dawid.cap_poec_java.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@WithMockUser
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRedirectGamesFormAnonymous() throws Exception {
        mockMvc.perform(get("/jeux").with(anonymous()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testGamesLogged() throws Exception {
        mockMvc.perform(get("/jeux").with(user("toto1")))
                .andExpect(status().isOk());
    }

    @Test
    public void testRedirectGameFormFormAnonymous() throws Exception {
        mockMvc.perform(get("/admin/jeux/nouveau").with(anonymous()))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    public void testRedirectGameFormFormUser() throws Exception {
        mockMvc.perform(get("/admin/jeux/nouveau").with(user("toto1")))
                .andExpect(status().isOk());
    }

    @Test
    public void testGameFormLogged() throws Exception {
        mockMvc.perform(get("/admin/jeux/nouveau").with(user("richmann").roles("MODERATOR")))
                .andExpect(status().isOk());
    }

}