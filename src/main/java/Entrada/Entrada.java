/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entrada;

import java.util.Date;

/**
 *
 * @author DANNA LAGOS
 */
public class Entrada {
    //Atributos
    private int idEntrada;
    private String fecha;
    private String descripcion;
    
    //Metodos 
    
        public Entrada(){
            //
        }
    
        public Entrada(int idEntrada, String fecha, String descripcion){
        this.idEntrada= idEntrada;
        this.fecha = fecha;
        this.descripcion = descripcion;       
        }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    
    
}
