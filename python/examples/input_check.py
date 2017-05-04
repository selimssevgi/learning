
# get base
input_ok = False
while not input_ok:
  base = input("Enter base: ")
  try:
    base = float(base)
    input_ok = True
  except ValueError as error:
    print(error, ': base must be a floating-point number.')
