import java.net.*;
import java.util.*;
import java.io.*;

public class tcp1cli{
    

    public static void main(String [] args){
        try {
            if (args.length!=2) throw new Exception("Wrong number of parameters, correct use: \njava tcp1cli ip_address port_numer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }        
        int port=Integer.parseInt(args[1]); 
        Scanner imput = new Scanner(System.in);
        InetAddress address = null;
        try {            
            address = InetAddress.getByName(args[0]);
        }
        catch(Exception e){
            System.out.println("Error getting address");
            System.exit(-1);
        }
        try{    
            Socket socket = new Socket(address,port);
            DataInputStream input= new DataInputStream(socket.getInputStream());
            DataOutputStream output=new DataOutputStream(socket.getOutputStream());
            do{
            System.out.println("Enter a serie of numbers finished by 0 (write a number and press enter for each one, if a 0 is typed the serie is finished");
            String numbers= imput.nextLine();
            String [] ar=numbers.split(" ");
            if (Integer.parseInt(ar[0])==0) {
                socket.close();
                imput.close();
                System.exit(0);                
            }
            else{                 
                output.writeUTF(numbers);
                output.flush();
                System.out.println(input.readInt());              
            }
            }while(true);                   
        }
        catch (Exception e) {                         
            System.out.print("Error");
            System.exit(-1);
        }      
    }
}