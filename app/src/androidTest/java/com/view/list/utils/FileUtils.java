package com.view.list.utils;

import android.support.test.espresso.core.internal.deps.guava.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class FileUtils {
    public static String getResponseFromFile(Class clazz, String filename) {
        String body = null;
        InputStream inputStream = null;

        try {
            inputStream = clazz.getResourceAsStream(filename);
            body = new String(ByteStreams.toByteArray(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return body;
    }
}
