//package com.example.routing.controller;
//
////import com.example.routing.Service.MainService;
//import com.example.routing.Service.MainService;
//import com.example.routing.dao.FieldExecutive;
//import com.example.routing.dao.LocationEntryDTO;
////import com.example.routing.repositry.BikerRepositry;
//import com.example.routing.repositry.FieldExecutiveRepositry;
//import com.example.routing.repositry.LocationEntryRepositry;
//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by ridha on 27/7/17.
// */
//@RestController
//@RequestMapping(value = "/register")
//public class mainController {
//    @Autowired
//    FieldExecutiveRepositry executiveRepositry;
//    @Autowired
//    MainService mainservice;
//    @Autowired
//    LocationEntryRepositry locationRepositry;
//    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
//    public ResponseEntity registerUser(@RequestBody FieldExecutive newuser)
//
//    {
//        DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
//        System.out.println(dt);
//        if(newuser==null)
//        {
//            return new ResponseEntity("user can not be empty", HttpStatus.OK);
//        }
//        return mainservice.insertUser(newuser);
//
//    }
//    @RequestMapping(value="/getFieldExecutive",method = RequestMethod.POST)
//    public ResponseEntity getUser(@RequestParam("id") Long id){
//
//        return new ResponseEntity(executiveRepositry.getUserByid(id),HttpStatus.OK);
//    }
//    @RequestMapping(value="/getLocationEntry",method =RequestMethod.POST)
//    public ResponseEntity getLocation(@RequestParam("id") Long id){
//        return new ResponseEntity(locationRepositry.getLocation(id),HttpStatus.OK);
//
//    }
//    @RequestMapping(value="/locationEntry",method =RequestMethod.POST)
//    public ResponseEntity locationEntry(@RequestBody LocationEntryDTO locationEntryDTO) {
//        if (locationEntryDTO == null) {
//            return new ResponseEntity("It can not be empty", HttpStatus.OK);
//        }
//
//        return mainservice.insertLocation(locationEntryDTO);
//    }
//
//    @RequestMapping(value="/test",method =RequestMethod.GET)
//    public ResponseEntity test(@RequestBody LocationEntryDTO locationEntryDTO){
//        return new ResponseEntity(DateTime.now().withTimeAtStartOfDay(),HttpStatus.ACCEPTED);
//    }
//}
