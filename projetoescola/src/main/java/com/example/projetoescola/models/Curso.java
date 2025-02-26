package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String nome;
    @Column(nullable = false)
    private Integer cargaHorario;

    public Curso(Long id, String nome, Integer cargaHorario) {
        this.id = id;
        this.nome = nome;
        this.cargaHorario = cargaHorario;
    }
    public Curso() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCargaHorario() {
        return cargaHorario;
    }
    public void setCargaHorario(Integer cargaHorario) {
        this.cargaHorario = cargaHorario;
    }
}
