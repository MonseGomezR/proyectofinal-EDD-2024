package com.edd.travelmapgt.grafosN;

/**
 *
 * @author mgome
 */
public class Peso {
    
    private final float distancia;
    private final float gastoGasolina;
    private final float tiempoVehículo;
    private final float desgaste;
    private final float tiempoCaminando;

    public Peso(float distancia, float gastoGasolina, float tiempoVehículo, float desgaste, float tiempoCaminando) {
        this.distancia = distancia;
        this.gastoGasolina = gastoGasolina;
        this.tiempoVehículo = tiempoVehículo;
        this.desgaste = desgaste;
        this.tiempoCaminando = tiempoCaminando;
    }

    public float getDistancia() {
        return distancia;
    }

    public float getGastoGasolina() {
        return gastoGasolina;
    }

    public float getTiempoVehículo() {
        return tiempoVehículo;
    }

    public float getDesgaste() {
        return desgaste;
    }

    public float getTiempoCaminando() {
        return tiempoCaminando;
    }
    
    public float getGasolinaDistancia() {
        return gastoGasolina/distancia;
    }
    
    public float getDesgasteDistancia() {
        return desgaste/distancia;
    }
    
    
}
