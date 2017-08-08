//package com.example.routing.Service;
//
//import com.example.routing.dao.FieldExecutive;
////import com.example.routing.dao.BikerEntry;
//import com.example.routing.dao.LocationEntry;
//import com.example.routing.dao.LocationEntryDTO;
////import com.example.routing.repositry.BikerRepositry;
//import com.example.routing.repositry.FieldExecutiveRepositry;
//import com.example.routing.repositry.LocationEntryRepositry;
//import org.joda.time.DateTime;
//import org.joda.time.Period;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
////import java.sql.Date;
//
//
/////**
//// * Created by ridha on 27/7/17.
//// */
//@Service
//public class MainService {
//    @Autowired
//    private FieldExecutiveRepositry userRepositry;
//    @Autowired
//    private LocationEntryRepositry locationRepositry;
//
//    public ResponseEntity insertUser(FieldExecutive user)
//    {
//        FieldExecutive checkUser=userRepositry.getUserByname(user.getUserName());
//        if(checkUser!=null){
//            return new ResponseEntity("{\"message\":\"userName already exist"+"\"}", HttpStatus.OK);
//        }
//        else if(user.getUserName().length()>40)
//        {
//            return new ResponseEntity("{\"message\":\"please enter user-name of length less than 40"+"\"}",HttpStatus.OK);
//        }
//        else if(user.getPassword().length()>40)
//        {
//            return new ResponseEntity("{\"message\" : \"please enter user-name of length less than 40"+"\"}",HttpStatus.OK);
//        }
//       userRepositry.save(user);
//        return new ResponseEntity("{\"message\" : \"welcome"+user.getName()+"\"}",HttpStatus.OK);
//    }
//    public ResponseEntity insertLocation(LocationEntryDTO le){
//        LocationEntry locationEntry =ConvertToEntity(le);
//        locationRepositry.save(locationEntry);
//        return new ResponseEntity("entry save", HttpStatus.ACCEPTED);
////        if(checkEntry(locationEntry) ){
////            locationRepositry.save(locationEntry);
////            return new ResponseEntity("entry save", HttpStatus.ACCEPTED);
////        }
////        return  new ResponseEntity("not valid",HttpStatus.BAD_REQUEST);
//    }
//    public LocationEntry ConvertToEntity(LocationEntryDTO locationEntryDTO)
//    {
//        LocationEntry locationEntry = new LocationEntry();
//        locationEntry.setLattitude(locationEntryDTO.getLattitude());
//        locationEntry.setLongitude(locationEntryDTO.getLongitude());
//        locationEntry.setId(locationEntryDTO.getId());
////        String dateTime = "11/15/2013 08:00:00";
//        DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
//// Parsing the date
//        DateTime jodatime = dtf.parseDateTime(locationEntryDTO.getDateTimeFormat());
//        locationEntry.setDateTimeFormat(jodatime);
//
//        return locationEntry;
//    }
//    public boolean checkEntry(LocationEntry newle)
//    {
//        PageRequest pageable = new PageRequest(0, 1);
//        LocationEntry le= (LocationEntry) locationRepositry.getLatestEntry(newle.getId(),pageable);
//        if(le==null) {
//            return true;
//        }
//
//        else{
//           double distance=  getDistance(le.getLattitude(),le.getLongitude(),newle.getLattitude(),newle.getLongitude());
//
//            Period p = new Period(newle.getDateTimeFormat(), le.getDateTimeFormat());
//            Double timetaken=p.getDays()*24+p.getHours()+ p.getMinutes()*1.0/60+p.getSeconds()/60/60;
//            Double speed=distance/timetaken;
//            if(speed>60)
//            {
//                return  false;
//            }
//            else
//            {
//                return true;
//            }
//
//        }
//    }
//    double getDistance(double lat1, double lon1, double lat2, double lon2) {
//        double  p = 0.017453292519943295;    // Math.PI / 180
//        double a = 0.5 - Math.cos((lat2 - lat1) * p)/2 +
//                Math.cos(lat1 * p) * Math.cos(lat2 * p) *
//                        (1 - Math.cos((lon2 - lon1) * p))/2;
//
//        return 12742 * Math.asin(Math.sqrt(a)); // 2 * R; R = 6371 km
//    }
//}
