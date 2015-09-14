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
		static String array [][] = new String [4][4];
		static String arrayHidden [][] = new String [4][4];
		static String tempArray [] = new String [4];
		static ArrayList <String> arrayFile = new ArrayList<String>();
		public static void main(String[] args) throws IOException
			{
			
			chooseTheme();
			fillArrayList();
			fillArraySpaces();
			fillArray();
			makeGrid();
			while(gameCounter!=8)
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
					array[i][y] = "    ";
					arrayHidden[i][y] = "    ";
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
						array[i][y] = arrayFile.get(counter);
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
						array[i][y] = arrayFile.get(counter);
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
						array[i][y] = arrayFile.get(counter);
						counter++;
						}
					}
				}
			}
		public static void makeGrid()
			{
				
			System.out.println("      A         B         C         D");
			System.out.println("-----------------------------------------");	
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("1|  "+arrayHidden[0][0]+"  ||  "+arrayHidden[0][1]+"  ||  "+arrayHidden[0][2]+"  ||  "+arrayHidden[0][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("2|  "+arrayHidden[1][0]+"  ||  "+arrayHidden[1][1]+"  ||  "+arrayHidden[1][2]+"  ||  "+arrayHidden[1][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("3|  "+arrayHidden[2][0]+"  ||  "+arrayHidden[2][1]+"  ||  "+arrayHidden[2][2]+"  ||  "+arrayHidden[2][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("4|  "+arrayHidden[3][0]+"  ||  "+arrayHidden[3][1]+"  ||  "+arrayHidden[3][2]+"  ||  "+arrayHidden[3][3]+"  |");
			System.out.println(" |        ||        ||        ||        |");
			System.out.println("-----------------------------------------");
			
			}
		public static void playGame()
			{
			determineCoor();
			arrayHidden[row][col] = array [row][col];
			tempArray[0] = arrayHidden[row][col];
			makeGrid();
			determineCoorSecond();
			arrayHidden[rowS][colS] = array [rowS][colS];
			makeGrid();
			tempArray[1] = arrayHidden[rowS][colS];
			if(tempArray[0]==tempArray[1])
				{
				gameCounter++;
				}
			if(tempArray[0]!=tempArray[1])
				{
				arrayHidden[row][col] = "    ";
				arrayHidden[rowS][colS] = "    ";
				}
			}
		public static void determineCoor()
			{
			System.out.println("Enter in coordinates");
			Scanner pls = new Scanner(System.in);
			String input = pls.nextLine();
			row = Integer.parseInt(input.substring(1))-1;
			switch(input.substring(0,1))
				{
				case "A":
				case "a":
					{
					col = 0;	
					break;	
					}
				case "B":
				case "b":
					{
					col = 1;
					break;		
					}
				case "C":
				case "c":
					{
					col = 2;	
					break;
					}
				case "D":
				case "d":
					{
					col = 3;	
					break;	
					}
				}
			}
		public static void determineCoorSecond()
			{
			System.out.println("Enter in coordinates");
			Scanner pls = new Scanner(System.in);
			String input = pls.nextLine();
			rowS = Integer.parseInt(input.substring(1))-1;
			switch(input.substring(0,1))
				{
				case "A":
				case "a":
					{
					colS = 0;	
					break;	
					}
				case "B":
				case "b":
					{
					colS = 1;
					break;		
					}
				case "C":
				case "c":
					{
					colS = 2;	
					break;
					}
				case "D":
				case "d":
					{
					colS = 3;	
					break;	
					}
				}
			}
		
	
	
	}