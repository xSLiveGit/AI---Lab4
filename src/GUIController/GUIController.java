package GUIController;
import ACO.*;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergiu on 4/10/2017.
 */
public class GUIController {
//    ACO aco = new ACO();
    @FXML
    TextField textField_nAnts;
    @FXML
    TextField textField_nIteration;
    @FXML
    TextField textField_evaporationFactor;
    @FXML
    TextField textField_W;
    @FXML
    TextField textField_D;
    @FXML
    TextField textField_Solution;
    @FXML
    Pane graphicPane;
    @FXML
    TextField textField_TranspositionNumber;
    public GUIController() {
    }

    public void initDesgin(){
//        drawPane(new ArrayList<>());
    }
    @FXML
    private void searchHandler(){
//        textField_MutationProbability.setTooltip(new Tooltip("mutation probability"));
        ACO aco = new ACO();
        List<List<Double>> w = getMatrixFromLine(textField_W.getText());
        List<List<Double>> d = getMatrixFromLine(textField_D.getText());
       // System.out.print(textField_TranspositionNumber.getText());
        Ant a = aco.search(w.size(),
                Integer.parseInt(textField_nAnts.getText()),
                Integer.parseInt(textField_nIteration.getText()),
                w,
                d,
                Double.parseDouble(textField_evaporationFactor.getText()),
                1.0d);
        String txt = (String.join(" ",a.getVisitedNodes().stream().map(el->el.toString()+" ").collect(Collectors.toList())));
        txt+=" Fitness: " + a.getScore().toString();
        System.out.println(txt);
        textField_Solution.setText(txt);
        System.out.println("Generatiile");

        drawPane(aco.getGenerations());
    }

    //forma 1:2:3!4:5:6!7:8:9
    private List<List<Double>> getMatrixFromLine(String lineToParse){
        List<List<Double>> matrix = new ArrayList<>();
        for(String line: lineToParse.split("!")){
            matrix.add(new ArrayList<>());
            Integer poz = matrix.size()-1;
            for(String number : line.split(":")){
                matrix.get(poz).add(Double.parseDouble(number));
            }
        }
        return matrix;
    }

    private void drawPane(List<List<Ant>> generations){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("ChromosomeIndex");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Evolutions of egenerations");

        Integer popIndex = 0;

        for(List<Ant> generation : generations){
            Integer index = 0;
            XYChart.Series generationChart = new XYChart.Series();
            generationChart.setName("Gen: " + popIndex.toString());
            for(Ant ant : generation){
                generationChart.getData().add(new XYChart.Data(index,ant.getScore()));
                index++;
            }
            popIndex++;
            lineChart.getData().add(generationChart);
        }


        lineChart.setMinWidth(823);
        graphicPane.getChildren().clear();
        graphicPane.getChildren().add(lineChart);
//        graphicPane.getChildren().addAll(stage);

    }

}
