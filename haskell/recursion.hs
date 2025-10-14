factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)

prod :: Int -> Int -> Int
prod m 0 = 0 -- prod _ 0 = 0 -- donde _ se llama variable anonima
prod m n = m + prod m (n - 1)

tam :: [a] -> Int
tam [] = 0
tam (_ : xs) = 1 + tam xs

zip2 :: [a] -> [b] -> [(a, b)] -- zip ya existe
zip2 [] _ = []
zip2 _ [] = []
zip2 (x : xs) (y : ys) = (x, y) : zip2 xs ys

-- recursion multiple
fibo :: Int -> Int
fibo 0 = 0
fibo 1 = 1
fibo n = fibo (n - 1) + fibo (n - 2)

-- recursion mutua o indirecta en materias anteriores
pares :: [a] -> [a]
pares [] = []
pares (x : xs) = x : impares xs

impares :: [a] -> [a]
impares [] = []
impares (_ : xs) = pares xs
