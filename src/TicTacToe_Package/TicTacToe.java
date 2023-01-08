package TicTacToe_Package;

import java.util.Optional;
import java.util.Scanner;

public class TicTacToe {
  private String[][] board;
  private String currentPlayer;
  private Scanner scanner;
  
  public TicTacToe() {
    board = new String[3][3];
    currentPlayer = "X";
    scanner = new Scanner(System.in);
    
    // Initialisation du plateau
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = " ";
      }
    }
  }
  
  //Affichage du plateau
  public void viewBoard(String[][] board) {
	  System.out.println("   0  1  2");
      for (int i = 0; i < 3; i++) {
        System.out.print(i+" ");
        for (int j = 0; j < 3; j++) {
          System.out.print(" "+board[i][j] + " ");
        }
        System.out.println();
      }
  }
  
//Affichage du plateau pour confirmer l'action
  public void confirmedPlay(String[][] board,int row,int col , String currentPlayer) {
	  System.out.println("   0  1  2");
      for (int i = 0; i < 3; i++) {
        System.out.print(i+" ");
        for (int j = 0; j < 3; j++) {
        	if(i==row && j==col) {
        		System.out.print(">"+currentPlayer+"<");
        	}else {
        		System.out.print(" "+board[i][j]+" ");
        	}
        }
        System.out.println();
      }
  }
  
  public void play() {
    // Boucle de jeu
    while (true) {
      
    
    	//Affichage du plateau
      viewBoard(board);
      
      // Demande de la prochaine position au joueur courant
      System.out.print("Entrez la ligne (0, 1, 2) pour " + currentPlayer + " : ");
      int row = scanner.nextInt();
      System.out.print("Entrez la colonne (0, 1, 2) pour " + currentPlayer + " : ");
      int col = scanner.nextInt();
      
      
      // Mise à jour du plateau
      if (board[row][col] == " ") {
    	 confirmedPlay(board,row,col,currentPlayer);
    	 System.out.print("Vous confirmez votre placement (O/N) : ");
    	 char confirmed=scanner.next().charAt(0);
    	 if(confirmed=='O') {
    	     board[row][col] = currentPlayer;
    	 }else {
    		 continue;
    	 }

      } else {
        System.out.println("Cette case est déjà occupée, veuillez en choisir une autre.");
        continue;
      }
      
      // Vérification de la victoire
      if (checkWin(currentPlayer)) {
        System.out.println("Le joueur " + currentPlayer + " a gagné !");
        break;
      }
      
      // Vérification du match nul
      boolean isDraw = true;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] == " ") {
            isDraw = false;
            break;
          }
        }
      }
      if (isDraw) {
        System.out.println("Match nul !");
        break;
      }
      
      // Passage au joueur suivant
      if (currentPlayer == "X") {
        currentPlayer = "O";
      } else {
        currentPlayer = "X";
      }
    }
  }
  
  // Méthode pour vérifier si le joueur courant a gagné
  private boolean checkWin(String player) {
    // Vérifie les lignes
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
        return true;
      }
    }
    
    // Vérifie les colonnes
    for (int i = 0; i < 3; i++) {
      if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
        return true;
      }
    }
    
    // Vérifie les diagonales
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    
    return false;
  }

}
        		  
        		  
        		  
        		  
        		
