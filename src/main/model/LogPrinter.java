package model;


public class LogPrinter {

    public void printLog(EventLog eventLog) {
        System.out.println("has been there");
        for (Event next: eventLog) {
            System.out.println(next.toString() + "\n\n");
        }
    }
}
