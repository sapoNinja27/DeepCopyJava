# DeepClone Project

## Description

This project provides a function for performing a deep clone of a Java object. The deep clone function is tested within the `Test` class.

## Getting Started

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sapoNinja27/DeepCopyJava.git 


### Usage

1. Create an instance of the class you want to deep clone.

2. Call the deepClone method to create a deep copy of the instance.

3. The Test class includes test cases that demonstrate how to use the deepClone function.

### Example
Here is an example of how to use the deep clone function:

```java
public class Main {
    public static void main(String[] args) {
        TestObject original = new TestObject(/* initialize fields */);
        TestObject cloned = DeepClone.deepClone(original);

        // Verify the deep clone
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
    }
}
