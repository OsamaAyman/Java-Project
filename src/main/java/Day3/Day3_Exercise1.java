package Day3;

import joinery.DataFrame;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Day3_Exercise1 {
    static Table titanicDataTablesaw;
    static DataFrame<Object> titanicDataJoinery;
    static String dataPath = "src/main/resources/data/titanic.csv";
    public static void main(String args[]) throws IOException {
        titanicDataTablesaw = Table.read().csv (dataPath);
        titanicDataJoinery=DataFrame.readCsv(dataPath);
        //getting the Structure of the data
        System.out.println ("=======================Structure of data by tablesaw============================");
        String structure = titanicDataTablesaw.structure ().toString();
        System.out.println(structure);
        System.in.read();

        System.out.println ("=======================summary of the data by tablesaw============================");
        //getting the summary of the data by tablesaw
        String summaryTablesaw =titanicDataTablesaw.summary().toString();
        System.out.println(summaryTablesaw);
        System.in.read();
        System.out.println ("=======================summary of the data by joinery============================");
        //getting the summary of the data by joinery

        System.out.println(titanicDataJoinery.describe().toString());
        System.out.println ("=====================================================================================");

        Table tableSaw1 = titanicDataTablesaw.first(5);
        Table tableSaw2 = titanicDataTablesaw.last(50);
        DataFrame<Object> dataFrame1= titanicDataJoinery.retain(0,1,2,3);
        DataFrame<Object> dataFrame2=titanicDataJoinery.retain(2,6,7,8,9);
        DataFrame<Object> dataFrame3=dataFrame1.join(dataFrame2);
        System.out.println(dataFrame3.head());
        //DataFrame<Object> df=dataFrame1.merge(dataFrame2);
        System.out.println(addColumnsToData(titanicDataTablesaw).structure());



    }
    public static Table addColumnsToData(Table data) {
        int rowCount = data.rowCount ();
        List<String> stringlist = new ArrayList<>();
        int[] intlist=new int[rowCount];
        List<LocalDate> dateList = new ArrayList<LocalDate> ();
        for (int i = 0; i < rowCount; i++) {
            intlist[i]=i+1;
            stringlist.add("row:"+i);
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }

        IntColumn intColumn = IntColumn.create("INTEGER COLUMN", intlist);
        data.insertColumn (data.columnCount (), intColumn);
        StringColumn stringColumn = StringColumn.create("STRING COLUMN", stringlist);
        data.insertColumn (data.columnCount (), stringColumn);
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }

}

