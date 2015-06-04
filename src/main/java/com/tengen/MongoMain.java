package com.tengen;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.util.Set;

/**
 * Created by Администратор on 01.06.2015.
 */
public class MongoMain {

    public static void main(String[] args) {
        Mongo mongoSvr = new Mongo("localhost", 27017);
        DB mongoDB = mongoSvr.getDB("m101");
        Set<String> dbCollections = mongoDB.getCollectionNames();

        for(String colName:dbCollections){
            System.out.println(colName);
        }
        DBCollection hw1= mongoDB.getCollection("hw1");
        DBObject currentObject = hw1.findOne();
        System.out.println(currentObject);

    }
}
