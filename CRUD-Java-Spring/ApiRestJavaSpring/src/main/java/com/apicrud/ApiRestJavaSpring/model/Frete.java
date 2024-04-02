package com.apicrud.ApiRestJavaSpring.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name =  "fretes")

public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String origem;
    private String destino;
    private BigDecimal distanciaKm;
    private BigDecimal valorFrete;
    private Date dataContrato;
    private String status;

    // Construtores
    public Frete() {
    }

    public Frete(String origem, String destino, BigDecimal distanciaKm, BigDecimal valorFrete, Date dataContrato, String status) {
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.valorFrete = valorFrete;
        this.dataContrato = dataContrato;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(BigDecimal distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString() para facilitar a exibição
    @Override
    public String toString() {
        return "Frete{" +
                "id=" + id +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", distanciaKm=" + distanciaKm +
                ", valorFrete=" + valorFrete +
                ", dataContrato=" + dataContrato +
                ", status='" + status + '\'' +
                '}';
    }
}

