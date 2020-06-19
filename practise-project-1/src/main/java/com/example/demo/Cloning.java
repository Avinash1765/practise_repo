package com.example.demo;


import java.util.*;
class Node30
{
    int data;
    Node30 next, arb;
    
    Node30(int d)
    {
        next = arb = null;
    }
}
class Cloning
{
   static Node30 head;
    
    public static void addToTheLast(Node30 node)
    {
        	if (head == null) 
		{
			head = node;
		} else 
		{
		   Node30 temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    
    
    public static boolean validation(Node30 head,Node30 res,Node30 cloned_add,Node30 generated_add)
    {
        
    if(generated_add==cloned_add)
        return false;
	Node30 temp1 = head;
	Node30 temp2 = res;
	int len1=0,len2=0;
	while(temp1!=null)
	{
		len1++;
		temp1=temp1.next;
	}
	while(temp2!=null)
	{
		len2++;
		temp2 = temp2.next;
	}
	/*if lengths not equal */
	if(len1!=len2)
	return false;
	temp1= head;
	temp2=res;
	while(temp1!=null)
	{
		if(temp1.data!=temp2.data)
		return false;
		if(temp1.arb!=null && temp2.arb!=null)
		{
			if(temp1.arb.data!=temp2.arb.data)
			return false;
		}else if(temp1.arb!=null && temp2.arb==null)
			return false;
		temp1= temp1.next;
		temp2=temp2.next;
	}
	return true;
    }
   // public static void printList()
   
   public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       
       while(t-- > 0)
       {
           Node30 generated_add = null;
           int n = sc.nextInt();
           int q = sc.nextInt();
           
           int a1 = sc.nextInt();
           Node30 head = new Node30(a1);
           addToTheLast(head);
           
           for(int i = 1; i < n; i++)
           {
               int a = sc.nextInt();
               addToTheLast(new Node30(a));
           }
           
             for(int i=0;i<q;i++)
    {
       int a = sc.nextInt();
       int b = sc.nextInt();
       
       Node30 tempA=head;
       int count=-1;
       while(tempA!=null)
       {
           count++;
           if(count==a-1)
            break;
           tempA=tempA.next;
       }
       Node30 tempB = head;
       count=-1;
       while(tempB!=null)
       {
           count++;
           if(count==b-1)
            break;
           tempB=tempB.next;
       }
       //when both a is greater than N
       if(a<=n)
       tempA.arb = tempB;
       }
       
       generated_add = head;
       GfG1 g = new GfG1();
       Node30 res = g.copyList(head);
       
       Node30 cloned_add = res;
       
       if(validation(head,res,cloned_add,generated_add) == true)
         System.out.println("1");
         else
         System.out.println("false");
       }
       
   }
}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/
/*
class Node30
    {
        int data;
        Node30 next;
        Node30(int d) {data = d; next = null; }
    }*/
//function to copy linked list
class GfG1
{
    Node30 copyList(Node30 head)
    {
    	HashMap<Node30, Node30> map=new HashMap<>();
    	
    	Node30 finalHead=null;
    	Node30 finalHeadTemp=null;
    	
    	Node30 temp=head;
    	
    	head=head.next;
    	
    	boolean heafFlag=false;
    	
    	while(head != null) {
    		finalHead= new Node30(head.data);
    		
    		if(!heafFlag) {
    			heafFlag= true;
    			finalHeadTemp= finalHead;
    		}
    		finalHead=finalHead.next;
    		map.put(head, finalHead);
    		head=head.next;
    	}
    	
    	while(temp!=null) {
    		finalHeadTemp.arb= map.get(temp.arb);
    		temp=temp.next;
    		finalHeadTemp= finalHeadTemp.next;
    	}
    	
    	return finalHead;
    }
}

