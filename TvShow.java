public class TvShow {
    private String seriesID;
    private String seriesName;
    private int numberOfEpisodes;
    private int ageRestriction; // Field for age restriction

    //constructor for TvShow
    public TvShow(String seriesID, String seriesName, int numberOfEpisodes, int ageRestriction) {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.numberOfEpisodes = numberOfEpisodes;
        this.ageRestriction = ageRestriction;
    }

    // Getter for the series ID
    public String getSeriesID() {
        return seriesID;
    }

    // Getter for the series name
    public String getSeriesName() {
        return seriesName;
    }

    // Sets the series name
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    // Sets number of episodes
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    // Sets the age restriction
    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesID +
                ", Name: " + seriesName +
                ", Episodes: " + numberOfEpisodes +
                ", Age Restriction: " + ageRestriction + "+";
    }
}
