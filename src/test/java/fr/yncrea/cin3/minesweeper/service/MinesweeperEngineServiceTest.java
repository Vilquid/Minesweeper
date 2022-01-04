package fr.yncrea.cin3.minesweeper.service;

import fr.yncrea.cin3.minesweeper.domain.Minefield;
import fr.yncrea.cin3.minesweeper.exception.MinesweeperException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Minesweeper Engine")
class MinesweeperEngineServiceTest {
    private final MinesweeperEngineService service = new MinesweeperEngineService();

    @Test
    @DisplayName("Add mine out of bound should returns an exception")
    public void testAddMineOutOfBound() {
        Minefield minefield = new Minefield(4, 4);

        assertThrows(MinesweeperException.class, () -> service.addMine(minefield, -1, 2));
        assertThrows(MinesweeperException.class, () -> service.addMine(minefield, 2, -1));
        assertThrows(MinesweeperException.class, () -> service.addMine(minefield, 4, 2));
        assertThrows(MinesweeperException.class, () -> service.addMine(minefield, 2, 4));
    }

    @Test
    @DisplayName("Add two mines")
    public void testAddMine() {
        Minefield minefield = new Minefield(4, 4);

        // mines not present
        assertFalse(service.hasMine(minefield, 1, 2));
        assertFalse(service.hasMine(minefield, 1, 3));

        // adding 2 mines
        service.addMine(minefield, 1, 2);
        service.addMine(minefield, 1, 3);

        // mines should be present
        assertTrue(service.hasMine(minefield, 1, 2));
        assertTrue(service.hasMine(minefield, 1, 3));

        // mines not added
        assertFalse(service.hasMine(minefield, 2, 1));
        assertFalse(service.hasMine(minefield, 1, 1));
    }

    @Test
    @DisplayName("Count mines, should be zero")
    public void testGetMineCountNearZero() {
        Minefield minefield = new Minefield(9, 9);

        for (long x = 0; x < 9; ++x) {
            for (long y = 0; y < 9; ++y) {
                assertEquals(0, service.getMineCountNear(minefield, x, y));
            }
        }
    }

    @Test
    @DisplayName("Count mines, should be one")
    public void testGetMineCountNearOne() {
        Minefield minefield = new Minefield(9, 9);
        service.addMine(minefield, 4, 4);

        assertEquals(1, service.getMineCountNear(minefield, 3, 3));
        assertEquals(1, service.getMineCountNear(minefield, 4, 3));
        assertEquals(1, service.getMineCountNear(minefield, 5, 3));

        assertEquals(1, service.getMineCountNear(minefield, 3, 4));
        assertEquals(1, service.getMineCountNear(minefield, 5, 4));

        assertEquals(1, service.getMineCountNear(minefield, 3, 5));
        assertEquals(1, service.getMineCountNear(minefield, 4, 5));
        assertEquals(1, service.getMineCountNear(minefield, 5, 5));

        assertEquals(0, service.getMineCountNear(minefield, 2, 2));
    }

    @Test
    @DisplayName("Count mines, should be two")
    public void testGetMineCountNearTwo() {
        Minefield minefield = new Minefield(9, 9);
        service.addMine(minefield, 4, 4);
        service.addMine(minefield, 6, 6);

        assertEquals(1, service.getMineCountNear(minefield, 5, 4));
        assertEquals(1, service.getMineCountNear(minefield, 4, 5));
        assertEquals(2, service.getMineCountNear(minefield, 5, 5));
    }

    @Test
    @DisplayName("Count mines, should be eight")
    public void testGetMineCountNearEight() {
        Minefield minefield = new Minefield(9, 9);
        service.addMine(minefield, 3, 3);
        service.addMine(minefield, 4, 3);
        service.addMine(minefield, 5, 3);
        service.addMine(minefield, 3, 4);
        service.addMine(minefield, 5, 4);
        service.addMine(minefield, 3, 5);
        service.addMine(minefield, 4, 5);
        service.addMine(minefield, 5, 5);

        assertEquals(8, service.getMineCountNear(minefield, 4, 4));
    }

    @Test
    @DisplayName("Create minefield with invalid size should returns an exception")
    public void testCreateInvalidSize() {
        assertThrows(MinesweeperException.class, () -> service.create(-2, -2, 0));
        assertThrows(MinesweeperException.class, () -> service.create(-2, 2, 0));
        assertThrows(MinesweeperException.class, () -> service.create(2, -2, 0));
    }

    @Test
    @DisplayName("Create minefield with invalid mine count should returns an exception")
    public void testCreateInvalidMineNumber() {
        assertThrows(MinesweeperException.class, () -> service.create(2, 2, -1));
        assertThrows(MinesweeperException.class, () -> service.create(2, 2, 5));
    }

    @Test
    @DisplayName("Create valid minefield : 8 mines")
    public void testCreateEight() {
        Minefield minefield = service.create(10, 20, 8);

        assertEquals(10, minefield.getWidth());
        assertEquals(20, minefield.getHeight());

        // count mines
        long count = 0;
        for (long x = 0; x < minefield.getWidth(); ++x) {
            for (long y = 0; y < minefield.getHeight(); ++y) {
                if (service.hasMine(minefield, x, y)) {
                    ++count;
                }
            }
        }

        assertEquals(8, count);
    }

    @Test
    @DisplayName("Create valid minefield : 200 mines")
    public void testCreateTwoHundred() {
        Minefield minefield = service.create(10, 20, 200);

        assertEquals(10, minefield.getWidth());
        assertEquals(20, minefield.getHeight());

        // count mines
        long count = 0;
        for (long x = 0; x < minefield.getWidth(); ++x) {
            for (long y = 0; y < minefield.getHeight(); ++y) {
                if (service.hasMine(minefield, x, y)) {
                    ++count;
                }
            }
        }

        assertEquals(200, count);
    }

    @Test
    @DisplayName("Discover empty cell")
    public void testIsDiscoveredEmpty() {
        Minefield minefield = new Minefield(4, 4);
        assertFalse(service.isDiscovered(minefield, 0, 0));

        service.play(minefield, 0, 0);
        assertTrue(service.isDiscovered(minefield, 0, 0));
    }

    @Test
    @DisplayName("Discover mined cell")
    public void testIsDiscoveredMine() {
        Minefield minefield = new Minefield(4, 4);
        service.addMine(minefield, 0, 0);
        assertFalse(service.isDiscovered(minefield, 0, 0));

        service.play(minefield, 0, 0);
        assertTrue(service.isDiscovered(minefield, 0, 0));
    }

    @Test
    @DisplayName("Discover cell around a mine")
    public void testIsDiscoveredMineAround() {
        Minefield minefield = new Minefield(4, 4);
        service.addMine(minefield, 1, 1);
        assertFalse(service.isDiscovered(minefield, 0, 0));

        service.play(minefield, 0, 0);
        assertTrue(service.isDiscovered(minefield, 0, 0));
    }

    @Test
    @DisplayName("Play at invalid position should returns an exception")
    public void testPlayInvalidPosition() {
        Minefield minefield = new Minefield(4, 4);

        assertThrows(MinesweeperException.class, () -> service.play(minefield, -1, 0));
        assertThrows(MinesweeperException.class, () -> service.play(minefield, 0, -1));
        assertThrows(MinesweeperException.class, () -> service.play(minefield, 4, 0));
        assertThrows(MinesweeperException.class, () -> service.play(minefield, 0, 4));
    }

    @Test
    @DisplayName("Play should be impossible after victory")
    public void testPlayFinishedWin() {
        Minefield minefield = new Minefield(4, 4);
        service.play(minefield, 0, 0);

        assertThrows(MinesweeperException.class, () -> service.play(minefield, 1, 1));
    }

    @Test
    @DisplayName("Play should be impossible after loss")
    public void testPlayFinishedLost() {
        Minefield minefield = new Minefield(4, 4);
        service.addMine(minefield, 0, 0);
        service.play(minefield, 0, 0);

        assertThrows(MinesweeperException.class, () -> service.play(minefield, 1, 1));
    }

    @Test
    @DisplayName("Play should be impossible on already discovered cell")
    public void testPlayAlreadyDiscovered() {
        Minefield minefield = new Minefield(4, 4);
        service.addMine(minefield, 3, 3);
        service.play(minefield, 0, 0);

        assertThrows(MinesweeperException.class, () -> service.play(minefield, 0, 1));
    }

    @Test
    @DisplayName("Testing auto-discover algorithm : case 1")
    public void testAutoDiscoverCase1() throws IOException, URISyntaxException {
        String file = "minefield_case_1.txt";
        Minefield minefield = buildMinefieldFromFile(file);

        service.play(minefield, 0, 0);

        assertDiscoverFromFile(minefield, file);
    }

    @Test
    @DisplayName("Testing auto-discover algorithm : case 2")
    public void testAutoDiscoverCase2() throws IOException, URISyntaxException {
        String file = "minefield_case_2.txt";
        Minefield minefield = buildMinefieldFromFile(file);

        service.play(minefield, 0, 0);

        assertDiscoverFromFile(minefield, file);
    }

    @Test
    @DisplayName("Testing auto-discover algorithm : case 3")
    public void testAutoDiscoverCase3() throws IOException, URISyntaxException {
        String file = "minefield_case_3.txt";
        Minefield minefield = buildMinefieldFromFile(file);

        service.play(minefield, 5, 0);

        assertDiscoverFromFile(minefield, file);
    }

    private Minefield buildMinefieldFromFile(String file) throws IOException, URISyntaxException {
        Path path = Path.of(getClass().getClassLoader().getResource(file).toURI());
        List<String> lines = Files.readAllLines(path);

        // determine width
        long width = lines.get(0).split(" ").length;

        // depermine height
        long height = lines.size();

        // create the minefield
        Minefield minefield = new Minefield(width, height);

        // add mines (should be an "x" in the file)
        long y = 0;
        for (String line: lines) {
            String[] cols = line.split(" ");
            long x = 0;
            for (String cell: cols) {
                if ("x".equals(cell)) {
                    service.addMine(minefield, x, y);
                }

                ++x;
            }

            ++y;
        }

        return minefield;
    }

    private void assertDiscoverFromFile(Minefield minefield, String file) throws IOException, URISyntaxException {
        Path path = Path.of(getClass().getClassLoader().getResource(file).toURI());
        List<String> lines = Files.readAllLines(path);

        // add mines (should be an "x" in the file)
        long y = 0;
        for (String line: lines) {
            String[] cols = line.split(" ");
            long x = 0;
            for (String cell: cols) {
                // if cell is a number, the cell should have been discovered
                if (cell.matches("[0-9]")) {
                    assertTrue(service.isDiscovered(minefield, x, y));
                }

                ++x;
            }

            ++y;
        }
    }
}