package com.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientApp {
	static Socket socket =null;
	public static void main(String[] args) {
		while (true) {
			try {
				socket = new Socket("localhost", 8444);
				System.out.println("open connection");

				
				InputStream in = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(in);
				Object object = ois.readObject();
				String resp = (String) object;
				System.out.println("resp : " + resp);


			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					if(socket !=null) {
					socket.close();
					}
				} catch (IOException e) {
					
					
					e.printStackTrace();
				}
			}
		}
	}

}