package com.example.demo.modelo;

public class Clima {
    private String estado;
    private double min;
    private double max;
    private String ciudad;

    public Clima() {
    }

    public Clima(String estado, double min, double max, String ciudad) {
        this.estado = estado;
        this.min = min;
        this.max = max;
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
