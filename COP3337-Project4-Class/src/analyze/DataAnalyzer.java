package analyze;

import app.Controller;
import app.ExecutionInfo;

import java.util.ArrayList;


public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         // your output format must match mine
         // the format is Index: "x"      FibValue: "x"     Calls: "x        Exponent: "x.xxx"
         // for each index
         // the exponent value is e^x = total method class   
         // you need to find the x... do not overthink it use the Math class
         // YOU PUT YOUR CODE HERE
        for(ExecutionInfo info : data ) {
        int fibIndex = info.getFibIndex();
        int fibValue = info.getFibValue();
        double totalCalls = info.getTotalMethodCalls();
        double exponent = Math.log(totalCalls);

        System.out.printf("Index %-4d FibValue: %-10d Calls: %-10.0f Exponent: %-10.3f\n",
                fibIndex, fibValue, totalCalls, exponent);



        }
        Controller.infoHeader();
    }

}// end class
