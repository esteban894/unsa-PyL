f :: Float -> Float
f x = 3 * x + 2

g :: Float -> Float -> Float
g x y
  | x ^ 2 + y ^ 2 /= 0 = 1 / (x ^ 2 + y ^ 2)
  | otherwise = 0

g1 x y
  | x * x + y * y == 0 = 0
  | otherwise = 1 / (x * x + y * y)

fact 0 = 1
fact x = fact (x - 1) * x

fibo 0 = 1
fibo 1 = 0
fibo x = fibo (x - 1) + fibo (x - 2)

{-func x =
  if x rem 2 == 0
    then putStrLn "numero par"
    else putStrLn "numero impar"-}

sumDig :: Int -> Int
sumDig 0 = 0
sumDig x = mod x 10 + sumDig (div x 10)

sumDig2 :: Int -> Int
sumDig2 x
  | x <= 9 = x
  | otherwise = mod x 10 + sumDig2 (div x 10)

-- sumElem :: [Int] -> Int
-- sumElem [] = 0
-- sumElem (x : xs) = x + sumElem xs

insertLast :: [Int] -> Int -> [Int]
insertLast [] x = [x]
insertLast l x = reverse (x : reverse l)

cuadrado :: Int -> Int
cuadrado x = x * x

boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

doble x = 2 * x

suma x y = x + y