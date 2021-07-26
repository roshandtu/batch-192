package serial;
import java.io.*;
public class employee implements Serializable
{
   public String name;
   public String address;
   public transient int SSN;
   public int number;
  
}