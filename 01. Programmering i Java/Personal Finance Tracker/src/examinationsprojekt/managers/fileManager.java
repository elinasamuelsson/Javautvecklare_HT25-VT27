package examinationsprojekt.managers;

import examinationsprojekt.models.Transaction;

import java.io.*;
import java.util.ArrayList;

import static examinationsprojekt.Main.accountBalance;
import static examinationsprojekt.Main.transactions;

public class fileManager {
    public static void saveDataToFile() {
        try {
            FileOutputStream saveData = new FileOutputStream("saveData.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(saveData);
            objectOut.writeObject(transactions);
            objectOut.writeObject(accountBalance);
            objectOut.close();
            saveData.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void loadDataFromFile() {
        File saveDataCheck = new File("saveData.ser");
        if (!saveDataCheck.exists()) return;

        try {
            FileInputStream saveData = new FileInputStream("saveData.ser");
            ObjectInputStream objectIn = new ObjectInputStream(saveData);
            transactions = (ArrayList<Transaction>) objectIn.readObject();
            accountBalance = (double) objectIn.readObject();
            objectIn.close();
            saveData.close();
        } catch (ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
