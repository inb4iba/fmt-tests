package br.lab365.labcar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.lab365.labcar.fixtures.CarroFixture;
import br.lab365.labcar.model.CarroModel;
import br.lab365.labcar.repository.CarroRepository;
import br.lab365.labcar.service.CarroServiceImpl;
import net.datafaker.Faker;

@ExtendWith(MockitoExtension.class)
public class CarroServiceImplTest {

    @InjectMocks
    CarroServiceImpl service;

    @Mock
    CarroRepository repository;

    Faker faker = new Faker(new Locale("pt-BR"));

    @Test
    void shouldReturnListOfCarros() {
        List<CarroModel> data = new ArrayList<>();
        int quantidade = faker.number().randomDigitNotZero();
        for (int i = 0; i < quantidade; i++)
            data.add(CarroFixture.criarCarro());
        when(repository.findAll()).thenReturn(data);
        assertEquals(quantidade, service.buscarTodos().size());
    }

    @Test
    void shouldReturnCarroById() {
        Long id = faker.number().randomNumber();
        when(repository.findById(id)).thenReturn(Optional.of(CarroFixture.criarCarro()));
        assertNotNull(service.buscarPorId(id));
    }

    @Test
    void shouldSaveCarro() throws Exception {
        when(repository.save(any())).thenReturn(CarroFixture.criarCarro());
        CarroModel carro = service.salvar(CarroFixture.criarCarro());
        assertNotNull(carro);
    }

    @Nested
    class Exceptions {
        @Test
        void shouldThrowNoSuchElementExceptionIfInvalidId() {
            assertThrowsExactly(NoSuchElementException.class, () -> service.apagar(null));
        }
    }
}
