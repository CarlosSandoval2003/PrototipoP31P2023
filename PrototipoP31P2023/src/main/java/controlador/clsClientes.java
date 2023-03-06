/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoClientes;
/**
 *
 * @author visitante
 */
public class clsClientes {
    private String CodigoVendedores;
    private String NombreVendedores;
    private String DireccionVendedores;
    private String TelefonoVendedores;
    private String NitVendedores;
    private String EstatusVendedores;

       public clsClientes() {
    }
    
    public clsClientes(String CodigoVendedores) {
        this.CodigoVendedores = CodigoVendedores;
    }    
    
    public clsClientes(String NombreVendedores, String DireccionVendedores) {
        this.NombreVendedores = NombreVendedores;
        this.DireccionVendedores = DireccionVendedores;
    }
    
    public clsClientes(String CarnetVendedores, String NombreVendedores, String DireccionVendedores, String TelefonoVendedores, String NitVendedores, String EstatusVendedores) {
        this.CodigoVendedores = CarnetVendedores;
        this.NombreVendedores = NombreVendedores;
        this.DireccionVendedores = DireccionVendedores;
        this.TelefonoVendedores = TelefonoVendedores;
        this.NitVendedores = NitVendedores;
        this.EstatusVendedores = EstatusVendedores;
    }    

    public String getCodigoVendedores() {
        return CodigoVendedores;
    }
  
    public void setCodigoVendedores(String CodigoVendedores) {
        this.CodigoVendedores = CodigoVendedores;
    }

    public String getNombreVendedores() {
        return NombreVendedores;
    }

    public void setNombreVendedores(String NombreVendedores) {
        this.NombreVendedores = NombreVendedores;
    }

    public String getDireccionVendedores() {
        return DireccionVendedores;
    }

    public void setDireccionVendedores(String DireccionVendedores) {
        this.DireccionVendedores = DireccionVendedores;
    }
    public String getTelefonoVendedores() {
        return TelefonoVendedores;
    }

    public void setTelefonoVendedores(String TelefonoVendedores) {
        this.TelefonoVendedores= TelefonoVendedores;
    }
    public String getNitVendedores() {
        return NitVendedores;
    }

    public void setNitVendedores(String NitVendedores) {
        this.NitVendedores = NitVendedores;
    }
    public String getEstatusVendedores() {
        return EstatusVendedores;
    }

    public void setEstatusVendedores(String EstatusVendedores) {
        this.EstatusVendedores = EstatusVendedores;
    }

    @Override
   public String toString() {
        return "clsClientes" + "CodigoVendedores=" + CodigoVendedores + ", NombreVendedores=" + NombreVendedores + ", DireccionVendedores=" + DireccionVendedores + ", TelefonoVendedores=" + TelefonoVendedores + ", NitVendedores=" + NitVendedores+ ", EstatusVendedores=" + EstatusVendedores +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionVendedoresPorNombre(clsClientes vendedores)
    {
        daoClientes daovendedores = new daoClientes();
        return daovendedores.consultaVendedorPorNombre(vendedores);
    }
    public clsClientes getBuscarInformacionVendedoresPorCodigo(clsClientes vendedores)
    {
        daoClientes daovendedores = new daoClientes();
        return daovendedores.consultaVendedorPorCodigo(vendedores);
    }    
    public List<clsClientes> getListadoVendedores()
    {
        daoClientes daovendedores = new daoClientes();
        List<clsClientes> listadoClientes = daovendedores.consultaVendedor();
        return listadoClientes;
    }
    public int setBorrarVendedores(clsClientes vendedores)
    {
        daoClientes daovendedores = new daoClientes();
        return daovendedores.borrarVendedor(vendedores);
    }          
    public int setIngresarVendedores(clsClientes vendedores)
    {
        daoClientes daovendedores = new daoClientes();
        return daovendedores.ingresaVendedor(vendedores);
    }              
    public int setModificarVendedores(clsClientes vendedores)
    {
        daoClientes daovendedores = new daoClientes();
        return daovendedores.actualizaVendedor(vendedores);
    }              
}
