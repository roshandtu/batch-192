package serial;
import java.io.*;
public class SerializeDemo
{
   public static void main(String [] args)
   {
      employee e = new employee();
      e.name = "sandip";
      e.address = "jaynagar, 4th Block";
      e.SSN = 11123;
      e.number = 101;
      try
      {
         FileOutputStream fileOut =new FileOutputStream("serial.txt");//file will be created and open in write mode.
         ObjectOutputStream out = new ObjectOutputStream(fileOut);//write the object into the file
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in serial.txt");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
   }
}