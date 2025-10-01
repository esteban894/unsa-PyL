num = int(input("Numero: "))

def sumDig(num: int):
  return num if num == 0 else num % 10 + sumDig(num//10)

print(sumDig(num))