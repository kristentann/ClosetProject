// Portions of this class references code from this repository
// Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;


import org.json.JSONObject;
import model.Closet;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

// class used to write App into JSON format so that we can save our clothes
public class JsonWriter {
    private static final int TABS_FOR_FORMATTING = 4;
    private PrintWriter writer;
    private String toFile;

    // REQUIRES: toFile to be non-zero length
    // EFFECTS: sets which file we should be writing to
    public JsonWriter(String toFile) {
        this.toFile = toFile;
    }

    // MODIFIES: this
    // EFFECTS: instantiates a PrintWriter with our file destination so that we are able to write into the JSON file
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(toFile);
    }

    // REQUIRES: save is a valid object (non-null)
    // EFFECTS: saves App into a JSON object, then writes them into a .json file
    public void write(Closet save) {

        // helper method which converts App into a JSON object
        JSONObject jsonObj = save.toJson();

        // helper method which writes the newly converted JSON object into a .json file
        saveToFile(jsonObj);
    }

    // REQUIRES: jsonObj is non-null
    // EFFECTS: we write our jsonObj of App into our .json file
    public void saveToFile(JSONObject jsonObj) {

        // convert the jsonObj into string
        String jsonToString = jsonObj.toString(TABS_FOR_FORMATTING);

        // PrintWriter writes the string into the .json file
        writer.print(jsonToString);
    }

    // MODIFIES: this
    // EFFECTS: closes our PrintWriter as we are done using it to write into our .json file
    public void close() {
        writer.close();
    }

}
