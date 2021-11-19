/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretariasalud;

/**
 * @author Camilo Andres Rodriguez Reyes
 * @author Karen Yulieth Plazas Ramirez
 * @author Jhonatan Murcia Posso
 * @author Sebastian Saldaña Silva
 * @author Sebastian Lopez Galeano
 */
public class listadatos {
    String ID,Identificación,Apellidos,Nombres,Genero,Direccion,Centro,Motivo,Medico,Fecha,Hora;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public listadatos(String ID) {
        this.ID = ID;
    }

    public listadatos(String Identificación, String Apellidos, String Nombres, String Genero, String Direccion, String Centro, String Motivo, String Medico, String Fecha, String Hora) {
        this.Identificación = Identificación;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.Genero = Genero;
        this.Direccion = Direccion;
        this.Centro = Centro;
        this.Motivo = Motivo;
        this.Medico = Medico;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    listadatos(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdentificación() {
        return Identificación;
    }

    public void setIdentificación(String Identificación) {
        this.Identificación = Identificación;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCentro() {
        return Centro;
    }

    public void setCentro(String Centro) {
        this.Centro = Centro;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    

  
}
