package mx.edu.utng.equiposfutbol;

public class EquiposModelo {
    private String codigo, equipo,liga;



    public EquiposModelo(){

    }

    public EquiposModelo(String codigo,String equipo, String liga) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.liga = liga;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }
}
