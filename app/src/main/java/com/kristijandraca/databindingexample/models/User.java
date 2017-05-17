package com.kristijandraca.databindingexample.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

public class User implements Parcelable {

    /**
     * Sample data
     *
     * _id : 591b828d5153a39f4bb1201a
     * premium : true
     * balance : 3359.93
     * age : 28
     * firstName : Dunn
     * lastName : Ramirez
     * company : Suremax
     */

    private String _id;
    private boolean premium;
    private float balance;
    private int age;
    private String firstName;
    private String lastName;
    @Nullable
    private String company;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getCompany() {
        return company;
    }

    public void setCompany(@Nullable String company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeByte(this.premium ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.balance);
        dest.writeInt(this.age);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.company);
    }

    public User() {
    }

    protected User(Parcel in) {
        this._id = in.readString();
        this.premium = in.readByte() != 0;
        this.balance = in.readFloat();
        this.age = in.readInt();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.company = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
