import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import model.HospitalGeoData;

import model.HospitalGeoResponse;
import model.HospitalGeoResponseParent;
import model.Location;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tommy on 2017/6/4.
 */
public class ConvertGeoData {
    public static void main(String[] args) throws IOException {


        int j=0;
        File folder = new File("I:\\醫療相關資料\\crawlerGeoData\\twypage.com\\");
        File[] listOfFiles = folder.listFiles();
        Set<HospitalGeoResponse> hospitalGeoResponseSet=new HashSet<HospitalGeoResponse>();


        for (File file : listOfFiles) {

                try {
                    ObjectMapper mapper = new ObjectMapper();
                    HospitalGeoResponse hospitalGeoData = mapper.readValue(file, HospitalGeoResponse.class);
                    List<Double> doubles = new ArrayList<Double>();
                    hospitalGeoData.setAddress(hospitalGeoData.getAddress().replace("地　　址： ", ""));
                    hospitalGeoData.setCategory(hospitalGeoData.getCategory().replace("科　　別： ", ""));
                    hospitalGeoData.setHosNo(hospitalGeoData.getHosNo().replace("編　　號： ", ""));
                    hospitalGeoData.setPhone(hospitalGeoData.getPhone().replace("電　　話： ", ""));
                    hospitalGeoData.setServiceItem(hospitalGeoData.getServiceItem().replace("服務項目： ",""));
                    doubles.add(Double.parseDouble(hospitalGeoData.getLongitude()));
                    doubles.add(Double.parseDouble(hospitalGeoData.getLatitude()));
                    Location location=new Location();
                    location.setCoordinates(doubles);
                    location.setType("Point");
                    hospitalGeoData.setLocation(location);

                    // System.out.println(hospitalGeoData.getAddress());

                    // System.out.println(hospitalGeoData.getTimeTable());
                    int i = 1;
                    for (String str : hospitalGeoData.getTimeTable()) {
                        if (i <= 4) {
                            Document doc = Jsoup.parse(str);
                            //   System.out.println(doc.body().html());
                            List<String> stringList = new ArrayList<String>();
                            for (String strT : doc.body().html().split(" ")) {
                                if (!"".equals(strT.trim())) {
                                    if (strT.equals("&nbsp;")) {
                                        strT = "是";
                                    }
                                    //  System.out.println(strT);
                                    stringList.add(strT);

                                }
                            }

                            if (i == 1) {
                                hospitalGeoData.setWeekDay(stringList);
                            } else if (i == 2) {
                                hospitalGeoData.setMorning(stringList);
                            } else if (i == 3) {
                                hospitalGeoData.setAfternoo(stringList);
                            } else {
                                hospitalGeoData.setNight(stringList);
                            }

                        }
                        i++;
                    }
                    hospitalGeoResponseSet.add(hospitalGeoData);
                } catch (UnrecognizedPropertyException e) {
                   // e.printStackTrace();
                    ObjectMapper mapper = new ObjectMapper();
                    HospitalGeoResponseParent hospitalGeoDataParent = mapper.readValue(file, HospitalGeoResponseParent.class);
                    HospitalGeoResponse hospitalGeoData = hospitalGeoDataParent.getHospitalGeoResponse();
                    List<Double> doubles = new ArrayList<Double>();
                    hospitalGeoData.setAddress(hospitalGeoData.getAddress().replace("地　　址： ", ""));
                    hospitalGeoData.setCategory(hospitalGeoData.getCategory().replace("科　　別： ", ""));
                    hospitalGeoData.setHosNo(hospitalGeoData.getHosNo().replace("編　　號： ", ""));
                    hospitalGeoData.setPhone(hospitalGeoData.getPhone().replace("電　　話： ", ""));
                    hospitalGeoData.setServiceItem(hospitalGeoData.getServiceItem().replace("服務項目： ",""));
                    doubles.add(Double.parseDouble(hospitalGeoData.getLongitude()));
                    doubles.add(Double.parseDouble(hospitalGeoData.getLatitude()));
                    Location location=new Location();
                    location.setCoordinates(doubles);
                    location.setType("Point");
                    hospitalGeoData.setLocation(location);
                    //  System.out.println(hospitalGeoData.getAddress());
                    // System.out.println(hospitalGeoData.getTimeTable());
                    int i = 1;
                    for (String str : hospitalGeoData.getTimeTable()) {
                        if (i <= 4) {
                            Document doc = Jsoup.parse(str);
                            //   System.out.println(doc.body().html());
                            List<String> stringList = new ArrayList<String>();
                            for (String strT : doc.body().html().split(" ")) {
                                if (!"".equals(strT.trim())) {
                                    if (strT.equals("&nbsp;") || strT.equals("V")) {
                                        strT = "是";
                                    }
                                     //   System.out.println(strT);
                                    stringList.add(strT);
                                }
                            }

                            if (i == 1) {
                                hospitalGeoData.setWeekDay(stringList);
                            } else if (i == 2) {
                                hospitalGeoData.setMorning(stringList);
                            } else if (i == 3) {
                                hospitalGeoData.setAfternoo(stringList);
                            } else {
                                hospitalGeoData.setNight(stringList);
                            }
                        }
                        i++;
                    }
                    hospitalGeoResponseSet.add(hospitalGeoData);
                }

        }


        System.out.println(hospitalGeoResponseSet.size());
        List<HospitalGeoResponse> hospitalGeoResponseList=new ArrayList<HospitalGeoResponse>();
        for(HospitalGeoResponse hospitalGeoResponse:hospitalGeoResponseSet){
            hospitalGeoResponseList.add(hospitalGeoResponse);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("I:\\醫療相關資料\\crawlerGeoData\\list.txt"),hospitalGeoResponseList);
    }

}
