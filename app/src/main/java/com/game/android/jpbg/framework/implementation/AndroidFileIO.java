package com.game.android.jpbg.framework.implementation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.preference.PreferenceManager;

import com.game.android.jpbg.framework.FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AndroidFileIO implements FileIO {
	private Context context;
    private AssetManager assets;
    private Resources resources;
    private String externalStoragePath;

    public AndroidFileIO(Context context) {
        this.context = context;
        this.assets = context.getAssets();
        this.resources = context.getResources();
        this.externalStoragePath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator;

    }

    public InputStream readAsset(int id) throws IOException{
        return readAsset(resources.getString(id));
    }

    @Override
    public InputStream readAsset(String file) throws IOException {
        return assets.open(file);
    }

    @Override
    public InputStream readFile(String file) throws IOException {
        return new FileInputStream(externalStoragePath + file);
    }

    @Override
    public OutputStream writeFile(String file) throws IOException {
        return new FileOutputStream(externalStoragePath + file);
    }
    
    public SharedPreferences getSharedPref() {
    	return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
