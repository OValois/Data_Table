/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubaj.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;

/**
 *
 * @author ovaloismtz
 */
public class Converter {
    
   JSONArray array = new JSONArray();
    public JSONArray FileConverter(File FileName) throws FileNotFoundException, JSONException {
        String[] values = null;
        boolean r = true;
        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject = null;
        Scanner inputStream = new Scanner(FileName);
        String[] ss = null;
        while (inputStream.hasNext()) {
            String data = inputStream.nextLine();

            if (r) {
                ss = data.split(",");
                if (ss.length > 1) {
                    r = false;
                }
            } else {

                String[] sfs = data.split(",");
                for (int i = 0; i < sfs.length; i++) {
                    map.put(ss[i], sfs[i]);

                }
                    array.put(map);
            }
        }
        return array;
    }
}
