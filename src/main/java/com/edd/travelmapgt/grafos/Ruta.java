/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edd.travelmapgt.grafos;

/**
 *
 * @author mgome
 */
public class Ruta {
    private int tiempoConduciendo;
    private int tiempoCaminando;
    private int gastoCombustible;
    private int gastoFisico;
    private int distancia;

    public Ruta(int tiempoConduciendo, int tiempoCaminando, int gastoCombustible, int gastoFisico, int distancia) {
        this.tiempoConduciendo = tiempoConduciendo;
        this.tiempoCaminando = tiempoCaminando;
        this.gastoCombustible = gastoCombustible;
        this.gastoFisico = gastoFisico;
        this.distancia = distancia;
    }

    /**
     * @return the tiempoConduciendo
     */
    public int getTiempoConduciendo() {
        return tiempoConduciendo;
    }

    /**
     * @return the tiempoCaminando
     */
    public int getTiempoCaminando() {
        return tiempoCaminando;
    }

    /**
     * @return the gastoCombustible
     */
    public int getGastoCombustible() {
        return gastoCombustible;
    }

    /**
     * @return the gastoFisico
     */
    public int getGastoFisico() {
        return gastoFisico;
    }

    /**
     * @return the distancia
     */
    public int getDistancia() {
        return distancia;
    }

    /**
     * @param tiempoConduciendo the tiempoConduciendo to set
     */
    public void setTiempoConduciendo(int tiempoConduciendo) {
        this.tiempoConduciendo = tiempoConduciendo;
    }

    /**
     * @param tiempoCaminando the tiempoCaminando to set
     */
    public void setTiempoCaminando(int tiempoCaminando) {
        this.tiempoCaminando = tiempoCaminando;
    }

    /**
     * @param gastoCombustible the gastoCombustible to set
     */
    public void setGastoCombustible(int gastoCombustible) {
        this.gastoCombustible = gastoCombustible;
    }

    /**
     * @param gastoFisico the gastoFisico to set
     */
    public void setGastoFisico(int gastoFisico) {
        this.gastoFisico = gastoFisico;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
    
}
