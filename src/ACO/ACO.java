package ACO;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Sergiu on 4/25/2017.
 */

public class ACO {
    private List<List<Ant>> generations;
    private List<List<Double>> globalPheromonesQuantity;
    private List<List<Double>> modifiedPheromonesQuantity;
    Integer nNodes;
    Integer nAnts;
    Integer iteration;

    public ACO() {
        generations = new ArrayList<>();
    }

    public List<List<Ant>> getGenerations() {
        return generations;
    }

    public Ant search(
            Integer nNodes,
            Integer nAnts,
            Integer iteration,
            List<List<Double>> w,
            List<List<Double>> d,
            Double evaporationFactor,//evaporation index
            Double initialQuantity){
        generations = new ArrayList<>();
        this.nAnts = nAnts;
        this.nNodes = nNodes;
        this.iteration = iteration;
        Integer t = 0;
        this.globalPheromonesQuantity = initializePheromones(initialQuantity,nNodes);
        List<Ant> currentAntsGeneration;
        while(t < iteration){
            currentAntsGeneration = new ArrayList<>();
            for(Integer i=0;i<nAnts;i++)    currentAntsGeneration.add(new Ant(nNodes));
            this.modifiedPheromonesQuantity = initializeModifiedPheromonesQuantity(nNodes);
            placeAntsRandom(currentAntsGeneration);
            for(Ant ant : currentAntsGeneration){
                while (ant.getSizeOfRemainingNodesToVisit() > 0){
                    Integer next = choseNextNode(ant);
                    ant.addVisitedNode(next);
                }
            }
            evalAntsPopulation(w,d,currentAntsGeneration);
            currentAntsGeneration.sort(Comparator.comparing(a -> a.getScore()));


            modifyPheromonesQuantity(currentAntsGeneration,modifiedPheromonesQuantity);
            actualizeGlobalPheromones(globalPheromonesQuantity,modifiedPheromonesQuantity,evaporationFactor);
            generations.add(currentAntsGeneration);
            t++;
        }
        if(generations.size() == 0){
            return null;
        }
        Ant bestAnt = generations.get(0).get(0);
        for(List<Ant> generation : generations){
            for(Ant ant : generation){
                if(bestAnt.getScore().compareTo(ant.getScore()) > 0){
                    bestAnt = ant;
                }
            }
        }
        return bestAnt;
    }

    public void actualizeGlobalPheromones(
             List<List<Double>> globalPheromonesQuantity,
             List<List<Double>> modifiedPheromonesQuantity,
             Double evaporationFactor
    ){
        for(Integer i=0;i<nNodes;i++){
            for(Integer j=0;j<nNodes;j++){
                globalPheromonesQuantity.get(i).set(j,
                        globalPheromonesQuantity.get(i).get(j) * (1-evaporationFactor) + modifiedPheromonesQuantity.get(i).get(j)
                        );
            }
        }
    }

    public void modifyPheromonesQuantity(List<Ant> currentAntsGeneration,List<List<Double>> modifiedPheromonesQuantity){
        Integer half = currentAntsGeneration.size()/2;
        for(Integer i = half;i<currentAntsGeneration.size();i++){
            increasePheromonesQuantity((double) (i - half + 1),currentAntsGeneration.get(i),modifiedPheromonesQuantity);
        }
    }

    public void increasePheromonesQuantity(Double quantity,Ant ant,List<List<Double>> pheromones){
        for(Integer i=0;i<ant.getVisitedNodesSize()-1;i++){
            pheromones.get(ant.getGene(i)-1).set(
                    ant.getGene(i+1)-1
                    ,pheromones.get(ant.getGene(i)-1).get(ant.getGene(i+1)-1) + quantity);
        }
    }

    public void evalAntsPopulation(List<List<Double>> w,
                               List<List<Double>> d,
                               List<Ant> list){
        list.forEach(el->el.setScore(evalChromosome(w, d,el)));
    }

    public Double evalChromosome(
            List<List<Double>> w,
            List<List<Double>> d,
            Ant ant){
        Double sum = 0.0d;
        for(Integer a=0;a<w.size();a++){
            for(Integer b=0;b<d.size();b++){
                sum = sum
                        +
                        w.get(a).get(b)
                                *
                                d.get(ant.getGene(a)-1).get(ant.getGene(b)-1);
            }
        }
        return sum;
    }

    private List<List<Double>> initializePheromones(Double initialCapacity, Integer nNodes){
        Integer i,j;
        List<List<Double>> pheromones = new ArrayList<>();
        ArrayList<Ant> antsList = new ArrayList<>();

        for(i=0;i<nNodes;i++){
            pheromones.add(new ArrayList<>());
            for(j=0;j<nNodes;j++){
                pheromones.get(i).add(initialCapacity);
            }
        }
        return pheromones;
    }

    private List<List<Double>> initializeModifiedPheromonesQuantity(Integer nNondes){
        List<List<Double>> arr = new ArrayList<>();
        Integer i,j;
        for(i=0;i<nNondes;i++){
            arr.add(new ArrayList<>());
            for(j=0;j<nNondes;j++){
                arr.get(i).add(0.0d);
            }
        }
        return arr;
    }

    private Integer choseNextNode(Ant ant){
        Integer i;
        List<Integer> nodesToVisit = ant.getAllNodesToVisit().stream().collect(Collectors.toList());
        Double totalPheromones = 0.0d;
        for (Integer el: nodesToVisit) {
            totalPheromones += globalPheromonesQuantity.get(ant.getLastNode()-1).get(el-1);
        }
        Double randNr = ThreadLocalRandom.current().nextDouble(0, totalPheromones);
        for(i=0;i<nodesToVisit.size() && randNr >= 0;i++){
            randNr = randNr - globalPheromonesQuantity.get(ant.getLastNode()-1).get(nodesToVisit.get(i)-1);
        }
        return nodesToVisit.get(i-1);
    }

    private void placeAntsRandom(List<Ant> ants){
        Random random = new Random();
        for(Integer i=0;i<ants.size();i++){
            Integer nr = Math.abs(random.nextInt()) % nNodes + 1;
            ants.get(i).addVisitedNode(nr);
        }
    }
}
