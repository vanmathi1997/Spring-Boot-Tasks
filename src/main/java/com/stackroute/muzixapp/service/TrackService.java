package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track);
    List<Track> getAllTracks();
     void deleteTrackById(int id);
    void deleteAllTrack();
    boolean updateById(int id,Track track);
    List<Track> trackByName(String trackName);
}
