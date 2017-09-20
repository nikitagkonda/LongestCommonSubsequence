import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LCS_Nikita_Konda_nkonda
{
	public static void main(String[] args) throws IOException {
		
		//Input file
		 BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		//Output file
		 PrintWriter writer = new PrintWriter("output.txt");
		 
		 String first=br.readLine();
		 String second=br.readLine();
		 int m= second.length()+1;
		 int n= first.length()+1;
		 int[][] opt = new int[n][m];
		 char[][] parent=new char[n][m];
		 
		 //LCS
		 for(int j=0;j<m;j++)
		 {
			opt[0][j]=0;
		 }
		 for(int i=1;i<n;i++){
			 opt[i][0]=0;
			 for(int j=1;j<m;j++)
			 {
				 if(first.charAt(i-1)==second.charAt(j-1))
				 {
					 opt[i][j]=opt[i-1][j-1]+1;
					 parent[i][j]='d';
				 }
				 else if(opt[i][j-1]>=opt[i-1][j]) {
					 opt[i][j]=opt[i][j-1];
					 parent[i][j]='l';
				 }
				 else{
					 opt[i][j]=opt[i-1][j];
				     parent[i][j]='u';
				 }
			 }
		 }
		 
		 //Output
		 int length=opt[n-1][m-1];
		 int i=n-1,j=m-1;
		 String output="";
		 while(i>0 && j>0){
			 if(parent[i][j]=='d')
			 {
				 output=Character.toString(first.charAt(i-1))+output;
				 i--;j--;
			 }
			 else if(parent[i][j]=='u'){
				 i--;
			 }
			 else{
				 j--;
			 }
		 }
		 writer.println(length);
		 writer.println(output);
		 writer.close();
		 br.close();
	}

	
}