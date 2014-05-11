package com.evervolv.news;

import org.json.JSONObject;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

public class NewsEntry implements Parcelable {

    public static final String COLUMN_ID       = "_id";
    /* Fields populated by server manifest */
    public static final String COLUMN_DATE     = "date";
    public static final String COLUMN_TITLE     = "title";
    public static final String COLUMN_MESSAGE  = "message";
    /* Devices that the entry will be shown for, blank for all */
    public static final String COLUMN_DEVICE   = "device";
    public static final String COLUMN_IMAGE_URL   = "image_url";

    static final String[] ALL_COLUMNS = {
        COLUMN_ID,
        COLUMN_DATE,
        COLUMN_TITLE,
        COLUMN_MESSAGE,
        COLUMN_DEVICE,
        COLUMN_IMAGE_URL
    };

    static final String TABLE_TEMPLATE = " (" +
            COLUMN_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_DATE      + " TEXT, " +
            COLUMN_TITLE     + " TEXT, " +
            COLUMN_MESSAGE   + " TEXT, " +
            COLUMN_DEVICE    + " TEXT, " +
            COLUMN_IMAGE_URL + " TEXT);";

    private long id;
    private String date;
    private String title;
    private String message;
    private String device;
    private String imgUrl;

    public NewsEntry() {
        /* pass */
    }

    public NewsEntry(JSONObject json) {
        this.date     = json.optString(COLUMN_DATE);
        this.title     = json.optString(COLUMN_TITLE);
        this.message   = json.optString(COLUMN_MESSAGE);
        this.device = json.optString(COLUMN_DEVICE);
        this.imgUrl = json.optString(COLUMN_IMAGE_URL);
    }

    public NewsEntry(Cursor cursor) {
        this.id       = cursor.getLong(0);
        this.date     = cursor.getString(1);
        this.title     = cursor.getString(2);
        this.message   = cursor.getString(3);
        this.device = cursor.getString(4);
        this.imgUrl = cursor.getString(5);
    }

    private NewsEntry(Parcel in) {
        this.id = in.readLong();
        this.date = in.readString();
        this.title = in.readString();
        this.message = in.readString();
        this.device = in.readString();
        this.imgUrl = in.readString();
    }

    public static final Parcelable.Creator<NewsEntry> CREATOR =
            new Parcelable.Creator<NewsEntry>() {
        public NewsEntry createFromParcel(Parcel in) {
            return new NewsEntry(in);
        }

        public NewsEntry[] newArray(int size) {
            return new NewsEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(id);
        out.writeString(date);
        out.writeString(title);
        out.writeString(message);
        out.writeString(device);
        out.writeString(imgUrl);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getImageUrl() {
        return imgUrl;
    }

    public void setImageUrl(String url) {
        this.imgUrl = url;
    }

}
