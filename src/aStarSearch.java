/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.Comparator;
/**
 *
 * @author user
 */
public class aStarSearch {
        static Comparator <queue> comp=new Compare();
        static ArrayList<queue> olistv=new ArrayList<queue>();
        static Queue<Integer> olist=new LinkedList<Integer>();
        static Queue<queue> clistv=new LinkedList<queue>();
        static Queue<Integer> clist=new LinkedList<Integer>();
        static int i;
        static int k;
        static int vertex;
        static queue q1;
        static String[] s2;
        static double[][]a2;
        static int s;
        static int d;
  
    
    public void Search(String[]s1,double[][]a1,int start,int dest)
    {
        vertex=s1.length;
        s=start;
        d=dest;
        s2=new String[s1.length];
        a2=new double[a1.length][a1.length];
        for (int j = 0; j < s1.length; j++) {
            s2[j]=s1[j];
        }

        for (int j = 0; j <a1.length; j++) {
            for (int l = 0; l < a1.length; l++) {
                a2[j][l]=a1[j][l];
            }
        }
       
        
        
        
        olistv.add(new queue(a1[start][start],start,s1[start]));
        olist.add(start);
        
        
        i=start;
        k=0;
        search();
        queue fin=null;
        double comp=50.0;
        for(queue a5:clistv)
        {
            if(a5.cost<comp)
            {
                comp=a5.cost;
                fin=a5;
            }
        }
        System.out.println("Shortest Path : "+fin.name);
        System.out.println("Cost : "+fin.cost);
        
        

        //olistv.remove(0);

        //System.out.println(olist);
//        for (queue a2:olistv) {
//            System.out.println(a2.name+" "+a2.index+" "+a2.cost+" ");
//        }
        







    }
    public static void search()
    {
        while(!olistv.isEmpty())
        {
            q1=olistv.remove(0);
            if(q1.name.endsWith(s2[d]))
            {
                clistv.add(q1);
            }
            else
            {
                k=q1.index;
                for (int j = 0; j < a2.length; j++) {
                    if(a2[k][j]!=0.0&&!(q1.name.contains(s2[j])))
                    {
                        olistv.add(new queue(a2[k][j]+q1.cost,j,q1.name+"-->"+s2[j]));
                    }
                }
                
                Collections.sort(olistv,comp);
                //print();

                
              

                
            }
            

            
        }
    }
    public static void print()
    {
        for (queue a5:olistv){
            System.out.println(a5.name+" "+a5.index+" "+a5.cost+" ");
        }
    }

}
