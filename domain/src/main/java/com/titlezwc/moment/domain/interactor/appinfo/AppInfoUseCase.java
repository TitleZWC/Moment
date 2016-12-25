package com.titlezwc.moment.domain.interactor.appinfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TitleZWC on 2016/12/24.
 */

public final class AppInfoUseCase {
    private Map<String, Object> mMap = new HashMap<>();

    public boolean getBoolean(String key) {
        return Boolean.valueOf(String.valueOf(this.mMap.get(key)));
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return Boolean.valueOf(String.valueOf(localObject));
    }

    public double getDouble(String key) {
        return Double.valueOf(String.valueOf(this.mMap.get(key)));
    }

    public double getDouble(String key, double defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return Double.valueOf(String.valueOf(localObject));
    }

    public float getFloat(String key) {
        return Float.valueOf(String.valueOf(this.mMap.get(key)));
    }

    public float getFloat(String key, float defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return Float.valueOf(String.valueOf(localObject));
    }

    public int getInt(String key) {
        return Integer.valueOf(String.valueOf(this.mMap.get(key)));
    }

    public int getInt(String key, int defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return Integer.valueOf(String.valueOf(localObject));
    }

    public long getLong(String key) {
        return Long.valueOf(String.valueOf(this.mMap.get(key)));
    }

    public long getLong(String key, long defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return Long.valueOf(String.valueOf(localObject));
    }

    public Object getObject(String key) {
        return this.mMap.get(key);
    }

    public Object getObject(String key, Object defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return localObject;
    }

    public String getString(String key) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return null;
        return String.valueOf(localObject);
    }

    public String getString(String key, String defaultValue) {
        Object localObject = this.mMap.get(key);
        if (localObject == null)
            return defaultValue;
        return String.valueOf(localObject);
    }

    public void setBoolean(String key, boolean value) {
        this.mMap.put(key, value);
    }

    public void setDouble(String key, double value) {
        this.mMap.put(key, value);
    }

    public void setFloat(String key, float value) {
        this.mMap.put(key, value);
    }

    public void setInt(String key, int value) {
        this.mMap.put(key, value);
    }

    public void setLong(String key, long value) {
        this.mMap.put(key, value);
    }

    public void setObject(String key, Object value) {
        this.mMap.put(key, value);
    }

    public void setString(String key, String value) {
        this.mMap.put(key, value);
    }
}
