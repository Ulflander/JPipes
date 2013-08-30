JPipes
======

Java pattern for normal/threaded pipelines

Current version: `0.1.0`

#### Install

Add this maven repo to your pom.xml:

```
	<repositories>
        <repository>
            <id>JPipes</id>
            <url>https://raw.github.com/Ulflander/JPipes/master/snapshots</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```

And this dependency:
```
    <dependencies>
        <dependency>
            <groupId>com.ulflander</groupId>
            <artifactId>JPipes</artifactId>
            <version>0.1.0</version>
        </dependency>
    </dependencies>
```

#### A normal pipeline with 3 pipes

```

   > - (A) - - (B) - - (C) - >

```

#### A pipeline with 2 normal pipes and 2 threaded pipes

```
               - (B1) -
             /          \
   > - (A) -              - (C) - >
             \          /
               - (B2) -
```

#### A more complex one

```
               - (B1) -             - (D1) -
             /          \         /          \
   > - (A) -              - (C) - - - (D2) - - - (E) - >
             \          /         \          /
               - (B2) -             - (D3) -
```


#### Deploy to github

```
$ mvn -DaltDeploymentRepository=snapshot-repo::default::file:snapshots clean deploy
```