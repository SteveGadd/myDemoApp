package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;


import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App 
{
    //Checks if the sum of the first array plus index1 equals sum of the second array plus int2.
    public static boolean isSumOfRangeEqual(ArrayList<Integer> array1, ArrayList<Integer> array2, int index1, int index2){
        int sum1 = 0;int sum2=0;
        if(array1!=null && array2!=null && array1.size()>index2 && array2.size()>index2 && index2>=index1 && index1>=0){
            for(int i = index1;i<=index2;i++){
                sum1+=array1.get(i);
                sum2+=array1.get(i);
            }
            return sum1==sum2;
        }
        return false;
        
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
        while (sc1.hasNext()){
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList1.add(value);
        }
        System.out.println(inputList1);

        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext()){
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
        }
        System.out.println(inputList2);


        String input3 = req.queryParams("input3").replaceAll("\\s","");
        int index1 = Integer.parseInt(input3);

        String input4 = req.queryParams("input4").replaceAll("\\s","");
        int index2 = Integer.parseInt(input4);

        boolean result = App.isSumOfRangeEqual(inputList1, inputList2,index1,index2);

        Map map = new HashMap();
        map.put("result", result);
        sc1.close();
        sc2.close();
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return -1;
    }
}
