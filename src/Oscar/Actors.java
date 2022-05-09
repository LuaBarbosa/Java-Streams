package Oscar;

public class Actors {

    int listIndex;
    int year;
    int age;
    String name;
    String movie;
    
    public Actors(int listIndex, int year, int age, String name, String movie) {
        this.listIndex = listIndex;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }


    @Override
    public String toString() {
        return
                "\n listIndex=" + listIndex +
                        ", year=" + year +
                        ", age=" + age +
                        ", name='" + name + '\'' +
                        ", movie='" + movie + '\'';
    }
}
