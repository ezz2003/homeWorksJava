package Hworks;

public class Cat {
    String nameCat;
    int yearOfBirth, weight;

    public Cat(String nameCat, int yearOfBirth, int weight){
        this.nameCat = nameCat;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
    }

    public Cat() {

    }

    @Override
    public String toString() {
        return String.format("%s %d %d ", this.nameCat, this.yearOfBirth, this.weight);
    }

    @Override
    public boolean equals(Object o) {
        var c = (Cat) o;
        return this.nameCat == c.nameCat && this.yearOfBirth == c.yearOfBirth && this.weight ==c.weight;
    }

    @Override
    public int hashCode() {
        int sumNumSymb = 0;
        for (char ch : this.nameCat.toCharArray()) {
            sumNumSymb += (int) ch;
        }
        return weight + sumNumSymb + this.yearOfBirth;
    }
}
