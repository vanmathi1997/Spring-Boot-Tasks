package com.stackroute.muzixapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.service.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest

public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackService trackService;
    @InjectMocks
    private TrackController trackController;
    private List<Track> list=null;

    @Before
    public void setUp(){
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(this.trackController).build();
    track = new Track();
    track.setId(1);
    track.setName("Baby");
    track.setArtist("Jst Beiber");
    list=new ArrayList<>();
    list.add(track);
    }
    @Test
    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }


    @Test
    public void testSaveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenThrow(TrackAlreadyExistsException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }
    //Test for getAllTracks

    @Test
    public void teshGetAllTracks() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    //Test for DeleteTrackById
    @Test
    public void testDeleteMusic() throws Exception {
        when(trackService.deleteById(1)).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/muzix/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print());
    }

    //Test for UpdateById
    @Test
    public void testUpdateById() throws Exception {
        Track track = new Track(1,"Hello", "Arya Stark");
        when(trackService.getTrackById(track.getId()));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/track/{id}", track.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(track)))
                .andExpect(status().isCreated());
    }




    private String asJsonString(final Object object) {
        try
        {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }


}