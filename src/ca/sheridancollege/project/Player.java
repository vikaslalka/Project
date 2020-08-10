/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Scanner;


public class Player
{ 
	int n ;
	ArrayList<UnoCard> playerCards = new ArrayList<>(n);
	
	UnoCard getCard(UnoCard TopCard)
	{
		//System.out.println("enter your card");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		UnoCard card = new UnoCard();
		card = this.playerCards.get(n);
		if(card.colour==TopCard.colour || card.number_on_card == TopCard.number_on_card || card.colour==0||TopCard.colour==0)
		{
			return card;
		}
		else
		{
			this.getCard(TopCard);
		}
		return card;
	}

    



 
	void displayCards()
	{
		System.out.println("you dont need to see this");
		for(int p=0;p<this.playerCards.size();p++)
		{
			System.out.print(p+" ");
			if (this.playerCards.get(p)==null)
			{ System.out.println("we are breaking the loop");
				break;}
			this.playerCards.get(p).displayUnoCard();
		}
	}
	
	UnoCard play(UnoCard TopCard)
	{
		
		int index1=-1;
		int index2=-1;
		int index3=-1;
		for(int i=0;i<this.playerCards.size();i++)
		{
			if(this.playerCards.get(i)==null)
			{
				System.out.println("we are breaking the lopp");
				break;
			}
			if(this.playerCards.get(i).colour==TopCard.colour)
				index1=i;
			if(this.playerCards.get(i).number_on_card==TopCard.number_on_card)
				index2=i;
			if(this.playerCards.get(i).colour==0)
				index3=i;
			
		}
		UnoCard temp=new UnoCard();
		if(index1!=-1)
		{
			
			temp.colour=this.playerCards.get(index1).colour;
			temp.number_on_card=this.playerCards.get(index1).number_on_card;
			this.playerCards.remove(index1);
			
		}
		else if(index2!=-1)
		{
			temp.colour=this.playerCards.get(index2).colour;
			temp.number_on_card=this.playerCards.get(index2).number_on_card;
			this.playerCards.remove(index2);
		}
		else if(index3!=-1)
		{
			temp.colour=this.playerCards.get(index3).colour;
			temp.number_on_card=this.playerCards.get(index3).number_on_card;
			this.playerCards.remove(index3);
		}
		else
		{
			//COMPUTER DRAWS CARD
			temp=null;
			
			
		}
		//System.out.println("temp is ");
		//temp.displayUnoCard();
		return temp;
	}

 
	
}

  class user_Player extends Player
{
    void displayCards()
	{
		for(int p=0;p<this.playerCards.size();p++)
		{
			System.out.print(p+" ");
			this.playerCards.get(p).displayUnoCard();
		}
	}

    @Override
	UnoCard getCard(UnoCard TopCard)
	{
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		UnoCard card = new UnoCard();
		card = this.playerCards.get(n);
		if(card.colour==TopCard.colour || card.number_on_card == TopCard.number_on_card || card.colour==0||TopCard.colour==0)
		{
			return card;
		}
		else
		{
			this.getCard(TopCard);
		}
		return card;
	}

}
