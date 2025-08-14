public class TvShow extends SeriesItem {
    private int numberOfEpisodes;

    public TvShow(String seriesID, String seriesName, int numberOfEpisodes, int ageRestriction) {
        super(seriesID, seriesName, ageRestriction);
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesID +
                "\nSeries Name: " + seriesName +
                "\nSeries Type: TV Show" +
                "\nSeries Age Restriction: " + ageRestriction +
                "\nNumber of Episodes: " + numberOfEpisodes + "\n";
    }
}
