import service.ApplicationService;
import service.impl.EWalletApplicationServiceImpl;

public class Main {

    public static void main(String[] args) {
        try {
            // Start the console application flow.
            ApplicationService applicationService = new EWalletApplicationServiceImpl();
            applicationService.start();
        } catch (RuntimeException exception) {
            // Prevent unexpected startup failures from terminating silently.
            System.err.println("Application failed to start: " + exception.getMessage());
        }
    }
}
