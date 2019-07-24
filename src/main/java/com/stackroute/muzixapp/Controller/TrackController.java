package com.stackroute.muzixapp.Controller;
import com.stackroute.muzixapp.Domain.Track;
import com.stackroute.muzixapp.Repository.TrackRepository;
import com.stackroute.muzixapp.Service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
    public TrackService trackService;
    public TrackRepository trackRepository;
    public TrackController(TrackService trackService)
    {
        this.trackService=trackService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)
    {
        ResponseEntity responseEntity;

            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("success", HttpStatus.CREATED);

        return responseEntity;
    }
    @GetMapping("track")
    public  ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id)
    {
        trackService.deleteTrackById(id);
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/delete")
    public ResponseEntity<?> deleteAllTrack()
    {
     trackService.deleteAllTrack();
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }
    @PutMapping("track/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") int id,@RequestBody Track track)
    {
        trackService.updateById(id,track);
        return new ResponseEntity<String>("updated", HttpStatus.CREATED);
    }
}
