import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] args) {
        int addNumbers = 30;
        int sumNumbers = 0;
        Collection<Integer> numbers = new ArrayList<Integer>();
        Collection<Integer> numbersOfThrees = new ArrayList<Integer>();

        for (int i = 1; i <= addNumbers; i++) { //add the number in numbers arrayList.
            numbers.add(i);
        }
        System.out.println(numbers); //Logic work test.


        for (Integer number : numbers) { //Array For sentences. need to add the three numbers in numbersOfThrees ArrayList.
            if (number % 3 == 0) {
                numbersOfThrees.add(number);
            }
        }
        System.out.println(numbersOfThrees); // Logic work test.

        for (Integer addTargetNumber : numbersOfThrees) {
            sumNumbers += addTargetNumber;
        }

        System.out.println(sumNumbers);// Logic work test.

        //---------->> Stream (Lambda ways) << ----------
        Predicate<Integer> testThree = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number % 3 == 0;
            }
        };

        numbers.stream()//Collection --> Stream
                .filter(testThree)//Stream --> Stream
                .toArray();//Stream --> Object Array.


        IntStream.rangeClosed(1, 30) // single thread
                .parallel()// Use a multithreaded. single-threaded -> multithreaded. if you want change to sequential mode, use .sequential() method.
                .forEach(e -> System.out.print(e + " "));

        new ArrayList<>().stream(); // sequential mode.(single-threading)
        new ArrayList<>().parallelStream(); // parallel mode.(multithreading)

        //if check the array or values is not null, then start processing you can use the isPresent method to check.
    }
}
