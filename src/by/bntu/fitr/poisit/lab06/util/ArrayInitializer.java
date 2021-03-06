package by.bntu.fitr.poisit.lab06.util;

import by.bntu.fitr.poisit.lab06.exception.NotEnoughDataException;
import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayInitializer {
    private static final String DEFAULT_FILENAME = ".\\data\\data.txt";

    public void initializeFromFile(@NotNull int[] array, String filename) throws NotEnoughDataException {
        int i = 0;
        try (Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextInt() && i < array.length ){
                array[i] = scanner.nextInt();
                i++;
            }
        } catch (FileNotFoundException e){
            initializeFromFile(array, DEFAULT_FILENAME);
        }

        if (i < array.length){
            throw new NotEnoughDataException("not enough data in " + filename);
        }
    }

    public void initializeFromConsole(@NotNull int[] array){
        int i = 0;
        try (Scanner scanner = new Scanner(System.in)){
            while(i < array.length ){
                array[i] = scanner.nextInt();
                i++;
            }
        } catch (InputMismatchException e){
            e.printStackTrace();
        }

    }
}
