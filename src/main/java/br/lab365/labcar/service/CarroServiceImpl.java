package br.lab365.labcar.service;

import br.lab365.labcar.repository.CarroRepository;
import br.lab365.labcar.model.CarroModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public List<CarroModel> buscarTodos() {
        return carroRepository.findAll();
    }

    @Override
    public CarroModel buscarPorId(Long id) {
        return carroRepository.findById(id).get();
    }

    @Override
    public CarroModel salvar(CarroModel carro) throws Exception {
        return carroRepository.save(carro);
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        if (id == null) {
            id = 0L;
        }
        CarroModel carroEncontrado = buscarPorId(id);
        if (carroEncontrado == null) {
            throw new Exception("Carro não encontrado!");
        }
        try {
            carroRepository.delete(carroEncontrado);
        } catch (Exception e) {
            throw new Exception("Algo deu errado!");
        }
        return true;
    }

}
