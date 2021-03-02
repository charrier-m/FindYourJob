package fr.apside.matis.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetierDTO {

    @JsonProperty("libelle_metier")
    private String libelleMetier;

    public String getLibelleMetier() {
        return libelleMetier;
    }

    @Override
    public String toString() {
        return "MetierDTO{" + "libelleMetier='" + libelleMetier + '\'' +'}';
    }

    public void setLibelleMetier(String libelleMetier) {
        this.libelleMetier = libelleMetier;
    }
}

