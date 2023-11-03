package br.lab365.labcar.fixtures;

import java.util.Locale;
import br.lab365.labcar.model.UsuarioModel;
import net.datafaker.Faker;

public class UsuarioFixture {

    private static Faker faker = new Faker(new Locale("pt-BR"));

    public static UsuarioModel criarUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(faker.name().fullName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setSenha(faker.internet().password());
        return usuario;
    }

}
