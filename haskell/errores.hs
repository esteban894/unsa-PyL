-- cabeza :: [Int] -> Int
-- cabeza (x:_) = x

-- cabeza [] -- esto genera un error

cabeza :: [Int] -> Int
cabeza (x : _) = x
cabeza [] = error "La lista esta vacia" -- siempre la func error va al final
