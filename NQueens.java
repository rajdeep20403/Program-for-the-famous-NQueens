Java Program for placing 2 queens in n*n chess board safely

import java.util.*;
public class nqueens           
{
    public static void printNQueens(int chess[][],String qsf,int row)
    {
        //function to print print positons safe for the queens in the form of row.column,
        if(row==chess.length)
        {
            System.out.println(qsf);
            return;
        }
        for(int col=0;col<chess.length;col++)
        {
            if(isItSafePlaceForQueen(chess,row,col)==true)
            {
                chess[row][col]=1;
                printNQueens(chess, qsf+row+"."+col+",", row+1);    //prints position
                chess[row][col]=0;
            }
        }
    }
    public static boolean isItSafePlaceForQueen(int chess[][],int row,int col)
    {
        //vertical check
        for(int i=row-1,j=col;i>=0;i--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        //left top diagonal check
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        //right top diagonal check
        for(int i=row-1,j=col+1;i>=0&&j<chess.length;i--,j++)
        {
            if(chess[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int chess[][]=new int[n][n];
        printNQueens(chess, "", 0);
    }
}
