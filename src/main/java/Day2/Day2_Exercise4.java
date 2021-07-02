package Day2;

import Day1.Pyramid;
import Day1.PyramidsImplementDAO;

import java.util.List;

public class Day2_Exercise4 {
    public static void main(String args[]){
        PyramidsImplementDAO pyramidsDAO =new PyramidsImplementDAO();
        List<Pyramid> pyramids=pyramidsDAO.readPyramidsFromCSV("src/main/resources/data/pyramids.csv");
        List<Float> sortedHight;
        sortedHight=pyramids.stream().map(Pyramid::getHeight)
                .sorted().toList();

        //List<Float>sortedHight=Arrays.asList(1f,2f,3f,4f,5f,6f,7f);

        double allDataMedian=median(sortedHight);
        double firstQuartile=median(sortedHight.subList(0,sortedHight.size()/2));
        double thirdQuartile;
        if(sortedHight.size()%2==0)
            thirdQuartile=median(sortedHight.subList(sortedHight.size()/2,sortedHight.size()));
        else
            thirdQuartile=median(sortedHight.subList(sortedHight.size()/2+1,sortedHight.size()));
        System.out.println("Median= "+allDataMedian);
        System.out.println("First Quartile= "+firstQuartile);
        System.out.println("Third Quartile= "+thirdQuartile);

    }
    public static double median(List<Float> hights){
        if(hights.size()%2==0)
            return (hights.get(hights.size()/2)+hights.get((hights.size()/2)-1))/2;
        else
            return hights.get(hights.size()/2);
    }
}

