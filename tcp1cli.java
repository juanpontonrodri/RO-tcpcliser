import java.net.*;
import java.util.*;
import java.io.*;

public class tcp1cli{
    

    public static void main(String [] args){

        try {
            if (args.length!=2) throw new Exception("Wrong number of parameters, correct use: \njava udpcli ip_address port_numer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        
        int port=Integer.parseInt(args[1]); 
        Scanner imput = new Scanner(System.in);
        InetAddress address = null;
        //Socket socket=null;

        try {
            
            address = InetAddress.getByName(args[0]);

        }

        catch(Exception e){
            System.out.println("Error getting address");
            System.exit(-1);
        }
        

        try{    
            Socket socket = new Socket(address,port);
            do{
            System.out.println("Enter a serie of numbers finished by 0 (write a number and press enter for each one, if a 0 is typed the serie is finished");
            int number = imput.nextInt();
            if (number==0) {
                //socket.close();
                System.exit(0);
                System.out.println("Exit");
                
            }
            else{   

                /*LinkedList <Integer> list = new LinkedList<>();
                list.add(number);  

                String numbers=imput.nextLine();
                


                do {
                    number=imput.nextInt();   
                    if (number==0) {
                        imput.close();
                        break;
                    }        
                    list.add(number);       
                    
                } while(number!=0);
               
                java.util.Iterator<Integer> iterator = list.iterator();  
                int n=0;
                while (iterator.hasNext()) {
                    n=iterator.next();
                    buffer.putInt(n);

                }
                buffer.rewind();
                DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.array().length,address,port);
                
                */
                DataInputStream input= new DataInputStream(socket.getInputStream());
                DataOutputStream output=new DataOutputStream(socket.getOutputStream());
                output.writeInt(number);
                output.flush();
                System.out.println(input.readInt());
                


            }
            }while(true);  
            

        }
        catch(SocketTimeoutException e){
            
        }
        catch (Exception e) {                         
            System.out.print("Error");
            System.exit(-1);

        }
        
        
        
        

    }

    
}