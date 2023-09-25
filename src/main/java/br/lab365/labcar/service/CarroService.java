package br.lab365.labcar.service;

import br.lab365.labcar.model.CarroModel;

import java.util.List;

public interface CarroService {

    List<CarroModel> buscarTodos();

    CarroModel buscarPorId(Long id);

    CarroModel salvar(CarroModel carro) throws Exception;

    boolean apagar(Long id) throws Exception;

}
