package ch.heigvd.res.labs.roulette.net.client;

import ch.heigvd.res.labs.roulette.data.JsonObjectMapper;
import ch.heigvd.res.labs.roulette.data.Student;
import ch.heigvd.res.labs.roulette.data.StudentsList;
import ch.heigvd.res.labs.roulette.net.protocol.RouletteV2Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

/**
 * This class implements the client side of the protocol specification (version 2).
 *
 * @author Olivier Liechti
 */

public class RouletteV2ClientImpl extends RouletteV1ClientImpl implements IRouletteV2Client {

  @Override
  public void clearDataStore() throws IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Student> listStudents() throws IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void loadStudents(List<Student> students) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

    super.loadStudents(students);
  }


}
