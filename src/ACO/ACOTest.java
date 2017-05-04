package ACO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sergiu on 5/2/2017.
 */
public class ACOTest {
    @org.junit.Test
    public void search() throws Exception {
        assert (true);
        assertTrue(true);
        assertFalse(false);
        assertFalse(true == false);
        assertTrue(true == true);
        ACO aco = new ACO();
        List<List<Double>> w = new ArrayList<>(Arrays.asList(
                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	4.0d,	6.0d,	2.0d,	4.0d,	1.0d,	7.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(2.0d,	5.0d,	4.0d,	3.0d,	8.0d,	3.0d,	2.0d,	1.0d,	7.0d)),
                new ArrayList<Double>(Arrays.asList(4.0d,	4.0d,	3.0d,	3.0d,	5.0d,	1.0d,	5.0d,	7.0d,	3.0d)),
                new ArrayList<Double>(Arrays.asList(6.0d,	3.0d,	3.0d,	2.0d,	3.0d,	2.0d,	1.0d,	8.0d,	5.0d)),
                new ArrayList<Double>(Arrays.asList(2.0d,	8.0d,	5.0d,	3.0d,	3.0d,	1.0d,	8.0d,	5.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(4.0d,	3.0d,	1.0d,	2.0d,	1.0d,	4.0d,	5.0d,	2.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	5.0d,	1.0d,	8.0d,	5.0d,	3.0d,	2.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(7.0d,	1.0d,	7.0d,	8.0d,	5.0d,	2.0d,	2.0d,	5.0d,	3.0d)),
                new ArrayList<Double>(Arrays.asList(1.0d,	7.0d,	3.0d,	5.0d,	1.0d,	1.0d,	1.0d,	3.0d,	6.0d))
                ));
        List<List<Double>> d = new ArrayList<>(Arrays.asList(
                new ArrayList<Double>(Arrays.asList(1.0d,	7.0d,	3.0d,	5.0d,	1.0d,	1.0d,	1.0d,	3.0d,	6.0d)),
                new ArrayList<Double>(Arrays.asList(7.0d,	5.0d,	4.0d,	3.0d,	8.0d,	3.0d,	2.0d,	1.0d,	7.0d)),
                new ArrayList<Double>(Arrays.asList(3.0d,	4.0d,	3.0d,	4.0d,	3.0d,	1.0d,	2.0d,	1.0d,	4.0d)),
                new ArrayList<Double>(Arrays.asList(5.0d,	3.0d,	4.0d,	2.0d,	1.0d,	2.0d,	5.0d,	1.0d,	8.0d)),
                new ArrayList<Double>(Arrays.asList(1.0d,	8.0d,	3.0d,	1.0d,	3.0d,	3.0d,	3.0d,	5.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(1.0d,	3.0d,	1.0d,	2.0d,	3.0d,	4.0d,	2.0d,	5.0d,	3.0d)),
                new ArrayList<Double>(Arrays.asList(1.0d,	2.0d,	2.0d,	5.0d,	3.0d,	2.0d,	3.0d,	2.0d,	1.0d)),
                new ArrayList<Double>(Arrays.asList(3.0d,	1.0d,	1.0d,	1.0d,	5.0d,	5.0d,	2.0d,	5.0d,	3.0d)),
                new ArrayList<Double>(Arrays.asList(6.0d,	7.0d,	4.0d,	8.0d,	1.0d,	3.0d,	1.0d,	3.0d,	6.0d))
        ));
        for(Integer step=1;step<15;step++){
            Ant a = aco.search(9,10*step,100,w,d,0.67d,1.0d);
            System.out.println(a.getScore());
        }
        Ant a = aco.search(9,100,100,w,d,0.67d,1.0d);
        for(List<Ant> generation : aco.getGenerations()){
            for(Ant ant : generation){
                assertTrue(ant.getScore() >= a.getScore());
            }
        }
        
    }

}