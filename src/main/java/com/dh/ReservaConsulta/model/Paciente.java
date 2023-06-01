package com.dh.ReservaConsulta.model;

public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private String dataAlta;

    public Paciente(int id, String nome, String sobrenome, String endereco, String rg, String dataAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", rg='" + rg + '\'' +
                ", dataAlta='" + dataAlta + '\'' +
                '}';
    }
}
