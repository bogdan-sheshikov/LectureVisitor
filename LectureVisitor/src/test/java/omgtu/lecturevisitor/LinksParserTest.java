package omgtu.lecturevisitor;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class LinksParserTest {
    @Test
    void getListOfLinks() {
        LinksParser linksParser = new LinksParser();
        HashMap<String, String> realResult = linksParser.getListOfLinks();
        HashMap<String, String> expected = new HashMap<>();
        expected.put("name", "Url");
        expected.put("name1", "Url");
        expected.put("name2", "Url");
        if(realResult.equals(expected)){
            System.out.println("All fine. Test passed!");
        }
    }
}