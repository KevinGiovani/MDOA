/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author magdielo-pacheco
 */
public class Pedido {
    private int idPedido;
    private int idCliente;
    private String paquete;
    private String extra;
    private String fecha;
    private int total;

    public Pedido(int idPedido, int idCliente, String paquete, String extra, String fecha,int total) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
    }
    
    public Pedido(int idCliente, String paquete, String extra, String fecha,int total){
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
