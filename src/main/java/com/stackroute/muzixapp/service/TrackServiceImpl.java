package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    private TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track already exists!");
        }
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> musixList = trackRepository.findAll();
        if (musixList.isEmpty()) {
            throw new TrackNotFoundException("Tracks not found");
        }
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        Optional<Track> trackId = trackRepository.findById(id);
        if (trackId.isPresent()) {
            Optional<Track> track_id = trackRepository.findById(id);
            return track_id.get();
        } else {
            throw new TrackNotFoundException("Track not found!");
        }

    }

    @Override
    public List<Track> deleteById(int id) throws TrackNotFoundException {

        Optional<Track> track_id = trackRepository.findById(id);
        if (track_id.isEmpty()) {
            throw new TrackNotFoundException("track not found");
        }
        trackRepository.deleteById(id);
        return trackRepository.findAll();

    }


    @Override
    public Track updateById(int id, Track track) {
        Optional<Track> optionalTrack = trackRepository.findById(id);
        if (!optionalTrack.isPresent())
            return track;

        track.setId(id);
        trackRepository.save(track);
        return track;


    }
}
