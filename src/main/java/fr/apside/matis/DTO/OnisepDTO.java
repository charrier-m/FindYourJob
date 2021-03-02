package fr.apside.matis.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.apside.matis.DTO.MetierDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OnisepDTO {

    List<MetierDTO> results;

    public List<MetierDTO> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "OnisepDTO{" +"results=" + results +'}';
    }

    public void setResults(List<MetierDTO> results) {
        this.results = results;
    }
}
