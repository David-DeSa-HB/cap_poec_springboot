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
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRedirectFromHomeAnonymous() throws Exception {
        mockMvc.perform(get("/").with(anonymous()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testHomeLogged() throws Exception {
        mockMvc.perform(get("/").with(user("toto1")))
                .andExpect(status().isOk());
    }

    @Test
    public void testPageHomeNonModerator() throws Exception{
        mockMvc.perform(get("/?sort=moderator,asc").with(user("toto1")))
                .andExpect(content().string(containsString("page 1 sur 34")));
    }

    @Test
    public void testPageHomeModerator() throws Exception{
        mockMvc.perform(get("/?sort=moderator,asc").with(user("richmann").roles("MODERATOR")))
                .andExpect(content().string(containsString("page 1 sur 51")));
    }
}