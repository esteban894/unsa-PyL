-- [1,2,3,4] => 6
sumaPares :: [Int] -> Int
sumaPares nums = sum (filter even nums)

-- [3,9,5,6] => 9
maximo :: (Ord a) => [a] -> a
maximo [] = error "Lista vacía"
maximo [a] = a
maximo (x : xs)
  | x > maximo xs = x
  | otherwise = maximo xs

sinRepetidos :: (Eq a) => [a] -> [a]
sinRepetidos [] = []
sinRepetidos (x : xs) = x : sinRepetidos (filter (/= x) xs)

esPerfecto :: Int -> Bool
esPerfecto x = x == sum [n | n <- [1 .. div x 2], mod x n == 0]

pares :: [a] -> [(a, a)]
pares [] = []
pares (x : xs) = [(x, y) | y <- xs] ++ pares xs

promedio :: [Float] -> Float
promedio [] = 0
promedio xs = sum xs / fromIntegral (length xs)

conteo :: (Eq a) => a -> [a] -> Int
conteo x [] = 0
conteo x xs = length (filter (== x) xs)

esPalindromo :: (Eq a) => [a] -> Bool
esPalindromo xs = xs == reverse xs

insertarOrd :: (Ord a) => a -> [a] -> [a]
insertarOrd x [] = [x]
insertarOrd x (y : ys)
  | x <= y = x : y : ys
  | otherwise = y : insertarOrd x ys

distancia :: (Float, Float) -> (Float, Float) -> Float
distancia (x1, y1) (x2, y2) = sqrt ((x2 - x1) ^ 2 + (y2 - y1) ^ 2)