package client;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("--- Starting Calculator Client ---");

            CalculatorWS_Service service = new CalculatorWS_Service();
            CalculatorWS port = service.getCalculatorWSPort();

            System.out.println("\nInvoking method 'hello'...");
            String response = port.hello("Younes Nait Bakkou");
            System.out.println("Server Response: " + response);

            int a = 15;
            int b = 25;
            System.out.println("\nInvoking method 'add'...");
            int result = port.add(a, b);

            System.out.println("Calculation Result: " + a + " + " + b + " = " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
