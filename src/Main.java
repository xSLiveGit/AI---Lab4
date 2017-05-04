/**
 * Created by Sergiu on 4/25/2017.
 */
import ACO.*;
import GUIController.GUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends Application{
//    public static void main(String argv[]){
//        ACO aco = new ACO();
//        List<List<Double>> w = new ArrayList<>(Arrays.asList(
//                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	4.0d,	6.0d,	2.0d,	4.0d,	1.0d,	7.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(2.0d,	5.0d,	4.0d,	3.0d,	8.0d,	3.0d,	2.0d,	1.0d,	7.0d)),
//                new ArrayList<Double>(Arrays.asList(4.0d,	4.0d,	3.0d,	3.0d,	5.0d,	1.0d,	5.0d,	7.0d,	3.0d)),
//                new ArrayList<Double>(Arrays.asList(6.0d,	3.0d,	3.0d,	2.0d,	3.0d,	2.0d,	1.0d,	8.0d,	5.0d)),
//                new ArrayList<Double>(Arrays.asList(2.0d,	8.0d,	5.0d,	3.0d,	3.0d,	1.0d,	8.0d,	5.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(4.0d,	3.0d,	1.0d,	2.0d,	1.0d,	4.0d,	5.0d,	2.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	5.0d,	1.0d,	8.0d,	5.0d,	3.0d,	2.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(7.0d,	1.0d,	7.0d,	8.0d,	5.0d,	2.0d,	2.0d,	5.0d,	3.0d)),
//                new ArrayList<Double>(Arrays.asList(1.0d,	7.0d,	3.0d,	5.0d,	1.0d,	1.0d,	1.0d,	3.0d,	6.0d))
//                ));
//        List<List<Double>> d = new ArrayList<>(Arrays.asList(
//                new ArrayList<Double>(Arrays.asList(1.0d,	7.0d,	3.0d,	5.0d,	1.0d,	1.0d,	1.0d,	3.0d,	6.0d)),
//                new ArrayList<Double>(Arrays.asList(7.0d,	5.0d,	4.0d,	3.0d,	8.0d,	3.0d,	2.0d,	1.0d,	7.0d)),
//                new ArrayList<Double>(Arrays.asList(3.0d,	4.0d,	3.0d,	4.0d,	3.0d,	1.0d,	2.0d,	1.0d,	4.0d)),
//                new ArrayList<Double>(Arrays.asList(5.0d,	3.0d,	4.0d,	2.0d,	1.0d,	2.0d,	5.0d,	1.0d,	8.0d)),
//                new ArrayList<Double>(Arrays.asList(1.0d,	8.0d,	3.0d,	1.0d,	3.0d,	3.0d,	3.0d,	5.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(1.0d,	3.0d,	1.0d,	2.0d,	3.0d,	4.0d,	2.0d,	5.0d,	3.0d)),
//                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	2.0d,	5.0d,	3.0d,	2.0d,	3.0d,	2.0d,	1.0d)),
//                new ArrayList<Double>(Arrays.asList(3.0d,	1.0d,	1.0d,	1.0d,	5.0d,	5.0d,	2.0d,	5.0d,	3.0d)),
//                new ArrayList<Double>(Arrays.asList(6.0d,	7.0d,	4.0d,	8.0d,	1.0d,	3.0d,	1.0d,	3.0d,	6.0d))
//        ));
//        for(Integer step=1;step<15;step++){
//            Ant a = aco.search(9,10*step,100,w,d,0.67d,1.0d);
//            System.out.println(a.getScore());
//        }
//        Ant a = aco.search(9,100,100,w,d,0.67d,1.0d);
//        System.out.println(a.getScore());
        public static void main(String[] argv) {
            // STOPSHIP: 4/10/2017
            launch(argv);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MainWindows.fxml"));
            GUIController guiController = loader.getController();
            System.out.print(guiController);
//        guiController.initDesgin();
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }


