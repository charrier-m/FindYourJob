package fr.apside.matis.DTO;

public class UserQualitiesDTO {

    private boolean agriculture, social, mathematiques, commerce, medical, manager, informatique;

    public boolean isAgriculture() {
        return agriculture;
    }

    public void setAgriculture(boolean agriculture) {
        this.agriculture = agriculture;
    }

    public boolean isSocial() {
        return social;
    }

    public void setSocial(boolean social) {
        this.social = social;
    }

    public boolean isMathematiques() {
        return mathematiques;
    }

    public void setMathematiques(boolean mathematiques) {
        this.mathematiques = mathematiques;
    }

    public boolean isCommerce() {
        return commerce;
    }

    public void setCommerce(boolean commerce) {
        this.commerce = commerce;
    }

    public boolean isMedical() {
        return medical;
    }

    public void setMedical(boolean medical) {
        this.medical = medical;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isInformatique() {
        return informatique;
    }

    public void setInformatique(boolean informatique) {
        this.informatique = informatique;
    }
}

