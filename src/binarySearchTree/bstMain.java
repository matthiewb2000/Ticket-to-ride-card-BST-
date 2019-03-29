package binarySearchTree;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class bstMain {
	
	public static void main(String[] args) throws IOException {
		int handsize;
		//System.out.println("cat".compareTo("cat"));
		File file =new File ("C:\\Users\\khscs017\\eclipse-workspace\\binarySearchTree\\src\\res\\cards.txt");
		File colorfile =new File ("C:\\Users\\khscs017\\eclipse-workspace\\binarySearchTree\\src\\res\\colorlist");
		ArrayList<String> colors = new ArrayList<String>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine())
		{
			String col=sc.nextLine();
			//System.out.println(col);
			colors.add(col);
		}
		ArrayList<String> listOColors = new ArrayList<String>();
		Scanner scan = new Scanner(colorfile);
		while(scan.hasNextLine())
		{
			String colList=scan.nextLine();
			listOColors.add(colList);
		}
			
		/*FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuffer stringBuffer = new StringBuffer();
		String line;
		while((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
		}
		fileReader.close();
		//System.out.println(stringBuffer.toString());
		String color = new String(stringBuffer.toString());*/
		//System.out.println(colors);
		

		BinaryCardTree bct = new BinaryCardTree();

		ArrayList<String> hand = new ArrayList<String>();
		handsize = Integer.parseInt(colors.get(0));
		for(int i=1;i<handsize+1;i++)
		{
		hand.add(colors.get(i));
		System.out.println(colors.get(i));
		}
		for(int i=0;i<listOColors.size();i++)
		{
			int numOColor=0;
			for(int j=0;j<hand.size();j++)
			{
				if(listOColors.get(i).compareTo(hand.get(j))==0)
				{
					numOColor=numOColor+1;
				}
				if(hand.get(j).compareTo("wild")==0)
				{
					numOColor=numOColor+1;
				}
			}
			bct.addNode(listOColors.get(i), numOColor);
			System.out.println(listOColors.get(i)+" "+numOColor);
		}
		
		/*for(int i=0;i<hand.size();i++)
		{
			bct.addNode(hand.get(i), i);
			System.out.println(hand.get(i));
		}*/
		int orders = Integer.parseInt(colors.get(11));
		ArrayList<String> cardType = new ArrayList<String>();
		ArrayList<String> numRemove = new ArrayList<String>();
		for(int i=12;i<orders+12;i++)
		{
			String[] order = colors.get(i).split(" ");
			numRemove.add(order[0]);
			cardType.add(order[1]);
		}
		
		for(int i=12;i<orders+12;i++)
		{
			System.out.println(BinaryCardTree.search( bct.root,colors.get(i)));//You were here on the end of class friday
		}
		
		System.out.println(BinaryCardTree.search( bct.root,"blue"));//This line proves the colors match their given numbers in the search tree. The code is ready for execution
		
		
		
		bct.display(bct.root);
		System.out.println();
		//colorList();
	}
	/*
	public static void colorList()
	{
	BinaryCardTree bct= new BinaryCardTree();
	
		ArrayList<String> blue = new ArrayList<String>();
		ArrayList<String> pink = new ArrayList<String>();
		ArrayList<String> wild = new ArrayList<String>();
		ArrayList<String> green = new ArrayList<String>();
		ArrayList<String> black = new ArrayList<String>();
		ArrayList<String> orange = new ArrayList<String>();
		ArrayList<String> white = new ArrayList<String>();
		ArrayList<String> red = new ArrayList<String>();
		ArrayList<String> yellow = new ArrayList<String>();

		bct.display(bct.root);
		for(int i=0;i<bct.cards.size();i++)
		{
			String node = bct.cards.get(i);
			System.out.print(bct.cards.size()+"a");
			if(node.compareTo("blue")==0)
				{blue.add(node);}
			if(node.compareTo("pink")==0)
				{pink.add(node);}
			if(node.compareTo("wild")==0)
				{wild.add(node);}
			if(node.compareTo("green")==0)
				{green.add(node);}
			if(node.compareTo("black")==0)
				{black.add(node);}
			if(node.compareTo("orange")==0)
				{orange.add(node);}
			if(node.compareTo("white")==0)
				{white.add(node);}
			if(node.compareTo("red")==0)
				{red.add(node);}
			if(node.compareTo("yellow")==0)
				{yellow.add(node);}
		}
		//System.out.print(wild.size()+"");
		System.out.println(bct.search(bct.root, "blue"));
		System.out.println(bct.search(bct.root, "pink"));
		System.out.println(bct.search(bct.root, "wild"));
		System.out.println(bct.search(bct.root, "green"));
		System.out.println(bct.search(bct.root, "black"));
		System.out.println(bct.search(bct.root, "orange"));
		System.out.println(bct.search(bct.root, "white"));
		System.out.println(bct.search(bct.root, "red"));
		System.out.println(bct.search(bct.root, "yellow"));
	}
*/



}
