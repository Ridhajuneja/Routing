package com.example.routing.controller;

import com.example.routing.Service.ProjectService;
import com.example.routing.dao.Biker;
import com.example.routing.dao.LocationEntryDTO;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ridha on 1/8/17.
 */
@RestController
@RequestMapping(value = "/Register")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody Biker newuser)

    {
        DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
        System.out.println(dt);
        if(newuser==null)
        {
            return new ResponseEntity("user can not be empty", HttpStatus.OK);
        }
        return projectService.insertBiker(newuser);

    }

    @RequestMapping(value="/locationEntry",method =RequestMethod.POST)
    public ResponseEntity locationEntry(@RequestBody LocationEntryDTO locationEntryDTO) {
        if (locationEntryDTO == null) {
            return new ResponseEntity("It can not be empty", HttpStatus.OK);
        }

        return projectService.insertBikerLocation(locationEntryDTO);
    }
    @RequestMapping(value = "/locationLogs",method=RequestMethod.POST)
    public ResponseEntity userLocationTrack(@RequestParam("name") String name, @RequestParam("date") String date)
    {
        return new ResponseEntity(projectService.userLocationTrack(name,date),HttpStatus.ACCEPTED);
    }


    }

