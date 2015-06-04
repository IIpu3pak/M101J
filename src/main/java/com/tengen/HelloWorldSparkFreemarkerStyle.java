package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 28.05.2015.
 */
public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {

        final Configuration cfgFreemarker = new Configuration();
        cfgFreemarker.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");

        Spark.get(new Route("/") {


            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = cfgFreemarker.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<>();
                    helloMap.put("name", "Freemarker");
                    helloMap.put("userName", "Vlad Orlov");

                    helloTemplate.process(helloMap, writer);

                    System.out.println(writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
    }
}
