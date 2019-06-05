package utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.telnet.TelnetClient;

public class TelnetUtil
{
    private static TelnetClient telnetCliente = null;
    private static InputStream in;
    private static PrintStream out;
    private static String prompt = "#";
    
    public static void conectar(String ip, int remotePort)
    {
        TelnetClient telnet = new TelnetClient();

        try 
        {
            telnet.connect(ip, remotePort);
            
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());

            /*
            readUntil("login: ",true);
            write(usuario);
            readUntil("Password: ",true);
            write(pass);*/
 
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public static void su(String password) 
    {
        try 
        {
            write("su");
            readUntil("Password: ",true);
            write(password);
            prompt = "#";
            readUntil(prompt + " ",true);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
 
    public static String  readUntil()
    {
        return readUntil(prompt + " ",false);
    }
    public static String readUntil(String pattern ,boolean sout) 
    {
        try
        {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            boolean found = false;
            
            char ch = (char) in.read();
            
            while (true) 
            {
                if(sout)
                {
                    System.out.print(ch);
                }
                sb.append(ch);
                if (ch == lastChar) 
                {
                    if (sb.toString().endsWith(pattern))
                    {
                        return sb.toString();
                    }
                }
                
                ch = (char) in.read();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
 
    public static void write(String value) 
    {
        try 
        {
            out.println(value);
            out.flush();
            System.out.println(value);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
 
    public static String sendCommand(String command) 
    {
        try 
        {
            write(command);
            return readUntil(prompt + " ",true);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}
