package com.example.mylianxi.mondel.util;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;




public class Utils {
    public static <T> void getData(String url, final CallBackHome callBackHome, final Class<T> t) {
        RequestParams params = new RequestParams();
        params.setUri(url);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                T t1 = gson.fromJson(result, t);
                callBackHome.callBack(t1);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public interface CallBackHome<T> {
        void callBack(T t);
    }
}

