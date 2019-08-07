package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track) throws TrackAlreadyExistsException;
    List<Track> getAllTracks();
     void deleteTrackById(int id);
    void deleteAllTrack();
    boolean updateById(int id,Track track)throws TrackNotFoundException;
    List<Track> trackByName(String trackName);
}
