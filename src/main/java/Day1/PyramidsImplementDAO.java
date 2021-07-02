package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidsImplementDAO implements PyramidsDAO{
    List<Pyramid> pyramids =new ArrayList();

    @Override
    public List<Pyramid> readPyramidsFromCSV(String fileName) {
        FileReader reader=null;
        try {
            File f=new File(fileName);
            reader = new FileReader(f);
            BufferedReader breader= new BufferedReader(reader);
            String line=breader.readLine();

            String data[];
            float height;
            do{
                line=breader.readLine();
                if(line!=null){
                    data=line.split(",");
                    //System.out.println("aaaaaaaaaaaaaaaa"+data[7]);
                    if (data[0]=="" || data[1]=="" || data[4]=="" || data[7]=="")
                        continue;


                    if (data[7].equals(""))
                        height=0.0f;
                    else
                        height=Float.parseFloat(data[7]);
                    Pyramid p=new Pyramid(data[0],data[1],data[4],height);

                    pyramids.add(p);
                }

            }while(line!=null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidsImplementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PyramidsImplementDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(PyramidsImplementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return pyramids;
    }

    @Override
    public Pyramid createPyramid(String[] metadata) {

        Pyramid p=new Pyramid("","","",0);
        return p;
    }

}

