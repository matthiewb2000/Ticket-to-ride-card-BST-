package binarySearchTree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryCardTree {

	Node root;
	static int loops=0;
	ArrayList <String> cards = new ArrayList<String>();

	public void addNode(String color,int num){
        Node newNode=new Node(color,num);
        if(root==null)
        {
            root=newNode;
            //System.out.println(root);
        }
        else
        {
        	Node targetNode = root;
        	Node parent;
        	while(true)
        	{
        		parent= targetNode;
        		if(newNode.color.compareTo(targetNode.color)<0)
        		{
        			targetNode = targetNode.leftChild;
                    if(targetNode==null)
                    {
                        parent.leftChild=newNode;
                        return;
                    }
        		}
        		if(newNode.color.compareTo(targetNode.color)>0)
        		{
        			targetNode = targetNode.rightChild;
                    if(targetNode==null)
                    {
                        parent.rightChild=newNode;
                        return;
                    }
        		}
        		if(newNode.color.compareTo(targetNode.color)==0)
        		{
        			num += 1;
        			return;
        		}
        	}
        	
        }
}
	public void display(Node n)
    {
        if(n!=null)
        {        
        display(n.leftChild);
        System.out.println(n.color);
        display(n.rightChild);
        }

    }
	public String cardType(Node n)
    {
        if(n!=null)//order of cards is in postorder instead of the default
        {        
        cardType(n.leftChild);
        cardType(n.rightChild);
        return n.color;
        }
        else
        {
        	return "";
        }	


    }
	public static int search(Node n, String val)
    {
		if(n!=null)
		{
        //boolean isThere = false;
		//System.out.println("");
		//System.out.print(n.num);
        if(n.color.compareTo(val)==0)
        {
            //System.out.println("loops: "+loops+" for value "+val);
            loops=0;
            return n.num;
        }
        if(n.color.compareTo(val)>0)
        {
            loops=loops+1;
            if (n.leftChild==null)
            {
                //System.out.println("loops: "+loops+" for value "+val);
                loops=0;
                return n.num;
            }
            return search(n.leftChild,val);
        }
        if(n.color.compareTo(val)>0)
        {
            
            loops=loops+1;
            if (n.rightChild==null)
            {
                System.out.println("loops: "+loops+" for value "+val);
                loops=0;
                return n.num;
            }
            return search(n.rightChild,val);
        }
        return n.num;
		}
		else
		{
			return 0;
		}
    }
	public void setNum(int newNum) {
		
		Node.setNum(newNum);
		
	}


	    
		
	}
	class Node {

		
		String color;
		
		static int num=0;
		Node leftChild;
		Node rightChild;
		Node(String color,int num)
		{
			this.color = color;
			this.num = num;
		}
		public String toString()
		{
			return "card: " + this.color;
		}

	 
	    public void setNum(int num) {
	        this.num = num;
	    }
	}

	
