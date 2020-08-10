/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;


import java.util.*;

public class Uno {
int white=0;
int yellow=1;
int green=2;
int blue=3;
int red=4;
int skip=10;
int reverse=11;
int draw2=12;
int wild=13;
int wild_4=14;
		
public static void main(String[] args) {
		
		System.out.println("Welcome to Uno Game");
		System.out.println();
		
		Scanner scn= new Scanner(System.in);
		
		Deck Deck1= new Deck();
		
		Player computer_Player1= new Player();
		
		
			user_Player user_Player2= new user_Player();
			
		Deck1.distribute_cards(computer_Player1, user_Player2);
		UnoCard TopCard= new UnoCard();
		TopCard=Deck1.assignTopCard();
		System.out.print("TOP ");
		TopCard.displayUnoCard();
		
		boolean move=false;
		boolean tcupdate=false;
		
		while(computer_Player1.playerCards.isEmpty()!=true && user_Player2.playerCards.isEmpty()!=true)
		{
			UnoCard tempCard= new UnoCard();
			
			if(move==true)
			{
				System.out.println("**TURN:COMPUTER**");
				
				
				System.out.println();
				UnoCard compPlayCard;
				compPlayCard=computer_Player1.play(TopCard);
				if(compPlayCard==null)
				{
					System.out.println("Top card does not change");
					UnoCard temp2=new UnoCard();
					temp2=Deck1.getRandomCard();
					computer_Player1.playerCards.add(temp2);
					if(move==false)  
						move=true;
					else
						move=false;
				}
				else
				{
					tempCard=compPlayCard;
					tcupdate=true;
				}
			}
			else
			{
				System.out.println("**TURN: USER**");
				System.out.println("Your cards are:- ");
				System.out.println();
				user_Player2.displayCards();
				int no;
				System.out.println();
				System.out.println("enter 1 to draw card and enter 2 to put card");
				no=scn.nextInt();
				if(no==1)
				{
					if(move==false)  //now its computer chance. basically next bande ki chance
						move=true;
					else
						move=false;
					user_Player2.playerCards.add(Deck1.getRandomCard());
					
				}
				else
				{
					System.out.println("enter the card you want to put");
				
				    tempCard=user_Player2.getCard(TopCard);
				    user_Player2.playerCards.remove(tempCard);
				    tcupdate=true;
				}
				
			}
			if(tcupdate==true)
			{
				tcupdate=false;
				//putting the previous top card back in the deck
				int number=TopCard.number_on_card;
				int col=TopCard.colour;
				int index= ((col-1)*25)+(2*number);
		
				if(Deck1.arr.get(index)==null)
					Deck1.arr.set(index,TopCard);
				else
					Deck1.arr.set(index+1,TopCard);
				
				TopCard=tempCard;
				System.out.print("TOP ");
				TopCard.displayUnoCard();
				{
					//IF WILD IS TOP CARD
					if(TopCard.colour==0&&TopCard.number_on_card==13)
						{
						//nothing happens. move does not changes
						}
					// IF WILD DRAW4 IS TOP CARD
					else if(TopCard.colour==0&&TopCard.number_on_card==14)
					{
						if(move==false)
						{
							//computer draws 4 cards 
						for(int counter=0;counter<=3;counter++)
							computer_Player1.playerCards.add(Deck1.getRandomCard());
						}
						else
						{
							for(int counter=0;counter<=3;counter++)
								user_Player2.playerCards.add(Deck1.getRandomCard());
							//player draws 4 cards
						}
						//move does not change
					}
					//IF TOP CARD IS ACTION CARD
					else if(TopCard.number_on_card>=10)
					{
						if(TopCard.number_on_card==12)
						{
							if(move==false)
							{
								for(int counter=0;counter<=1;counter++)
									computer_Player1.playerCards.add(Deck1.getRandomCard());
								//computer draws 2 cards 
							}
							else
							{
								for(int counter=0;counter<=1;counter++)
									user_Player2.playerCards.add(Deck1.getRandomCard());
							//player draws 2 cards
                                    }
				}
                            }
					
					else
					{	if(move==false)  
							move=true;
						else
							move=false;
					}
					
				}	
			}
			else
			{
				
			}
			
		}
		if(computer_Player1.playerCards.isEmpty()==true)
			{System.out.println("Computer wins!");}
		else
			{System.out.println("You Win!");}
		
		
		

	}

}