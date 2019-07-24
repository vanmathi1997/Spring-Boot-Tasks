package com.stackroute.muzixapp.Repository;

import com.stackroute.muzixapp.Domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

}
