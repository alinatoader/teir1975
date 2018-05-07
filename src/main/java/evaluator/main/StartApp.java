package evaluator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import evaluator.exception.DuplicateIntrebareException;
import evaluator.exception.InputValidationFailedException;
import evaluator.model.Intrebare;
import evaluator.model.Statistica;

import evaluator.AppController;
import evaluator.exception.NotAbleToCreateStatisticsException;

//functionalitati
//i.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//ii.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//iii.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

	private static final String file = "intrebari.txt";
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		AppController appController = new AppController();
		
		boolean activ = true;
		String optiune = null;
		
		while(activ){
			
			System.out.println("");
			System.out.println("1.Adauga intrebare");
			System.out.println("2.Creeaza test");
			System.out.println("3.Statistica");
			System.out.println("4.Afiseaza intrebari");
			System.out.println("5.Exit");
			System.out.println("");

			System.out.println("Optiune: ");
			optiune = console.readLine();
			
			switch(optiune){
			case "1" :
				System.out.println("Enunt: ");
				String enunt = console.readLine();
				System.out.println("Varianta1: ");
				String varianta1 = console.readLine();
				System.out.println("Varianta2: ");
				String varianta2 = console.readLine();
				System.out.println("VariantaCorecta: ");
				String variantaCorecta = console.readLine();
				System.out.println("Domeniu: ");
				String domain = console.readLine();
				try {
					appController.addNewIntrebare(new Intrebare(enunt,varianta1,varianta2,variantaCorecta,domain));
				} catch (DuplicateIntrebareException e) {
					e.printStackTrace();
				} catch (InputValidationFailedException e) {
					e.printStackTrace();
				}
				break;
			case "2" :
				break;
			case "3" :
				appController.loadIntrebariFromFile(file);
				Statistica statistica;
				try {
					statistica = appController.getStatistica();
					System.out.println(statistica);
				} catch (NotAbleToCreateStatisticsException e) {
					// TODO 
				}
				
				break;
				case "4":
					List<Intrebare> intrebari = appController.getIntrebari();
					for (Intrebare i:intrebari ) {
						System.out.println(i);
					}
					break;
			case "5" :
				activ = false;
				break;
			default:
				break;
			}
		}
		
	}

}
