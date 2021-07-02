package Day1;

import java.io.*;

public class Day1_Exercise1 {
    public static void main(String args[]) throws IOException {

        InputStreamReader reader= new InputStreamReader(System.in);
        BufferedReader breader= new BufferedReader(reader);
        FileWriter writer=new FileWriter("src/main/resources/data/output.txt");
        BufferedWriter bwriter= new BufferedWriter(writer);

        String data;
        do{
            System.out.println("Enter Data: ");
            data=breader.readLine();
            System.out.println("Data is: "+data);
            bwriter.write(data);
            bwriter.newLine();
        }while(!data.equalsIgnoreCase("stop"));

        bwriter.close();
        writer.close();
        breader.close();
        reader.close();


    }
}
