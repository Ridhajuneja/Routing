package com.example.routing.Service;

import com.example.routing.dao.Biker;
import com.example.routing.dao.BikerLocation;
import com.example.routing.dao.LocationEntry;
import com.example.routing.dao.LocationEntryDTO;
import com.example.routing.repositry.BikerLocationRepositry;
import com.example.routing.repositry.BikerRepositry;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ridha on 1/8/17.
 */
@Service
public class ProjectService {
    @Autowired
    private BikerRepositry userRepositry;
    @Autowired
    private BikerLocationRepositry locationRepositry;

    public ResponseEntity insertBiker(Biker user)
    {
        Biker checkUser=userRepositry.getUserByname(user.getUserName());
        if(checkUser!=null){
            return new ResponseEntity("{\"message\":\"userName already exist"+"\"}", HttpStatus.OK);
        }
        else if(user.getUserName().length()>40)
        {
            return new ResponseEntity("{\"message\":\"please enter user-name of length less than 40"+"\"}",HttpStatus.OK);
        }
        else if(user.getPassword().length()>40)
        {
            return new ResponseEntity("{\"message\" : \"please enter user-name of length less than 40"+"\"}",HttpStatus.OK);
        }
        userRepositry.save(user);
        return new ResponseEntity("{\"message\" : \"welcome"+user.getName()+"\"}",HttpStatus.OK);
    }




    public ResponseEntity insertBikerLocation(LocationEntryDTO le){
        int z=0;
        for (Double x:le.getLattitude())
        {
            BikerLocation locationEntry =ConvertToEntity(le,z);
            if(checkEntry(locationEntry) ) {
                locationRepositry.save(locationEntry);
            }
            z++;

        }


            return new ResponseEntity("tracks saved", HttpStatus.ACCEPTED);

    }



    public BikerLocation ConvertToEntity(LocationEntryDTO locationEntryDTO,int z)
    {
        BikerLocation locationEntry = new BikerLocation();
        locationEntry.setLattitude(locationEntryDTO.getLattitude().get(z));
        locationEntry.setLongitude(locationEntryDTO.getLongitude().get(z));
       Biker b= userRepositry.getUserByid(locationEntryDTO.getId());
        locationEntry.setBiker(b);
//        String dateTime = "11/15/2013 08:00:00";
        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
// Parsing the date
        DateTime jodatime = dtf.parseDateTime(locationEntryDTO.getDateTimeFormat());
        locationEntry.setDateTimeFormat(jodatime);

        return locationEntry;
    }



    public boolean checkEntry(BikerLocation newle)
    {
        PageRequest pageable = new PageRequest(0, 1);
        List BikerList=locationRepositry.getLatestEntry(newle.getBiker().getId(),pageable).getContent();
        if(BikerList.size()==1) {
            BikerLocation le = (BikerLocation)locationRepositry.getLatestEntry(newle.getBiker().getId(), pageable).getContent().get(0);
            double distance=  getDistance(newle.getLattitude(),le.getLongitude(),le.getLattitude(),newle.getLongitude());

            Period p = new Period(le.getDateTimeFormat(), newle.getDateTimeFormat());
            Double timetaken=p.getDays()*24+p.getHours()+ p.getMinutes()*1.0/60+p.getSeconds()/60/60;
            Double speed=distance/timetaken;
            if(timetaken>1)
            {
                return true;
            }
            if(speed>60||timetaken<0)
            {
                return  false;
            }
            else
            {
                return true;
            }

        }
        else  {
            return true;
        }


    }



    double getDistance(double lat1, double lon1, double lat2, double lon2) {
//        double  p = 0.017453292519943295;    // Math.PI / 180
//        double a = 0.5 - Math.cos((lat2 - lat1) * p)/2 +
//                Math.cos(lat1 * p) * Math.cos(lat2 * p) *
//                        (1 - Math.cos((lon2 - lon1) * p))/2;
//
//        return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = (double) (earthRadius * c)*1.0/1000;
        return dist;

    }
  public   List<Double> userLocationTrack(String name,String date)
    {
        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
// Parsing the date
        DateTime jodatime = dtf.parseDateTime(date);
        List<BikerLocation> bikerLocations=locationRepositry.getCoordinates(name,jodatime);
        List<Double> list = new ArrayList<>();
        for (BikerLocation b:bikerLocations) {
          list.add(b.getLongitude());
          list.add(b.getLattitude());

        }


return  list;

    }
}
