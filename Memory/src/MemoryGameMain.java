import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class MemoryGameMain
	{	
		static int row;
		static int col;
		static int rowS;
		static int colS;
		static int randomRow;
		static int randomCol;
		static int choice;
		static int counter;
		static int gameCounter;
		static String arrayHidden [][] = new String [4][4];
		static String arrayDisplay [][] = new String [4][4];
		static String tempArray [] = new String [4];
		static ArrayList <String> arrayFile = new ArrayList<String>();
		public static void main(String[] args) throws IOException
			{
			
			chooseTheme();
			fillArrayList();
			fillArraySpaces();
			fillArray();
			makeGrid();
			while(gameCounter<9)
				{
					
				playGame();
				try
					{
					TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e)
					{
					e.printStackTrace();
					}
				printSpaces();
				makeGrid();
				}
			
			
			}
		public static void printSpaces()
			{
			for(int i=0;i<75;i++)
			System.out.println("");	
			}
		public static void fillArrayList() throws IOException
			{
			if(choice==1)
				{
				Scanner pls1 = new Scanner(new File("animals.txt"));
				while(pls1.hasNext())
					{
					arrayFile.add(pls1.nextLine());
					}
				}
			if(choice==2)
				{
				Scanner pls2 = new Scanner(new File("bodies.txt"));
				while(pls2.hasNext())
					{
					arrayFile.add(pls2.nextLine());						
					}
				}
			if(choice==3)
				{
				Scanner pls3 = new Scanner(new File("dedamimal.txt"));
				while(pls3.hasNext())
					{
					arrayFile.add(pls3.nextLine());
					}
				}
			}
		public static void fillArraySpaces()
			{
			for(int i=0;i<4;i++)
				{
				for(int y=0;y<4;y++)
					{
					arrayHidden[i][y] = "    ";
					arrayDisplay[i][y] = "    ";
					}
				}
			}
		public static void chooseTheme()
			{
			System.out.println("1) Animals 2)Body parts 3)Animals for consumption");	
			Scanner pls = new Scanner(System.in);
			choice = pls.nextInt();	
			}
		public static void fillArray() throws IOException
			{
			if(choice==1)
				{
				Scanner pls1 = new Scanner(new File("animals.txt"));
				Collections.shuffle(arrayFile);
				for(int i=0;i<4;i++)
					{
					for(int y=0;y<4;y++)
						{
						arrayHidden[i][y] = arrayFile.get(counter);
						counter++;
						}
					}
				}
			if(choice==2)
				{
				Scanner pls2 = new Scanner(new File("bodies.txt"));
				Collections.shuffle(arrayFile);
				for(int i=0;i<4;i++)
					{
					for(int y=0;y<4;y++)
						{
						arrayHidden[i][y] = arrayFile.get(counter);
						counter++;
						}
					}
				}
			if(choice==3)
				{
				Scanner pls3 = new Scanner(new File("dedamimal.txt"));
				Collections.shuffle(arrayFile);
				for(int i=0;i<4;i++)
					{
					for(int y=0;y<4;y++)
						{
						arrayHidden[i][y] = arrayFile.get(counter);
						counter++;
						}
					}
				}
			}
		public static void makeGrid()
			{
				
			System.out.println("      1         2         3         4");
			System.out.println("-----------------------------------------");	
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("A|  "+arrayDisplay[0][0]+"  ||  "+arrayDisplay[0][1]+"  ||  "+arrayDisplay[0][2]+"  ||  "+arrayDisplay[0][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("B|  "+arrayDisplay[1][0]+"  ||  "+arrayDisplay[1][1]+"  ||  "+arrayDisplay[1][2]+"  ||  "+arrayDisplay[1][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("C|  "+arrayDisplay[2][0]+"  ||  "+arrayDisplay[2][1]+"  ||  "+arrayDisplay[2][2]+"  ||  "+arrayDisplay[2][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("D|  "+arrayDisplay[3][0]+"  ||  "+arrayDisplay[3][1]+"  ||  "+arrayDisplay[3][2]+"  ||  "+arrayDisplay[3][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			
			}
		public static void playGame()
			{
			determineCoor();
			arrayDisplay[row][col] = arrayHidden [row][col];
			tempArray[0] = arrayDisplay[row][col];
			makeGrid();
			determineCoorSecond();
			arrayDisplay[rowS][colS] = arrayHidden [rowS][colS];
			makeGrid();
			tempArray[1] = arrayDisplay[rowS][colS];
			if(tempArray[0].equals(tempArray[1]))
				{
				gameCounter++;
				}
			else
				{
				arrayDisplay[row][col] = "    ";
				arrayDisplay[rowS][colS] = "    ";
				}
			}
		public static void determineCoor()
			{
			System.out.println("Enter in coordinates");
			Scanner pls = new Scanner(System.in);
			String input = pls.nextLine();
			col = Integer.parseInt(input.substring(1))-1;
			switch(input.substring(0,1))
				{
				case "A":
				case "a":
					{
					row = 0;	
					break;	
					}
				case "B":
				case "b":
					{
					row = 1;
					break;		
					}
				case "C":
				case "c":
					{
					row = 2;	
					break;
					}
				case "D":
				case "d":
					{
					row = 3;	
					break;	
					}
				}
			}
		public static void determineCoorSecond()
			{
			System.out.println("Enter in coordinates");
			Scanner pls = new Scanner(System.in);
			String input = pls.nextLine();
			colS = Integer.parseInt(input.substring(1))-1;
			switch(input.substring(0,1))
				{
				case "A":
				case "a":
					{
					rowS = 0;	
					break;	
					}
				case "B":
				case "b":
					{
					rowS  = 1;
					break;		
					}
				case "C":
				case "c":
					{
					rowS = 2;	
					break;
					}
				case "D":
				case "d":
					{
					rowS = 3;	
					break;	
					}
				}
			}
		
	
	
	}