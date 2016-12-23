package com.titlezwc.moment.domain.interactor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TitleZWC on 2016/12/24.
 */

public class UseCaseParams {
    private Map<String, Object> mMap = new HashMap();

    public boolean getBoolean(String paramString)
    {
        return Boolean.valueOf(String.valueOf(this.mMap.get(paramString))).booleanValue();
    }

    public boolean getBoolean(String paramString, boolean paramBoolean)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramBoolean;
        return Boolean.valueOf(String.valueOf(localObject)).booleanValue();
    }

    public double getDouble(String paramString)
    {
        return Double.valueOf(String.valueOf(this.mMap.get(paramString))).doubleValue();
    }

    public double getDouble(String paramString, double paramDouble)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramDouble;
        return Double.valueOf(String.valueOf(localObject)).doubleValue();
    }

    public float getFloat(String paramString)
    {
        return Float.valueOf(String.valueOf(this.mMap.get(paramString))).floatValue();
    }

    public float getFloat(String paramString, float paramFloat)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramFloat;
        return Float.valueOf(String.valueOf(localObject)).floatValue();
    }

    public int getInt(String paramString)
    {
        return Integer.valueOf(String.valueOf(this.mMap.get(paramString))).intValue();
    }

    public int getInt(String paramString, int paramInt)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramInt;
        return Integer.valueOf(String.valueOf(localObject)).intValue();
    }

    public long getLong(String paramString)
    {
        return Long.valueOf(String.valueOf(this.mMap.get(paramString))).longValue();
    }

    public long getLong(String paramString, long paramLong)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramLong;
        return Long.valueOf(String.valueOf(localObject)).longValue();
    }

    public Object getObject(String paramString)
    {
        return this.mMap.get(paramString);
    }

    public Object getObject(String paramString, Object paramObject)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return paramObject;
        return localObject;
    }

    public String getString(String paramString)
    {
        Object localObject = this.mMap.get(paramString);
        if (localObject == null)
            return null;
        return String.valueOf(localObject);
    }

    public String getString(String paramString1, String paramString2)
    {
        Object localObject = this.mMap.get(paramString1);
        if (localObject == null)
            return paramString2;
        return String.valueOf(localObject);
    }

    public void setBoolean(String paramString, boolean paramBoolean)
    {
        this.mMap.put(paramString, Boolean.valueOf(paramBoolean));
    }

    public void setDouble(String paramString, double paramDouble)
    {
        this.mMap.put(paramString, Double.valueOf(paramDouble));
    }

    public void setFloat(String paramString, float paramFloat)
    {
        this.mMap.put(paramString, Float.valueOf(paramFloat));
    }

    public void setInt(String paramString, int paramInt)
    {
        this.mMap.put(paramString, Integer.valueOf(paramInt));
    }

    public void setLong(String paramString, long paramLong)
    {
        this.mMap.put(paramString, Long.valueOf(paramLong));
    }

    public void setObject(String paramString, Object paramObject)
    {
        this.mMap.put(paramString, paramObject);
    }

    public void setString(String paramString1, String paramString2)
    {
        this.mMap.put(paramString1, paramString2);
    }
}