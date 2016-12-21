package com.tudose.mihai.testdatasource.data;

import java.util.Random;

/**
 * Created by Utente on 02/12/2016.
 */

public class Contact {
    public long mId;
    public String mName;
    public String mSurname;
    public  Contact(String aName,String aSurname){
        mName=aName;
        mSurname=aSurname;

    }
    public Contact(){

    }
    public Contact(long aId,String aName,String aSurname){
        mId=aId;
        mName=aName;
        mSurname=aSurname;

    }
    public static Contact CreateRandomContacts(){
        Random vRandom=new Random();
        String vName="Cordenos"+vRandom.nextInt();
        String vSurname="Shiet"+vRandom.nextInt();
        return new  Contact(vName,vSurname);
    }

}
