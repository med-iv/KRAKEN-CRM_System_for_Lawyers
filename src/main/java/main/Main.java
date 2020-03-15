package main;


import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.Client;


public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        //dbService.printConnectInfo();

        try {
            long clientId = dbService.addClient("Вася", "", "Царев", "", "", "");
            System.out.println("Added clientId: " + clientId);

            Client client = dbService.getClient(clientId);
            System.out.println("Client: " + client);

        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
