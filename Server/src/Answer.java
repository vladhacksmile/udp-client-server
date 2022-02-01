import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Answer implements Serializable {
    private ArrayList<String> answer;
    private PriorityQueue<Organization> collection;
    private boolean success;

    public Answer(Object object, boolean success) {
        if(object instanceof ArrayList) this.answer = (ArrayList<String>) object;
        if(object instanceof PriorityQueue) this.collection = (PriorityQueue<Organization>) object;
        this.success = success;
    }

    public PriorityQueue<Organization> getCollection() {
        return collection;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        if(collection != null) return collection.toString();
        else return answer.toString();
    }

    public void printArray() {
        answer.stream().forEach(System.out::println);
    }
}