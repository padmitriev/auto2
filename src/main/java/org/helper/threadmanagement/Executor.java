package org.helper.threadmanagement;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {


    public static void runExecutorService() {

        ExecutorService executorService = Executors.newCachedThreadPool();

    }











}




//
//
//
//
//
//
//
//
//
//import java.io.IOException;
//
//public class ExecutePowerShellScript {
//
//    public static void main(String[] args) {
//        // Path to the PowerShell script
//        String scriptPath = "C:\\path\\to\\script.ps1";
//
//        // Build the PowerShell command
//        String command = "powershell.exe " + scriptPath;
//
//        try {
//            // Create the ProcessBuilder object
//            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
//
//            // Start the process
//            Process process = processBuilder.start();
//
//            // Wait for the process to complete
//            int exitCode = process.waitFor();
//
//            if (exitCode == 0) {
//                System.out.println("PowerShell script executed successfully");
//            } else {
//                System.out.println("PowerShell script execution failed");
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.InputStreamReader;
//
//public class PowerShellExecutor {
//
//    public String executePowerShellScript(String scriptName) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-File", scriptName);
//        processBuilder.redirectErrorStream(true);
//
//        Process process = processBuilder.start();
//        StringBuilder output = new StringBuilder();
//
//        try (InputStream inputStream = process.getInputStream();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//        }
//
//        return output.toString();
//    }
//
//    public static void main(String[] args) {
//        PowerShellExecutor executor = new PowerShellExecutor();
//        try {
//            String scriptName = "path/to/your/script.ps1";
//            String output = executor.executePowerShellScript(scriptName);
//            System.out.println(output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//public class MyRunnable implements Runnable {
//    public void run() {
//        // Code to be executed in the run method
//        System.out.println("Hello from the run method!");
//    }
//}
//    Instantiate an object of the MyRunnable class and pass it to a Thread object:
//public class Main {
//    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//
//        // Start the thread
//        thread.start();
//    }
//}
//
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.InputStreamReader;
//
//public class PowershellThreadFabric {
//
//    public static void main(String[] args) {
//        // Create and start multiple threads
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(new PowershellThread());
//            thread.start();
//        }
//    }
//
//    static class PowershellThread implements Runnable {
//
//        @Override
//        public void run() {
//            String command = "powershell.exe -Command \"Write-Host 'Hello from Powershell!'\"";
//            try {
//                Process process = Runtime.getRuntime().exec(command);
//
//                // Capture the output of the Powershell script
//                InputStream inputStream = process.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    System.out.println(line);
//                }
//
//                bufferedReader.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.concurrent.ExecutorService;
//        import java.util.concurrent.Executors;
//        import java.util.concurrent.Future;
//        Define a class to represent the task that executes the PowerShell scripts:
//public class PowershellTask implements Runnable {
//    private String scriptPath;
//    private String result;
//
//    public PowershellTask(String scriptPath) {
//        this.scriptPath = scriptPath;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    @Override
//    public void run() {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", scriptPath);
//            Process process = processBuilder.start();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            StringBuilder output = new StringBuilder();
//
//            while ((line = reader.readLine()) != null) {
//                output.append(line).append("\n");
//            }
//
//            process.waitFor();
//            result = output.toString();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//    Create a main class to orchestrate the pool of threads:
//public class MainClass {
//    public static void main(String[] args) {
//        // List of script paths
//        List<String> scriptPaths = new ArrayList<>();
//        scriptPaths.add("script1.ps1");
//        scriptPaths.add("script2.ps1");
//        // ... add more script paths as needed
//
//        // Create a thread pool with a fixed number of threads
//        ExecutorService executorService = Executors.newFixedThreadPool(scriptPaths.size());
//
//        // List to hold the Future tasks
//        List<Future<?>> futures = new ArrayList<>();
//
//        // Submit each script execution task to the thread pool
//        for (String scriptPath : scriptPaths) {
//            PowershellTask task = new PowershellTask(scriptPath);
//            futures.add(executorService.submit(task));
//        }
//
//        // Wait for all the script executions to complete
//        for (Future<?> future : futures) {
//            try {
//                future.get(); // Block until completion
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Shutdown the thread pool
//        executorService.shutdown();
//
//        // Retrieve and process the results
//        for (Future<?> future : futures) {
//            if (future.isDone()) {
//                PowershellTask task = (PowershellTask) future;
//                String result = task.getResult();
//                // Process the result as needed
//                System.out.println(result);
//            }
//        }
//    }
//}
//
//
//    In Java, there are several mechanisms available to organize the work of different threads and facilitate their interoperability. Here are a few common approaches:
//        Thread synchronization: Use synchronization mechanisms like locks, mutexes, or semaphores to control access to shared resources. This ensures that only one thread can access a particular resource at a time, preventing undesirable interference or data corruption.
//        Thread coordination: Utilize methods like wait(), notify(), and notifyAll() from the Object class to coordinate communication between threads. These methods allow threads to pause, resume, or notify others about changes in shared data.
//        Thread pooling: Implement a thread pool using the Executor framework from the java.util.concurrent package. A thread pool manages a group of worker threads that can be reused to perform multiple tasks. This approach improves performance by reducing the overhead of thread creation and destruction.
//        Message passing: Use concurrent data structures like BlockingQueue or ConcurrentLinkedQueue to pass messages or data between threads. These structures provide a safe and efficient way for threads to exchange information without explicit locking.
//        Future and Callable: Use the Future interface in conjunction with the Callable interface to create asynchronous tasks. The Callable interface represents a task that can return a result, and the Future interface provides a way to check if the task is completed and retrieve the result once available. This is helpful when multiple threads are performing different tasks, and results are needed for further processing.
//        By leveraging these techniques, you can effectively organize the work of different threads and facilitate their coordination and communication in Java applications.
