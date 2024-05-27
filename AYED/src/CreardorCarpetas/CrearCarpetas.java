package CreardorCarpetas;
import java.io.File;

public class CrearCarpetas {
    public static void main(String[] args) {
        // Ruta base donde se crearán las carpetas
        String rutaBase = "C:\\Users\\David\\Documents\\Ingeniería en Computación";
        
        // Nombre de las carpetas a crear
        String[] nombresCarpetas = {"Introduccion al Procesamiento de Señales", "Sistemas Operativos", "Taller de Lenguajes 2"};

        for (String nombreCarpeta : nombresCarpetas) {
            // Crear un objeto File para cada carpeta
            File carpeta = new File(rutaBase + File.separator + nombreCarpeta);
            
            // Intentar crear la carpeta
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta creada: " + carpeta.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear la carpeta: " + carpeta.getAbsolutePath());
            }
        }
    }
}

