esPositivo :: Int -> Bool
esPositivo x = x > 0

entre0y9 :: Int -> Bool
entre0y9 x = x >= 0 && x <= 9

esMultiploDeTres :: Int -> Bool
esMultiploDeTres x = mod x 3 == 0

celsius2Fahr :: Float -> Float
celsius2Fahr x = (x * (9 / 5)) + 32

norma1 :: Double -> Double -> Double
norma1 x y = sqrt (x ^ 2 + y ^ 2)

norma :: (Double, Double) -> Double
norma (x, y) = sqrt (x ^ 2 + y ^ 2)

-- =================================

swap :: (Int, Float) -> (Float, Int)
swap (x, y) = (y, x)

tup2List :: (Int, Int) -> [Int]
tup2List (x, y) = if x < y then [x .. y] else [x, x - 1 .. y]

palindromo :: String -> Bool
palindromo str = str == reverse str

insertaTup :: (Char, Char, String) -> String
insertaTup (x, y, str) = [x] ++ str ++ [y]