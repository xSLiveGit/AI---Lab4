package ACO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergiu on 4/25/2017.
 */
public class Ant {
    private HashSet<Integer> nodesToVisit;
    private List<Integer> visitedNodes;
    private Integer lastInsertedNode = null;
    private Double score = 0.0d;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Ant(Integer nNodes) {
        nodesToVisit = new HashSet<>();
        visitedNodes = new ArrayList<>();
        for(int i=0;i<nNodes;i++){
            nodesToVisit.add(i+1);
        }
    }

    public Integer getVisitedNodesSize(){
        return this.visitedNodes.size();
    }

    public Integer getGene(Integer index){
        return this.visitedNodes.get(index);
    }

    public Integer getSizeOfRemainingNodesToVisit(){
        return this.nodesToVisit.size();
    }

    public void addVisitedNode(Integer n){
        visitedNodes.add(n);
        nodesToVisit.remove(n);
        lastInsertedNode = n;
    }

    public Integer getLastNode(){
        return this.lastInsertedNode;
    }

    public List<Integer> getAllVisitedNodes(){
        return  visitedNodes.stream().collect(Collectors.toList());
    }

    public List<Integer> getAllNodesToVisit(){
        return nodesToVisit.stream().collect(Collectors.toList());
    }

    public boolean canVisitNode(Integer n){
        return nodesToVisit.contains(n);
    }

    public boolean isVisited(Integer node){
        return this.visitedNodes.contains(node);
    }

    public HashSet<Integer> getNodesToVisit() {
        return nodesToVisit;
    }

    public void setNodesToVisit(HashSet<Integer>  nodesToVisit) {
        this.nodesToVisit = nodesToVisit;
    }

    public List<Integer> getVisitedNodes() {
        return visitedNodes;
    }

    public void setNodesVisited(ArrayList<Integer> nodesVisited) {
        this.visitedNodes = nodesVisited;
    }
}
