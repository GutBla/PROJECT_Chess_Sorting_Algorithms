# Chess : Sorting Algorithms
![Java](https://img.shields.io/badge/Java-red)

![Protada_Chess_Sorting_Algorithms.png](images/Protada_Chess_Sorting_Algorithms.png)

# Algoritmos de Ordenamiento para Ajedrez

## ¿Qué es el Ajedrez?

El ajedrez es un juego de estrategia de mesa que se juega entre dos personas. Se desarrolla en un tablero de 8x8 casillas y cada jugador cuenta con un conjunto de 16 piezas, cada una con movimientos y funciones específicas. El objetivo principal del juego es capturar al rey del oponente mediante una serie de movimientos estratégicos.

![Todo sobre el Ajedrez.png](images/Todo_sobre_el_Ajedrez.png)

## Historia del Ajedrez

El ajedrez tiene una historia milenaria que se remonta a la India en el siglo VI, donde se jugaba una versión primitiva llamada "Chaturanga". Este juego se extendió a Persia, donde se le llamó "Shatranj" y posteriormente llegó a Europa a través de los árabes. En el siglo XV, el ajedrez moderno tomó forma en España e Italia, con las reglas y movimientos que conocemos hoy en día.

![Historia_Chess.png](images/Historia_Chess.png)

## Piezas del Ajedrez

El juego consta de las siguientes piezas:

| Pieza | Icono | Abreviaciones | Movimiento |
| --- | --- | --- | --- |
| Rey | ♔ / ♚ | KB / KN | Se mueve una casilla en cualquier dirección |
| Reina | ♕ / ♛ | QB / QN | Se mueve en todas las direcciones sin límite de casillas |
| Torre | ♖ / ♜ | TB / TN | Se mueve en líneas rectas |
| Alfil | ♗ / ♝ | AB / AN | Se mueve en diagonales |
| Caballo | ♘ / ♞ | CB / CN | Se mueve en "L" |
| Peón | ♙ / ♟ | PB / PN | Se mueve una casilla hacia adelante, captura en diagonal |

![Piezas de Ajedrez.png](images/Piezas_de_Ajedrez.png)

---

## Tablero de Ajedrez

El tablero de ajedrez es una cuadrícula de 8x8 casillas alternadas entre colores claros y oscuros. Cada casilla está identificada por coordenadas alfanuméricas (ejemplo: "e4").

```bash
  +----+----+----+----+----+----+----+----+
8 | TN | CN | AN | QN | KN | AN | CN | TN |
  +----+----+----+----+----+----+----+----+
7 | PN | PN | PN | PN | PN | PN | PN | PN |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 | PN | PN | PN | PN | PN | PN | PN | PN |
  +----+----+----+----+----+----+----+----+
1 | TN | CN | AN | QN | KN | AN | CN | TN |
  +----+----+----+----+----+----+----+----+
    A    B    C    D    E    F    G    H

```

```bash
  +----+----+----+----+----+----+----+----+
8 | ♜ | ♞ | ♝ | ♛ | ♚ | ♝ | ♞ | ♜ |
  +----+----+----+----+----+----+----+----+
7 | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ | ♙ |
  +----+----+----+----+----+----+----+----+
1 | ♖ | ♘ | ♗ | ♕ | ♔ | ♗ | ♘ | ♖ |
  +----+----+----+----+----+----+----+----+
    A    B    C    D    E    F    G    H

```

![Tablero de Ajedrez.png](images/Tablero_de_Ajedrez.png)

## Algoritmos de Ordenamiento (a)

Los algoritmos de ordenamiento son procedimientos diseñados para organizar un conjunto de elementos en un orden determinado, ya sea ascendente o descendente. Estos algoritmos tienen aplicaciones en informática, bases de datos y en este caso, en la organización de las piezas de ajedrez en un tablero.

> [!WARNING]
Algoritmos de Ordenamiento (a):
> 
> - **Valores Válidos:** s, b , i, m, q, h, c, r.
> - **Validación:** Si no es uno de los valores validos, se considera **inválido**.


### Selection Sort (Selección) `a=s` o `a=S`

Este algoritmo selecciona el elemento más pequeño y lo intercambia con el primer elemento, repitiendo este proceso con el resto de la lista.

![Selection_sort.png](images/Selection_sort.png)

### Bubble Sort (Burbuja) `a=b` o `a=B`

Compara elementos adyacentes y los intercambia si están en el orden incorrecto, recorriendo la lista varias veces.

![Bubble_sort.png](images/Bubble_sort.png)

### Insertion Sort (Inserción) `a=i` o `a=I`

Inserta cada elemento en su posición correcta dentro de una parte ordenada de la lista.

![Insertion_sort.png](images/Insertion_sort.png)

### Merge Sort (Combinación) `a=m` o `a=M`

Divide la lista en partes más pequeñas, las ordena y luego las combina en una lista ordenada.

![Merge_sort.png](images/Merge_sort.png)

### Quick Sort (Rápida) `a=q` o `a=Q`

Selecciona un pivote, divide la lista en elementos menores y mayores que el pivote y ordena cada sublista recursivamente.

![Quick_sort.png](images/Quick_sort.png)

### Heap Sort (Montón) `a=h` o `a=H`

Construye un montón binario y extrae el elemento más grande repetidamente para formar la lista ordenada.

![Heap_sort.png](images/Heap_sort.png)

### Counting Sort (Conteo) `a=c` o `a=C`

Cuenta la frecuencia de cada elemento y usa esa información para construir la lista ordenada.

![Counting_sort.png](images/Counting_sort.png)

### Radix Sort (Raíz) `a=r` o `a=R`

Ordena los números considerando sus dígitos de menor a mayor peso.

![Radix_sort.png](images/Radix_sort.png)

## Tipos de Listas (t)

En el proyecto se pueden representar las piezas del ajedrez usando dos tipos de listas:

> [!WARNING]
Tipos de Listas (t):
> 
> - **Valores Válidos:** n , c
> - **Validación:** Si no es uno de los valores validos, se considera **inválido**

### Lista de Números `t=n` o `t=N`

```
1. Rey
2. Reina
3. Torre I
4. Torre II
5. Alfil I
6. Alfil II
7. Caballo I
8. Caballo II
9. Peón 1
10. Peón 2
11. Peón 3
12. Peón 4
13. Peón 5
14. Peón 6
15. Peón 7
16. Peón 8
```

### Lista de Caracteres `t=c` o `t=C`

```
a. Rey
b. Reina
c. Torre I
d. Torre II
e. Alfil I
f. Alfil II
g. Caballo I
h. Caballo II
i. Peón 1
j. Peón 2
k. Peón 3
l. Peón 4
m. Peón 5
n. Peón 6
o. Peón 7
p. Peón 8
```

## ¿Qué significa el Color de Piezas (c)?

Las piezas pueden tener dos colores:

> [!WARNING]
Color de Piezas (c):
> 
> - **Valores Válidos:** b , w
> - **Validación:** Si no es uno de los valores validos, se considera **inválido**

### Piezas Negras

Representan el jugador de las piezas oscuras.  `c=b` o `c=B`

### Piezas Blancas

Representan el jugador de las piezas claras. `c=w` o `c+W`

## ¿Qué es la Cantidad de Piezas (r)?

Determina cuántas piezas se colocan en el tablero:

> [!WARNING]
Cantidad de Piezas (r):
> 
> - **Valores Válidos:** 1, 2, 3, 4, 6, 8, 10, 16
> - **Validación:** Si no es uno de los valores validos, se considera **inválido**


| Valor | Piezas Incluidas |
| --- | --- |
| 1 | Rey |
| 2 | Rey y Reina |
| 4 | Alfiles, Rey y Reina |
| 6 | Caballos, Alfiles, Rey y Reina |
| 8 | Torres, Caballos, Alfiles, Rey y Reina |
| 10 | Peones |
| 16 | Todas las piezas |

## ¿Qué es la Velocidad (s)?

La velocidad `s` representa la pausa en milisegundos entre cada paso de ejecución de los algoritmos, variando entre 100 y 1000 ms.

> [!WARNING]
Cantidad de Piezas (r):
> 
> - **Valores Válidos (Rango):** (100 - 1000)
> - **Validación:** Si no es uno de los valores validos dentro del rango, se considera **inválido**


## Simulación y Resultados

Este documento proporciona una base académica y estructurada para el desarrollo del proyecto Capstone Chess, asegurando una explicación detallada y ordenada de los elementos involucrados.

**Configuración de Simulación:**

Input (CLI):

```bash
a=b t=n c=w r=16 s=200
```

Output:

```bash
Algoritmo: [BubbleSort]
Tipo de lista: [Lista numérica]
Color de piezas: [Blancas]
Número de piezas: [16]
Velocidad: [200] ms
```

```bash
  +----+----+----+----+----+----+----+----+
8 | ♜ |    |    | ♝ |    | ♟ |    |    |
  +----+----+----+----+----+----+----+----+
7 |    | ♞ |    |    | ♟ |    |    |    |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    | ♟ |    |
  +----+----+----+----+----+----+----+----+
5 | ♟ |    | ♟ |    | ♛ |    |    |    |
  +----+----+----+----+----+----+----+----+
4 | ♟ | ♜ |    |    |    |    | ♟ |    |
  +----+----+----+----+----+----+----+----+
3 |    | ♚ |    | ♟ |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 |    |    |    |    |    | ♞ |    |    |
  +----+----+----+----+----+----+----+----+
1 |    |    | ♝ |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
    A    B    C    D    E    F    G    H

```

```bash
  +----+----+----+----+----+----+----+----+
8 | ♜ | ♝ | ♟ | ♞ | ♟ | ♟ | ♟ | ♟ |
  +----+----+----+----+----+----+----+----+
7 | ♟ | ♛ | ♟ | ♜ | ♚ | ♟ | ♞ | ♝ | 
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
1 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
    A    B    C    D    E    F    G    H
```

…

```bash

Tiempo total: [4249] ms
  +----+----+----+----+----+----+----+----+
8 | ♜ | ♞ | ♝ | ♛ | ♚ | ♝ | ♞ | ♜ |
  +----+----+----+----+----+----+----+----+
7 | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ | ♟ |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
1 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
    A    B    C    D    E    F    G    H
```

## Workflow (Flujo de trabajo)

```bash
---
config:
  theme: default
---
classDiagram
direction TB
    class Main {
	    +main(String[] args)
    }
    class SortingAlgorithm {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
    }
    class BubbleSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
    }
    class CountingSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
    }
    class HeapSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
	    -heapify(List~ChessPiece~, int, int, int, ChessBoard) throws InterruptedException
    }
    class InsertionSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
    }
    class MergeSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
	    -mergeSort(List~ChessPiece~, int, int, int, ChessBoard) throws InterruptedException
	    -merge(List~ChessPiece~, int, int, int, int, ChessBoard) throws InterruptedException
    }
    class QuickSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
	    -quickSort(List~ChessPiece~, int, int, int, ChessBoard) throws InterruptedException
	    -partition(List~ChessPiece~, int, int, int, ChessBoard) throws InterruptedException
    }
    class RadixSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
	    -countSort(List~ChessPiece~, int, int, ChessBoard) throws InterruptedException
    }
    class SelectionSort {
	    +sort(List~ChessPiece~, int, ChessBoard) throws InterruptedException
	    +getName() : String
    }
    class SortingAlgorithmFactory {
	    +getAlgorithm(String) : SortingAlgorithm
    }
    class GameConfig {
	    +BOARD_SIZE : int
	    +startGame(String[] args) throws InterruptedException
	    -validateConfig(int, int) : void
    }
    class ListType {
	    +NUMERIC
	    +CHARACTER
	    -code : String
	    +fromCode(String) : ListType
    }
    class PieceColor {
	    +WHITE
	    +BLACK
	    -code : String
	    +fromCode(String) : PieceColor
    }
    class PieceType {
	    +KING
	    +QUEEN
	    +ROOK_I
	    +ROOK_II
	    +BISHOP_I
	    +BISHOP_II
	    +KNIGHT_I
	    +KNIGHT_II
	    +PAWN_1
	    +PAWN_2
	    +PAWN_3
	    +PAWN_4
	    +PAWN_5
	    +PAWN_6
	    +PAWN_7
	    +PAWN_8
	    -value : int
	    -whiteSymbol : String
	    -blackSymbol : String
	    -charValue : String
	    +getValue() : int
	    +getCharValue() : String
	    +getSymbol(PieceColor) : String
	    +fromValue(int) : PieceType
    }
    class SortingAlgorithmType {
	    +BUBBLE_SORT
	    +SELECTION_SORT
	    +INSERTION_SORT
	    +MERGE_SORT
	    +QUICK_SORT
	    +HEAP_SORT
	    +COUNTING_SORT
	    +RADIX_SORT
	    -code : String
	    -algorithm : SortingAlgorithm
	    +getAlgorithm() : SortingAlgorithm
	    +fromCode(String) : SortingAlgorithmType
    }
    class ChessBoard {
	    -grid : ChessPiece[][]
	    -listType : ListType
	    +ChessBoard(ListType)
	    +placePiecesRandomly(List~ChessPiece~) : void
	    +updateLayout(List~ChessPiece~) : void
	    +getListType() : ListType
	    +getGrid() : ChessPiece[][]
	    -clearBoard() : void
    }
    class ChessCell {
	    -row : int
	    -column : int
	    -piece : ChessPiece
	    +ChessCell(int, int)
	    +getRow() : int
	    +getColumn() : int
	    +getPiece() : ChessPiece
	    +setPiece(ChessPiece) : void
    }
    class ChessGame {
	    -algorithm : SortingAlgorithm
	    -board : ChessBoard
	    -speed : int
	    -pieces : List~ChessPiece~
	    +ChessGame(SortingAlgorithm, ListType, PieceColor, int, int)
	    -generatePieces(PieceColor, int) : List~ChessPiece~
	    +run() : void throws InterruptedException
	    +getBoard() : ChessBoard
    }
    class ChessPiece {
	    -type : PieceType
	    -color : PieceColor
	    +ChessPiece(PieceType, PieceColor)
	    +getSymbol() : String
	    +getType() : PieceType
	    +compareTo(ChessPiece) : int
    }
    class CLIUtils {
	    +getAlgorithmType(ArrayList~String~) : SortingAlgorithmType
	    +getListType(ArrayList~String~) : ListType
	    +getPieceColor(ArrayList~String~) : PieceColor
	    +getPieceCount(ArrayList~String~) : int
	    +getSpeed(ArrayList~String~) : int
	    -getParamValue(ArrayList~String~, String) : String
    }
    class GameUtils {
	    +updateBoardAndSleep(ChessBoard, List~ChessPiece~, int) throws InterruptedException
	    +listToString(List~ChessPiece~, ListType) : String
    }
    class Renderer {
	    +printConfig(String, ListType, PieceColor, int, int) : void
	    +displayBoard(ChessBoard) : void
	    -getBoardDesign(ChessBoard) : String
    }
    class Comparable {
    }

	<<interface>> SortingAlgorithm
	<<enumeration>> ListType
	<<enumeration>> PieceColor
	<<enumeration>> PieceType
	<<enumeration>> SortingAlgorithmType

    BubbleSort --|> SortingAlgorithm
    CountingSort --|> SortingAlgorithm
    HeapSort --|> SortingAlgorithm
    InsertionSort --|> SortingAlgorithm
    MergeSort --|> SortingAlgorithm
    QuickSort --|> SortingAlgorithm
    RadixSort --|> SortingAlgorithm
    SelectionSort --|> SortingAlgorithm
    Main --> GameConfig : uses
    GameConfig --> CLI : uses
    GameConfig --> Renderer : uses
    GameConfig --> ChessGame : creates
    ChessGame --> ChessBoard : uses
    ChessGame --> ChessPiece : uses
    ChessGame --> SortingAlgorithm : uses
    SortingAlgorithmFactory --> SortingAlgorithmType : uses
    SortingAlgorithmType --> SortingAlgorithm : creates
    CLI ..> ListType
    CLI ..> PieceColor
    CLI ..> SortingAlgorithmType
    GameUtils ..> Renderer
    Renderer ..> ChessBoard
    ChessPiece ..|> Comparable

	class Main:::Ash
	class SortingAlgorithm:::Ash
	class GameConfig:::Peach
	class PieceType:::Aqua
	class ChessBoard:::Rose
	class ChessGame:::Aqua
	class ChessGame:::Pine
	class ChessPiece:::Ash
	class CLI:::Ash
	class GameUtils:::Rose
	class Renderer:::Aqua
	class Comparable:::Rose

	classDef Peach :, stroke-width:1px, stroke-dasharray:none, stroke:#FBB35A, fill:#FFEFDB, color:#8F632D
	classDef Pine :, stroke-width:1px, stroke-dasharray:none, stroke:#254336, fill:#27654A, color:#FFFFFF
	classDef Aqua :, stroke-width:1px, stroke-dasharray:none, stroke:#46EDC8, fill:#DEFFF8, color:#378E7A
	classDef Ash :, stroke-width:1px, stroke-dasharray:none, stroke:#999999, fill:#EEEEEE, color:#000000
	classDef Rose :,stroke-width:1px, stroke-dasharray:none, stroke:#FF5978, fill:#FFDFE5, color:#8E2236


```


![Capstone_Chess_Diagrama.png](images/Capstone_Chess_Diagrama.png)
## Execution (Ejecución)

![Capstone_Chess_Ejecucion_1.png](images/Capstone_Chess_Ejecucion_1.png)

![Capstone_Chess_Ejecucion_2.png](images/Capstone_Chess_Ejecucion_2.png)
