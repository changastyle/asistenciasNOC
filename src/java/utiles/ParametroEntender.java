package utiles;

public class ParametroEntender
{
    private String nombre;
    private String comienzo;
    private String fin;
    private String valor;

    public ParametroEntender()
    {
    }

    public ParametroEntender(String nombre, String comienzo, String fin, String valor)
    {
        this.nombre = nombre;
        this.comienzo = comienzo;
        this.fin = fin;
        this.valor = valor;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getComienzo()
    {
        return comienzo;
    }

    public void setComienzo(String comienzo)
    {
        this.comienzo = comienzo;
    }

    public String getFin()
    {
        return fin;
    }

    public void setFin(String fin)
    {
        this.fin = fin;
    }

    public String getValor()
    {
        return valor;
    }

    public void setValor(String valor)
    {
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        return "Parametro{" + "nombre=" + nombre + ", comienzo=" + comienzo + ", fin=" + fin + ", valor=" + valor + '}';
    }
    
    
}
