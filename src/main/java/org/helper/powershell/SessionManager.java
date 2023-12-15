package org.helper.powershell;

import java.io.IOException;

public class SessionManager {

    public static void runPowershellSession() {
        try {
            // Command to execute PowerShell
            String command = "powershell.exe";

            // PowerShell script/command
//            String script = "Write-Host 'Hello, PowerShell!'";

            // Create ProcessBuilder instance
            ProcessBuilder processBuilder = new ProcessBuilder(command, "-NoExit");

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to finish
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    void closePowershellSession() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-Command", "Exit");
            processBuilder.start();
//            System.out.println("PowerShell session closed successfully");
        } catch (IOException e) {
            System.out.println("Error while closing PowerShell session: " + e.getMessage());
        }
//        Get-PSSession  -   list of running powershell sessions
    }




}
