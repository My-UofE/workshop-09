[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18357061)

## Example java project structure and how to work within it

This simple java project directory has been defined with the following structure:

```
PROJECT ROOT DIRECTORY
|
|---bin << jar file >>
|
|---build---PACKAGES--- << java binaries (class files) >>
|
|---doc-- << documentation files >>
|
|---res-- << resource files >>
|
|----src---PACKAGEs--- << java files >>
|
|----TestSystem--- << test files >>
```

In this case the example project is a package named `backend`.

This contains a simple object class `Element` and a backend service for creating and working with `Element` objects. The system methods are set out in the `MyServiceInterface.java` interface which are then implemented in the `MyServiceImplementation.java` class. 

All package source code is placed in a package folder in the `src` (source code) folder.

In each of the class files that are part of the package, the first line of code specifies the package
the file is part of (i.e. if you open any of the files in `./src/backend` you will see the first code line is `package backend;`).

#### Working within the project structure

When developing the code we can use the following process to build the classes and test the compiled files using a test application (e.g. here we have a directory called TestSystem containing a program to test the `backend` package.)

All the following commands should be executed from the root project directory (i.e. the folders are all specified, and we don't need to change into the various directories to build or run code).

##### Build the binaries

The first step of packaging our project code is to compile the binaries and store into the `bin` folder. To do this we compile all our project classes in order of dependencies (i.e. here we cannot compile `MyServiceInterface.java` until we have compiled `Element.java`)

The `-d bin` argument saves the resulting `.class` binaries into the project's `bin` folder.

```
javac -d bin -cp bin src/backend/Element.java
javac -d bin -cp bin src/backend/MyServiceInterface.java 
javac -d bin -cp bin src/backend/MyServiceImplementation.java 
```

##### Run tests on the compiled files

Compile the `TestClient` program. 

This produces the `TestClient.class` file in the `TestSystem` folder. 

Note we have to specify the class path (`-cp`) with the `bin` folder that contains the binaries for the classes needed by `TestClient.java`.

```
javac -cp bin ./TestSystem/TestClient.java
```

We can now run the test file. Now we need to specify both `bin` and `TestSystem` as the folders that contain the necessary binaries to run the `TestClient` program.

```
java -cp bin:TestSystem TestClient
```

You should see the program runs. Check the output against the code in `TestClient.java` and you should be able to verify the implementation is working as expected.

```
Testing my system integration.
Before creating elements, my system has 0 elements.
Element created. Id = 1
After creating one element, my system has 1 elements.
What is the name of the element ID=10? null
What is the name of the element created? my first element
```

##### Make the documentation

We can build the documentation using the following code.

```
javadoc -sourcepath src -d doc  backend
```

Here we have specified: the folder that contains the source code; the folder for the output `.html` files; and the name of the package to be documented.

To download the doc folder from CodeSpaces it is useful to make a zip archive of the folder which can then be downloaded (right click in the explorer panel) e.g.

```
zip -r backend_docs.zip ./doc
```

##### Make the jar file

We use `jar cvf` to create a jar file to distribute our code as a single file. The following will make a new jar file containing our project binaries.

```
jar cvf ./build/ecm1410_jar_demo_v1_0.jar -C bin .
```

Here the `-C` option lets us specify the folder containing the files to add, and the `.` that follows means add all files from that folder to the jar.

We can also add other files we might like to distribute e.g. documentation, source code.
In this case we won't add these because they can be accessed via the GitHub repositories.

##### Test / Use the jar

We can use the following code to see the files and structure of the `jar` file:

```
jar -tf ./build/ecm1410_jar_demo_v1_0.jar
```

The jar file we have created can be used instead of the binaries when compiling and running code that makes use of the package it contains, e.g. we can run the `TestClient` program using:

```
java -cp ./build/ecm1410_jar_demo_v1_0.jar:TestSystem TestClient
```
