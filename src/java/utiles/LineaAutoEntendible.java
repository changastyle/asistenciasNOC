package utiles;

public class LineaAutoEntendible
{
    private String linea;

    public LineaAutoEntendible(String linea)
    {
        this.linea = linea;
    }
    
    
    public ParametroEntender autoentenderme(ParametroEntender parametroAProcesar)
    {
        String comienzo = parametroAProcesar.getComienzo();
        String fin = parametroAProcesar.getFin();
        
        if(linea.contains(comienzo)&& linea.contains(fin))
        {
            //int posComienzo =  (linea.lastIndexOf(comienzo) + comienzo.length() ) ;
            int posComienzo =  (linea.indexOf(comienzo) + comienzo.length() ) ;
            int posFin =  (linea.indexOf(fin) - fin.length()  + 1 ) ;

            String medio = linea.substring(posComienzo, posFin );
            //System.out.println("poss: " + posComienzo + " | " + posFin);
            
            if(medio != null)
            {
                parametroAProcesar.setValor(medio);
            }
            //System.out.println("RTA:" + parametroAProcesar.getNombre()+ ": " + parametroAProcesar.getValor());

        }
        return parametroAProcesar;
    }
}
