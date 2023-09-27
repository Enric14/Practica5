package es.travelworld.practica5;

public class LoginResponse {
    private String nombre;
    private int edad;
    private int genero;
    private String usertToken;
    private int idBdReference;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getUsertToken() {
        return usertToken;
    }

    public void setUsertToken(String usertToken) {
        this.usertToken = usertToken;
    }

    public int getIdBdReference() {
        return idBdReference;
    }

    public void setIdBdReference(int idBdReference) {
        this.idBdReference = idBdReference;
    }
}
