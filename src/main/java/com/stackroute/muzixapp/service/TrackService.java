package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);

    public List<Track> getAllTracks();

    public Track getTrackById(int id);

    public Track deleteTrackById(int id);

    public Track updateById(int id, Track track);
}
