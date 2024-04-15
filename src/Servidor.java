import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    
    public static void main(String[] args) {
        try {
            // Establece el puerto del servidor
            int puerto = 9090;
            String servidor = "192.168.64.10";

            // Escribe en pantalla que el servidor esta ejecutandose
            System.out.println("Iniciando servidor en:");
            System.out.println("Hostname: " + servidor);
            System.out.println("Puerto: " + puerto);

            // Crea el registro de este objeto emoto
            Registry registro = LocateRegistry.createRegistry(puerto);

            // Establece la IP del servidor
            System.setProperty("java.rmi.server.hostname", servidor);

            // Le coloca un nombre al objeto remoto y establece el stub
            registro.rebind("Calculadora", new CalcRMI());

            // Escribe en pantalla que el servidor esta ejecutandose
            System.out.println("Servidor en ejecución en espera de clientes...");

        } catch (RemoteException ex) {
            System.err.println(ex);
        }
    }

}
