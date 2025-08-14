public class Movie extends SeriesItem {
    private int runTimeInMinutes;

    public Movie(String seriesID, String seriesName, int runTimeInMinutes, int ageRestriction) {
        super(seriesID, seriesName, ageRestriction);
        this.runTimeInMinutes = runTimeInMinutes;
    }

    // Gets and sets for the Movie property.
    public int getRunTimeInMinutes() {
        return runTimeInMinutes;
    }

    public void setRunTimeInMinutes(int runTimeInMinutes) {
        this.runTimeInMinutes = runTimeInMinutes;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesID +
                "\nSeries Name: " + seriesName +
                "\nSeries Type: Movie" +
                "\nSeries Age Restriction: " + ageRestriction +
                "\nRun Time: " + runTimeInMinutes + " minutes" + "\n";
    }
}
