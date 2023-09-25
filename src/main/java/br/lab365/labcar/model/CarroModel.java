package br.lab365.labcar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "carro")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String marca;

    @Column(length = 100, nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(precision = 19, scale = 2)
    private BigDecimal preco;

    @Column(columnDefinition = "text")
    private String foto;

}
