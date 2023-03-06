/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoMarcas;
/**
 *
 * @author visitante
 */
public class clsLineas {
    private String CodigoMarca;
    private String NombreMarca;
    private String EstatusMarca;

    public clsLineas() {
    }
    
    
    public clsLineas(String CodigoMarca, String NombreMarca, String EstatusMarca) {
        this.CodigoMarca = CodigoMarca;
        this.NombreMarca = NombreMarca;
        this.EstatusMarca= EstatusMarca;
    }
    
 

    public String getCodigoMarca() {
        return CodigoMarca;
    }

    public void setCodigoMarca(String CodigoMarca) {
        this.CodigoMarca = CodigoMarca;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }

    public String getEstatusMarca() {
        return EstatusMarca;
    }

    public void setEstatusMarca(String EstatusMarca) {
        this.EstatusMarca = EstatusMarca;
    }
    @Override
    public String toString() {
        return "clsLineas{" + "CodigoMarca=" + CodigoMarca + ", NombreMarca=" + NombreMarca + ", EstatusMarca=" + EstatusMarca + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMarcas getBuscarInformacionMarcaPorNombre(clsMarcas seccion)
    {
        daoMarcas daosecciones = new daoMarcas();
        return daosecciones.consultaMarcasPorNombre(seccion);
    }
    public clsMarcas getBuscarInformacionMarcaPorId(clsMarcas seccion)
    {
        daoMarcas daosecciones = new daoMarcas();
        return daosecciones.consultaMarcasPorId(seccion);
    }    
    public List<clsMarcas> getListadoMarcas()
    {
        daoMarcas daosecciones = new daoMarcas();
        List<clsMarcas> listadoMarcas = daosecciones.consultaMarcas();
        return listadoMarcas;
    }
    public int setBorrarMarca(clsMarcas seccion)
    {
        daoMarcas daosecciones = new daoMarcas();
        return daosecciones.borrarMarcas(seccion);
    }          
    public int setIngresarMarca(clsMarcas seccion)
    {
        daoMarcas daosecciones = new daoMarcas();
        return daosecciones.ingresaMarcas(seccion);
    }              
    public int setModificarMarca(clsMarcas seccion)
    {
        daoMarcas daosecciones = new daoMarcas();
        return daosecciones.actualizaMarcas(seccion);
    }              
}
