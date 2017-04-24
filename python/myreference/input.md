# input

```python
name = input("What's your name? :")
age = int(input("Your age? : "))
```

```python
def read_float(request_msg, err_msg):
  while True:
    val = input(request_msg)
    try:
      val = float(val)
      return val
    except:
      print(err_msg)

maas = read_float("Maasiniz > ", "Hata: maas virgullu sayi olmalidir.")
```

```python
def read_val(val_type, request_msg, err_msg):
  while True:
    val = input(request_msg)
    try:
      val = val_type(val)
      return val
    except:
      print(err_msg)

sayi = read_val(int, "Bir sayi giriniz > ", "Hata: sayi giriniz.")
maas = read_val(float, "Maasiniz > ", "Hata: maas virgullu sayi olmalidir.")
```
