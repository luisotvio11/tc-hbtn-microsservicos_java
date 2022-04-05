package com.example.jpah2demo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "Cliente")
@Entity
public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "nome", nullable = false)
        private String nome;

        private Long idade;

        private String email;


        @OneToMany(cascade = {CascadeType.ALL})
        private List<Telefone> telefoneList = new ArrayList<>();



        @OneToMany(cascade = {CascadeType.ALL})
        private List <Endereco> enderecoList = new ArrayList<>();

        public Cliente() {
        }


    public Cliente(Long id, String nome, Long idade, String email, List<Telefone> telefoneList, List<Endereco> enderecoList) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefoneList = telefoneList;
        this.enderecoList = enderecoList;
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

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefoneList=" + telefoneList +
                ", enderecoList=" + enderecoList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(idade, cliente.idade) && Objects.equals(email, cliente.email) && Objects.equals(telefoneList, cliente.telefoneList) && Objects.equals(enderecoList, cliente.enderecoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, email, telefoneList, enderecoList);
    }
}

