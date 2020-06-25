package by.training.homework4_1.entity;

import by.training.homework4_1.validator.ArrayValidator;

import java.util.ArrayList;


public class IntegerArray {
    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_INDEX = 0;
    private static ArrayValidator validator;

    private final int[] array;
    private final int size;

    static {
        validator = new ArrayValidator();
    }

    public IntegerArray(int size) {
        if (size < 0) {
            size = DEFAULT_SIZE;
        }
        this.array = new int[size];
        this.size = size;
    }

    public IntegerArray(int... content) {
        if (content == null) {
            this.array = new int[DEFAULT_SIZE];
            this.size = DEFAULT_SIZE;
        } else {
            this.size = content.length;
            this.array = new int[size];
            for (int i = 0; i < size; i++) {
                this.array[i] = content[i];
            }
        }
    }

    public IntegerArray(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            this.array = new int[DEFAULT_SIZE];
            this.size = DEFAULT_SIZE;
        } else {
            this.size = arrayList.size();
            this.array = new int[size];
            for (int i = 0; i < size; i++) {
                this.array[i] = arrayList.get(i);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getElementByIndex(int index) {
        if (!validator.validateArrayBounds(array, index)) {
            return this.array[DEFAULT_INDEX];
        }
        return this.array[index];
    }

    public boolean setElementByIndex(int index, int number) {
        if (!validator.validateArrayBounds(array, index)) {
            return false;
        }
        this.array[index] = number;
        return true;
    }

    public int[] getArrayCopy() {
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }
        return newArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegerArray integerArray = (IntegerArray) o;
        if (integerArray.size != size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] != integerArray.getElementByIndex(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : array) {
            result = 17 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Size: ").append(size);
        sb.append(". Content of array: [");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(this.array[i]);
            } else {
                sb.append(this.array[i]).append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
