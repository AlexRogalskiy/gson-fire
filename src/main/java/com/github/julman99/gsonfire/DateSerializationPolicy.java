package com.github.julman99.gsonfire;

import com.github.julman99.gsonfire.gson.DateUnixtimeSecondsTypeAdapter;
import com.github.julman99.gsonfire.gson.DateUnixtimeMillisTypeAdapter;
import com.github.julman99.gsonfire.gson.DateRFC3339TypeAdapter;
import com.github.julman99.gsonfire.gson.NullableTypeAdapter;
import com.google.gson.TypeAdapter;

import java.util.Date;
import java.util.TimeZone;

/**
 * @autor: julio
 */
public enum DateSerializationPolicy {

    /**
     * Serializes to/from unix timestamps in milliseconds and allows negative numbers
     */
    unixTimeMillis {
        @Override
        public TypeAdapter<Date> createTypeAdapter() {
            return new NullableTypeAdapter<Date>(
                new DateUnixtimeMillisTypeAdapter(true)
            );
        }
    },

    /**
     * Serializes to/from unix timestamps in seconds and allows negative numbers
     */
    unixTimeSeconds {
        @Override
        public TypeAdapter<Date> createTypeAdapter() {
            return new NullableTypeAdapter<Date>(
                new DateUnixtimeSecondsTypeAdapter(true)
            );
        }
    },

    /**
     * Serializes to/from unix timestamps in milliseconds and only allows positive numbers. If a negative unix timestamp is passed, it
     * will be serialized as null
     */
    unixTimePositiveMillis {
        @Override
        public TypeAdapter<Date> createTypeAdapter() {
            return new NullableTypeAdapter<Date>(
                new DateUnixtimeMillisTypeAdapter(false)
            );
        }
    },

    /**
     * Serializes to/from unix timestamps and only allows positive numbers. If a negative unix timestamp is passed, it
     * will be serialized as null
     */
    unixTimePositiveSeconds {
        @Override
        public TypeAdapter<Date> createTypeAdapter() {
            return new NullableTypeAdapter<Date>(
                new DateUnixtimeSecondsTypeAdapter(false)
            );
        }
    },

    rfc3339 {
        @Override
        public TypeAdapter<Date> createTypeAdapter() {
            return new NullableTypeAdapter<Date>(
                new DateRFC3339TypeAdapter(TimeZone.getDefault())
            );
        }
    };

    public abstract TypeAdapter<Date> createTypeAdapter();
}
