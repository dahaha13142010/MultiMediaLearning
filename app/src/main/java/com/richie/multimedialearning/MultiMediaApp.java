package com.richie.multimedialearning;

import android.app.Application;
import android.content.Context;

import com.richie.multimedialearning.utils.FileUtils;
import com.richie.multimedialearning.utils.ThreadHelper;

/**
 * @author Richie on 2018.10.17
 */
public class MultiMediaApp extends Application {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        // 将 assets 下面的所有文件拷贝到外部存储私有目录下
        ThreadHelper.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                FileUtils.copyAssetsToFileDir(sContext);
            }
        });
    }

}
