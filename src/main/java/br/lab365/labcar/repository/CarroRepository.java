package br.lab365.labcar.repository;

import br.lab365.labcar.model.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {
}
