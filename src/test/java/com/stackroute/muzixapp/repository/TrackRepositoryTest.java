package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TrackRepositoryTest {
    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(10);
        track.setName("Flashlight");
        track.setArtist("Jessie J");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(10,fetchTrack.getId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(34,"Harry","Harry123");
        trackRepository.save(track);
        Track fetchTrack= trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllTrack(){
        Track track1 = new Track(10,"Jenny","Johny12");
        Track track2 = new Track(11,"Jenny","Harry12");
        trackRepository.save(track1);
        trackRepository.save(track2);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Jenny",list.get(0).getName());
    }
    @Test
    public void testUpdateTrack() {
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        track.setArtist("Harry");
        trackRepository.save(track);
        Assert.assertEquals("Harry", fetchTrack.getArtist());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDeleteTrack() {
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals("Flashlight",fetchTrack.getName());
        trackRepository.deleteById(1);
        trackRepository.findById(track.getId()).get();
    }
}