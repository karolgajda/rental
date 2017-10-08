package pl.rental.administration.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.rental.administration.domain.ChangeUserPasswordDto;
import pl.rental.administration.domain.CreateUserDto;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdministrationAppStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(AdministrationAppStart.class)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkHealthTest() {

        ResponseEntity<String> entity = restTemplate.getForEntity("/health", String.class);

        assertThat(entity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }

    @Test
    public void createUserTest() {
        String url = "/v1/user/";
        CreateUserDto dto = new CreateUserDto("test@test.pl", "password", "password");

        ResponseEntity<String> entity = this.restTemplate.postForEntity(url, dto, String.class);

        assertThat(entity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }

    @Test
    @Sql(value = "/scripts/UserControllerTest/changeUserPasswordTest.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void changeUserPasswordTest() {
        String uuid = "30a254c5-712d-4418-bb50-034be0538b68";
        String url = String.format("/v1/user/%s/password", uuid);
        ChangeUserPasswordDto dto = new ChangeUserPasswordDto("password", "NewPassword", "NewPassword");
        HttpEntity<ChangeUserPasswordDto> requestEntity = new HttpEntity(dto);

        ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        assertThat(entity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
    }
}
