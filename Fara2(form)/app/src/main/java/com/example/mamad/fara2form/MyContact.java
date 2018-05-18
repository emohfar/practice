package com.example.mamad.fara2form;

/**
 * Created by MAMAD on 5/17/2018.
 */

public class MyContact {
    private String name;
    private String phoneNumber;
    private int id;

    public MyContact(String name, String phoneNumber, int id){
        this.name= name;
        this.phoneNumber= phoneNumber;
        this.id=id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    } //******* when ever it wanted to string Mycontact show name
}
