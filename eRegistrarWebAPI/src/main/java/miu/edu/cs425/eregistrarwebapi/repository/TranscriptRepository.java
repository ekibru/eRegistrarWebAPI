package miu.edu.cs425.eregistrarwebapi.repository;

import miu.edu.cs425.eregistrarwebapi.enitity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript,Long> {
}
