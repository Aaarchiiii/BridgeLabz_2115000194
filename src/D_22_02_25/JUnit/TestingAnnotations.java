package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class TestingAnnotations {
    static class DatabaseConnection {
        private boolean connected = false;
        public void connect() {
            connected = true;
            System.out.println("Database connected.");
        }
        public void disconnect() {
            connected = false;
            System.out.println("Database disconnected.");
        }
        public boolean isConnected() {
            return connected;
        }
    }
    private DatabaseConnection dbConnection;
    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }
    @AfterEach
    void tearDown() {
        dbConnection.disconnect();
    }
    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected());
    }
    @Test
    void testConnectionIsClosedAfterEachTest() {
        assertTrue(dbConnection.isConnected());
    }
}
