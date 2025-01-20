package D_19_01_25;

import java.util.Scanner;
public class Main{
public static void main(String[] args){
int type, a, b;
Scanner sc = new Scanner(System.in);
System.out.println("Select type from 1 to 4");
type = sc.nextInt();
System.out.println("Select first number");
a = sc.nextInt();
System.out.println("Select second number");
b = sc.nextInt(); 
switch(type){
case 1: System.out.println(a+b);
break;
case 2: System.out.println(a-b);
break;
case 3: System.out.println(a*b);
break;
case 4: System.out.println(a/b);
break;
default: System.out.println(0);
}
}
}