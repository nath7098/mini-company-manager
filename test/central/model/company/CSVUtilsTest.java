package central.model.company;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static central.model.company.CSVUtils.*;
import static org.junit.Assert.*;

public class CSVUtilsTest {

    private FileWriter writer;
    private List<String> row;
    private File csvfile;

    @Before
    public void setup(){
        try {
            csvfile = new File("./data/CSVUtilsTestFile.csv");
            writer = new FileWriter("./data/CSVUtilsTestFile.csv");
            row = List.of("arg0", "arg1", "arg2", "arg3");
        }catch (IOException e){
            System.out.println(e);
        }
    }

    @Test
    public void testFollowCSVFormat(){
        String result = "\"\"result\"\"";
        String test = "\"result\"";
        assertEquals(result,followCSVFormat(test));
    }

    @Test
    public void testReadWrite() {
        try {
            Scanner sc = new Scanner(csvfile);
            writeLine(writer, row);
            writer.flush();
            writer.close();
            List test = readLine(sc.nextLine());
            assertEquals(row,test);
            assertEquals(false,sc.hasNext());
        }catch(IOException e){
            System.out.println(e);
        }
    }

}