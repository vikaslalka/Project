package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Random;


public class Deck{
int noo=5;
	
	 ArrayList<UnoCard> arr= new ArrayList<>();
	 
	 
	 
		Deck()
		{
//			
			for(int i=0;i<112;i++){
				arr.add(new UnoCard());
			}
			int x=0; 
			for(int i=0;i<=12;i++)
			{
				int p=2;
				while(p>0)
				{
					arr.get(x).colour=1;
					arr.get(x).number_on_card=i;
					p--;
					x++;
				}	
			}
			for(int i=0;i<=12;i++)
			{
				int p=2;
				while(p>0)
				{
					arr.get(x).colour=2;
					arr.get(x).number_on_card=i;
					p--;
					x++;
				}	
			}
			for(int i=0;i<=12;i++)
			{
				int p=2;
				while(p>0)
				{
					arr.get(x).colour=3;
					arr.get(x).number_on_card=i;
					p--;
					x++;
				}	
			}
			for(int i=0;i<=12;i++)
			{
				int p=2;
				while(p>0)
				{
					arr.get(x).colour=4;
					arr.get(x).number_on_card=i;
					p--;
					x++;
				}	
			}
			while(x<=107)
			{
				arr.get(x).colour=0;
				arr.get(x).number_on_card=13;
				x++;
			}
			while(x<=111)
			{
				arr.get(x).colour=0;
				arr.get(x).number_on_card=14;
				x++;
			}
		}
		




void distribute_cards(Player computer_Player1, user_Player user_Player2)
{
	

	
	
	for(int i=0;i<=13;i++)
	{
		Random r = new Random();
		int Low = 0;
		int High = 111;
		int result = r.nextInt(High-Low) + Low;
		
		if(arr.get(result)!=null)
		{
		
		
		if(i%2 == 0)
		{
			computer_Player1.playerCards.add(arr.get(result));
			arr.set(result,null);
		}
		else
		{
			user_Player2.playerCards.add(arr.get(result));
			arr.set(result,null);
		}
		}
		else {i--;}
			
	}
}

UnoCard assignTopCard()
{
	Random r = new Random();
		int Low = 0;
		int High = 111;
		int result = r.nextInt(High-Low) + Low;
		int l=((result%26)/2);
		while(arr.get(result)==null||(result>=104)||l>=10) 
		{
			
 		result = r.nextInt(High-Low) + Low;	
		}
		UnoCard temp=new UnoCard();
		temp=arr.get(result);
		arr.set(result,null);		
		return temp;
}

UnoCard getRandomCard()
{
Random r = new Random();
	int Low = 0;
	int High = 111;
	int result = r.nextInt(High-Low) + Low;
	
	while(arr.get(result)==null) 
	{
		
		result = r.nextInt(High-Low) + Low;	
	}
	UnoCard temp=new UnoCard();
	temp = arr.get(result);
	arr.set(result,null);
	return temp;
	
}

}