package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
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
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
        Optional<Track> track_id = null;
        try {
            track_id = trackRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return track_id.get();
    }

    @Override
    public Track deleteTrackById(int id) {
        TrackService trackService = null;
        try {
            trackRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trackService.getTrackById(id);

    }


    @Override
    public Track updateById(int id, Track track) {
        try {
            Optional<Track> optionalTrack = trackRepository.findById(id);
            if (!optionalTrack.isPresent())
                return track;

            track.setId(id);
            trackRepository.save(track);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return track;

    }
}


