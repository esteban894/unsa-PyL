esPositivo :: Int -> Bool
esPositivo x = x > 0

entre0y9 :: Int -> Bool
entre0y9 x = x >= 0 && x <= 9

esMultiploDeTres :: Int -> Bool
esMultiploDeTres x = mod x 3 == 0

celsius2Fahr :: Float -> Float
celsius2Fahr x = (x * 9 / 5) + 32
