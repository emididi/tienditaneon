/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author gamae
 */
public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private float saldo;

    public Cliente() {
        
    }
    
    
    
    public Cliente(String nombre, String telefono, String correo, float saldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.saldo=saldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + ", saldo=" + saldo + '}';
    }


    
    
}
