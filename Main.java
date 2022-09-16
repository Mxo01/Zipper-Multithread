import java.io.File;

public class Main {
  public static void main(String args[]) {
    for (int i=0; i<args.length; i++) {
      File directory = new File(args[i]); // directory path
      if (directory.exists() && directory.isDirectory()) { // check if directory
        File[] fileList = directory.listFiles(); // list files inside directory
        RecZip(fileList, directory);
      }
      else {
        System.err.println("'" + directory + "'" + " isn't a directory!");
      }
    }
  }
  
  // Recursively check inside directory
  public static void RecZip(File[] listDir, File stdDir) {
    for (File file : listDir) {
      if (file.isFile()) { // check if is file 
        if (!file.getName().endsWith(".zip")) { // check if it's already a zipped file
          String filePath = file.getAbsolutePath(); // current file path
          String fileName = file.getName(); // current file name
          String destination = fileName.substring(0, fileName.lastIndexOf('.')) + ".zip"; // zipped file destination
          ZipThread zippedFile = new ZipThread(filePath, stdDir + "\\" + destination); // create zipped file
          Thread thread = new Thread(zippedFile); // create thread
          thread.start(); // starting thread
        }
      }
      if (file.isDirectory()) { // check if is directory
        File newDir = new File(file.getAbsolutePath());
        File[] files = file.listFiles(); // list files inside directory
        RecZip(files, newDir);
      }
    }
  }

}
