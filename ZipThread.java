import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class ZipThread implements Runnable {
  
  private String filePath; // file path
  private String destination; // zipped file destination

  // Constructor
  public ZipThread(String filePath, String destination) {
    this.filePath = filePath;
    this.destination = destination;
  }

  // Zip a file from source to destination
  public void zip(String input, String output) {
    byte[] buffer = new byte[1024];
 
    // Try to zip the input to the output directory
    try {
      FileInputStream fileInput = new FileInputStream(input);
      FileOutputStream fileOutputStream = new FileOutputStream(output);
      GZIPOutputStream gzipOuputStream = new GZIPOutputStream(fileOutputStream);
 
      int bytes_read;
      // Read from input and save into buffer
      while ((bytes_read = fileInput.read(buffer)) > 0) {
        gzipOuputStream.write(buffer, 0, bytes_read); // write from the buffer to zipped file 
      }
      
      // files closing
      fileInput.close(); 
      gzipOuputStream.finish();
      gzipOuputStream.close();

      File file = new File(input);
      System.out.println("The file " + "'" + file.getName() + "'" + " was compressed successfully!");
 
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void run() {
    this.zip(filePath, destination);
  }

}
