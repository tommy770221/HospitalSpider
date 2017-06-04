package model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.List;

/**
 * Created by Tommy on 2017/6/4.
 */
@TargetUrl("http://twypage.com/sd-*-H-*.html")
public class HospitalGeoData {

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[1]/text()")
    private String hosNo;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[2]/text()")
    private String address;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[3]/text()")
    private String phone;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[4]/a/text()")
    private String city;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[5]/text()")
    private String category;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[6]/text()")
    private String serviceItem;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/section/p/b[7]/a/text()")
    private List<String> hosCategory;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[2]/table/tbody/tr")
    private List<String> timeTable;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[1]/meta[1]/@content")
    private String name;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[1]/meta[3]/@content")
    private String telephone;

    @ExtractBy("//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[1]/meta[4]/@content")
    private String hasMap;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[1]/meta[2]/@content")
    private String legalName;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[1]/div/meta[1]/@content")
    private String streetAddress;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[2]/div/meta[1]/@content")
    private String latitude;

    @ExtractBy(value = "//*[@id=\"form1\"]/div[2]/div/article/div[2]/div[1]/div[2]/div/meta[2]/@content")
    private String longitude;

    public String getHosNo() {
        return hosNo;
    }

    public void setHosNo(String hosNo) {
        this.hosNo = hosNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServiceItem() {
        return serviceItem;
    }

    public void setServiceItem(String serviceItem) {
        this.serviceItem = serviceItem;
    }

    public List<String> getHosCategory() {
        return hosCategory;
    }

    public void setHosCategory(List<String> hosCategory) {
        this.hosCategory = hosCategory;
    }

    public List<String> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(List<String> timeTable) {
        this.timeTable = timeTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHasMap() {
        return hasMap;
    }

    public void setHasMap(String hasMap) {
        this.hasMap = hasMap;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
