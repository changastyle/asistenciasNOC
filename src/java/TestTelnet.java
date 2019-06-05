import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.commons.net.telnet.TelnetNotificationHandler;
import org.apache.commons.net.telnet.SimpleOptionHandler;
import org.apache.commons.net.telnet.EchoOptionHandler;
import org.apache.commons.net.telnet.TerminalTypeOptionHandler;
import org.apache.commons.net.telnet.SuppressGAOptionHandler;
import org.apache.commons.net.telnet.InvalidTelnetOptionException;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.commons.net.io.Util;
import utiles.ManejoArchivos;
import utiles.TelnetUtil;

public class TestTelnet 
{
    private static TelnetClient telnetCliente = null;
    private static InputStream in;
    private static PrintStream out;
    private static String prompt = "#";

    public static void main(String[] args) throws IOException
    {
        //String ip = "172.20.32.101";
        String ip = "vdmcomm2";
        int remoteport = 5900;
        //int remoteport = 23;
        String usuario = "root";
        String pass = "tecacc";
        
        TelnetUtil.conectar(ip, remoteport);
        TelnetUtil.write("sh");
        String str = TelnetUtil.readUntil("[admin",false);
        str += TelnetUtil.readUntil("[admin",false);
        
        System.out.println("STR:" +str.length());
        
        String rutaArchivoAux = "C:\\transformer\\salida-comd.txt";
        ManejoArchivos.write(rutaArchivoAux, str);
        
        
        List<String> lineasLeidas = ManejoArchivos.read(rutaArchivoAux);
        
        lineasLeidas = lineasLeidas.subList(2, (lineasLeidas.size() - 1) );
        
        for(String strLoop : lineasLeidas)
        {
            System.out.println(strLoop);
        }
        

    }
}
