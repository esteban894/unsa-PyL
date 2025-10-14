-- calcular polinomios
-- suma de 2 polinomios
-- multiplicar por escalar
-- grado del polinomio
-- [(escalar, exponente)] x -- polinomio otra forma: [escalares]

sumaPolinomios :: [Float] -> [Float] -> [Float]
sumaPolinomios [] ys = ys
sumaPolinomios xs [] = xs
sumaPolinomios (x : xs) (y : ys) = x + y : sumaPolinomios xs ys

multEscalar :: Float -> [Float] -> [Float]
multEscalar n [] = []
multEscalar n (x : xs) = x * n : multEscalar n xs

grado :: [Float] -> Int
grado [] = 0
grado n = length n - 1