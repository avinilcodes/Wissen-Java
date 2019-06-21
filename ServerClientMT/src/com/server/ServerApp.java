package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// java.net.*

public class ServerApp {
	private static int reqCount = 0;
	private static Socket socket;
	private static ObjectOutputStream oos;
	private static ServerSocket serverSocket = null;
	private static List<Socket> socks = new ArrayList<>();

	public static void main(String[] args) {
		try {
			serverSocket = new ServerSocket(8444);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Runnable task = () -> {
			try {
				while (true) {
					System.out.println("waiting for client request..");
					Socket socket = serverSocket.accept(); // accepts request
					socks.add(socket);
					System.out.println("accepted client request..");

					TimeUnit.SECONDS.sleep(5);
					reqCount++;

					OutputStream out = socket.getOutputStream();
					ObjectOutputStream oos = new ObjectOutputStream(out);
					oos.writeObject("hello client, your req count is " + reqCount);
					oos.close();
					System.out.println("respose sent back");
					//
					//

				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable task2 = () -> {
			try {
				while (true) {
					oos.writeObject("hi please choose 1..3");
					InputStream in = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(in);
					Object object = ois.readObject();
					String resp = (String) object;

					TimeUnit.SECONDS.sleep(3);
					switch (resp) {
					case "1":
						oos.writeObject("hi you have choosen request 1.. we are processing it..req no" + reqCount);
					case "2":
						oos.writeObject("hi you have choosen request 2.. we are processing it..req no" + reqCount);
					case "3":
						oos.writeObject("hi you have choosen request 3.. we are processing it..req no" + reqCount);
					default:
						oos.writeObject("thanks for using..ending now");
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(task);
			executorService.submit(task2);
		}
	}
}