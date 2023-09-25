package br.lab365.labcar.service;

import br.lab365.labcar.model.UsuarioModel;

public interface UsuarioService {

    UsuarioModel salvar(UsuarioModel usuario) throws Exception;

    Boolean existe(String email);

}
