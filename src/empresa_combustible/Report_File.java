/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa_combustible;

/**
 *
 * @author elias
 */
public class Report_File {
    
    private String idSucursal; //ID de la Sucursal
    private String idSurtidor; //ID del Surtidor
    private String combustible; //Nombre de Combustible Vendido
    private Double precioLitro; //Valor del precio por litro al momento de cargar
    private Double litrosSolicitados; //Litros solicitados por el cliente
    private Double litrosVendidos; //Litros realmente cargados (puede que no alcance el surtidor)
    private Double precioVenta; //El valor pagodo (basado en litrosVendidos)
    
    private String estadoCarga; //Sirve para decir si el estado es Completado o con Error y cual fue el error

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setIdSurtidor(String idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setPrecioLitro(Double precioLitro) {
        this.precioLitro = precioLitro;
    }

    public void setLitrosSolicitados(Double litrosSolicitados) {
        this.litrosSolicitados = litrosSolicitados;
    }

    public void setLitrosVendidos(Double litrosVendidos) {
        this.litrosVendidos = litrosVendidos;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setEstadoCarga(String estadoCarga) {
        this.estadoCarga = estadoCarga;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public String getIdSurtidor() {
        return idSurtidor;
    }

    public String getCombustible() {
        return combustible;
    }

    public Double getPrecioLitro() {
        return precioLitro;
    }

    public Double getLitrosSolicitados() {
        return litrosSolicitados;
    }

    public Double getLitrosVendidos() {
        return litrosVendidos;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public String getEstadoCarga() {
        return estadoCarga;
    }
    
    
}
