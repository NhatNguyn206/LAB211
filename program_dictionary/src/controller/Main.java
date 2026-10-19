package controller;

public class Main {
    public static void main(String[] args) {
        WordManagement wordManagement = new WordManagement("dictionary.txt");
        wordManagement.execute();
    }
}
