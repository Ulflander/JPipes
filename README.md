JPipes
======

Java pattern for normal/threaded pipelines

### A normal pipeline with 3 pipes

```

   > - (A) - - (B) - - (C) - >

```

### A pipeline with 2 normal pipes and 2 threaded pipes

```
               - (B1) -
             /          \
   > - (A) -              - (C) - >
             \          /
               - (B2) -
```

### A more complex one

```
               - (B1) -             - (D1) -
             /          \         /          \
   > - (A) -              - (C) - - - (D2) - - - (E) - >
             \          /         \          /
               - (B2) -             - (D3) -
```