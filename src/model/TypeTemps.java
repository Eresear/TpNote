package model;

public enum TypeTemps {
    TEMP_PLEIN,
    TEMP_PARTIEL;

    public String getType() {
        return name();
    }
}
