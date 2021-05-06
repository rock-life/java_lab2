package laba2;
import java.io.*;
import java.util.Scanner;
public class lab2 {
	public static void main(String[] str) {
		Scanner in = new Scanner(System.in);
		byte v=0;
		do {
			System.out.println("\nВиберіть завдання:\n1 - String\n2 - Читання з файлу\n3 - Bвід і вивід з тексту\n");
	   try {
		   v=in.nextByte();
		   switch(v) {
		   case 1: one();break;
		   case 2: two();break;
		   case 3: tree();break;
		   case 4: return;
		   default: System.out.println("Завдання не існує!");
		   }
	   }	
	   catch(Exception e) 
	   {
		   System.out.println("Введеня не вірне. "+e.toString());
	   }
		}while(v!=4)
		;
		}
	public static void one() {
		Scanner in=new Scanner(System.in);
		byte j=0;
		System.out.println("Введіть рядок будь-яких символів - ");
		String s=in.nextLine();
		char []c=new char[s.length()];
		for(int i=s.length()-1;i>=0;i--)
		{
			c[j]=s.charAt(i);
			j++;
		}
		s=new String(c);
		System.out.println("Інвертований рядок - "+s+"\nКiлькість літер - "+s.length());
	}
	public static void two() {

	try (BufferedReader bf=new BufferedReader(new FileReader("C:\\Users\\Admin\\Downloads\\lab\\laba2\\src\\laba2\\text.txt")))
	 {
		Scanner in=new Scanner (System.in);
		 String s="",w, b="";
		 System.out.println("Введіть слово - ");
		 w=in.nextLine();
		 while((b=bf.readLine())!=null) {
		 s=s+b+"\n";
		 }
		 System.out.println("\nТекст з файла\n"+s+"\nPядок з попередьо введеним словом:");
		 char []ch=new char[s.length()];
		 int j=0;
		 for(int i=0;i<s.length();i++)
		 {
			 if(s.charAt(i)!='.'&&s.charAt(i)!='!'&&s.charAt(i)!='?')
			 { 
				 ch[j]=s.charAt(i);
				 j++;
			 }
			 else {
				 ch[j]=s.charAt(i);
				 b=new String(ch);
				 b.trim();
				 ch=new char[s.length()];
				 j=0;
			 if(b.contains(w)==true)
				 System.out.print(b);
			 }
		 }

			bf.close();
		 }
	 catch(IOException ex) { System.out.println(ex.getMessage()); }
}
	public static void tree() {
		String s="", b="";
	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Admin\\Downloads\\lab\\laba2\\src\\laba2\\output.txt")))
	{
		while((b=br.readLine())!=null)
		s=s+b+"\n";	
		System.out.print("Текст з файлу:\n"+s+"\nВилучення тексту в душках");
		
	}
	catch(IOException e) {System.out.print("помилка читання файлу - "+e.getMessage());}
char[]ch=new char[s.length()];
int j=-1;
boolean t=false;
for(int i=0;i<s.length();i++)
{	
	j++;
	ch[j]=s.charAt(i);
	if(s.charAt(i)=='(')
	{
		while(s.charAt(i)!=')'&&i!=s.length()-1)
		{
			i++;
			if(i==s.length())
				break;
			if(s.charAt(i)==')')
				{
					t=true;
					j++;
					ch[j]=s.charAt(i);
				}
		}
	}
}
	if(t==true)
	{
	s=new String(ch);
	s.trim();
	}
	System.out.print("\nТекст який буде записаний в файл:\n"+s);
try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Downloads\\lab\\laba2\\src\\laba2\\input.txt")))
{
	bw.write(s);
}
catch(IOException ex)
{
	System.out.print("помилка читання файлу - "+ex.getMessage());
}
}
}

