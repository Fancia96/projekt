package aplikacja.projekt.test;

import aplikacja.projekt.Model.Person;
import aplikacja.projekt.ProjektApplication;
import aplikacja.projekt.Repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PersonControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;

    private static final ObjectMapper om = new ObjectMapper();

    public void clean() {
        personRepository.deleteAll();

        for (int i = 1; i <= 10; i++) {
            Person person = new Person("Person" + i);
            personRepository.save(person);
        }
    }

    @Test
    public void shouldCreatePerson() throws Exception {
        clean();
        Person person = new Person("Bob");

        mvc.perform(post("/createPerson")
                .content(om.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nickname", is("Bob")));
    }

    @Test
    public void shouldNotCreatePerson() throws Exception {
        clean();
        Person person = new Person("milk");

        mvc.perform(post("/createPerson")
                .content(om.writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.BAD_REQUEST", is("Word you put in name is not allowed")));
    }

    @Test
    public void shouldFindPersonById() throws Exception {
        clean();
        mvc.perform(get("/findPersonByID/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nickname", is("Person1")));
    }


    @Test
    public void shouldNotFindPersonById() throws Exception {
        clean();
        mvc.perform(get("/findPersonByID/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.NOT_FOUND", is(ProjektApplication.personNotFound)));
    }


    @Test
    public void shouldFindPersonAll() throws Exception {
        clean();
        mvc.perform(get("/getEverything")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nickname", is("Person1")));
    }


    @Test
    public void shouldEditPerson() {
        clean();
    }

    @Test
    public void shouldNotEditPerson() {
        clean();
    }

    @Test
    public void shouldDeletePerson() {
        clean();
    }

    @Test
    public void shouldNotDeletePerson() {
        clean();
    }

}
