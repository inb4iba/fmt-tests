package br.lab365.labcar.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import java.util.Locale;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import br.lab365.labcar.fixtures.UsuarioFixture;
import br.lab365.labcar.model.UsuarioModel;
import net.datafaker.Faker;

@ActiveProfiles("test")
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository repository;

    private int quantidade;

    private Faker faker = new Faker(new Locale("pt-BR"));

    @BeforeEach
    void BeforeEach() {
        entityManager.clear();
        quantidade = faker.number().randomDigitNotZero();
        for (int i = 0; i < quantidade; i++)
            entityManager.persistAndFlush(UsuarioFixture.criarUsuario());
    }

    @Test
    void itShouldSaveUsuario() {
        UsuarioModel usuario = UsuarioFixture.criarUsuario();
        usuario = entityManager.persistAndFlush(usuario);
        assertEquals(quantidade + 1, repository.findAll().size());
    }

    @Test
    void itShouldFindUsuarioById() {
        UsuarioModel usuario = UsuarioFixture.criarUsuario();
        usuario = entityManager.persistAndFlush(usuario);
        assertEquals(repository.findById(usuario.getId()).get(), usuario);
    }

    @Test
    void itShouldFindAllUsuarios() {
        List<UsuarioModel> usuarios = repository.findAll();
        assertEquals(usuarios.size(), quantidade);
    }

    @Nested
    class ColumnNome {

        @Test
        void givenNullNomeItShouldThrowNullException() {
            UsuarioModel usuario = UsuarioFixture.criarUsuario();
            usuario.setNome(null);
            assertThrows(PropertyValueException.class,
                    () -> entityManager.persistAndFlush(usuario));
        }
    }

    @Nested
    class ColumnEmail {

        @Test
        void givenNullEmailItShouldThrowNullException() {
            UsuarioModel usuario = UsuarioFixture.criarUsuario();
            usuario.setEmail(null);
            assertThrows(PropertyValueException.class,
                    () -> entityManager.persistAndFlush(usuario));
        }
    }

    @Nested
    class ColumnSenha {

        @Test
        void givenNullSenhaItShouldThrowNullException() {
            UsuarioModel usuario = UsuarioFixture.criarUsuario();
            usuario.setSenha(null);
            assertThrows(PropertyValueException.class,
                    () -> entityManager.persistAndFlush(usuario));
        }
    }
}
