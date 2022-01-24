package omgtu.lecturevisitor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;


public class LinksParser {
    HashMap<String, String> links;

    private void readLinksFile(){
        final Path filePath = Path.of("./Links.txt");
        try(InputStream inputStream = Files.newInputStream(filePath)){
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                parse(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void parse(String line) {
        String[] separatedLine = line.split(":");
        links.put(separatedLine[0], separatedLine[1]);
    }

    HashMap<String, String> getListOfLinks(){
        readLinksFile();
        return links;
    }
}
