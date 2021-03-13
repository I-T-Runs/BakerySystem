package com.bakerysystem.properties;

/**
 * This is a configure for our bakery system. Used to alter properties
 *
 * @author Themba
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.Properties;

public class BSConfig {

    private String filename = "./data/config.properties";
    private Properties property;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    private String host;
    private String port;
    private String dbhost;

    // USE THIS IF YOU DONT NEED TO CHANGE THE EXISTING PROPERTIES IN THE CONFIG FILE
    public BSConfig() {
        try {
            property = new Properties();
            read();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // USE THIS IF YOU WISH TO CHANGE THE EXISTING PROPERTIES IN THE CONFIG FILE
    public BSConfig(String host, int port, String databaseHost) {
        try {
            property = new Properties();

            writer = new ObjectOutputStream(new FileOutputStream(filename));
            property.setProperty("port", port + "");
            property.setProperty("DatabaseHostAddress", databaseHost);
            property.setProperty("APIHostAddress", host);
            property.store(writer, null);

            read();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public String getHost() {
        return host;
    }
    public String getPort() {
        return port;
    }
    public String getDbhost() {
        return dbhost;
    }
    public String getURL(String pathParent) {
        return "http://" + getHost() + ":" + getPort() + "/BakerySystemRest/app/" + pathParent + "/";
    }
    private void read() throws FileNotFoundException, IOException {
        reader = new ObjectInputStream(new FileInputStream(filename));
        property.load(reader);
        this.port = property.getProperty("port");
        this.dbhost = property.getProperty("DatabaseHostAddress");
        this.host = property.getProperty("APIHostAddress");
    }

    @Override
    public String toString() {
        return "BSConfig{\n\t" + " filename=" + filename + ",\n\t host=" + host + ",\n\t port=" + port + ",\n\t dbhost=" + dbhost + "\n}";
    }

    public static void main(String[] args) {
        // testing
<<<<<<< HEAD
        BSConfig config = new BSConfig("localhost", 8080, "localhost");
=======
        BSConfig config = new BSConfig("192.22.3.2", 8080, "199.23.11.2");
>>>>>>> 92fa375293901d518580bad559895f784aa0e400
        System.out.println(config);
    }
}
