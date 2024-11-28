/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author andrespillajo
 */
public class Cliente {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 3010;
        try (Socket socket = new Socket(host, port);
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))){
            
            System.out.println("Conectado al servidor");
            System.out.println("Mensaje del servidor: " + serverInput.readLine());
            
            String userInput;
            while ((userInput = consoleInput.readLine()) != null) {
                output.println(userInput); // Envía al servidor
                System.out.println("Respuesta del servidor: " + serverInput.readLine()); // Recibe del servidor
            }
            
        }catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
