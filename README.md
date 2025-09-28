# Złożoność obliczeniowa

## Metoda generatePin(int length)
```
for (int i = 0; i < length; i++) {
    int digit = random.nextInt(10);
    pin.append(digit);
}
```

Pętla: wykonuje się `length` razy.

Operacje w każdej iteracji:

`random.nextInt(10)` >>> **O(1)**

`pin.append(digit)` >>> **O(1)**

### Złożoność: O(length) <br/> <br/> <br/>

## Metoda generateToken(int length)
```
for (int i = 0; i < length; i++) {
    int index = random.nextInt(CHARACTERS.length());
    password.append(CHARACTERS.charAt(index));
}
```


Pętla: wykonuje się `length` razy.

Operacje w każdej iteracji:

`random.nextInt(CHARACTERS.length())` >>> **O(1)**

`CHARACTERS.charAt(index)` >>> **O(1)**

`password.append(...)` >>> **O(1)**

### Złożoność: O(length)