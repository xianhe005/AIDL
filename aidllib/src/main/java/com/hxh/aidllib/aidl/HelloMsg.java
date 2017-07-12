package com.hxh.aidllib.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HXH on 2017/7/11 0011.
 *
 */

public class HelloMsg implements Parcelable {
    private String msg;
    private int pid;

    public HelloMsg(String msg, int pid) {
        this.msg = msg;
        this.pid = pid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.msg);
        dest.writeInt(this.pid);
    }

    protected HelloMsg(Parcel in) {
        this.msg = in.readString();
        this.pid = in.readInt();
    }

    public static final Creator<HelloMsg> CREATOR = new Creator<HelloMsg>() {
        @Override
        public HelloMsg createFromParcel(Parcel source) {
            return new HelloMsg(source);
        }

        @Override
        public HelloMsg[] newArray(int size) {
            return new HelloMsg[size];
        }
    };
}
