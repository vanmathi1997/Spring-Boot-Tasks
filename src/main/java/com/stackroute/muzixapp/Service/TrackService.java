package com.stackroute.muzixapp.Service;

import com.stackroute.muzixapp.Domain.Track;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track);
    List<Track> getAllTracks();
     void deleteTrackById(int id);
    void deleteAllTrack();
    boolean updateById(int id,Track track);
}
