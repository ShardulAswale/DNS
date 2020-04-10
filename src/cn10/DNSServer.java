package cn10;
import java.io.*;  
import java.net.*;  
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

class Server{  
public static void main(String args[])throws Exception{  
ServerSocket ss=new ServerSocket(3333);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
Scanner sc=new Scanner(System.in);  
  
String str="",str2="";  
//while(!str.equals("stop")){  



str=din.readUTF();  
System.out.println("client says: "+str);  


BufferedReader objReader = null;
  try {
   String strCurrentLine;

   objReader = new BufferedReader(new FileReader("database.txt"));

   while ((strCurrentLine = objReader.readLine()) != null) {
       
       
       if(str.equals(strCurrentLine)){
           try { 
			// Fetch IP address by getByName() 
			InetAddress ip = InetAddress.getByName(new URL(strCurrentLine).getHost()); 

			// Print the IP address 
			System.out.println("Public IP Address of: " + ip); 
                        URI uri= new URI(strCurrentLine);
                        java.awt.Desktop.getDesktop().browse(uri);
                        System.out.println("Web page opened in browser");
 
		} 
		catch (Exception e) { 
			// It means the URL is invalid 
			System.out.println("Invalid URL"); 
		}
       }
    //System.out.println(strCurrentLine);
   }

  } catch (IOException e) {

   e.printStackTrace();

  } finally {

   try {
    if (objReader != null)
     objReader.close();
   } catch (IOException ex) {
    ex.printStackTrace();
   }
  }
str2=sc.nextLine();  
dout.writeUTF(str2);  
dout.flush();    
din.close();  
s.close();  
ss.close();  
}}
