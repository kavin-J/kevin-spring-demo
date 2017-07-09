package com.kevin;

import com.kevin.annotation.InArray;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Jkevin
 * @create 2017-06-30
 **/
public class IssueOrderInput implements java.io.Serializable {

    @NotNull(message = "vin码必填")
    private String vin;

    @NotNull(message = "订单必填")
    private Long orderId;

    @NotNull(message = "订单开始时间(yyyy-MM-dd HH:mm:ss)必填")
    @Pattern(regexp = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$", message = "日期格式匹配不正确(yyyy-MM-dd HH:mm:ss)")
    private String startTime;

    @NotNull(message = "订单结束时间(yyyy-MM-dd HH:mm:ss)必填")
    private String endTime;

    @NotNull(message = "RFID号(8位)必填")
    @Length(min = 8, max = 8, message = "RFID号(8位)必填")
    private String rfid;

    @NotNull(message = "授权码(6位)必填")
    @Min(value = 100000, message = "授权码最小值 100000")
    @Max(value = 999999, message = "授权码最大值 999999")
    private Integer authCode;

    @InArray(range = {1, 2, 3})
    private Integer flag;

    private String appId;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public Integer getAuthCode() {
        return authCode;
    }

    public void setAuthCode(Integer authCode) {
        this.authCode = authCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "IssueOrderInput{" +
                "vin='" + vin + '\'' +
                ", orderId=" + orderId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rfid='" + rfid + '\'' +
                ", authCode=" + authCode +
                ", appId='" + appId + '\'' +
                '}';
    }
}
