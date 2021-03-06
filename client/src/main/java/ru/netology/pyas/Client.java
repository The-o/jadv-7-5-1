/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.netology.pyas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    private final static String HOST = "127.0.0.1";
    private final static int PORT = 8080;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
        ) {
            int num = readFibonacciNum(scanner);
            out.writeInt(num);
            long fib = in.readLong();
            System.out.printf("%d'ое число Фибоначчи: %d%n", num, fib);
        } catch (IOException e) {
            System.out.println("Ошибка сокета: " + e.getMessage());
        }
    }

    private static int readFibonacciNum(Scanner scanner) {
        while (true) {
            System.out.print("Введите номер числа Фибоначчи: ");
            int num;
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                continue;
            }
            if (num <= 0) {
                continue;
            }
            return num;
        }

    }
}
