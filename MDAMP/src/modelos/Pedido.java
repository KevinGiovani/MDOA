/*
 * Clase para almacenar y regresar información del pedido, será utilizada para
 * registrar esta información dentro de la base de datos, o también obtener esa
 * información de ahí.
 */
package modelos;

/**
 *@author Inzunza Kevin
 *@version 16-04-2021
 */
public class Pedido {
    private int idPedido; //Clave para el pedido
    private int idCliente; //Clave referencia del cliente obtenida del teléfono
    private String paquete; //Cadena de los paquetes y cantidad de estos
    private String extra; //Cadena de los extras y cantidad de estos
    private String fecha; //Fecha en que se realizó el pedido
    private int total; //Total del pedido
    private int[] costoAcumulado; //Total de cada paquete y extra
    private int[] precioNeto; //Precio de cada paquete y extra

    /**
     * Constuctor que permite almecenar la información importante para el pedido
     * @param idPedido
     * @param idCliente
     * @param paquete
     * @param extra
     * @param fecha
     * @param total
     */
    public Pedido(int idPedido, int idCliente, String paquete, String extra, String fecha,int total) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
        inicializar();

    }

    /**
     * Constructor vacío que incicializa los valores de precio neto
     */
    public Pedido(){
        inicializar();
    }

    /**
     * Constuctor que permite almecenar la información importante para el pedido sin su clave
     * @param idCliente
     * @param paquete
     * @param extra
     * @param fecha
     * @param total
     */
    public Pedido(int idCliente, String paquete, String extra, String fecha,int total){
        this.idCliente = idCliente;
        this.paquete = paquete;
        this.extra = extra;
        this.fecha = fecha;
        this.total=total;
        inicializar();
    }

    /**
     * Regresa la información actual del id del pedido
     * @return
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Ingresa un nuevo id del pedido
     * @param idPedido
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Regresa la información actual del id del cliente
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Ingresa un nuevo id del cliente
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Regresa la información actual del paquete
     * @return
     */
    public String getPaquete() {
        return paquete;
    }

    /**
     * Ingresa una nueva cadena del paquete
     * @param paquete
     */
    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    /**
     * Regresa la información actual del extra
     * @return
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Ingresa una nueva cadena del extra
     * @param extra
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * Regresa la información actual de la fecha
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Ingresa una nueva fecha
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa la información actual del total
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     * Ingresa un nuevo total
     * @param total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Inicia los precios neto de cada paquete y extra.
     */
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

      /**
       * Define en cero el costo acumulado
       */
      public void comenzarCosto(){
        for (int i = 0; i < 11; i++) {
            costoAcumulado[i] = 0;
        }
      }


      /**
       * Calcula el costo de cada paquete y extra dependiendo de cuantos se eligieron
       * @param pos
       * @param valor
       * @return
       */
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

