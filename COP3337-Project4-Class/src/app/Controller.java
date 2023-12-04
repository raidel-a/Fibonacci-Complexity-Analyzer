//=============================================================================
// PROGRAMMER: Raidel Almeida
// PANTHER ID: 3932877
//
// CLASS: COP3337 Programming II
// SECTION: RVBB 1238
// SEMESTER: Fall 2023
// CLASSTIME: Remote 7PM Tuesday's
//
// Project: Project 4
// 
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
//                own and that none of it is the work of any other person.
//=============================================================================

/*
Remember, I will not except late assignments. So please check the due date of the assignment.
IMPORTANT, you must have the File Header shown below with your information entered on the 
file at contains the project main method. If you do not have this header with your 
information, I will take 40% off your assignment grade.
*/

package app;

import analyze.DataAnalyzer;
import util.StopWatch;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Controller {

    
    public static void main(String[] args) {
        
        // create a DataAnalyzer object named dataAnalyzer
        // YOUR CODE HERE
        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        // find the first 35 fibonacci numbers
        // until you get it all working set the for-loop to loop 8 times to save time
        
        for(int n = 1; n<=35; n++){
            
            // create a Stack object named stack
            // YOUR CODE HERE
            Stack<String> stack = new Stack<>();

            // create a StopWatch object named stopWatch
            // YOUR CODE HERE
            StopWatch stopWatch = new StopWatch();

            // start the stopWatch
            // YOUR CODE HERE
            stopWatch.start();

            // find the fibonacci index at n and save the value in fibValue
            // also pass the stack object so it can record the recursive method calls
            
            // HINT
            // int fibValue = YOUR CODE HERE
            int fibValue = fib(n, stack);
            
            // create a map object <String, Integer> name map that is
            // constructed using a TreeMap constructor
            // HINT
            // Map<String, Integer> map YOUR CODE HERE
            Map<String, Integer> map = new TreeMap<>();
            
            
            // figure out here how  many times a fib(n) was called and store this 
            // information in the map with fib(m) as the key and the times it was called 
            // as the value for this key
            // example
            // map("fib(5)", 2832);
            // map("fib(6)", 1230);
            //....
            
            // hint use
            /// for(int i=1; i<=n; i++){
                 // YOU NEED SOME CODE HERE
            for(int i = 1; i<= n; i++) {
                Iterator<String> stackIterator = stack.iterator();
                int count = 0;


                 //while(stackIterator.hasNext()){
                   // YOU NEED SOME CODE HERE
                   // if statement would be helpful
                //}//end while
        
                // YOU NEED SOME CODE HERE
           //} //end for

                while(stackIterator.hasNext()) {
                    String call = stackIterator.next();
                    if (call.equals("fib(" + i + ")")) {
                        count++; // Increment count if the current stack element is fib(i)
                    }
                }

                // Update the map with the count for fib(i)
                map.put("fib(" + i + ")", count);
            }
            
    
            // stop the stopWatch object
            //YOUR CODE HERE
            stopWatch.stop();
            
            // create an ExecutionInfo object name executionInfo
            // with correct inputs for the constructor
            // hint use stopWatch.getElapsedTime() for the last input
            
            // ExecutionInfo executionInfo YOUR CODE HERE
            ExecutionInfo executionInfo = new ExecutionInfo(map, n, fibValue, stopWatch.getElapsedTime());


            // add the executionInfo object to the dataAnalyzer arraylist
            // YOUR CODE HERE
            dataAnalyzer.getData().add(executionInfo);
            for (ExecutionInfo info : dataAnalyzer.getData()) {
                info.displayInfo();
            }

            //dataAnalyzer.findGrowthRate();

        }//end for
        
   
        //----------------------------------
        
        
        // run the displayInfo method on each executionInfo object
        // within the dataAnalyzer arraylist using an enhanced for-loop
        // YOUR CODE HERE

        for(ExecutionInfo executionInfo : dataAnalyzer.getData()){
            executionInfo.displayInfo();
        }

        // call the dataAnalyzer findGrowthRate method
        // YOUR CODE HERE

        dataAnalyzer.findGrowthRate();

    }
    
    public static int fib(int n, Stack stack){
        
        // update the stack with the needed information
        // YOUR CODE HERE
        stack.push("fib(" + n + ")");

        // base cases
        if(n == 1 ) {
            return 1;
        }
        if(n == 2 ) {
            return 2;
        }
        
        return fib(n-1,stack) +  fib(n-2,stack);
    }
    
}
