
public class Zoo {
    private static final int NUMBER_OF_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String city;
    private int nbrAnimals;

    public Zoo(String name, String city) {
        this.name = (name != null && !name.isEmpty()) ? name : "Unnamed Zoo";
        this.city = city;
        this.animals = new Animal[NUMBER_OF_CAGES];
        this.nbrAnimals = 0;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNumberOfAnimals() {
        return nbrAnimals;
    }

    public boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1 || isZooFull() || animal.getAge() < 0)
            return false;

        animals[nbrAnimals++] = animal;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1)
            return false;

        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("List of animals in " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    private int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].equals(animal))
                return i;
        }
        return -1;
    }

    private boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", Number of Animals: " + nbrAnimals + ", Number of Cages: " + NUMBER_OF_CAGES;
    }
}

