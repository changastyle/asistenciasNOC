package parsers;

public class ParserWatchDog
{
    public String nombre;
    public String sitio;
    public String ip;
    public String equipofisico;
    public String localidad;
    public String extra;

    public ParserWatchDog()
    {
    }

    
    public ParserWatchDog(String nombre, String sitio, String ip, String equipoFisico, String localidad, String extra)
    {
        this.nombre = nombre;
        this.sitio = sitio;
        this.ip = ip;
        this.equipofisico = equipoFisico;
        this.localidad = localidad;
        this.extra = extra;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getSitio()
    {
        return sitio;
    }

    public void setSitio(String sitio)
    {
        this.sitio = sitio;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getEquipofisico()
    {
        return equipofisico;
    }

    public void setEquipofisico(String equipofisico)
    {
        this.equipofisico = equipofisico;
    }


    public String getLocalidad()
    {
        return localidad;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    public String getExtra()
    {
        return extra;
    }

    public void setExtra(String extra)
    {
        this.extra = extra;
    }

    @Override
    public String toString()
    {
        return "ParserWatchDog{" + "nombre=" + nombre + ", sitio=" + sitio + ", ip=" + ip + ", equipoFisico=" + equipofisico + ", localidad=" + localidad + ", extra=" + extra + '}';
    }

    
    public String toJSON()
    {
        return "ParserWatchDog{" + "nombre=" + nombre + ", sitio=" + sitio + ", ip=" + ip + ", equipoFisico=" + equipofisico + ", localidad=" + localidad + ", extra=" + extra + '}';
    }
    
    
    
}
