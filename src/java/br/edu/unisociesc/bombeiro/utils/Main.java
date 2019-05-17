package br.edu.unisociesc.bombeiro.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/bombeiro";
            String usuario = "postgres";
            String senha = "admin";

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}