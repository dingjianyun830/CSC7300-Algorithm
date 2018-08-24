/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeroones;

/**
 *
 * @author robin
 */
public class ZeroOnes
{

    /**
     * @param args the command line arguments
     */
    public static void SwapElement(int[] m_nArray, int[] nIndex)
    {
        m_nArray[nIndex[0]] = 1;
        m_nArray[nIndex[1]] = 0;
    }
    
    public static void PrintArray(int[] m_nArray, int N)
    {
        System.out.print("[");
        for(int i = 0; i < N ; i++)
        {
            System.out.printf("%2d,", m_nArray[i]);        
        }
        System.out.println("]");
    }
    
    public static int[] FindIndex(int[] m_nArray, int N)
    {
        int[] nIndex = new int[2];
        
        for(int i = 0; i < N; i++)
        {
            if(m_nArray[i]==1)
            {
                nIndex[1] = i;
                break;
            }
        }
        
        for(int i = N - 1; i > 0; i--)
        {
            if(m_nArray[i]==0)
            {
                nIndex[0] = i;
                break;
            }
        }
        return nIndex;
    }
    
    public static int[] RandomArray(int N)
    {
        int[] m_nArray;
        m_nArray = new int[N];
        for(int i = 0; i < N ; i++)
        {
            // The random element is between 0 and 1.
            m_nArray[i] = (int)(Math.random()*2);      
        }

        return m_nArray;
    }
       
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.println("This is an application which is used to practice algorithm.");
        System.out.println("First, let's generate a random array which has 10 elements.");
        System.out.println("The element of the array is 0 or 1.");
        int[] m_nArray;
        int N = 10;
        m_nArray = RandomArray(N);
        PrintArray(m_nArray,N);
        System.out.println("Second, Let's move all 0's to the left and all 1's to the right.");
        System.out.println("We choose the algorithm which is taught by courses.");
        System.out.println("IndexZero is the most right 0's, IndexOne is the most left 1's .");
        int count =0;
        while(true)
        {
            int[] nIndex = new int[2];
            nIndex = FindIndex(m_nArray, N);
            
            if(nIndex[0] > nIndex[1])
            {
                System.out.printf("IndexZero = %d > IndexOne = %d. Swap it.\n",nIndex[0],nIndex[1]);
                SwapElement(m_nArray,nIndex);
                PrintArray(m_nArray,N);
                count++;
            }
            else
            {
                System.out.printf("IndexZero = %d < IndexOne = %d. Stop it.\n",nIndex[0],nIndex[1]);
                System.out.printf("We need sawp %d times to achieve the goal.\n",count);
                break;
            }       
        }       
    }
    
}
