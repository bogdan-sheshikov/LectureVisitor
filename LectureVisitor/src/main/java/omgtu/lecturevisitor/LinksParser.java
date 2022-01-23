package omgtu.lecturevisitor;

import java.io.*;
import java.util.HashMap;

public class LinksParser {
    HashMap<String, String> links;

    HashMap<String, String> getListOfLinks(){
        try {
            FileInputStream fileInputStream = new FileInputStream("./Links.txt");
            StringBuilder stringBuilder;
            while (fileInputStream.read())
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return links;
    }
}
