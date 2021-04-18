/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 *
 */
public class Pedido {
    private int idPedido;
    private int idCliente;
    private String paquete;
    private String extra;
    private String fecha;
    private int total;
    private int[] costoAcumulado;
    private int[] precioNeto;

    public Pedido(int idPedido, int idCliente, String paquete, String extra, String fecha,int total) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
        inicializar();
        
    }
    
    public Pedido(){
        inicializar();
    }
    
    public Pedido(int idCliente, String paquete, String extra, String fecha,int total){
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
        inicializar();
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
    
      public void inicializar() {
        costoAcumulado = new int[11];
        precioNeto = new int[11];
        precioNeto[0] = 210; //Precio Paquete 1
        precioNeto[1] = 240; //Precio Paquete 2
        precioNeto[2] = 190; //Precio Paquete 3
        precioNeto[3] = 150; //Precio Paquete 4
        precioNeto[4] = 120; //Precio Paquete 5
        precioNeto[5] = 60; //Precio Paquete 6
        precioNeto[6] = 5; //Precio Extra 1
        precioNeto[7] = 20; //Precio Extra 2
        precioNeto[8] = 5; //Precio Extra 3
        precioNeto[9] = 10; //Precio Extra 4
        precioNeto[10] = 15; //Precio Extra 5
        comenzarCosto();
    }
    
      public void comenzarCosto(){
        for (int i = 0; i < 11; i++) {
            costoAcumulado[i] = 0;
        }
      }
      
    
    public int calcular(int pos, int valor) {
        int totalPago = 0;
        costoAcumulado[pos] = valor * precioNeto[pos];

        for (int i = 0; i < 11; i++) {
            totalPago += costoAcumulado[i];
        }
        setTotal(totalPago);
        return totalPago;
    }
    
    
}
