package com.example.hepsisurada.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hepsisurada.UserO;

import java.util.ArrayList;

public class userDBO {

    public ArrayList<UserO> getMyUsers(DBHelper vt) {
        ArrayList<UserO> users = new ArrayList<>();

        SQLiteDatabase dbx = vt.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM USERS ",null);

        while (c.moveToNext()) {
            UserO mUser = new UserO(
                    c.getString(c.getColumnIndexOrThrow("user_name")),
                    c.getString(c.getColumnIndexOrThrow("user_passwd")));
            mUser.setId(c.getInt(c.getColumnIndexOrThrow("user_id")));
            users.add(mUser);

        }
        dbx.close();
        return users;
    }

    public boolean LogIn(DBHelper vt, UserO User) {

        String tempName;
        SQLiteDatabase dbx = vt.getReadableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM USERS",null);

        while (c.moveToNext()) {
            tempName = c.getString(c.getColumnIndexOrThrow("user_name"));
            if (User.getName().equals(tempName)) {
                if (User.getPasswd().equals(c.getString(c.getColumnIndexOrThrow("user_passwd")))) {
                    return true;
                }
            }
        }


        return false;
    }

    public void Del(DBHelper vt, int id) {
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("USERS","user_id=?",new String[]{String.valueOf(id)});
        dbx.close();
    }

    public void Add(DBHelper vt, UserO user) {
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_name",user.getName());
        values.put("user_passwd",user.getPasswd());

        dbx.insertOrThrow("USERS",null,values);
        dbx.close();
    }

    public void Update(DBHelper vt, UserO user, int id) {
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_id",user.getId());
        values.put("user_name",user.getName());
        values.put("user_passwd",user.getPasswd());

        dbx.update("USERS",values,"user_id=?",new String[]{String.valueOf(id)});
        dbx.close();
    }
    public userDBO() {
    }
}
