import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersistenciaGremio {
    private static final String CARPETA = "datos_gremio";

    public PersistenciaGremio() {
        crearCarpetaSiNoExiste();
    }

    private void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("[IO] Carpeta '" + CARPETA + "' creada.");
        }
    }

    public void guardarRoster(ArrayList<Personaje> roster) throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        for (Personaje p : roster) {
            writer.write(p.getNombre() + "," + p.getNivel() + "," + p.getPuntosVida());
            writer.newLine(); 
        }
        writer.close();
        System.out.println("[IO] Roster guardado: " + roster.size() + " personajes.");
    }

    public ArrayList<String> cargarRoster() throws IOException {
        File archivo = new File(CARPETA + "/roster.txt");
        ArrayList<String> lineas = new ArrayList<>();
        if (!archivo.exists()) {
            System.out.println("[IO] roster.txt no encontrado.");
            return lineas;
        }
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = reader.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                lineas.add(linea);
            }
        }
        reader.close();
        System.out.println("[IO] Roster cargado: " + lineas.size() + " registros.");
        return lineas;
    }

    public void agregarEntradaBitacora(String entrada) throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
        writer.write(entrada);
        writer.newLine();
        writer.close();
    }

    public void mostrarBitacora() throws IOException {
        File archivo = new File(CARPETA + "/bitacora.txt");
        if (!archivo.exists()) {
            System.out.println("[IO] La bitácora está vacía.");
            return;
        }
        System.out.println("\n=== Bitácora de Batallas ===");
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        int numero = 1;
        while ((linea = reader.readLine()) != null) {
            System.out.println(numero++ + ". " + linea);
        }
        reader.close();
    }

    public void guardarInventario(HashMap<String, Integer> inventario) throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        for (Map.Entry<String, Integer> e : inventario.entrySet()) {
            writer.write(e.getKey() + "," + e.getValue());
            writer.newLine();
        }
        writer.close();
        System.out.println("[IO] Inventario guardado: " + inventario.size() + " items.");
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        File archivo = new File(CARPETA + "/inventario.txt");
        HashMap<String, Integer> inventario = new HashMap<>();
        if (!archivo.exists()) {
            return inventario;
        }
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = reader.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                String[] partes = linea.split(",");
                String item = partes[0];
                int cantidad = Integer.parseInt(partes[1]);
                inventario.put(item, cantidad);
            }
        }
        reader.close();
        System.out.println("[IO] Inventario cargado: " + inventario.size() + " items.");
        return inventario;
    }
}