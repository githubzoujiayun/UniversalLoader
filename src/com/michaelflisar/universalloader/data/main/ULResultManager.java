
package com.michaelflisar.universalloader.data.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ULResultManager
{
    private Map<ULKey, ULResult> mResults;
    private Set<ULKey> mUndelivered;

    public ULResultManager()
    {
        mResults = new HashMap<ULKey, ULResult>();
        mUndelivered = new HashSet<ULKey>();
    }

    public void put(ULKey key, ULResult result)
    {
        mResults.put(key, result);
        mUndelivered.add(key);
    }

    public ULResult get(ULKey key)
    {
        return mResults.get(key);
    }

    public boolean setDelivered(ULKey key)
    {
        return mUndelivered.remove(key);
    }

    public void clear()
    {
        mUndelivered.clear();
        mResults.clear();
    }

    public void clear(ULKey key)
    {
        mUndelivered.remove(key);
        mResults.remove(key);
    }

    public Iterator<Entry<ULKey, ULResult>> iterator()
    {
        return mResults.entrySet().iterator();
    }
}
