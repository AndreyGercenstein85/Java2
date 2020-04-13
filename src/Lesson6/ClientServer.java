package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientServer {
    final static String IP_ADDRESS = "127.0.0.1";
    final static int PORT = 8083;
    static ServerSocket server = null;
    static Socket socket = null;
    static DataInputStream in = null;
    static DataOutputStream out = null;
    static Scanner scanner = new Scanner(System.in);
    private static String nameHost;


    public static void main(String[] args) {

        if (StartSever()){
            nameHost = "Server";
            System.out.println("Starting..." + nameHost);
            try {
                socket = server.accept();
                System.out.println("Enter message:");
                if (in == null) System.out.printf("[" + nameHost + "]: ");
            } catch (IOException e) {
                e.printStackTrace();
                CloseSession();
            }
        } else {
            nameHost = "Client";
            System.out.println("Starting..." + nameHost);
            System.out.println("Enter message:");
            if (in == null) System.out.printf("[" + nameHost + "]: ");
            try {
                socket = new Socket(IP_ADDRESS,PORT);
            } catch (IOException e) {
                e.printStackTrace();
                CloseSession();
            }
        }
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            CloseSession();
        }

        Thread task = new Thread(() -> {
            try {
                while (!Thread.interrupted()) {
                    String str =  in.readUTF();
                    System.out.println( str);
                }
            } catch (IOException e){
                e.printStackTrace();
            } finally {
                CloseSession();
            }
        });
        task.start();


        while (true) {
            String msg = "\n[" + nameHost + "]: " + scanner.nextLine();
            if (msg.equals("/end")) break;
            SendMessage(msg);
        }


        task.interrupted();
    }
    public static boolean StartSever() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static void CloseSession() {
        try {
            in.close();
            out.close();
            scanner.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void SendMessage(String msg){
            try {
                out.writeUTF(msg);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
