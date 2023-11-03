package br.lab365.labcar.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import java.util.Locale;
import org.hibernate.PropertyValueException;
import org.hibernate.exception.DataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import br.lab365.labcar.fixtures.CarroFixture;
import br.lab365.labcar.model.CarroModel;
import net.datafaker.Faker;

@ActiveProfiles("test")
@DataJpaTest
public class CarroRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarroRepository repository;

    private int quantidade;

    private Faker faker = new Faker(new Locale("pt-BR"));

    @BeforeEach
    void BeforeEach() {
        entityManager.clear();
        quantidade = faker.number().randomDigitNotZero();
        for (int i = 0; i < quantidade; i++)
            entityManager.persistAndFlush(CarroFixture.criarCarro());
    }

    @Test
    void itShouldSaveCar() {
        CarroModel carro = CarroFixture.criarCarro();
        carro = entityManager.persistAndFlush(carro);
        assertEquals(quantidade + 1, repository.findAll().size());
    }

    @Test
    void itShouldFindCarById() {
        CarroModel carro = CarroFixture.criarCarro();
        carro = entityManager.persistAndFlush(carro);
        assertEquals(repository.findById(carro.getId()).get(), carro);
    }

    @Test
    void itShouldFindAllCars() {
        List<CarroModel> carros = repository.findAll();
        assertEquals(carros.size(), quantidade);
    }

    @Nested
    class ColumnMarca {

        @Test
        void givenNullMarcaItShouldThrowNullException() {
            CarroModel carro = CarroFixture.criarCarro();
            carro.setMarca(null);
            assertThrows(PropertyValueException.class, () -> entityManager.persistAndFlush(carro));
        }

        @Test
        void givenOversizedMarcaItShouldThrowDataException() {
            CarroModel carro = CarroFixture.criarCarro();
            carro.setMarca(faker.text().text(101));
            assertThrows(DataException.class, () -> entityManager.persistAndFlush(carro));
        }
    }

    @Nested
    class ColumnModelo {

        @Test
        void givenNullModeloItShouldThrowNullException() {
            CarroModel carro = CarroFixture.criarCarro();
            carro.setModelo(null);
            assertThrows(PropertyValueException.class, () -> entityManager.persistAndFlush(carro));
        }

        @Test
        void givenOversizedModeloItShouldThrowDataException() {
            CarroModel carro = CarroFixture.criarCarro();
            carro.setModelo(faker.text().text(101));
            assertThrows(DataException.class, () -> entityManager.persistAndFlush(carro));
        }
    }

    @Nested
    class ColumnAno {

        @Test
        void givenNullAnoItShouldThrowNullException() {
            CarroModel carro = CarroFixture.criarCarro();
            carro.setAno(null);
            assertThrows(PropertyValueException.class, () -> entityManager.persistAndFlush(carro));
        }
    }
}
