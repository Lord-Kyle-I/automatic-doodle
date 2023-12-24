/**
 * @author Kyle Leverence
 * linkedin: https://www.linkedin.com/in/kyleleverence
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket;
        String input;
        String name;
        boolean isCreator = false;
        try{
            //ask if create or join server
            System.out.print("Type 'c' to create a server or enter a port to join one: ");
            input = getInput();
            if(input.equals("c")){
                System.out.print("Enter the desired port number: ");
                serverSocket = new ServerSocket(Integer.parseInt(input));
                socket = serverSocket.accept();
                isCreator = true;
            } else{
                socket = new Socket("localhost", Integer.parseInt(input));
            }

            //get user
            System.out.print("Enter your alias: ");
            name = getInput();

            //messaging loop
            System.out.println("You are now in the chat room. Enter '/leave' to leave.");
            while(true){
                //output prior messages from socket
                //todo
                System.out.print(String.format("<%s> ", name));
                input = getInput();
                if(input.equals("/leave")){
                    break;
                }
                //write to socket
                //todo
            }
            if(isCreator){
                serverSocket.close();
            }
            socket.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getInput(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
