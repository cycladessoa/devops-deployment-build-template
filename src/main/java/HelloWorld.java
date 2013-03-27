import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Very simple example class to use as a deployment build example
 */
public class HelloWorld {

    public static void main (String[] args) {
        try {
            if (args.length < 1) {
                System.out.println(helloWorld());
            } else {
                parseAndPrintJSONFile(args[0]);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    public static String helloWorld () {
        return "Hello World!";
    }
    
    public static void parseAndPrintJSONFile (String jsonFilePath) throws Exception {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(jsonFilePath);
            System.out.println(new JSONObject(new String(toByteArray(fis, 1024), "UTF-8")).toString());
        } finally {
            try { fis.close(); } catch (Exception e) {}
        }
    }
    
    public static byte[] toByteArray (InputStream is, int bufferSize) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (bufferSize < 1) throw new Exception("Invalid buffer size: " + bufferSize);            
        int bytesRead;            
        byte[] buffer = new byte[bufferSize];            
        while ((bytesRead = is.read(buffer)) != -1) {                
            baos.write(buffer, 0, bytesRead);            
        }
        return baos.toByteArray();
    }

}
