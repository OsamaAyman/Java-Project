package Day1;

import java.io.IOException;
import java.util.List;

public class Day1_Exercise2 {
    public static void main(String args[]) throws IOException {
        PyramidsImplementDAO pyramidsDAO =new PyramidsImplementDAO();
        List<Pyramid> pyramids=pyramidsDAO.readPyramidsFromCSV("src/main/resources/data/pyramids.csv");
        int i=0;
        for(Pyramid p:pyramids)
            System.out.println("%"+(++i)+p);


    }
}
