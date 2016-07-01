package enterprise.module_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Evaluator {
    private List<String> resultForArrayList = new ArrayList();
    private List<String> resultForLinkedList = new ArrayList();
    private List<String> resultForHashSet = new ArrayList();
    private List<String> resultForTreeSet = new ArrayList();
    private StringBuilder stringBuilder = new StringBuilder();
    private StringBuilder stringBuilderForFile = new StringBuilder();
    ComparingList comparingList = new ComparingList();
    ComparingSet comparingSet = new ComparingSet();



    public void getListResult(List list, int size) {
        if(list instanceof ArrayList) {
            saveListResult(list, resultForArrayList, size);
        }
        else if (list instanceof LinkedList) {
            saveListResult(list, resultForLinkedList, size);
        }
    }

    private void saveListResult(List list, List resultList, int size) {
        resultList.add(0, list.getClass().getSimpleName());
        resultList.add(1, String.valueOf(comparingList.add(list, size)));
        resultList.add(2, String.valueOf(comparingList.get(list, size)));
        resultList.add(3, String.valueOf(comparingList.remove(list, size)));
        resultList.add(4, String.valueOf(comparingList.contains(list, size)));
        resultList.add(5, String.valueOf(comparingList.populate(list, size)));
        resultList.add(6, String.valueOf(comparingList.listIteratorAdd(list, size)));
        resultList.add(7, String.valueOf(comparingList.listIteratorRemove(list, size)));
    }

    public void getSetResult(Set set, int size) {
        if(set instanceof HashSet) {
            saveSetResult(set, resultForHashSet, size);
        }
        else if (set instanceof TreeSet) {
            saveSetResult(set, resultForTreeSet, size);
        }
    }

    private void saveSetResult(Set set, List resultSet, int size) {
        resultSet.add(0, set.getClass().getSimpleName());
        resultSet.add(1, String.valueOf(comparingSet.add(set, size)));
        resultSet.add(2, "-");
        resultSet.add(3, String.valueOf(comparingSet.remove(set, size)));
        resultSet.add(4, String.valueOf(comparingSet.contains(set, size)));
        resultSet.add(5, String.valueOf(comparingSet.populate(set, size)));
        resultSet.add(6, "-");
        resultSet.add(7, "-");
    }

    public void evaluate(int size) {
        getListResult(new ArrayList<>(), size);
        getListResult(new LinkedList<>(), size);
        getSetResult(new HashSet<>(), size);
        getSetResult(new TreeSet<>(), size);
    }

    public void printResult(String strSize, int size) {
        evaluate(size);
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", strSize, "add", "get", "remove", "contains", "populate", "listIteratorAdd", "listIteratorRemove"));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForArrayList.get(0), resultForArrayList.get(1), resultForArrayList.get(2), resultForArrayList.get(3),
                resultForArrayList.get(4), resultForArrayList.get(5), resultForArrayList.get(6), resultForArrayList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForLinkedList.get(0), resultForLinkedList.get(1), resultForLinkedList.get(2), resultForLinkedList.get(3),
                resultForLinkedList.get(4), resultForLinkedList.get(5), resultForLinkedList.get(6), resultForLinkedList.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForHashSet.get(0), resultForHashSet.get(1), resultForHashSet.get(2), resultForHashSet.get(3),
                resultForHashSet.get(4), resultForHashSet.get(5), resultForHashSet.get(6), resultForHashSet.get(7)));
        stringBuilder.append(String.format("%-12s%10s%10s%15s%15s%15s%22s%23s%n", resultForTreeSet.get(0), resultForTreeSet.get(1), resultForTreeSet.get(2), resultForTreeSet.get(3),
                resultForTreeSet.get(4), resultForTreeSet.get(5), resultForTreeSet.get(6), resultForTreeSet.get(7)));
        stringBuilder.append(String.format("%52s%n", "--------------------------------------------------------------------------------------------------------------------------"));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("\n"));
        stringBuilder.append(String.format("\n"));
        System.out.println(stringBuilder.toString());
        stringBuilderForFile.append(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void writeToFile(String fileName){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)))) {
             bufferedWriter.write(stringBuilderForFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // only for testing
    public List<String> getResultForArrayList() {
        return resultForArrayList;
    }

    // only for testing
    public List<String> getResultForLinkedList() {
        return resultForLinkedList;
    }
}
