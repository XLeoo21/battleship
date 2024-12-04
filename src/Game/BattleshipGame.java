package Game;
import java.util.Scanner;
import java.util.Random;

public class BattleshipGame {
	
	/* 3. Mejora el juego de los barcos que hiciste en la tarea7: Usa 5 filas y 5 columnas y esconde 2 barcos. 
	 * También es necesario que vayas mostrando las casillas donde hay agua después de cada jugada. El juego termina cuando se han encontrado los 2 barcos */

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	Random random = new Random();
    	
    	/// MATRIU
    	char matriu[][] = {{' ', 'A', 'B', 'C', 'D', 'E'},
    					  {'1', '*', '*', '*', '*', '*'},
    					  {'2', '*', '*', '*', '*', '*'},
    					  {'3', '*', '*', '*', '*', '*'},
    					  {'4', '*', '*', '*', '*', '*'},
    					  {'5', '*', '*', '*', '*', '*'}};
    	
    	// VARIABLES RANDOM PER POSAR ELS VAIXELLS AL TAULER
    	int filaConsola1 = random.nextInt(1,6), filaConsola2 = random.nextInt(1,6);
    	int columnaConsola1 = random.nextInt(1,6), columnaConsola2 = random.nextInt(1,6);
    	
    	String cordenades;
    	int vaixellsTrobats = 0;
    	char  columnaJugador, filaJugador;
    	int columnaJugadorInt = 0, filaJugadorInt = 0, jugades = 0;
    	
    	boolean filaOk = false;
    	boolean columnaOk = false;
    	
    	// MOSTRAR EL TAULER DE JOC
    	System.out.println("");
    	for(int fila = 0; fila < matriu.length; fila++) {
    		System.out.print("\t");
    		for(int columna = 0; columna < matriu[0].length; columna++) {
    			System.out.print(matriu[fila][columna] + " ");
    			
    			if(columna == matriu[0].length-1) {
    				System.out.println("");
    			}
    		}
    	}
    	
    	while(vaixellsTrobats != 2) {
    		do {
        		System.out.print("\n\tIntroduce la posición que crees que hay barco EJ.(A2), Intentos " + jugades + ": ");
        		cordenades = scan.next();
        		
        		columnaJugador = cordenades.charAt(0);
        		filaJugador = cordenades.charAt(1);
        				
        		switch(columnaJugador) {
        			case 'A':
        				columnaJugadorInt = 1;
        				columnaOk = true;
        				break;
        			case 'B':
        				columnaJugadorInt = 2;
        				columnaOk = true;
        				break;
        			case 'C':
        				columnaJugadorInt = 3;
        				columnaOk = true;
        				break;
        			case 'D':
        				columnaJugadorInt = 4;
        				columnaOk = true;
        				break;
        			case 'E':
        				columnaJugadorInt = 5;
        				columnaOk = true;
        				break;
        			default:
        				System.err.println("\n\tLetra incorrecta!!!");
        				columnaOk = false;
        				break;
        		}
        		
        		switch(filaJugador) {
    			case '1':
    				filaJugadorInt = 1;
    				filaOk = true;
    				break;
    			case '2':
    				filaJugadorInt = 2;
    				filaOk = true;
    				break;
    			case '3':
    				filaJugadorInt = 3;
    				filaOk = true;
    				break;
    			case '4':
    				filaJugadorInt = 4;
    				filaOk = true;
    				break;
    			case '5':
    				filaJugadorInt = 5;
    				filaOk = true;
    				break;
    			default:
    				System.err.println("\n\tNumero incorrecto!!!");
    				filaOk = false;
    				break;
        		}
        		
        	} while(!columnaOk || !filaOk);
    		
    		
    		if(columnaConsola1 == columnaJugadorInt && filaConsola1 == filaJugadorInt || columnaConsola2 == columnaJugadorInt && filaConsola2 == filaJugadorInt) {
    			matriu[filaJugadorInt][columnaJugadorInt] = 'V';
    			
    			System.out.print("\n\t *********************");
    			System.out.println("\n\t | BARCO HUNDIDO! |");
    			System.out.print("\t *********************\n");
    			
    			vaixellsTrobats++;
    			jugades++;
    			
    		} else {
    			matriu[filaJugadorInt][columnaJugadorInt] = 'A';
    			
    			System.out.print("\n\t *********************");
    			System.out.println("\n\t |       AGUA!      |");
    			System.out.print("\t *********************\n");
    			
    			jugades++;
    		}
    		
    		// MOSTRAR EL TAULER DE JOC
        	System.out.println("");
        	for(int fila = 0; fila < matriu.length; fila++) {
        		System.out.print("\t");
        		for(int columna = 0; columna < matriu[0].length; columna++) {
        			System.out.print(matriu[fila][columna] + " ");
        			
        			if(columna == matriu[0].length-1) {
        				System.out.println("");
        			}
        		}
        	}	
    	}
    	
    	System.out.println("\n\tEnhorabuena has GANADO!!");
    	System.out.println("\n\tNumero de intentos: " + jugades);
    	
    }
}