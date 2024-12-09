package Game;
import java.util.Scanner;
import java.util.Random;

public class BattleshipGame {
	
	/* 3. Improve the Battleship game you made in task7: Use 5 rows and 5 columns and hide 2 ships. 
	 * It is also necessary to display the cells where there is water after each move. The game ends when the 2 ships have been found. */

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	Random random = new Random();
    	
    	/// MATRIX
    	char matriu[][] = {{' ', 'A', 'B', 'C', 'D', 'E'},
    					  {'1', '*', '*', '*', '*', '*'},
    					  {'2', '*', '*', '*', '*', '*'},
    					  {'3', '*', '*', '*', '*', '*'},
    					  {'4', '*', '*', '*', '*', '*'},
    					  {'5', '*', '*', '*', '*', '*'}};
    	
    	// RANDOM VARIABLES TO PLACE SHIPS ON THE BOARD
    	int filaConsola1 = random.nextInt(1,6), filaConsola2 = random.nextInt(1,6);
    	int columnaConsola1 = random.nextInt(1,6), columnaConsola2 = random.nextInt(1,6);
    	
    	String cordenades;
    	int vaixellsTrobats = 0;
    	char  columnaJugador, filaJugador;
    	int columnaJugadorInt = 0, filaJugadorInt = 0, jugades = 0;
    	
    	boolean filaOk = false;
    	boolean columnaOk = false;
    	
    	// DISPLAY THE GAME BOARD
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
        		System.out.print("\n\tEnter the position where you think there's a ship (e.g., A2), Attempts " + jugades + ": ");
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
        				System.err.println("\n\tIncorrect letter!!!");
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
    				System.err.println("\n\tIncorrect number!!!");
    				filaOk = false;
    				break;
        		}
        		
        	} while(!columnaOk || !filaOk);
    		
    		
    		if(columnaConsola1 == columnaJugadorInt && filaConsola1 == filaJugadorInt || columnaConsola2 == columnaJugadorInt && filaConsola2 == filaJugadorInt) {
    			matriu[filaJugadorInt][columnaJugadorInt] = 'V';
    			
    			System.out.print("\n\t *********************");
    			System.out.println("\n\t | SHIP SUNK!      |");
    			System.out.print("\t *********************\n");
    			
    			vaixellsTrobats++;
    			jugades++;
    			
    		} else {
    			matriu[filaJugadorInt][columnaJugadorInt] = 'A';
    			
    			System.out.print("\n\t *********************");
    			System.out.println("\n\t |      WATER!     |");
    			System.out.print("\t *********************\n");
    			
    			jugades++;
    		}
    		
    		// DISPLAY THE GAME BOARD
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
    	
    	System.out.println("\n\tCongratulations, you WON!!");
    	System.out.println("\n\tNumber of attempts: " + jugades);
    	
    }
}
