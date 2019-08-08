package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks() throws TrackNotFoundException;

    public Track getTrackById(int id) throws TrackNotFoundException;

    public List<Track> deleteById(int id) throws TrackNotFoundException;

    public Track updateById(int id, Track track) throws TrackNotFoundException;
}
