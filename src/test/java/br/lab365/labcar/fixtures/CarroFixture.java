package br.lab365.labcar.fixtures;

import java.math.BigDecimal;
import java.util.Locale;
import br.lab365.labcar.model.CarroModel;
import net.datafaker.Faker;

public class CarroFixture {

    private static Faker faker = new Faker(new Locale("pt-BR"));

    public static CarroModel criarCarro() {
        CarroModel carro = new CarroModel();
        carro.setMarca(faker.vehicle().manufacturer());
        carro.setModelo(faker.vehicle().model());
        carro.setAno(faker.date().birthday(0, 25).toLocalDateTime().getYear());
        carro.setPreco(new BigDecimal(faker.number().numberBetween(4, 38) * 1000));
        return carro;
    }

}
