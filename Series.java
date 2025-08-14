import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Series {
    //stores TvShow objects
    private List<TvShow> tvShows = new ArrayList<>();

    // Method for capturing a new series
    public void CaptureSeries(Scanner scanner) {
        System.out.println("\n--- Capture New Series ---");
        System.out.print("Enter series ID: ");
        String seriesID = scanner.nextLine();

        System.out.print("Enter series name: ");
        String seriesName = scanner.nextLine();

        System.out.print("Enter number of episodes: ");
        int numberOfEpisodes = scanner.nextInt();

        System.out.print("Enter age restriction (e.g., 13, 16, 18): ");
        int ageRestriction = scanner.nextInt();
        scanner.nextLine();
    //creates new TvShow with data that user enters
        TvShow newTvShow = new TvShow(seriesID, seriesName, numberOfEpisodes, ageRestriction);
    //adds TvShow new data to list
        tvShows.add(newTvShow);
        System.out.println("Series '" + newTvShow.getSeriesName() + "' captured successfully.");
    }

    // Method to search for a series by its ID
    public void SearchSeries(Scanner scanner) {
        System.out.println("\n--- Search for a Series ---");
        System.out.print("Enter the series ID to search for: ");
        String seriesID = scanner.nextLine();
    //finds the series
        TvShow foundShow = findSeriesByID(seriesID);
        if (foundShow != null) {
            System.out.println("Series found: " + foundShow);
        } else {
            System.out.println("Series with ID '" + seriesID + "' not found.");
        }
    }

    // Method updates details of an existing series
    public void UpdateSeries(Scanner scanner) {
        System.out.println("\n--- Update Series Details ---");
        System.out.print("Enter the series ID to update: ");
        String seriesID = scanner.nextLine();

        TvShow foundShow = findSeriesByID(seriesID);
        if (foundShow != null) {
            System.out.println("Series found: " + foundShow);

            // Update Series Name
            System.out.print("Enter new series name (current: '" + foundShow.getSeriesName() + "', press Enter to skip): ");
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                foundShow.setSeriesName(newName);
                System.out.println("Series name updated.");
            }

            // Update Number of Episodes
            System.out.print("Enter new number of episodes (current: " + foundShow.getNumberOfEpisodes() + ", press Enter to skip): ");
            String newEpisodesStr = scanner.nextLine();
            if (!newEpisodesStr.trim().isEmpty()) {
                try {
                    int newEpisodes = Integer.parseInt(newEpisodesStr);
                    foundShow.setNumberOfEpisodes(newEpisodes);
                    System.out.println("Number of episodes updated.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for number of episodes. Value not updated.");
                }
            }

            // Update Age Restriction
            System.out.print("Enter new age restriction (current: " + foundShow.getAgeRestriction() + ", press Enter to skip): ");
            String newAgeRestrictionStr = scanner.nextLine();
            if (!newAgeRestrictionStr.trim().isEmpty()) {
                try {
                    int newAgeRestriction = Integer.parseInt(newAgeRestrictionStr);
                    foundShow.setAgeRestriction(newAgeRestriction);
                    System.out.println("Age restriction updated.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for age restriction. Value not updated.");
                }
            }

            System.out.println("\nUpdate complete for series '" + foundShow.getSeriesName() + "'.");

        } else {
            System.out.println("Series with ID '" + seriesID + "' not found.");
        }
    }

    // Method to delete a series
    public void DeleteSeries(Scanner scanner) {
        System.out.println("\n--- Delete a Series ---");
        System.out.print("Enter the series ID to delete: ");
        String seriesID = scanner.nextLine();

        TvShow foundShow = findSeriesByID(seriesID);
        if (foundShow != null) {
            System.out.println("Are you sure you want to delete the series '" + foundShow.getSeriesName() + "'? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                tvShows.remove(foundShow);
                System.out.println("Series '" + foundShow.getSeriesName() + "' deleted successfully.");
            } else if (confirmation.equalsIgnoreCase("N")) {
                System.out.println("Series deletion cancelled.");
            } else {
                System.out.println("Invalid input. Deletion cancelled.");
            }
        } else {
            System.out.println("Series with ID '" + seriesID + "' not found.");
        }
    }

    // Method prints report of all series
    public void SeriesReport() {
        System.out.println("\n--- Series Report ---");
        if (tvShows.isEmpty()) {
            System.out.println("No series have been captured yet.");
        } else {
            for (TvShow show : tvShows) {
                System.out.println("Series ID: " + show.getSeriesID());
                System.out.println("Series Name: " + show.getSeriesName());
                System.out.println("Series Age Restriction: " + show.getAgeRestriction() + "+");
                System.out.println("Number of Episodes: " + show.getNumberOfEpisodes());
                System.out.println("****************************");
            }
        }
    }

    //method to find a series by its ID
    private TvShow findSeriesByID(String seriesID) {
        for (TvShow show : tvShows) {
            if (show.getSeriesID().equalsIgnoreCase(seriesID)) {
                return show;
            }
        }
        return null;
    }
}

