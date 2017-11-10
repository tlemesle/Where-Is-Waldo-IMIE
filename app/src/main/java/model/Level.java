package model;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Level implements Parcelable{

    private int id;
    //private Drawable img;
    private int solutionX;
    private int solutionY;

    public Level(int id, int solutionX, int solutionY) {
        this.id = id;
        this.solutionX = solutionX;
        this.solutionY = solutionY;
    }

    protected Level(Parcel in) {
        id = in.readInt();
        solutionX = in.readInt();
        solutionY = in.readInt();
    }

    public static final Creator<Level> CREATOR = new Creator<Level>() {
        @Override
        public Level createFromParcel(Parcel in) {
            return new Level(in);
        }

        @Override
        public Level[] newArray(int size) {
            return new Level[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }*/

    public int getSolutionX() {
        return solutionX;
    }

    public void setSolutionX(int solutionX) {
        this.solutionX = solutionX;
    }

    public int getSolutionY() {
        return solutionY;
    }

    public void setSolutionY(int solutionY) {
        this.solutionY = solutionY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        //Bitmap bitmap = (Bitmap)((BitmapDrawable) img).getBitmap();
        //parcel.writeParcelable(bitmap,i);
        parcel.writeInt(solutionX);
        parcel.writeInt(solutionY);
    }
}
