package parsers;

public class ParserStatus
{
    public String[] host;
    public String[] interfaces;

    public ParserStatus()
    {
    }

    public ParserStatus(String[] host, String[] interfaces)
    {
        this.host = host;
        this.interfaces = interfaces;
    }

    public String[] getHost()
    {
        return host;
    }

    public void setHost(String[] host)
    {
        this.host = host;
    }

    public String[] getInterfaces()
    {
        return interfaces;
    }

    public void setInterfaces(String[] interfaces)
    {
        this.interfaces = interfaces;
    }
    
}
