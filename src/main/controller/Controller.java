package controller;


import model.Adress;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.AdressService;
import service.UserService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Controller {

    public static void main(String[] args) throws Exception {

        UserService userService = new UserService();
        AdressService adressService = new AdressService();
        int count =0;
        try {
            JSONParser parser=new JSONParser();
            Object obj = parser.parse(new FileReader("D:\\JavaLearning\\ExampleBD\\contacts.json"));
            JSONArray array = (JSONArray)parser.parse(obj.toString());

            for (Object o : array) {
                 count++;
                 userService.add((JSONObject) o);
                 adressService.add((JSONObject) o ,count);
            }

            for (User user : userService.getMany()) {
                user.getInfo();
                System.out.println(" ");
                Adress adress = adressService.getOne(user.getId());
                adress.getInfo();
            }


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
