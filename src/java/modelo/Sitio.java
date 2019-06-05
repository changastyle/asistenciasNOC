package modelo;

public class Sitio
{
    private String nombre;
    private String ip;

    public Sitio()
    {
    }

    public Sitio(String nombre, String ip)
    {
        this.nombre = nombre;
        this.ip = ip;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    @Override
    public String toString()
    {
        return "Sitio{" + "nombre=" + nombre + ", ip=" + ip + '}';
    }
    
    
}
