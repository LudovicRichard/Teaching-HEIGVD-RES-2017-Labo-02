package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.EmptyStoreException;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV1Protocol;
import ch.heigvd.schoolpulse.TestAuthor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * This class contains automated tests to validate the client and the server
 * implementation of the Roulette Protocol (version 2)
 *
 * @author Ludovic Richard, Luana Martelli
 */
public class RouletteV2LuanaMartelliTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Rule
    public EphemeralClientServerPair roulettePair = new EphemeralClientServerPair(RouletteV1Protocol.VERSION);

    @Test
    @TestAuthor(githubId = "LudovicRichard")
    public void theServerShouldBeEmptyAfterAClean() throws IOException {
        IRouletteV2Client client = (IRouletteV2Client)(roulettePair.getClient());

        client.loadStudent("John Smith");
        client.clearDataStore();
        assertEquals(client.getNumberOfStudents(), 0);
    }

    @Test
    @TestAuthor(githubId = "wasadigi")
    public void theServerShouldSendTheListOfStudentsCorrectly() throws IOException {
        IRouletteV2Client client = (IRouletteV2Client)(roulettePair.getClient());
        List<Student> newStudents = new ArrayList();
        List<Student> returnedList;

        newStudents.add(new Student("Ludovic Richard"));
        newStudents.add(new Student("Luana Martelli"));

        client.loadStudent("John Smith");
        client.loadStudents(newStudents);
        assertEquals(client.getNumberOfStudents(), 3);

        newStudents.add(new Student("John Smith"));
        returnedList = client.listStudents();

        for(Student s : newStudents){
            assertTrue(returnedList.contains(s));
        }
    }
}
