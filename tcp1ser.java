import java.net.*;
import java.io.*;

public class tcp1ser{  
        public static void main(String [] args){        
        try {
            if (args.length!=1) throw new Exception("Wrong number of parameters, correct use: \njava tcp1ser port_numer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        int port=Integer.parseInt(args[0]);     
        try{
            ServerSocket server =new ServerSocket(port);
            Socket socket=null;
            while(true){
                try{
                int acumulator=0;
                socket = server.accept();                
                DataInputStream input= new DataInputStream(socket.getInputStream());
                DataOutputStream output=new DataOutputStream(socket.getOutputStream());
                while(true){
                try{
                String message =input.readUTF();
                String [] ar=message.split(" ");
                for (int i = 0; i < ar.length; i++) {
                    acumulator=acumulator+(Integer.parseInt(ar[i]));
                    System.out.println(acumulator);
                }           
                output.writeInt(acumulator);
                }
                catch(SocketException e){
                    System.out.println(e.getMessage());
                    break;
                }
                catch(IOException e){
                    break;
                }                
                }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
               }
            }
        } 
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }

    
}