import java.util.*;
import java.io.*;
public class MemoryGameMain
	{	
		static int row;
		static int col;
		static int randomRow;
		static int randomCol;
		static int choice;
		static int counter;
		static String array [][] = new String [4][4];
		static String arrayHidden [][] = new String [4][4];
		static ArrayList <String> arrayFile = new ArrayList<String>();
		public static void main(String[] args) throws IOException
			{
			
			chooseTheme();
			fillArrayList();
			fillArraySpaces();
			fillArray();
	
			
			
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
		public static void generateNumbers()
			{
			randomRow = (int)(Math.random()*4);
			randomCol = (int)(Math.random()*4);
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
				while(pls1.hasNext())
					{
					generateNumbers();
					if(array[randomRow][randomCol]=="    ")
						{
						array [randomRow][randomCol] = arrayFile.get(counter);
						arrayFile.remove(counter);
						counter++;
						}
					else
						{
						generateNumbers();
						fillArray();
						}
					}
				}
			if(choice==2)
				{
				Scanner pls2 = new Scanner(new File("bodies.txt"));
				while(pls2.hasNext())
					{
					generateNumbers();
					if(array[randomRow][randomCol]=="    ")
						{
						array [randomRow][randomCol] = arrayFile.get(counter);
						arrayFile.remove(counter);
						counter++;
						}
					else
						{
						generateNumbers();
						fillArray();
						}
					}
				}
			if(choice==3)
				{
				Scanner pls3 = new Scanner(new File("dedamimal.txt"));
				while(pls3.hasNext())
					{
					generateNumbers();
					if(array[randomRow][randomCol]=="    ")	
						{
						array [randomRow][randomCol] = arrayFile.get(counter);
						arrayFile.remove(counter);
						counter++;
						}
					else
						{
						generateNumbers();
						fillArray();
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
			//System.out.println("      A         B         C         D");
			//System.out.println("-----------------------------------------");	
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("1|        ||        ||        ||        |");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("-----------------------------------------");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("2|        ||        ||        ||        |");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("-----------------------------------------");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("3|        ||        ||        ||        |");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("-----------------------------------------");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("4|        ||        ||        ||        |");
			//System.out.println(" |        ||        ||        ||        |");
			//System.out.println("-----------------------------------------");
			}
		public static void determineCoor()
			{
			Scanner pls = new Scanner(System.in);
			String input = pls.nextLine();
			int row = Integer.parseInt(input.substring(1))-1;
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
	}