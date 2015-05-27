package com.tengen;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 27.05.2015.
 */
public class HelloWorldFreemarkerStyle {

    public static void main(String[] args) {

        Configuration cfgFreemarker = new Configuration();
        cfgFreemarker.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {
            Template helloTemplate = cfgFreemarker.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<>();
            helloMap.put("name", "Freemarker");
            helloMap.put("userName", "Vlad Orlov");

            helloTemplate.process(helloMap, writer);

            System.out.println(writer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
