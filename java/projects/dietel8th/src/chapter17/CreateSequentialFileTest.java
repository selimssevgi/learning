package chapter17;

/**
 * Created by ssselim on 8/5/16.
 */
public class CreateSequentialFileTest {

    public static void main(String[] args) {
        CreateSequentialFile app = new CreateSequentialFile();

        app.openFile();
        app.addRecords();
        app.closeFile();
    }
}
