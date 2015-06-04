package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Администратор on 28.05.2015.
 */
public class SparkRoutes {

    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                return "Hello world\n";
            }
        });

        Spark.get(new Route("/test") {
            @Override
            public Object handle(final Request request, final Response response) {
                return "This is a test page\n";
            }
        });

        Spark.get(new Route("/echo/:things") {
            @Override
            public Object handle(final Request request, final Response response) {
                return request.params(":things");
            }
        });
    }
}
