import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String args[]) {
    ExecutorService service = Executors.newCachedThreadPool(); // create a new thread pool
    for (int i=0; i<args.length; i++) {
      File directory = new File(args[i]); // directory path
      if (directory.exists() && directory.isDirectory()) { // check if directory
        File[] fileList = directory.listFiles(); // list files inside directory
        RecZip(service, fileList, directory);
      }
      else {
        System.err.println("'" + directory + "'" + " isn't a directory!");
      }
    }
    service.shutdown(); // shut down the thread pool
  }
  
  // Recursively check inside directory
  public static void RecZip(ExecutorService service, File[] listDir, File stdDir) {
    for (File file : listDir) {
      if (file.isFile()) { // check if is file 
        if (!file.getName().endsWith(".zip")) { // check if it's already a zipped file
          String filePath = file.getAbsolutePath(); // current file path
          String fileName = file.getName(); // current file name
          String destination = fileName.substring(0, fileName.lastIndexOf('.')) + ".zip"; // zipped file destination
          ZipThread zippedFile = new ZipThread(filePath, stdDir + "\\" + destination); // create zipped file
          service.execute(zippedFile); // starting thread of ThreadPool
        }
      }
      if (file.isDirectory()) { // check if is directory
        File newDir = new File(file.getAbsolutePath());
        File[] files = file.listFiles(); // list files inside directory
        RecZip(service, files, newDir);
      }
    }
  }

}
