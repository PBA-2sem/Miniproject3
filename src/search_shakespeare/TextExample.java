package search_shakespeare;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 * https://www.tutorialspoint.com/javafx/javafx_text.htm
 */
public class TextExample extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        ShakespeareSuffixTrie test = new ShakespeareSuffixTrie();
        test.load("src/shakespeare_project/data.txt");

        Text text1 = new Text("Search Shakespeare Phrase");
        TextField search_input = new TextField("to be or no");
        TextArea result_first = new TextArea();
        result_first.setPrefWidth(600);
        Button button = new Button("Search");
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(text1, 0, 0);
        gridPane.add(search_input, 1, 0);
        gridPane.add(result_first, 1, 2);
        gridPane.add(button, 1, 1);

        // action event 
        EventHandler<ActionEvent> event = (ActionEvent e) -> {

            Trie toBeOrNot = test.trie.locate(new ShakespeareSuffixKey(search_input.getText()));

            Iterator iter = toBeOrNot.iterator();
            Set<String> set = new HashSet<>();

            for (int i = 0; i < 20; i++) {
                if (iter.hasNext()) {
                    recursiveMethod(iter, set);
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            set.forEach((object) -> {
                sb.append(object.toString()).append("\n");
            });

//            result_first.setText(search_input.getText());
            result_first.setText(sb.toString());
            search_input.clear();
        };

        // when button is pressed 
        button.setOnAction(event);

        Scene scene = new Scene(gridPane);
        stage.setTitle("Searching Shakespeare");
        stage.setScene(scene);
        stage.show();
    }

    public void recursiveMethod(Iterator iter, Set set) {
        Object obj = iter.next();
        if (obj.getClass().getCanonicalName().equals("search_shakespeare.ArrayTrie")) {
            ArrayTrie at = (ArrayTrie) obj;
            recursiveMethod(at.iterator(), set);
        } else {
//            System.out.println(obj.toString());
            set.add(obj.toString());
        }
    }

    public static void main(String args[]) {
        launch(args);
    }
}
