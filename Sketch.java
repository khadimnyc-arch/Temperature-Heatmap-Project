import processing.core.PApplet;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Sketch extends PApplet {
    ArrayList<DayRecord> records = new ArrayList<DayRecord>();
    int max = -99999;
    int min = 100000;
    int i = 0;
    
    public void settings() {
        size(600, 600);
        
    }

    public void setup() {
        background(220);
        //Month space int space space int 
        try {
            Scanner sc = new Scanner(new File("temps.txt"));
            
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                
                String month = line.substring(0,3);

                int space1 = line.indexOf(" ");
                int space2 = line.indexOf(" ", space1+1);

                String dayStr = line.substring(space1+1,space2);
                int day = Integer.parseInt(dayStr);

                int lastSpace = line.lastIndexOf(" ");
                String tempStr = line.substring(lastSpace+1, line.length()-2);
                int temp = Integer.parseInt(tempStr);

                DayRecord rec = new DayRecord(month, day, temp);
                records.add(rec);
                //determine max and minTemp you only need 2 do this once so it should be in set up
                int t = rec.getTemp();
                if(t>max) 
                    max=temp;
                if(t<min) 
                    min=t;

            }
            sc.close();
            //loop out change positions 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void draw() {
        background(220);
        drawHeatmap();


        
    }

    //helper method for month suff 
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    int getMonthrow(String month){
        int i = 0;
        //i less than 12 motnhs doesn't equal to month
        while(i<12 && !months[i].equals(month)){
            i+=1;
        }
    return i;
    }
    
    public void drawHeatmap(){
        int size = 20;
        //collums then rows
        for(int i = 0; i<records.size(); i++){
            DayRecord r = records.get(i);
            
            int row = getMonthrow(r.getMonth());
            int col = r.getDay()-1;

            fill(r.getColor(min,max));
            rect(col*size,row*size, size,size);
        }
    }

    
}
