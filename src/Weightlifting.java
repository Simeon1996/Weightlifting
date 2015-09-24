import java.util.Scanner;
import java.util.TreeMap;

public class Weightlifting {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        TreeMap<String, TreeMap<String,Long>> players = new TreeMap<>();

        Integer linesCounter = reader.nextInt();

        reader.nextLine();

        for(Integer i = 0; i < linesCounter;i++){
            String[] input = reader.nextLine().split(" ");

            String player = input[0];
            String exercise = input[1];
            Long weight = Long.parseLong(input[2]);

            if(!players.containsKey(player)){
                players.put(player, new TreeMap<String, Long>());
                players.get(player).put(exercise,weight);
            }
            else{
                if(players.get(player).containsKey(exercise)){
                    Long currentWeight = players.get(player).get(exercise);
                    currentWeight += weight;
                    players.get(player).put(exercise,currentWeight);
                }
                else{
                    players.get(player).put(exercise,weight);
                }
            }
        }

        for(String player : players.keySet()){
            System.out.print(player + " : ");

            String output = "";
            for(String exercise : players.get(player).keySet()){
                output += String.format("%s - %d kg, ",exercise,players.get(player).get(exercise));
            }

            System.out.println(output.substring(0, output.length() - 2));
        }
    }
}
