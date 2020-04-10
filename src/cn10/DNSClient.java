package cn10;


import java.awt.image.BufferedImage;
import java.io.*;  
import java.net.*; 
import javax.imageio.ImageIO;
import java.util.Scanner;


class Client{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",3333);
DataInputStream dis=new DataInputStream(s.getInputStream());
DataOutputStream dos=new DataOutputStream(s.getOutputStream());
Scanner sc=new Scanner(System.in);

String str="";
String str1="";
//while(!str.equals("stop")){
    str=sc.nextLine();
    dos.writeUTF(str);
    dos.flush();
    
    str1=dis.readUTF();
    System.out.println("Server says: "+str1);
dos.close();

s.close();



}} 

