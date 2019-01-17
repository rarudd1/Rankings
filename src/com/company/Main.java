package com.company;
import java.io.*;

public class Main {

    static int[] scoreranking(int[] scores, int[] student) {

        int[] rank = new int[student.length];
        int j = student.length-1;
        int count =1;
        for(int i =0; i<scores.length; i++)
        {
            while(j>= 0 && student[j]>=scores[i])
            {
                rank[j]=count;
                j--;
            }
            if(i == 0) count++;
            if(i != 0 && (scores[i-1] != scores[i])) count++;
        }

        while(j>=0)
        {
            rank[j]= count;
            j--;
        }
        return(rank);
    }


    public static void main(String[] args) throws IOException{

        try(BufferedReader br = new BufferedReader(new FileReader("thisfile.txt"))) {
            int n=0;
            String str = br.readLine();
            try {
                n = Integer.parseInt(str);
            } catch (NumberFormatException exc) {
                System.out.print("Format error");
            }

            String [] strscores  = br.readLine().split(" ");
            int[] scores = new int[n];
            for (int i = 0; i < n; i++) {

                try {
                    scores[i] = Integer.parseInt(strscores[i]);
                } catch (NumberFormatException exc) {
                    System.out.print("Format error");
                }

            }
            str = br.readLine();
            try {
                n = Integer.parseInt(str);
            } catch (NumberFormatException exc) {
                System.out.print("Format error");
            }
            String [] strstudentscores  = br.readLine().split(" ");
            int[] studentscores = new int[n];
            for (int i = 0; i < n; i++) {

                try {
                    studentscores[i] = Integer.parseInt(strstudentscores[i]);
                } catch (NumberFormatException exc) {
                    System.out.print("Format error");
                }
            }
        int[] rank = scoreranking(scores, studentscores);

            for(int i =0; i<rank.length; i++)
            System.out.print(rank[i]+ " ");

        }catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }


    }
}
