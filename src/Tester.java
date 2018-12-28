/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
        
/**
 *
 * @author user
 */
public class Tester {

    static String[]vertex;
    static double[]hval;
    static double [][] a;
 
    static int n1;
    static int n2;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
           FileReader f=new FileReader("aStar.txt");
           BufferedReader br=new BufferedReader(f);
           String s=br.readLine();
           StringTokenizer st=new StringTokenizer(s," ");
           int v=Integer.parseInt(st.nextToken()); //number of vertices
           int e=Integer.parseInt(st.nextToken()); //number of edges
           
           String start=br.readLine(); //start destination
           String dest=br.readLine();  //final destination
           
           System.out.println("Start: "+start);
           System.out.println("Destination: "+dest);
           
           vertex=new String[v+1];
           hval=new double[v+1];
           

           for(int i=0;i<v;i++)
           {
               s=br.readLine();
               st= new StringTokenizer(s,",");
               vertex[i]=st.nextToken();
               hval[i]=Double.parseDouble(st.nextToken());
               
           }
         
           a=new double[v+1][v+1];
           int c1=0;
           int c2=0;

            for (int i = 0; i < v; i++) {
                s=br.readLine();
                st= new StringTokenizer(s," ");
                String s1=st.nextToken();
                for (int j = 0; j < v; j++) {
                    if(s1.equals(vertex[j]))
                    {
                        c1=j;
                        break;
                    }
                }
                String s2=st.nextToken();
                for (int j = 0; j < v; j++) {
                    if(s2.equals(vertex[j]))
                    {
                        c2=j;
                        break;
                    }
                }
                String s3=st.nextToken();

                double cost=Double.parseDouble(s3)+hval[c2];
                a[c1][c2]=cost;
            }
            
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
           
            for (int i = 0; i < v; i++) {
                System.out.print(vertex[i]+" ");
            }
            System.out.println();
            
            n1=0;
            n2=0;
            for (int i = 0; i < v; i++) {
                if(vertex[i].equals(start)){
                    n1=i;
                }
                if(vertex[i].equals(dest))
                {
                    n2=i;
                }
            }
            System.out.println(n1);
            System.out.println(n2);
            
            aStarSearch as=new aStarSearch();
            as.Search(vertex, a, n1, n2);
//            for (int i = 0; i < v; i++) {
//                System.out.print(hval[i]+" ");
//            }
//            System.out.println();

        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
    }
    
}
