package com.example.mycontactbank;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassContact implements Parcelable {

    private String name;
    private String account_number;
    private String account_type;
    private String balance;

    public ClassContact(String name, String accaount_number, String account_type, String balance) {
        this.name = name;
        this.account_number = accaount_number;
        this.account_type = account_type;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccaount_number() {
        return account_number;
    }

    public void setAccaount_number(String accaount_number) {
        this.account_number = accaount_number;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.account_number);
        dest.writeString(this.account_type);
        dest.writeString(this.balance);
    }

    protected ClassContact(Parcel in) {
        this.name = in.readString();
        this.account_number = in.readString();
        this.account_type = in.readString();
        this.balance = in.readString();
    }

    public static final Parcelable.Creator<ClassContact> CREATOR = new Parcelable.Creator<ClassContact>() {
        @Override
        public ClassContact createFromParcel(Parcel source) {
            return new ClassContact(source);
        }

        @Override
        public ClassContact[] newArray(int size) {
            return new ClassContact[size];
        }
    };
}
