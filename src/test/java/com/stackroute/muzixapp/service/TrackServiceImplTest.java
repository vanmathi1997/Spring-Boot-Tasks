package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceImplTest {
    Track track;

    //Create a mock for UserRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("John");
        track.setId(101);
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        assertEquals(track, savedTrack);
        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);

    }

    @Test
    public void testGetAllTrack() throws TrackNotFoundException {

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        assertEquals(list, tracklist);
    }

    @Test
    public void deleteTrackTestSuccess() throws TrackAlreadyExistsException {

        trackRepository.delete(track);
        boolean deletedTrack = trackRepository.existsById(20);
        assertEquals(false, deletedTrack);
    }

    @Test
    public void updateTrackTest() throws TrackNotFoundException, TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track updateTrack = null;
        updateTrack = trackService.saveTrack(track);
        assertEquals(track, updateTrack);
    }
}