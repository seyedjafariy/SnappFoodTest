package com.worldsnas.snappfoodtest.servermodel;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.lang.reflect.Type;

@AutoValue
public abstract class BaseModel<T, E> {

    @Json(name="code")
    public abstract int code();

    @Nullable
    @Json(name="message")
    public abstract String message();

    @Json(name="detail")
    public abstract T detail();

    @Json(name="extra")
    public abstract E extra();

    public static <V, E> BaseModel<V, E> createBase(int code, String message, V detail, E extra){
        return new AutoValue_BaseModel<>(code, message, detail, extra);
    }

    public static <T, E> JsonAdapter<BaseModel<T, E>> jsonAdapter(Moshi moshi, Type[] types) {
        return new AutoValue_BaseModel.MoshiJsonAdapter<>(moshi, types);
    }
}
