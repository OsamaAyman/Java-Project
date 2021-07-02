package Day1;

import java.util.List;

public interface PyramidsDAO {
    List<Pyramid> readPyramidsFromCSV(String fileName);
    Pyramid createPyramid(String[] metadata);
}
