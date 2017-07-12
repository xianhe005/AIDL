package com.hxh.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.hxh.aidllib.aidl.HelloMsg;
import com.hxh.aidllib.aidl.IRemoteService;

/**
 * Created by HXH on 2017/7/11 0011.
 *
 */
public class RemoteService extends Service {

    private IBinder mBinder = new IRemoteService.Stub() {
        @Override
        public HelloMsg sayHello() throws RemoteException {
            System.out.println("服务端sayHello()");
            return new HelloMsg("msg from service at Thread " + Thread.currentThread().toString() + "\n" +
                    "tid is " + Thread.currentThread().getId() + "\n" +
                    "main thread id is " + getMainLooper().getThread().getId(), android.os.Process.myPid());
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("服务端onBind()" + mBinder.toString());
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("服务端onCreate()");
    }

    @Override
    public void onDestroy() {
        System.out.println("服务端onDestroy()");
        super.onDestroy();
    }
}
