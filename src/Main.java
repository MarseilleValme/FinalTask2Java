import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] name = {"Тачка", "Пушка", "Пицца", "Водка", "Коньяк", "Кокс", "Виагра", "Тёлка", "Тёлка", "PS"};
        int[] frequency = {20, 20, 25, 60, 30, 80, 30, 40, 20, 50};

        PriorityQueue Queue = new PriorityQueue(Comparator);
        for (int i = 0; i < id.length; i++) {
            Toy toy = new Toy(id[i], name[i], frequency[i]);
            Queue.add(toy);
        }

        String file = "AdultToys.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            while(true){
                Toy toy = (Toy) Queue.poll();
                if(toy == null) break;
                writer.write(String.format("Id: %d, Название: %s, Частота: %d" +"\n",
                        toy.getId(), toy.getName(), toy.getFrequency()));
            }
        } catch (IOException e) {
            System.out.println("Что-то о5 пошло не так");
        }
    }
    public static Comparator<Toy> Comparator = (c1, c2) -> (int) (c2.getFrequency() - c1.getFrequency());
}

