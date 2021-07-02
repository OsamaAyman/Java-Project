package Day4;

import org.apache.commons.csv.CSVFormat;
import smile.classification.RandomForest;
import smile.data.DataFrame;
import smile.data.formula.Formula;
import smile.data.measure.NominalScale;
import smile.data.vector.IntVector;
import smile.io.Read;
import smile.plot.swing.Histogram;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class SmileDemoEDA {
    static String trainPath = "src/main/resources/data/titanic_train.csv";
    static String testPath = "src/main/resources/data/titanic_test.csv";
    public static void main(String[] args) throws IOException {

        DataFrame trainData = readCSV (trainPath);
        System.out.println (trainData.structure ());
        System.in.read();
        System.out.println (trainData.summary ());
        System.in.read();
        trainData = trainData.merge (IntVector.of ("Gender", encodeCategory (trainData, "Sex")));
        trainData = trainData.merge (IntVector.of ("PClassValues", encodeCategory (trainData, "Pclass")));
        System.out.println ("=======Encoding Non Numeric Data==============");
        System.out.println (trainData.structure ());
        System.in.read();
        System.out.println ("=======Dropping the Name, Pclass, and Sex Columns==============");
        trainData = trainData.drop ("Name");
        trainData=trainData.drop("Pclass");
        trainData=trainData.drop("Sex");
        System.out.println (trainData.structure ());
        System.in.read();
        System.out.println (trainData.summary ());
        System.in.read();
        trainData = trainData.omitNullRows ();
        System.out.println ("=======After Omitting null Rows==============");
        System.out.println (trainData.summary ());
        System.in.read();
        System.out.println ("=======Start of Explaratory Data Analysis==============");
        eda (trainData);
        RandomForest model = RandomForest.fit(Formula.lhs("Survived"), trainData);
        System.out.println("feature importance:");
        System.out.println(Arrays.toString(model.importance()));
        System.out.println(model.metrics ());
        //TODO load test data to validate model


    }

    public static int[] encodeCategory(DataFrame df, String columnName) {
        String[] values = df.stringVector (columnName).distinct ().toArray(new String[]{});
        int[] columnFactorized = df.stringVector (columnName).factorize (new NominalScale(values)).toIntArray ();
        return columnFactorized;
    }
    private static void eda(DataFrame titanic) {
        titanic.summary ();
        DataFrame titanicSurvived = DataFrame.of (titanic.stream ().filter (t -> t.get ("Survived").equals (1)));
        DataFrame titanicNotSurvived = DataFrame.of (titanic.stream ().filter (t -> t.get ("Survived").equals (0)));
        titanicNotSurvived.omitNullRows ().summary ();
        titanicSurvived = titanicSurvived.omitNullRows ();
        titanicSurvived.summary ();
        int size = titanicSurvived.size ();
        System.out.println (size);
        Double averageAge = titanicSurvived.stream ()
                .mapToDouble (t -> t.isNullAt ("Age") ? 0.0 : t.getDouble ("Age"))
                .average ()
                .orElse (0);
        System.out.println (averageAge.intValue ());
        Map map = titanicSurvived.stream ()
                .collect (Collectors.groupingBy (t -> Double.valueOf (t.getDouble ("Age")).intValue (), Collectors.counting ()));

        double[] breaks = ((Collection<Integer>) map.keySet ())
                .stream ()
                .mapToDouble (l -> Double.valueOf (l))
                .toArray ();

        int[] valuesInt = ((Collection<Long>) map.values ())
                .stream ().mapToInt (i -> i.intValue ())
                .toArray ();

        try {
            Histogram.of (titanicSurvived.doubleVector ("Age").toDoubleArray (), 15, false)
                    .canvas ().setAxisLabels ("Age", "Count")
                    .setTitle ("Age frequencies among surviving passengers")
                    .window ();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            Histogram.of (titanicSurvived.intVector ("PClassValues").toIntArray (), 4, true)
                    .canvas ().setAxisLabels ("Classes", "Count")
                    .setTitle ("Pclass values frequencies among surviving passengers")
                    .window ();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //Histogram.of(values, map.size(), false).canvas().window();
        System.out.println (titanicSurvived.schema ());
        //////////////////////////////////////////////////////////////////////////

    }
    public static DataFrame readCSV(String path) {
        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader ();
        DataFrame df = null;
        try {
            df = Read.csv (path, format);
            System.out.println(df.summary ());
            df = df.select ("Name", "Pclass", "Age", "Sex", "Survived");
            System.out.println(df.summary ());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace ();
        }
        return df;


    }
}
