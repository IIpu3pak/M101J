package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 28.05.2015.
 */
public class FruitPicker {
    public static void main(String[] args) {

        final Configuration cfgFreemarker = new Configuration();
        cfgFreemarker.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {


            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template fruitPickerTemplate = cfgFreemarker.getTemplate("fruitPicker.ftl");

                    Map<String, Object> templatePapameters = new HashMap<>();
                    templatePapameters.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

                    fruitPickerTemplate.process(templatePapameters, writer);

                    System.out.println(writer);
                    return writer;
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                    return null;
                }

            }
        });

        Spark.post(new Route("/favorite_fruit") {
            @Override
            public Object handle(final Request request, final Response response) {
                String fruit = request.queryParams("fruit");
                if(fruit == null){
                    return "Why don't you pick one?";
                }else{
                    return "Your favorite fruit is " + fruit;
                }
            }
        });
    }
}
