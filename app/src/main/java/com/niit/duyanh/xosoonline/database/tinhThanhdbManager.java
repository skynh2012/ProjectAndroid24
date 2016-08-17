package com.niit.duyanh.xosoonline.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 09/08/2016.
 */
public class tinhThanhdbManager {
    private static final String DB_NAME = "xoso";
    private static final String TB_NAME = "tinhthanh";
    private static final int DB_VERSION = 3;

    private SQLiteDatabase database;

    public tinhThanhdbManager(Context context) {
        OpenHelper helper = new OpenHelper(context);
        database = helper.getWritableDatabase();
    }

    public class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE IF NOT EXISTS " + TB_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,matinh Text,tentinh Text)";
            db.execSQL(query); // create table
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS hocsinh"); //drop table
            onCreate(db);
        }
    }

    public void insertTinhThanh(String matinh, String tentinh) {
        ContentValues values = new ContentValues();
        values.put("matinh", matinh);
        values.put("tentinh", tentinh);
        database.insertOrThrow(TB_NAME, null, values);
    }

    public void updateTinhThanh(String matinh, String tentinh, int id) {
        ContentValues values = new ContentValues();
        values.put("matinh", matinh);
        values.put("tentinh", tentinh);
        database.update(TB_NAME, values, "_id = " + id, null);
    }

    public void deleteTinhThanh(int id) {
        database.delete(TB_NAME, "_id = " + id, null);
    }

    public Cursor getListTinhThanh() {
        return database.query(TB_NAME, null, null, null, null, null, null);
    }

    public Cursor getTenTinh(String matinh) {
        return database.query(TB_NAME, null, "matinh = ?", new String[]{matinh.trim()}, null, null, null);
    }

    public void insertDataTinhThanh() {
        insertTinhThanh("mb", "Miền Bắc");
        insertTinhThanh("ag", "An Giang");
        insertTinhThanh("bl", "Bạc Liêu");
        insertTinhThanh("btr", "Bến tre");
        insertTinhThanh("bd", "Bình Dương");
        insertTinhThanh("bp", "Bình Phước");
        insertTinhThanh("bth", "Bình Thuận");
        insertTinhThanh("bdi", "Bình Định");
        insertTinhThanh("cm", "Cà Mau");
        insertTinhThanh("ct", "Cần Thơ");
        insertTinhThanh("gl", "Gia Lai");
        insertTinhThanh("hg", "Hậu Giang");
        insertTinhThanh("kh", "Khánh Hòa");
        insertTinhThanh("kg", "Kiên Giang");
        insertTinhThanh("kt", "Kon Tum");
        insertTinhThanh("la", "Long An");
        insertTinhThanh("nt", "Ninh Thuận");
        insertTinhThanh("py", "Phú Yên");
        insertTinhThanh("qb", "Quảng Bình");
        insertTinhThanh("qn", "Quảng Nam");
        insertTinhThanh("qng", "Quảng Ngãi");
        insertTinhThanh("qt", "Quảng Trị");
        insertTinhThanh("st", "Sóc Trăng");
        insertTinhThanh("tn", "Tây Ninh");
        insertTinhThanh("tt4", "Thần Tài");
        insertTinhThanh("hue", "Thừa Thiên Huế");
        insertTinhThanh("tg", "Tiền Giang");
        insertTinhThanh("hcm", "TP Hồ Chí Minh");
        insertTinhThanh("tv", "Trà Vinh");
        insertTinhThanh("vl", "Vĩnh Long");
        insertTinhThanh("vt", "Vũng Tàu");
        insertTinhThanh("dl", "Đà Lạt");
        insertTinhThanh("dng", "Đà Nẵng");
        insertTinhThanh("dlc", "Đắc Lắc");
        insertTinhThanh("dno", "Đắc Nông");
        insertTinhThanh("dn", "Đồng Nai");
        insertTinhThanh("dt", "Đồng Tháp");
    }
}
