package Oscar;


import java.io.IOException;

import java.nio.file.Files;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Oscar {

    public static void main(String[] args) throws IOException {
        List<Actors> ActorsList = readLines(Paths.get("Arquivo1.csv"));
        List<Actors> ActressList = readLines(Paths.get("Arquivo2.csv"));

        List<Actors> allActorList = new ArrayList<>(ActorsList.size() + ActressList.size());
        allActorList.addAll(ActorsList);
        allActorList.addAll(ActressList);



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


        public static String youngActor (){



        };
}


//public static void atrizEntreVinteETrintaMaisVencedora() throws IOException{
        //Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?

       // Path path = Paths.get("Arquivo1.csv");
       // Stream<String> stream = Files.lines(path);
   // }


//}
