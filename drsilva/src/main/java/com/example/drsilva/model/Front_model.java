package com.example.drsilva.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Front_model") 
public class Front_model {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (length = 255)
	private String nome;
	
	@Column 
	private int idade;
	
	@Column
	private BigDecimal salario;
	
	@Column
	private LocalDate datanascimento;

	@Column // Adicione uma nova coluna para a data de criação
    private LocalDateTime dataCriacao; 
	
	@Column (length = 45)
	private String formacao;
	
	@Column (length = 45)
	private String genero;
	
	@Column(length = 50)
	private String listafruta;
	
	public Front_model() {
		
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getListafruta() {
		return listafruta;
	}

	public void setListafruta(String listafruta) {
		this.listafruta = listafruta;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@PrePersist
	protected void onCreate() {
		dataCriacao = LocalDateTime.now();
	}
}
