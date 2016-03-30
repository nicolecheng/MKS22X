import java.util.*;

public class Driver{
    public static void main(String[]args){
        MyStack<String> m = new MyStack<String>();
	Stack<String>   n = new Stack<String>();

	/*

        for(int i = 0; i < 10; i++){
            n.push(""+i);
            m.push(""+i);
        }

        try{
            m.push(-1,"oops");
            System.out.println("\n\nPush -1 #####################################");
        }catch(IndexOutOfBoundsException e){
	    
        }
        try{
            m.push(12,"oops");
            System.out.println("\n\n push 12 #####################################");
        }catch(IndexOutOfBoundsException e){
	    
        }
        try{
            m.pop(12);
            System.out.println("\n\n pop 12 #####################################");
        }catch(IndexOutOfBoundsException e){
	    
        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){
	    
        }





        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.pop(0);
        n.pop(0);
        System.out.println(m.toString(true));

        m.pop(2);
        n.pop(2);
        System.out.println(m.toString(true));

        m.pop(m.size()-1);
        n.pop(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test pushing to end/start
        m.push(0,"START");
        n.push(0,"START");
        m.push(m.size(),"PENULTIMATE");
        n.push(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test push
        m.push("Z-END!");
        n.push("Z-END!");
        System.out.println(m.toString(true));
        System.out.println(n);

	*/

        //test pop random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);

            if(op == 0 || n.size()==0){//ensure never empty
                n.push(""+i);
                m.push(""+i);
            }else if(op == 1 ){
                int x = rand.nextInt(n.size());
                n.push(x,""+i);
                m.push(x,""+i);
            }else{
                int x = rand.nextInt(n.size());
                if(!n.pop(x).equals(m.pop(x))){
                    System.out.println("Non matching elements popped\n");
                    System.exit(1);
                }
            }
        }
       	
        System.out.println(m.toString(true));
        System.out.println(n);

        /*test speed of push in front and at end.
	  long start,end;
	  System.out.println("Push 100k to front");

	  start = System.currentTimeMillis();
	  for(int i = 0; i < 100000; i++)
	  n.push(0,""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "ArrayList "+(end-start)/1000.0 );

	  start = System.currentTimeMillis();
	  for(int i = 0; i < 100000; i++)
	  m.push(0,""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "LinkedList "+(end-start)/1000.0 );


	  System.out.println("Push 1m to end");

	  start = System.currentTimeMillis();
	  for(int i = 0; i < 1000000; i++)
	  n.push(""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "ArrayList "+(end-start)/1000.0 );

	  start = System.currentTimeMillis();
	  for(int i = 0; i < 1000000; i++)
	  m.push(""+i);
	  end = System.currentTimeMillis();
	  System.out.println( "LinkedList "+(end-start)/1000.0 );

        */
    }
}
