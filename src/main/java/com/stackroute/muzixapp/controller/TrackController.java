package com.stackroute.muzixapp.controller;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
    private TrackService trackService;
    public TrackController(TrackService trackService)
    {
        this.trackService=trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;

        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("success", HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id") int id)
    {
        Track track=null;
        try{
            track=trackService.getTrackById(id);
        }catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(track,HttpStatus.OK);
    }
    @GetMapping("tracks")
    public  ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id)
    {
        Track track=null;
        try {
            trackService.deleteTrackById(id);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Track>(track,HttpStatus.OK);
    }
    @DeleteMapping("tracks/delete")
    public ResponseEntity<?> deleteAllTracks()
    {
        ResponseEntity responseEntity;
        try {
            trackService.deleteAllTracks();
            responseEntity= new ResponseEntity<>("Deleted",HttpStatus.OK);
        }catch (Exception e)
        {
            responseEntity= new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }
    @PutMapping("track/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") int id,@RequestBody Track track)
    {
        try {
            trackService.updateById(id, track);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("updated", HttpStatus.CREATED);
    }
}
