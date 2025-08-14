import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUnit {

    private Series seriesManager;
    private final String NL = System.lineSeparator();
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        seriesManager = new Series();
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Test search for an existing series by ID")
    void testSearchSeries_Success() {
        // test user input to capture a series first.
        String captureInput = "12345" + NL + "The Expanse" + NL + "60" + NL + "16" + NL;
        seriesManager.CaptureSeries(new Scanner(new ByteArrayInputStream(captureInput.getBytes())));

        // test user input to search for the series.
        String searchInput = "12345" + NL;
        seriesManager.SearchSeries(new Scanner(new ByteArrayInputStream(searchInput.getBytes())));

        String expectedOutput = "Series found: Series ID: 12345" + NL +
                "Series Name: The Expanse" + NL +
                "Series Age Restriction: 16" + NL +
                "Number of Episodes: 60" + NL;

        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Test search for a non-existent series")
    void testSearchSeries_NotFound() {
        // test user input to search for a series that hasn't been added.
        String searchInput = "NONEXISTENT" + NL;
        seriesManager.SearchSeries(new Scanner(new ByteArrayInputStream(searchInput.getBytes())));

        String expectedOutput = "Series with ID 'NONEXISTENT' not found.";
        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Test updating an existing series's name")
    void testUpdateSeries_Success() {
        // Capture a series.
        String captureInput = "54321" + NL + "Old Name" + NL + "10" + NL + "13" + NL;
        seriesManager.CaptureSeries(new Scanner(new ByteArrayInputStream(captureInput.getBytes())));

        // test input to update the series name.
        String updateInput = "54321" + NL + "New Name" + NL + NL + NL; // New name, then skip episodes and age restriction
        seriesManager.UpdateSeries(new Scanner(new ByteArrayInputStream(updateInput.getBytes())));

        // Search for the series to verify the update.
        seriesManager.SearchSeries(new Scanner(new ByteArrayInputStream(("54321" + NL).getBytes())));

        String expectedOutput = "Series Name: New Name";
        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Test deleting a series with 'Y' confirmation")
    void testDeleteSeries_Success() {
        // Capture a series to be deleted.
        String captureInput = "DELETE_ME" + NL + "Series to Delete" + NL + "5" + NL + "18" + NL;
        seriesManager.CaptureSeries(new Scanner(new ByteArrayInputStream(captureInput.getBytes())));

        // test input for deletion with 'Y'.
        String deleteInput = "DELETE_ME" + NL + "Y" + NL;
        seriesManager.DeleteSeries(new Scanner(new ByteArrayInputStream(deleteInput.getBytes())));

        // Try to search for the deleted series to confirm it's gone.
        seriesManager.SearchSeries(new Scanner(new ByteArrayInputStream(("DELETE_ME" + NL).getBytes())));

        String expectedOutput = "Series with ID 'DELETE_ME' not found.";
        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Test deleting a non-existent series")
    void testDeleteSeries_NotFound() {
        // test input to delete a series that was never captured.
        String deleteInput = "GHOST_SERIES" + NL + "Y" + NL; // The 'Y' is ignored if the series isn't found
        seriesManager.DeleteSeries(new Scanner(new ByteArrayInputStream(deleteInput.getBytes())));

        String expectedOutput = "Series with ID 'GHOST_SERIES' not found.";
        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    @DisplayName("Test updating a series with a valid age restriction")
    void testUpdateAgeRestriction_Valid() {
        // Capture a series.
        String captureInput = "AGE_TEST" + NL + "Age Test Show" + NL + "1" + NL + "10" + NL;
        seriesManager.CaptureSeries(new Scanner(new ByteArrayInputStream(captureInput.getBytes())));

        // test input to update the age restriction.
        String updateInput = "AGE_TEST" + NL + NL + NL + "18" + NL; // Skip name and episodes, update age
        seriesManager.UpdateSeries(new Scanner(new ByteArrayInputStream(updateInput.getBytes())));

        // Search for the series to verify the age update.
        seriesManager.SearchSeries(new Scanner(new ByteArrayInputStream(("AGE_TEST" + NL).getBytes())));

        String expectedOutput = "Series Age Restriction: 18";
        assertTrue(outputStream.toString().contains(expectedOutput));

    }
}