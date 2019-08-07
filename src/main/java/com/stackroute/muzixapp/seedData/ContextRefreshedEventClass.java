package com.stackroute.muzixapp.seedData;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class ContextRefreshedEventClass implements ApplicationListener<ContextRefreshedEvent> {
    private TrackRepository trackRepository;

    @Value("${track.1.id}")
    private int id1;
    @Value("${track.1.name}")
    private String trackName1;
    @Value("${track.1.trackComments}")
    private String comment1;
    @Value("${track.2.id}")
    private int id2;
    @Value("${track.2.trackName}")
    private String trackName2;
    @Value("${track.2.trackComments}")
    private String comment2;


    @Override
    public void onApplicationEvent(org.springframework.context.event.ContextRefreshedEvent contextRefreshedEvent) {
        trackRepository.save(new Track(1, trackName1, comment1));
        trackRepository.save(new Track(2, trackName2, comment2));
    }
}
