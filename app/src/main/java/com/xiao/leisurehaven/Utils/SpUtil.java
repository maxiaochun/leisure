package com.xiao.leisurehaven.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hasee on 2016/4/28.
 */
public class SpUtil {
    private static SharedPreferences sp ;


    /**
     * 写入String 类型的标志至sp中
     * @param ctx 上下文
     * @param key 存储节点名称
     * @param value 默认值
     */
    public static void putString(Context ctx,String key,String value){
        if (sp == null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        sp.edit().putString(key,value).commit();
    }
    /**
     * 从sp中读取String 类型的标志
     * @param ctx 上下文
     * @param key 存储节点名称
     * @param defvalue 没有此节点默认值
     */
    public static String getString(Context ctx,String key,String defvalue){
        if (sp == null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        //返回此节点读取到的结果
        return sp.getString(key,defvalue);

    }
    /**
     * 写入String 类型的标志至sp中
     * @param ctx 上下文
     * @param key 存储节点名称
     * @param value 默认值
     */
    public static void putBoolean(Context ctx, String key, boolean value) {
//        存储节点文件名称，读写方式
        if (sp == null) {
            sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }
    /**
     * 从sp中读取String 类型的标志
     * @param ctx 上下文
     * @param key 存储节点名称
     * @param value 没有此节点默认值
     */
    public static boolean getBoolean(Context ctx,String key, boolean defvalue){
        if (sp == null){
            sp = ctx.getSharedPreferences("config",Context.MODE_PRIVATE);
        }
        //返回此节点读取到的结果
        return sp.getBoolean(key,defvalue);

    }
}
