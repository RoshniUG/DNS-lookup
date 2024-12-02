package DNSLookup;
import java.net.*;
import java.util.Scanner;
public class DNSLookup 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get input from user
            System.out.print("Enter a domain name or IP address: ");
            String input = scanner.nextLine();

            // Check if the input is a valid IP address
            if (isValidIP(input)) {
                // IP Address to Domain
                InetAddress host = InetAddress.getByName(input);
                System.out.println("\nIP Address: " + input);
                System.out.println("Domain Name: " + host.getHostName());
            } else {
                // Domain to IP Address
                InetAddress ip = InetAddress.getByName(input);
                System.out.println("Domain: " + input);
                System.out.println("IP Address: " + ip.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve host. " + e.getMessage());
        } finally {
            scanner.close();  // Close the scanner resource to avoid memory leaks
        }
    }

    // Method to check if the input is a valid IP address
    public static boolean isValidIP(String ip) {
        String ipPattern = 
            "^([0-9]{1,3}\\.){3}[0-9]{1,3}$"; // Simple regex to check basic IP format
        return ip.matches(ipPattern);
    }

}
