//package linkedLists;
// Name: Jasmin Cervantes
// Date: 11/29/2024
// For this assignment I added a shuffle method in LinkList.java and in CardGame.java I called the method to shuffle the method and then display it
// I used AI to help me create the shuffle method.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;



public class CardGame {
	
	private static LinkList cardList = new LinkList();  // make list

	public static void main(String[] args) {

		// File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        System.out.println("Cards loaded:");
        cardList.displayList();

        // Code Added: Calling the shuffle method created in Link List
        // Shuffle the deck before starting the game
        System.out.println("\nShuffling the deck...");
        cardList.shuffle();
        System.out.println("Deck shuffled!");
		
        // Since the cards were printed before shuffling the deck, I am calling the displayList method to display the newly shuffled deck
        // Display the shuffled deck
        System.out.println("\nShuffled deck:");
        cardList.displayList();

		Card[] playerHand = new Card[5];
		for(int i = 0; i < playerHand.length; i++)
			playerHand[i] = cardList.getFirst();
		
		System.out.println("players hand");
		for(int i = 0; i < playerHand.length; i++)
			System.out.println(playerHand[i]);
		
		System.out.println();
		System.out.println("the deck");
		cardList.displayList();

	}//end main

}//end class
