package Oscar;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.util.Comparator;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Oscar {

    public static void main(String[] args) throws IOException {
        atorMaisJovem();

    }

    public static void atorMaisJovem() throws IOException {
        //Quem foi o ator mais jovem a ganhar um Oscar?
        Path path = Paths.get("Arquivo1.csv");
        Stream<String> stream = Files.lines(path);
        List<Actors> listActors;
        listActors = stream
                .skip(1)
                .map(line -> line.split(";"))
                .map(col-> new Actors(Integer.parseInt(col[0].trim()), Integer.parseInt(col[1].trim()), Integer.parseInt(col[2].trim()), col[3].trim(), col[4].trim()))
               .collect(Collectors.toList());


        System.out.println(listActors);

        Optional<Integer> younger =
        listActors.stream().min(Comparator.comparing(a -> a.getAge());
    };

    //public static void atrizMaispremiada() throws IOException{
        //Quem foi a atriz que mais vezes foi premiada?

        //Path path = Paths.get("Arquivo1.csv");
       // Stream<String> stream = Files.lines(path);


    }

    //public static void atrizEntreVinteETrintaMaisVencedora() throws IOException{
        //Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?

       // Path path = Paths.get("Arquivo1.csv");
       // Stream<String> stream = Files.lines(path);
   // }


//}
