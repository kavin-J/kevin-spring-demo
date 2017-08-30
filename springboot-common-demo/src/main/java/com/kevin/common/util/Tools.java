package com.kevin.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * @author jianghaiyang
 * @create 2017-08-11
 **/
public class Tools {
    public static void main(String[] args) {
        try {
            BufferedReader bufr = new BufferedReader(new FileReader("F:/1.json"));
            BufferedWriter bufw = new BufferedWriter(new FileWriter("F:/1.csv"));
            String line;
            bufw.write("cshsId,cshsNumber,cshsElectricMileage,cshsMileage,cshsDir,cshsCircular,cshsOil,cshsEngineT," +
                    "cshsCar,cshsLongitude,cshsSaving,cshsCurrentTime,cshsHost,cshsMoData,cshsOrder,cshsCsq,cshsCompres,cshsPtc," +
                    "cshsTemperature,cshsSpeed,values,cshsCharging,cshsLatitude,cshsEndurance,cshsLock,cshsFan,cshsMotor," +
                    "cshsPower,cshsObdMile,cshsWarn,cshsAddTime,cshsRented,cshsEvBattery,cshsLight,cshsKey,cshsFuelMileage," +
                    "cshsEngine,cshsAccess,suffix,cshsDoor");
            bufw.newLine();// 写入一个行分隔符
            bufw.flush();
            //另外开辟一个缓冲区，存储读取的一行数据，返回包含该行内容的字符串，不包含换行符，如果已到达流末尾，则返回【 null】
            while ((line = bufr.readLine()) != null) {
                JSONObject json = JSONObject.parseObject(line);
                JSONObject json2 = new JSONObject();
                json2.put("cshsId", json.get("cshsId"));
                json2.put("cshsNumber", json.get("cshsNumber"));
                json2.put("cshsElectricMileage", json.get("cshsElectricMileage"));
                json2.put("cshsMileage", json.get("cshsMileage"));
                json2.put("cshsDir", json.get("cshsDir"));
                json2.put("cshsCircular", json.get("cshsCircular"));
                json2.put("cshsOil", json.get("cshsOil"));
                json2.put("cshsEngineT", json.get("cshsEngineT"));
                json2.put("cshsCar", json.get("cshsCar"));
                json2.put("cshsLongitude", json.get("cshsLongitude"));
                json2.put("cshsSaving", json.get("cshsSaving"));
                json2.put("cshsCurrentTime", JSONObject.parseObject(JSONObject.toJSONString(json.get("cshsCurrentTime"))).get("$numberLong"));
                json2.put("cshsHost", json.get("cshsHost"));
                json2.put("cshsMoData", json.get("cshsMoData"));
                json2.put("cshsOrder", json.get("cshsOrder"));
                json2.put("cshsCsq", json.get("cshsCsq"));
                json2.put("cshsCompres", json.get("cshsCompres"));
                json2.put("cshsPtc", json.get("cshsPtc"));
                json2.put("cshsTemperature", json.get("cshsTemperature"));
                json2.put("cshsSpeed", json.get("cshsSpeed"));
                json2.put("values", "");
                json2.put("cshsCharging", json.get("cshsCharging"));
                json2.put("cshsLatitude", json.get("cshsLatitude"));
                json2.put("cshsEndurance", json.get("cshsEndurance"));
                json2.put("cshsLock", json.get("cshsLock"));
                json2.put("cshsFan", json.get("cshsFan"));
                json2.put("cshsMotor", json.get("cshsMotor"));
                json2.put("cshsPower", json.get("cshsPower"));
                json2.put("cshsObdMile", json.get("cshsObdMile"));
                json2.put("cshsWarn", json.get("cshsWarn"));
                json2.put("cshsAddTime", JSONObject.parseObject(JSONObject.toJSONString(json.get("cshsAddTime"))).get("$numberLong"));
                json2.put("cshsRented", json.get("cshsRented"));
                json2.put("cshsEvBattery", json.get("cshsEvBattery"));
                json2.put("cshsLight", json.get("cshsLight"));
                json2.put("cshsKey", json.get("cshsKey"));
                json2.put("cshsFuelMileage", json.get("cshsFuelMileage"));
                json2.put("cshsEngine", json.get("cshsEngine"));
                json2.put("cshsAccess", json.get("cshsAccess"));
                json2.put("suffix", json.get("suffix"));
                json2.put("cshsDoor", json.get("cshsDoor"));

                State temp = JSON.parseObject(json2.toJSONString(),State.class);

                bufw.write(temp.toString());
                bufw.newLine();// 写入一个行分隔符
                bufw.flush();
            }
            bufr.close();
            bufw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
