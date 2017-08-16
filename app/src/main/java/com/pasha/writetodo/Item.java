package com.pasha.writetodo;


public class Item {

    //private variables
    int _id;
    String _name;
    String _something;

    // Empty constructor
    public Item(){

    }
    // constructor
    public Item(int id, String name, String _something){
        this._id = id;
        this._name = name;
        this._something = _something;
    }

    // constructor
    public Item(String name, String _something){
        this._name = name;
        this._something = _something;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getSomething(){
        return this._something;
    }

    // setting phone number
    public void setSomething(String something){
        this._something = something;
    }

}
