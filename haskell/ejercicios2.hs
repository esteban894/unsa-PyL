import Data.Char (toLower)

sumaPares :: [Int] -> Int -- suma los numeros pares de una lista
sumaPares [] = 0
sumaPares (x : xs)
  | even x = x + sumaPares xs
  | otherwise = sumaPares xs

replicar :: Char -> Int -> String -- muestra n veces el caracter
replicar c 0 = ""
replicar c n = c : replicar c (n - 1)

cuentaVocales :: String -> Int -- cuenta las vocales de un string
cuentaVocales "" = 0
cuentaVocales (x : xs)
  | toLower x `elem` "aeiou" = 1 + cuentaVocales xs
  | otherwise = cuentaVocales xs