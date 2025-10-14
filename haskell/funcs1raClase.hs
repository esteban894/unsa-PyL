doble :: Float -> Float
doble x = 2 * x

aplicaFuncion :: (Int -> Int) -> Int -> Int
aplicaFuncion f x = f x

biseccion :: (Float -> Float) -> (Float, Float) -> Float -> Float
biseccion f (a, b) e
  | f a * f b >= 0 = error "No existe una raiz de la funcion en el intervalo"
  | abs (f m) < e = m
  | f a * f m < 0 = biseccion f (a, m) e
  | otherwise = biseccion f (m, b) e
  where
    m = (a + b) / 2

raizX2 :: Float -> Float
raizX2 x = 2 * (x - 2)