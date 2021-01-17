package io.github.consolero.bootbootboot;

import io.github.consolero.bootbootboot.impl.ApiClient;
import io.github.consolero.bootbootboot.impl.ApiException;
import io.github.consolero.bootbootboot.server.impl.OpenAPI2SpringBoot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest(
        classes = OpenAPI2SpringBoot.class, // start the real petstore server
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Boot {

    @LocalServerPort
    private Long port;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testThatStoreDoesNotHaveRegularPet() {
        try {
            createPetClient().getPetById(41l);
            fail("Expected exception not thrown.");
        } catch (final ApiException e) {
            assertThat(e.getCode()).isEqualTo(404);
        }
    }

    @Test
    public void testThatStoreHasSpecialPet() throws ApiException {
        assertThat(createPetClient().getPetById(42l).getName())
                .isEqualTo("Emmi");
    }

    private PetApi createPetClient() {
        var client = new ApiClient();
        client.setBasePath("http://localhost:" + port + "/v2");

        return new PetApi(client);
    }

}
