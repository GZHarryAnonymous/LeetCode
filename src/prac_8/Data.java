package prac_8;

import java.util.Arrays;
import java.util.List;

public class Data {
    private static List<PersonModel> list = null;
    static{
        PersonModel sam = new PersonModel("sam",18,Sex.m);
        PersonModel tom = new PersonModel("tom",23,Sex.m);
        PersonModel kitty = new PersonModel("kitty",19,Sex.f);
        PersonModel harry = new PersonModel("harry potter",25,Sex.m);
        PersonModel timi = new PersonModel("ti mi",17,Sex.f);
        PersonModel frank = new PersonModel("frank",24,Sex.m);
        list = Arrays.asList(sam,tom,kitty,harry,timi,frank);
    }
    public static List<PersonModel> getData(){
        return list;
    }
}
