public class AnimalShelter {

    public AnimalShelter() {
        // do initialize if necessary
        tot = 0;
        dogs = new LinkedList<String>();
        cats = new LinkedList<String>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // write your code here
        tot += 1;
        if (type == 1)
            dogs.add(tot + "#" + name);
        else
            cats.add(tot + "#" + name);
    }

    public String dequeueAny() {
        // write your code here
        if (cats.isEmpty())
            return dequeueDog();
        else if (dogs.isEmpty())
            return dequeueCat();
        else {
            int d_time = getTime(dogs.getFirst());
            int c_time = getTime(cats.getFirst());
            if (c_time < d_time)
                return dequeueCat();
            else
                return dequeueDog();
        }
    }

    public String dequeueDog() {
        // write your code here
        String name = getName(dogs.getFirst());
        dogs.removeFirst();
        return name;
    }

    public String dequeueCat() {
        // write your code here
        String name = getName(cats.getFirst());
        cats.removeFirst();
        return name;
    }

    private int tot;
    private LinkedList<String> cats, dogs;
    private String getName(String str) {
        return str.substring(str.indexOf("#") + 1, str.length());
    }
    private int getTime(String str) {
        return Integer.parseInt(str.substring(0, str.indexOf("#")));
    }
}

An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.

Have you met this question in a real interview? Yes
Example
int CAT = 0
int DOG = 1

enqueue("james", DOG);
enqueue("tom", DOG);
enqueue("mimi", CAT);
dequeueAny();  // should return "james"
dequeueCat();  // should return "mimi"
dequeueDog();  // should return "tom"
Challenge 
Can you do it with single Queue?

Tags 
Linked List Queue
