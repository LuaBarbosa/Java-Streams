package Oscar;


import java.io.IOException;

import java.nio.file.Files;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Oscar {

    public static void main(String[] args) throws IOException {
        List<Actors> actorsList = readLines(Paths.get("Arquivo1.csv"));
        List<Actors> actressList = readLines(Paths.get("Arquivo2.csv"));

        List<Actors> allActorList = new ArrayList<>(actorsList.size() + actressList.size());
        allActorList.addAll(actorsList);
        allActorList.addAll(actressList);

        System.out.println("O ator mais jovem a ganhar um Oscar foi: " + youngActor(actorsList));
        System.out.println("A atriz mais premiada foi: " + mostAwardedActress(actressList));
        System.out.println("A atriz mais premiada entre 20 e 30 anos foi: " + mostAwardedActressAge(actressList));

    }

    public static List<Actors> readLines(Path file) throws IOException {
    //criando uma lista para ler arquivo
        List<String> lines = Files.readAllLines(file);
        List<Actors> OscarList = new ArrayList<>();

        lines.stream()
                .skip(1)
                .map(line -> line.split(";"))
                .forEach(line -> {
                    OscarList.add(new Actors(Integer.parseInt(line[0].trim()),
                            Integer.parseInt(line[1].trim()), Integer.parseInt(line[2].trim()),
                            line[3].trim(), line[4].trim()));
                });
        return OscarList;
    }

        public static String youngActor (List<Actors> actorsList){
        //qual ator mais novo a ganhar um oscar?
           return actorsList
                   .stream()
                    .min(Comparator.comparing(a -> a.getAge()))
                    .get().getName();
        };

        public static String mostAwardedActress(List<Actors> actressList){
            //atriz mais premiada
            return actressList
                    .stream()
                    .collect(groupingBy(Actors::getName, counting()))
                    .entrySet()
                    .stream()
                    .max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                    .get()
                    .getKey();
        }

        public static String mostAwardedActressAge (List<Actors> actressList){
            //Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?
            return
                    actressList
                            .stream()
                            .filter(list -> list.getAge() > 20 &&  list.getAge() < 30)
                            .collect(groupingBy(Actors::getName, counting()))
                            .entrySet()
                            .stream()
                            .max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                            .get()
                            .getKey();
        }

    public static String mostAwardedAll(List<Actors> allActorList) {
        return null;
    }
    //Quais atores ou atrizes receberam mais de um Oscar?
            // Elabore uma única estrutura contendo atores e atrizes.


        }

}



