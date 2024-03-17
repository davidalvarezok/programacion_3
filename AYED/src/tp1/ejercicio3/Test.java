package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante [] e = new Estudiante [2]; 
		Profesor [] p = new Profesor [3]; 
        e[0] = new Estudiante("Javier","Milei",2,"javi@gmail.com","Olivos");
        e[1] = new Estudiante("Cristina","Kirchner",1,"cfk@gmail.com","Rio Gallegos");
        p[0] = new Profesor("Gonzalo","Gimenez","s@gmial.com","Ingenieria",2);
        p[1] = new Profesor("Juan","Rodriguez","rodri@gmial.com","Ingenieria",1);
        p[2] = new Profesor("Sebastian","Pinedo","seba@gmial.com","Informatica",4);
        impEst(e); 
        impPro(p); 
	}
	public static void impEst(Estudiante [] e) {
		int i = 0; 
        while (i < 2) {
			System.out.println(e[i].tusDatos()); 
			i++;
		}
	}
    public static void impPro(Profesor [] p) {
    	int i = 0; 
		while (i < 3) {
			System.out.println(p[i].tusDatos()); 
			i++;
		}
    }
}
